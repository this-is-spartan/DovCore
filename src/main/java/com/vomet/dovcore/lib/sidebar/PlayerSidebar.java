package com.vomet.dovcore.lib.sidebar;

import org.bukkit.scoreboard.Scoreboard;

import java.util.UUID;

public class PlayerSidebar {
    private final UUID playerID;
    private final Scoreboard bukkitBoard;

    public PlayerSidebar(UUID playerID, Scoreboard bukkitBoard) {
        this.playerID = playerID;
        this.bukkitBoard = bukkitBoard;
    }

    public UUID getPlayerID() {
        return playerID;
    }

    public Scoreboard getBukkitBoard() {
        return bukkitBoard;
    }
}
