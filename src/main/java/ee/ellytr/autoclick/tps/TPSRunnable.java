package ee.ellytr.autoclick.tps;

import ee.ellytr.autoclick.EllyCheat;
import ee.ellytr.autoclick.cps.CPSTracker;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.math.BigDecimal;

public class TPSRunnable implements Runnable {

    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            double tps = Math.round(TPSTracker.getTPS() * 100.0) / 100.0;
            if (tps <= EllyCheat.getInstance().getConfig().getInt("tps-warning")) {
                for (Player player2 : Bukkit.getOnlinePlayers()) {
                    if (player2.hasPermission("ellycheat.cps.warning")) {
                        player2.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "!" + ChatColor.GRAY + "] The server is currently running at " + ChatColor.GOLD + tps + ChatColor.GRAY + " TPS!");
                    }
                }
                if (EllyCheat.getInstance().getConfig().getBoolean("log-warnings")) {
                    Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "!" + ChatColor.GRAY + "] The server is currently running at " + ChatColor.GOLD + tps + ChatColor.GRAY + " TPS!");
                }
            }
        }
        Bukkit.getScheduler().runTaskLaterAsynchronously(EllyCheat.getInstance(), this, 20);
    }
}
