package eu.dragoncore.autosaveworld;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by marc on 07.01.17.
 */
public class Main extends JavaPlugin {

    public void onEnable() {
        this.saveDefaultConfig();
        for (String w : this.getConfig().getConfigurationSection("worlds").getKeys(false)) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    Bukkit.getServer().getWorld(w).save();
                    System.out.print("Autosaved World: " + w);
                }
            }.runTaskTimer(this, 0L, this.getConfig().getInt("worlds." + w) * 20L);
        }
    }

}
