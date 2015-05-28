package ee.ellytr.autoclick.cps;

import ee.ellytr.autoclick.EllyCheat;
import ee.ellytr.autoclick.log.UserLog;
import ee.ellytr.autoclick.tps.TPSTracker;
import ee.ellytr.autoclick.utils.MessageUtils;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.HoverEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Level;

public class CPSRunnable implements Runnable {

    @Override
    public void run() {
        CPSTracker.refresh();
        for (Player player : Bukkit.getOnlinePlayers()) {
            double cps = CPSTracker.getLeftCPS(player.getUniqueId());
            double tps = Math.round(TPSTracker.getTPS() * 100.0) / 100.0;
            double vl = Math.round(cps * tps * 100.0) / 100.0;
            if (cps >= EllyCheat.getInstance().getConfig().getInt("cps-warning")) {
                BaseComponent[] warning = MessageUtils.getCPSWarning(player.getName(), cps, tps, vl, ClickType.LEFT);
                Bukkit.getOnlinePlayers().stream().filter(toSend -> toSend.hasPermission("ellycheat.cps.warning")).forEach(toSend -> {
                    toSend.spigot().sendMessage(warning);
                });
                if (EllyCheat.getInstance().getConfig().getBoolean("log-warnings")) {
                    Bukkit.getConsoleSender().sendMessage(BaseComponent.toLegacyText(warning));
                }
                if (EllyCheat.getInstance().getConfig().getBoolean("local-database")) {
                    try {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
                        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                        new UserLog(player.getName(), "cps").log(dateFormat.format(new Date()) + " UTC: " + cps + " CPS [Left]");
                    } catch (IOException e) {
                        EllyCheat.getInstance().getLogger().log(Level.WARNING, "Could not initialize user log for player '" + player.getName() + "'");
                    }
                }
            }
            cps = CPSTracker.getRightCPS(player.getUniqueId());
            if (cps >= EllyCheat.getInstance().getConfig().getInt("cps-warning")) {
                BaseComponent[] warning = MessageUtils.getCPSWarning(player.getName(), cps, tps, vl, ClickType.RIGHT);
                Bukkit.getOnlinePlayers().stream().filter(toSend -> toSend.hasPermission("ellycheat.cps.warning")).forEach(toSend -> {
                    toSend.spigot().sendMessage(warning);
                });
                if (EllyCheat.getInstance().getConfig().getBoolean("log-warnings")) {
                    Bukkit.getConsoleSender().sendMessage(BaseComponent.toLegacyText(warning));
                }
                if (EllyCheat.getInstance().getConfig().getBoolean("local-database")) {
                    try {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
                        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                        new UserLog(player.getName(), "cps").log(dateFormat.format(new Date()) + " UTC: " + cps + " CPS [Right]");
                    } catch (IOException e) {
                        EllyCheat.getInstance().getLogger().log(Level.WARNING, "Could not initialize user log for player '" + player.getName() + "'");
                    }
                }
            }
        }
        Bukkit.getScheduler().runTaskLaterAsynchronously(EllyCheat.getInstance(), this, 20);
    }
}
