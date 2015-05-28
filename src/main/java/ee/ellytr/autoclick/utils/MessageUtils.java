package ee.ellytr.autoclick.utils;

import ee.ellytr.autoclick.cps.ClickType;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import org.bukkit.command.CommandSender;

public class MessageUtils {

    public static void sendErrorMessage(CommandSender sender, String message) {
        sender.sendMessage(ChatColor.RED + message);
    }

    public static ChatColor getScaledColor(double num, double scale, boolean reverse) {
        if (num >= scale * 0.75) return reverse ? ChatColor.GREEN : ChatColor.RED;
        if (num >= scale * 0.5) return reverse ? ChatColor.YELLOW : ChatColor.GOLD;
        if (num >= scale * 0.25) return reverse ? ChatColor.GOLD : ChatColor.YELLOW;
        return reverse ? ChatColor.RED : ChatColor.GREEN;
    }

    public static BaseComponent[] getCPSWarning(String player, double cps, double tps, double vl, ClickType clickType) {
        return new ComponentBuilder("[").color(ChatColor.GRAY).event(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                new ComponentBuilder("Click Type: ").color(ChatColor.GRAY)
                        .append(clickType + "\n").color(ChatColor.AQUA)
                        .append("TPS: ").color(ChatColor.GRAY)
                        .append(tps + "\n").color(MessageUtils.getScaledColor(tps, 20.0, true))
                        .append("Violation Level: ").color(ChatColor.GRAY)
                        .append(vl + "\n").color(MessageUtils.getScaledColor(vl, 10000.0, false))
                        .append("Both client-side and server-side\n").color(ChatColor.RED)
                        .append("lag may affect the perception of\n").color(ChatColor.RED)
                        .append("a player's CPS.").color(ChatColor.RED)
                        .create()
        ))
                .append("!").color(ChatColor.AQUA)
                .append("] ").color(ChatColor.GRAY)
                .append(player + " has ")
                .append(cps + "").color(MessageUtils.getScaledColor(cps, 500.0, false))
                .append(" CPS!").color(ChatColor.GRAY)
                .create();
    }

}
