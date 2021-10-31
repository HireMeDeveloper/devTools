package me.hiremedev.devtools.Keys;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

public class KeyManager {
    JavaPlugin plugin;

    public KeyManager(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public boolean itemHasKey(PersistentDataContainer data, String key, PersistentDataType type){
        var namespacedKey = new NamespacedKey(plugin, key);
        return data.has(namespacedKey, type);
    }

    public void setKey(PersistentDataContainer data,String key,String value){
        var namespacedKey = new NamespacedKey(plugin, key);
        data.set(namespacedKey,PersistentDataType.STRING, value);
    }

    public void setKey(PersistentDataContainer data,String key,float value){
        var namespacedKey = new NamespacedKey(plugin, key);
        data.set(namespacedKey,PersistentDataType.FLOAT, value);
    }
}
