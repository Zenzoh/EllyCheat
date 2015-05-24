package ee.ellytr.autoclick.command;

import ee.ellytr.autoclick.tps.TPSTracker;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TPSCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String name, String[] args) {
        String cmd = command.getName();
        if (cmd.equalsIgnoreCase("tps")) {
            sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "!" + ChatColor.GRAY + "] " + "The server is currently running at " + ChatColor.AQUA + Math.round(TPSTracker.getTPS() * 100.0) / 100.0 + ChatColor.GRAY + " TPS.");
        }
        return true;
    }

}
