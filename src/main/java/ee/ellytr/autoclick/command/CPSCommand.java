package ee.ellytr.autoclick.command;

import ee.ellytr.autoclick.cps.CPSTracker;
import ee.ellytr.autoclick.utils.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CPSCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String name, String[] args) {
        String cmd = command.getName();
        if (cmd.equalsIgnoreCase("cps")) {
            if (args.length >= 1) {
                Player player = Bukkit.getPlayer(args[0]);
                if (player != null) {
                    sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "!" + ChatColor.GRAY + "] " + player.getName() + "'s CPS:");
                    sender.sendMessage(ChatColor.GRAY + "  Left Click: " + ChatColor.AQUA + CPSTracker.getLeftCPS(player.getUniqueId()));
                    sender.sendMessage(ChatColor.GRAY + "  Right Click: " + ChatColor.AQUA + CPSTracker.getRightCPS(player.getUniqueId()));
                } else {
                    MessageUtils.sendErrorMessage(sender, "Player specified not found.");
                }
            } else {
                MessageUtils.sendErrorMessage(sender, "Too few arguments.");
                return false;
            }
        }
        return true;
    }

}
