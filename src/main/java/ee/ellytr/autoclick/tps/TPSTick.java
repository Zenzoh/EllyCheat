package ee.ellytr.autoclick.tps;

import ee.ellytr.autoclick.EllyCheat;
import org.bukkit.Bukkit;

public class TPSTick implements Runnable {

    @Override
    public void run() {
        TPSTracker.tick();
        Bukkit.getScheduler().runTaskLater(EllyCheat.getInstance(), this, 1);
    }

}
