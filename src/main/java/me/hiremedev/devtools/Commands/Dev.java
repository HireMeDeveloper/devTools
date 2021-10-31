package me.hiremedev.devtools.Commands;

import me.hiremedev.devtools.Menus.Menu;
import me.hiremedev.devtools.Structure.TwisterPlugin;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Dev implements CommandExecutor,TabCompleter {
    private TwisterPlugin plugin;

    public Dev(TwisterPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)) return true;
        var player = (Player) sender;
        if(args.length < 1){
            //run the default command
            return false;
        }
        switch (args[0].toUpperCase()){
            case "MENU" -> {
                var menu = new Menu(plugin,9, Component.text("Dev Menu"));
                menu.prepareItem(new ItemStack(Material.STICK, 1), 4);
                menu.open(player, true);
            }
            case "STICK" -> {
                player.getInventory().addItem(new ItemStack(Material.STICK));
            }
        }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        if(args.length == 1){
            return Arrays.stream(me.hiremedev.devtools.Enums.Dev.values())
                    .map(Enum::name)
                    .filter((name)-> name.contains(args[0].toUpperCase()))
                    .collect(Collectors.toList());
        }
        return null;
    }
}
