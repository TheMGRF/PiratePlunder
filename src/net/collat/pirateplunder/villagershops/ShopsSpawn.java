package net.collat.pirateplunder.villagershops;

import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;
import net.collat.gametemplate.events.GameStartEvent;
import net.collat.pirateplunder.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class ShopsSpawn implements Listener {

    private Plugin plugin = Main.getPlugin(Main.class);

    @EventHandler
    public void onGameStart(GameStartEvent event) {
        //Shops
        String worldName = plugin.getConfig().getString("Active");
        World world = Bukkit.getWorld(worldName);

        spawnShops(world);
    }

    public void spawnShops(World world) {

        double x1 = plugin.getConfig().getDouble("Maps." + world.getName() + ".Locations.Shops.Red.x");
        double y1 = plugin.getConfig().getDouble("Maps." + world.getName() + ".Locations.Shops.Red.y");
        double z1 = plugin.getConfig().getDouble("Maps." + world.getName() + ".Locations.Shops.Red.z");
        Location loc1 = new Location(world, x1, y1, z1);

        double x2 = plugin.getConfig().getDouble("Maps." + world.getName() + ".Locations.Shops.White.x");
        double y2 = plugin.getConfig().getDouble("Maps." + world.getName() + ".Locations.Shops.White.y");
        double z2 = plugin.getConfig().getDouble("Maps." + world.getName() + ".Locations.Shops.White.z");
        Location loc2 = new Location(world, x2, y2, z2);

        Entity shop1 = loc1.getWorld().spawnEntity(loc1, EntityType.VILLAGER);
        Villager villager1 = (Villager) shop1;
        setupVillager(villager1);

        //Villager Hologram
        Hologram redVillager = HologramsAPI.createHologram(plugin, loc1.add(0, 2.3, 0));
        redVillager.appendTextLine("§6§lITEM STORE");

        Entity shop2 = loc2.getWorld().spawnEntity(loc2, EntityType.VILLAGER);
        Villager villager2 = (Villager) shop2;
        setupVillager(villager2);

        //Villager Hologram
        Hologram whiteVillager = HologramsAPI.createHologram(plugin, loc2.add(0, 2.3, 0));
        whiteVillager.appendTextLine("§6§lITEM STORE");
    }

    private void setupVillager(Villager villager) {
        villager.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0);
        villager.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE).setBaseValue(1);
        villager.setInvulnerable(true);
        villager.setSilent(true);
        villager.setCollidable(false);
        villager.setAI(false);
    }

}
