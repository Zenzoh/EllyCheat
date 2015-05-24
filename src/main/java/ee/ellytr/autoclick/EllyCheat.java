package ee.ellytr.autoclick;

import ee.ellytr.autoclick.command.CPSCommand;
import ee.ellytr.autoclick.command.TPSCommand;
import ee.ellytr.autoclick.cps.CPSListener;
import ee.ellytr.autoclick.cps.CPSRunnable;
import ee.ellytr.autoclick.tps.TPSRunnable;
import ee.ellytr.autoclick.tps.TPSTick;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class EllyCheat extends JavaPlugin {

    private static EllyCheat instance;

    @Override
    public void onEnable() {
        instance = this;

        getConfig().options().copyDefaults(true);
        saveConfig();

        new CPSListener();
        getCommand("cps").setExecutor(new CPSCommand());
        getCommand("tps").setExecutor(new TPSCommand());

        Bukkit.getScheduler().runTask(this, new TPSTick());
        Bukkit.getScheduler().runTaskLaterAsynchronously(this, new CPSRunnable(), 20);
        Bukkit.getScheduler().runTaskLaterAsynchronously(this, new TPSRunnable(), 20);
    }

    @Override
    public void onDisable() {

    }

    public static EllyCheat getInstance() {
        return instance;
    }

}
