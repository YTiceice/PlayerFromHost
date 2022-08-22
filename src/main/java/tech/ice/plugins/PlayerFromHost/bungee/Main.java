package tech.ice.plugins.PlayerFromHost.bungee;

import net.md_5.bungee.api.plugin.Plugin;

import java.io.IOException;

public class Main extends Plugin {

    public static Main BungeePlayerFromHost;

    @Override
    public void onEnable() {
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
