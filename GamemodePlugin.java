package me.maurice.gamemodeplugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class GamemodePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        getCommand("gm").setExecutor(new GamemodeCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
