package ee.ellytr.autoclick.tps;

public class TPSTracker {

    private static int currentTicks = 0;
    private static int tps = 0;

    public static void tick() {
        currentTicks ++;
    }

    public static void refresh() {
        tps = currentTicks;

        currentTicks = 0;
    }

    public static double getTPS() {
        return tps;
    }

}
