package me.hiremedev.devtools.Menus;

import me.hiremedev.devtools.Structure.TwisterPlugin;
import net.kyori.adventure.text.Component;
import net.md_5.bungee.api.chat.hover.content.Item;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.HashMap;

public class MenuInstance implements Listener {
    private TwisterPlugin plugin;
    private Inventory inventory;
    private Player viewer;
    private boolean blocksClicks;

    public MenuInstance(TwisterPlugin plugin, Inventory inventory, Player viewer, boolean blocksClicks, HashMap<ItemStack, Integer> itemMap) {
        this.plugin = plugin;
        this.inventory = inventory;
        this.viewer = viewer;
        this.blocksClicks = blocksClicks;

        plugin.registerEvents(this);

        fillInventory(itemMap);
        viewer.openInventory(inventory);
    }

    private void fillInventory(HashMap<ItemStack, Integer> items){
        items.forEach((item,index)-> inventory.setItem(index, item));

        var empty = new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS_PANE, 1);
        var meta = empty.getItemMeta();
        meta.displayName(Component.text("Empty"));
        empty.setItemMeta(meta);

        for (int i = 0; i < inventory.getSize(); i++){
            var item = inventory.getItem(i);
            if(item != null) continue;
            inventory.setItem(i, empty);
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent event){
        var inventory = event.getInventory();
        if(inventory != this.inventory) return;
        event.setCancelled(blocksClicks);
    }
}
