package ee.ellytr.autoclick.cps;

import ee.ellytr.autoclick.EllyCheat;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class CPSRunnable implements Runnable {

    @Override
    public void run() {
        CPSTracker.refresh();
        for (Player player1 : Bukkit.getOnlinePlayers()) {
            double cps = CPSTracker.getLeftCPS(player1.getUniqueId());
            if (cps >= EllyCheat.getInstance().getConfig().getInt("click-warning")) {
                for (Player player2 : Bukkit.getOnlinePlayers()) {
                    if (player2.hasPermission("ellycheat.cps.warning")) {
                        player2.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "!" + ChatColor.GRAY + "] " + player1.getName() + "'s CPS is " + ChatColor.GOLD + cps + "! " + ChatColor.GRAY + "(left click)");
                    }
                }
                if (EllyCheat.getInstance().getConfig().getBoolean("log-warnings")) {
                    Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "!" + ChatColor.GRAY + "] " + player1.getName() + "'s CPS is " + ChatColor.GOLD + cps + "! " + ChatColor.GRAY + "(left click)");
                }
            }
            cps = CPSTracker.getRightCPS(player1.getUniqueId());
            if (cps >= EllyCheat.getInstance().getConfig().getInt("click-warning")) {
                for (Player player2 : Bukkit.getOnlinePlayers()) {
                    if (player2.hasPermission("ellycheat.cps.warning")) {
                        player2.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "!" + ChatColor.GRAY + "] " + player1.getName() + "'s CPS is " + ChatColor.GOLD + cps + "! " + ChatColor.GRAY + "(right click)");
                    }
                }
                if (EllyCheat.getInstance().getConfig().getBoolean("log-warnings")) {
                    Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "!" + ChatColor.GRAY + "] " + player1.getName() + "'s CPS is " + ChatColor.GOLD + cps + "! " + ChatColor.GRAY + "(right click)");
                }
            }
        }
        Bukkit.getScheduler().runTaskLater(EllyCheat.getInstance(), this, 20);
    }
}
