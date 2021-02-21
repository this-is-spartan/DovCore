package com.vomet.dovcore.lib.sidebar;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.*;

import java.util.*;

public class SidebarManager implements Listener {

    public String translate(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }
    private final Map<UUID, PlayerSidebar> sidebarsPerPlayer = new HashMap<>();


    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        setupSidebar(e.getPlayer());
    }

    public void setupSidebar(Player player) {
        ScoreboardManager sbManager = Bukkit.getScoreboardManager();
        Scoreboard board = sbManager.getNewScoreboard();

        Objective oneObjective = board.registerNewObjective("test", "dummy", translate("&c&lDayOver &f&lNetwork"));
        oneObjective.setDisplaySlot(DisplaySlot.SIDEBAR);

        List<String> lines = Arrays.asList(
                "Line 1",
                "Line 2",
                "Line 3"
        );

        for (int i = 0; i < lines.size(); i++) {
            Score score = oneObjective.getScore(lines.get(i));
            score.setScore(i);
        }


        PlayerSidebar sidebar = new PlayerSidebar(player.getUniqueId(), board);
        sidebarsPerPlayer.put(player.getUniqueId(), sidebar);
        player.setScoreboard(board);
    }
    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        sidebarsPerPlayer.remove(player.getUniqueId());
    }
}
