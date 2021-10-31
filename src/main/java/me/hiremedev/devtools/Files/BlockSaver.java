package me.hiremedev.devtools.Files;

import org.bukkit.event.Listener;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BlockSaver implements Listener {
    private Path location;

    public BlockSaver() {
        this.location = Paths.get("");
    }


}
