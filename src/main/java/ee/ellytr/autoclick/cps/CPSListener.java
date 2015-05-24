package ee.ellytr.autoclick.cps;

import ee.ellytr.autoclick.EllyCheat;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class CPSListener implements Listener {

    public CPSListener() {
        Bukkit.getPluginManager().registerEvents(this, EllyCheat.getInstance());
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction().equals(Action.LEFT_CLICK_AIR) || event.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
            CPSTracker.leftClick(event.getPlayer().getUniqueId());
        }
        if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            CPSTracker.rightClick(event.getPlayer().getUniqueId());
        }
    }

}
