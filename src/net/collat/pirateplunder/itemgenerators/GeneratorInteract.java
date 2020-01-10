package net.collat.pirateplunder.itemgenerators;

import net.collat.pirateplunder.Main;
import org.bukkit.*;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

public class GeneratorInteract {

    private Plugin plugin = Main.getPlugin(Main.class);

    public void onGeneratorInteract(World world, Object generator, PlayerInteractEvent event) {
        double x = plugin.getConfig().getDouble("Maps." + world.getName() + ".Locations.Chests." + generator + ".x");
        double y = plugin.getConfig().getDouble("Maps." + world.getName() + ".Locations.Chests." + generator + ".y");
        double z = plugin.getConfig().getDouble("Maps." + world.getName() + ".Locations.Chests." + generator + ".z");
        Location loc = new Location(world, x, y, z);

        if (event.getClickedBlock() != null) {
            if (event.getClickedBlock().getType() == Material.CHEST) {
                if (event.getClickedBlock().getLocation().equals(loc)) {
                    event.getPlayer().spawnParticle(Particle.SMOKE_NORMAL, event.getClickedBlock().getLocation().add(0.5, 0.8, 0.5), 50, 0.5, 0.5, 0.5, 0.01);
                    event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_NOTE_BASS, 1, 1);
                    event.setCancelled(true);
                }
            }
        }
    }

}
