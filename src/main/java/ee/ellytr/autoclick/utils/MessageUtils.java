package ee.ellytr.autoclick.utils;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class MessageUtils {

    public static void sendErrorMessage(CommandSender sender, String message) {
        sender.sendMessage(ChatColor.RED + message);
    }

}
