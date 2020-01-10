package net.collat.pirateplunder.events;

import net.collat.player.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;

public class PlayerPlaceBlock implements Listener {

    private Plugin plugin = Main.getPlugin(Main.class);

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        event.getBlock().setMetadata("playerPlaced", new FixedMetadataValue(plugin, true));
    }

}
