package me.hiremedev.devtools;

import me.hiremedev.devtools.Commands.Dev;
import me.hiremedev.devtools.Keys.KeyManager;
import me.hiremedev.devtools.Structure.TwisterCommand;
import me.hiremedev.devtools.Structure.TwisterPlugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class DevTools extends TwisterPlugin {

    @Override
    public void onEnable() {
        var keyManager = new KeyManager(this);

        registerCommands(
                new TwisterCommand("dev", new Dev(this), new Dev(this))
        );
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
