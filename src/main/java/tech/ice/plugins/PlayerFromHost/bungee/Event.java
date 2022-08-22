package tech.ice.plugins.PlayerFromHost.bungee;

import static tech.ice.plugins.PlayerFromHost.bungee.Config.*;

import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class Event implements Listener {
    @EventHandler
    public void OnLogin(PostLoginEvent event) {
        ProxiedPlayer Player = event.getPlayer();
        String PlayerName = Player.getName();
        String hostname = Player.getPendingConnection().getVirtualHost().getHostString();

        if (!HostName.contains(hostname)) {
            String result = String.join(HostAppend, HostName);
            String KickMessage = String.format(Message, result, hostname);
            Player.disconnect(new TextComponent(KickMessage));
            if (Enable) {
                String LogMessage = String.format(LoginFailed, PlayerName, hostname, result);
                Main.BungeePlayerFromHost.getLogger().info(LogMessage);
            }
        } else if (Enable) {
            String result = String.join(HostAppend, HostName);
            String LogMessage = String.format(LoginSuccess, PlayerName, hostname, result);
            Main.BungeePlayerFromHost.getLogger().info(LogMessage);
        }

    }
}
