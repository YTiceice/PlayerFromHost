package tech.ice.plugins.PlayerFromHost.bukkit;

import static tech.ice.plugins.PlayerFromHost.bukkit.Config.*;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.io.IOException;

public class Reload implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender.isOp() && sender.hasPermission("pfh.reload")) {
            try {
                Config.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            sender.sendMessage(Reload);
        } else {
            sender.sendMessage(NoPer);
        }
        return true;
    }
}
