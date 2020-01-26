package me.bcof.crouchcrop;

import me.bcof.crouchcrop.Listeners.CrouchEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class CrouchCrop extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new CrouchEvent(this), this);
        getConfig().options().copyDefaults();
        saveDefaultConfig();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
