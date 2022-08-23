package tech.ice.plugins.PlayerFromHost.bungee;

import net.md_5.bungee.api.plugin.Plugin;

import java.io.IOException;

import org.bstats.bungeecord.Metrics;

public class Main extends Plugin {

    public static Main BungeePlayerFromHost;

    @Override
    public void onEnable() {
        int ID = 16236;
        Metrics metrics = new Metrics(this, ID);

        BungeePlayerFromHost = this;
        getProxy().getPluginManager().registerListener(this, new Event());
        getProxy().getPluginManager().registerCommand(this, new Reload());

        try {
            Config.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
