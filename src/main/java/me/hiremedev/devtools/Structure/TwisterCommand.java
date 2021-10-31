package me.hiremedev.devtools.Structure;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabCompleter;

public class TwisterCommand {
    private String commandName;
    private CommandExecutor commandExecutor;
    private TabCompleter tabCompleter;

    public TwisterCommand(String commandName, CommandExecutor commandExecutor, TabCompleter tabCompleter) {
        this.commandName = commandName;
        this.commandExecutor = commandExecutor;
        this.tabCompleter = tabCompleter;
    }

    public CommandExecutor getCommandExecutor() {
        return commandExecutor;
    }

    public TabCompleter getTabCompleter() {
        return tabCompleter;
    }

    public String getCommandName() {
        return commandName;
    }
}
