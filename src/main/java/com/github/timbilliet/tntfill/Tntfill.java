package com.github.timbilliet.tntfill;

import org.bukkit.plugin.java.JavaPlugin;

public final class Tntfill extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage("[Tntfill]: Plugin is enabled");
        getCommand("tntfill").setExecutor(new FillCommand());
        getCommand("tntunfill").setExecutor(new UnfillCommand());
    }

}
