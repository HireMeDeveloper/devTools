package me.hiremedev.devtools.Structure;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class TwisterPlugin extends JavaPlugin {

    public PluginManager getPluginManager() {
        return getServer().getPluginManager();
    }

    public void registerEvents(Listener... listeners) {
        Arrays.stream(listeners).forEach((listener) ->
                getPluginManager().registerEvents(listener, this)
        );
    }

    public void registerCommands(TwisterCommand... twisterCommands) {
        Arrays.stream(twisterCommands).forEach((twisterCommand) -> {
            var command = getCommand(twisterCommand.getCommandName());
            command.setExecutor(twisterCommand.getCommandExecutor());
            command.setTabCompleter(twisterCommand.getTabCompleter());
        });
    }
}
