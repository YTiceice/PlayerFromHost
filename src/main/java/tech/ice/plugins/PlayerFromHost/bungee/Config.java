package tech.ice.plugins.PlayerFromHost.bungee;

import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.io.InputStream;
import java.util.List;

public class Config {

    public static List<String> HostName;
    public static String Message;
    public static String LoginFailed;
    public static String LoginSuccess;
    public static String NoPer;
    public static String Reload;
    public static String HostAppend;
    public static boolean Enable;

    public static void load() throws IOException {

        if (!Main.BungeePlayerFromHost.getDataFolder().exists()) {
            Main.BungeePlayerFromHost.getDataFolder().mkdir();
        }

        File file = new File (Main.BungeePlayerFromHost.getDataFolder(), "config.yml");

        if(!file.exists()) {
            FileOutputStream outputStream = new FileOutputStream(file);
            InputStream in = Main.BungeePlayerFromHost.getResourceAsStream("config.yml");
            in.transferTo(outputStream);
        }

        Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(Main.BungeePlayerFromHost.getDataFolder(), "config.yml"));

        HostName = config.getStringList("hostname");
        Message = config.getString("messages.disconnect");
        LoginFailed = config.getString("messages.console.failed");
        LoginSuccess = config.getString("messages.console.success");
        NoPer = config.getString("messages.command.no-per");
        Reload = config.getString("messages.command.reload");
        HostAppend = config.getString("messages.host-append");
        Enable = config.getBoolean("console-logger");
    }
}
