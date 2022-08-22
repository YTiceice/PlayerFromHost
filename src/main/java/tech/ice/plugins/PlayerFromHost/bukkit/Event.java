package tech.ice.plugins.PlayerFromHost.bukkit;

import static tech.ice.plugins.PlayerFromHost.bukkit.Config.*;
import static tech.ice.plugins.PlayerFromHost.bungee.Config.HostAppend;
import static tech.ice.plugins.PlayerFromHost.bungee.Config.HostName;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;

public class Event implements Listener {
    @EventHandler
    public void OnLogin(PlayerLoginEvent event) {
        Player Player = event.getPlayer();
        String PlayerName = Player.getName();
        String hostname = event.getHostname();

        if (!HostName.contains(hostname)) {
            String result = String.join(HostAppend, HostName);
            String KickMessage = String.format(Message, result, hostname);
            event.disallow(PlayerLoginEvent.Result.KICK_OTHER, KickMessage);
            if (Enable) {
                String LogMessage = String.format(LoginFailed, PlayerName, hostname, result);
                Main.BukkitPlayerFromHost.getLogger().info(LogMessage);
            }
        } else if (Enable) {
            String result = String.join(HostAppend, HostName);
            String LogMessage = String.format(LoginSuccess, PlayerName, hostname, result);
            Main.BukkitPlayerFromHost.getLogger().info(LogMessage);
        }

    }
}
