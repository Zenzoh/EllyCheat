package ee.ellytr.autoclick.tps;

import ee.ellytr.autoclick.EllyCheat;
import ee.ellytr.autoclick.utils.MessageUtils;
import org.bukkit.Bukkit;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;

public class TPSRunnable implements Runnable {

    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            double tps = Math.round(TPSTracker.getTPS() * 100.0) / 100.0;
            if (tps <= EllyCheat.getInstance().getConfig().getInt("tps-warning")) {
                if (player.hasPermission("ellycheat.cps.warning")) {
                    player.sendMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "!" + ChatColor.GRAY + "] The server is currently running at " + MessageUtils.getScaledColor(tps, 20.0, true) + tps + ChatColor.GRAY + " TPS!");
                }
                if (EllyCheat.getInstance().getConfig().getBoolean("log-warnings")) {
                    Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "!" + ChatColor.GRAY + "] The server is currently running at " + MessageUtils.getScaledColor(tps, 20.0, true) + tps + ChatColor.GRAY + " TPS!");
                }
            }
        }
        Bukkit.getScheduler().runTaskLaterAsynchronously(EllyCheat.getInstance(), this, 20);
    }
}
