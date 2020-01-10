package net.collat.pirateplunder.events;

import net.collat.player.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.plugin.Plugin;

public class GameTNTExplode implements Listener {

    Plugin plugin = Main.getPlugin(Main.class);

    @EventHandler
    public void onExplode(EntityExplodeEvent event) {
        for (Block b : event.blockList()) {
            final BlockState state = b.getState();
            b.setType(Material.AIR);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                public void run() {
                    state.update(true, false);
                }
            }, 200);
        }
    }

}
