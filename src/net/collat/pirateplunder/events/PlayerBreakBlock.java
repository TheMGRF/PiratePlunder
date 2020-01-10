package net.collat.pirateplunder.events;

import net.collat.player.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.Plugin;

public class PlayerBreakBlock implements Listener {

    private Plugin plugin = Main.getPlugin(Main.class);

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        if (!event.getBlock().hasMetadata("playerPlaced")) {
            event.setCancelled(true);
        } else {
            event.getBlock().removeMetadata("playerPlaced", plugin);
        }
    }

}
