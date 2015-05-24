package ee.ellytr.autoclick.tps;

public class TPSTracker {

    private static double lastTick = System.nanoTime();
    private static double tps = 0;

    public static void tick() {
        try {
            tps = 1 / ((System.nanoTime() - lastTick) / 1000000000.0);
        } catch (ArithmeticException e) {
        }
        lastTick = System.nanoTime();
    }

    public static double getTPS() {
        return tps;
    }

}
