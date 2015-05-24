package ee.ellytr.autoclick.tps;

import ee.ellytr.autoclick.EllyCheat;
import org.bukkit.Bukkit;

public class TPSRunnable implements Runnable {

    @Override
    public void run() {
        TPSTracker.refresh();
        Bukkit.getScheduler().runTaskLater(EllyCheat.getInstance(), this, 20);
    }
}
