package tech.ice.plugins.PlayerFromHost.bukkit;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public class Main extends JavaPlugin {

    public static Main BukkitPlayerFromHost;

    @Override
    public void onEnable() {
        BukkitPlayerFromHost = this;
        Bukkit.getPluginManager().registerEvents(new Event(), this);
        Bukkit.getPluginCommand("pfhreload").setExecutor(new Reload());

        try {
            Config.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
