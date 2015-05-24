package ee.ellytr.autoclick.tps;

public class TPSTracker {

    private static double lastTick = -1;
    private static double tps = 0;

    public static void tick() {
        if (lastTick != -1) {
            tps = 1 / ((System.nanoTime() - lastTick) / 1000000000.0);
        }
        lastTick = System.nanoTime();
    }

    public static double getTPS() {
        return tps;
    }

}
