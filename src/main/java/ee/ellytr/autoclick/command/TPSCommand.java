package ee.ellytr.autoclick.command;

import ee.ellytr.autoclick.tps.TPSTracker;
import ee.ellytr.autoclick.utils.MessageUtils;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TPSCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String name, String[] args) {
        String cmd = command.getName();
        if (cmd.equalsIgnoreCase("tps")) {
            if (sender.hasPermission("ellycheat.tps.command")) {
                sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "!" + ChatColor.GRAY + "] " + "The server is currently running at " + ChatColor.AQUA + Math.round(TPSTracker.getTPS() * 100.0) / 100.0 + ChatColor.GRAY + " TPS.");
            } else {
                MessageUtils.sendErrorMessage(sender, "You don't have permission.");
            }
        }
        return true;
    }

}
