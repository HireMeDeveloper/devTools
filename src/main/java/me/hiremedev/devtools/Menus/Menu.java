package me.hiremedev.devtools.Menus;

import me.hiremedev.devtools.Structure.TwisterPlugin;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class Menu implements Listener {
    private TwisterPlugin plugin;
    private int size;
    private Component title;

    private HashMap<ItemStack, Integer> items;

    public Menu(TwisterPlugin plugin, int size, Component title) {
        this.plugin = plugin;
        this.size = size;
        this.title = title;

        items = new HashMap<>();
    }

    public void open(Player player, boolean blocksClicks){
        new MenuInstance(plugin ,createInventory(player), player, blocksClicks, items);
    }

    private Inventory createInventory(Player player){
        return Bukkit.createInventory(player, size, title);
    }

    public void prepareItem(ItemStack itemStack, int index){
        items.put(itemStack, index);
    }
}
