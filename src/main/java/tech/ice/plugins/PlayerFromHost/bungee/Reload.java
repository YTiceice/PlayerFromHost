package tech.ice.plugins.PlayerFromHost.bungee;

import static tech.ice.plugins.PlayerFromHost.bungee.Config.*;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;

import java.io.IOException;

public class Reload extends Command {

    public Reload() {
        super("pfhreload");
    }

    public void execute(CommandSender sender, String[] args) {
        if (sender.hasPermission("pfh.reload")) {
            try {
                Config.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            sender.sendMessage(new TextComponent(Reload));
        } else {
            sender.sendMessage(new TextComponent(NoPer));
        }
    }
}
