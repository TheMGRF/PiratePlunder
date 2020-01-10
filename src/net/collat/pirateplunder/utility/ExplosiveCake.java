package net.collat.pirateplunder.utility;

import net.collat.player.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.Plugin;

public class ExplosiveCake implements Listener {

    private Plugin plugin = Main.getPlugin(Main.class);

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();

        if (player.getInventory().getItemInMainHand().hasItemMeta()) {
            if (player.getInventory().getItemInMainHand().getItemMeta().hasDisplayName()) {
                if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("§d§lExplosive Cake")) {
                    player.playSound(player.getLocation(), Sound.ENTITY_ARMORSTAND_PLACE, 1, 2);
                    Location loc = event.getBlock().getLocation();
                    player.getWorld().playSound(loc, Sound.ENTITY_CREEPER_PRIMED, 1, 1.5F);

                    Bukkit.getScheduler ().runTaskLater (plugin, () -> loc.getBlock().setType(Material.AIR), 60);
                    Bukkit.getScheduler ().runTaskLater (plugin, () -> loc.getWorld().createExplosion(loc, 5), 60);
                }
            }
        }
    }

}
