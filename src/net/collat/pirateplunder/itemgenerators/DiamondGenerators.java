package net.collat.pirateplunder.itemgenerators;

import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;
import net.collat.gametemplate.GameState;
import net.collat.pirateplunder.Main;
import org.bukkit.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DiamondGenerators implements Listener {

    private Plugin plugin = Main.getPlugin(Main.class);

    private GeneratorInteract gen = new GeneratorInteract();

    private String worldName = plugin.getConfig().getString("Active");
    private World world = Bukkit.getWorld(worldName);

    private List diamondGenerators = Arrays.asList("Diamond1", "Diamond2");

    public void spawnDiamondGenerator() {
        for (Object generator : diamondGenerators) {
            double x = plugin.getConfig().getDouble("Maps." + world.getName() + ".Locations.Chests." + generator + ".x");
            double y = plugin.getConfig().getDouble("Maps." + world.getName() + ".Locations.Chests." + generator + ".y");
            double z = plugin.getConfig().getDouble("Maps." + world.getName() + ".Locations.Chests." + generator + ".z");
            Location loc = new Location(world, x, y, z).add(0.5, 0, 0.5);
            Location holoLoc = new Location(world, x, y, z).add(0.5, 1.5, 0.5);

            loc.getBlock().setType(Material.CHEST);
            Hologram holo = HologramsAPI.createHologram(plugin, holoLoc);
            holo.appendTextLine("§b§lDiamond Spawner");
            holo.appendTextLine("§6Spawns in §cX §6seconds");

            Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
                int count;
                public void run() {
                    if (Main.game.getGameState() == GameState.STARTED) {
                        if (count > 0) {
                            holo.removeLine(holo.size() - 1);
                            holo.appendTextLine("§6Spawns in §c" + count + " §6seconds");

                            count = count - 1;
                        } else {
                            count = 60;
                            Location loc = new Location(world, x, y, z).add(0.5, 3, 0.5);
                            Location particles = new Location(world, x, y, z).add(0.5, 0, 0.5);

                            Random rand = new Random();
                            int amount = rand.nextInt(7) + 3;

                            for (int i = 0; i < amount; i++) {
                                loc.getWorld().dropItem(loc, new ItemStack(Material.DIAMOND, 1));
                            }
                            loc.getWorld().playSound(loc, Sound.ENTITY_PLAYER_LEVELUP, 0.5F, 2F);
                            particles.getWorld().spawnParticle(Particle.CRIT_MAGIC, particles, 50, 1.2, 2, 1.2, 0.01);
                        }
                    }
                }
            },0, 20);
        }
    }

    @EventHandler
    public void onChestOpen(PlayerInteractEvent event) {
        for (Object generator : diamondGenerators) {
            gen.onGeneratorInteract(world, generator, event);
        }
    }

}
