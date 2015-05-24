package ee.ellytr.autoclick.cps;

import java.util.HashMap;
import java.util.UUID;

public class CPSTracker {

    private static HashMap<UUID, Integer> currentRightClicks = new HashMap<>();
    private static HashMap<UUID, Integer> rightCps = new HashMap<>();
    private static HashMap<UUID, Integer> currentLeftClicks = new HashMap<>();
    private static HashMap<UUID, Integer> leftCps = new HashMap<>();

    public static void leftClick(UUID uuid) {
        if (!currentLeftClicks.containsKey(uuid)) {
            currentLeftClicks.put(uuid, 0);
        }
        currentLeftClicks.put(uuid, currentLeftClicks.get(uuid) + 1);
    }

    public static void rightClick(UUID uuid) {
        if (!currentRightClicks.containsKey(uuid)) {
            currentRightClicks.put(uuid, 0);
        }
        currentRightClicks.put(uuid, currentRightClicks.get(uuid) + 1);
    }

    public static void refresh() {
        leftCps.clear();
        rightCps.clear();

        for (UUID uuid : currentLeftClicks.keySet()) {
            leftCps.put(uuid, currentLeftClicks.get(uuid));
        }
        for (UUID uuid : currentRightClicks.keySet()) {
            rightCps.put(uuid, currentRightClicks.get(uuid));
        }

        currentLeftClicks.clear();
        currentRightClicks.clear();
    }

    public static double getLeftCPS(UUID uuid) {
        if (!leftCps.containsKey(uuid)) {
            leftCps.put(uuid, 0);
        }
        return leftCps.get(uuid);
    }

    public static double getRightCPS(UUID uuid) {
        if (!rightCps.containsKey(uuid)) {
            rightCps.put(uuid, 0);
        }
        return rightCps.get(uuid);
    }

}
