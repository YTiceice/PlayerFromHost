package tech.ice.plugins.PlayerFromHost.bukkit;

import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.YamlConfiguration;

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

        if (!Main.BukkitPlayerFromHost.getDataFolder().exists()) {
            Main.BukkitPlayerFromHost.getDataFolder().mkdir();
        }

        File file = new File (Main.BukkitPlayerFromHost.getDataFolder(), "config.yml");

        if(!file.exists()) {
            FileOutputStream outputStream = new FileOutputStream(file);
            InputStream in = Main.BukkitPlayerFromHost.getResource("config.yml");
            in.transferTo(outputStream);
        }

        Configuration config = YamlConfiguration.loadConfiguration(file);

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
