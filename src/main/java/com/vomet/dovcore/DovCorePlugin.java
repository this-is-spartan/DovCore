package com.vomet.dovcore;

import com.vomet.dovcore.lib.sidebar.SidebarManager;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class DovCorePlugin extends JavaPlugin {
    private final SidebarManager sidebarManager = new SidebarManager();
    @Override
    public void onEnable() {
        PluginManager pm = getServer().getPluginManager();

        pm.registerEvents(sidebarManager, this);

        getServer().getOnlinePlayers().forEach(p -> sidebarManager.setupSidebar(p));

    }
}
