package net.collat.pirateplunder.events;

import net.collat.gametemplate.events.GamePlayerRespawnEndEvent;
import net.collat.pirateplunder.Main;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class PlayerRespawnEvent implements Listener {

    private Plugin plugin = Main.getPlugin(Main.class);

    @EventHandler
    public void onRespawn(GamePlayerRespawnEndEvent event) {
        Player player = event.getPlayer();
        String team = Main.game.getPlayerTeam(player).getName();

        World world = player.getWorld();
        double x = plugin.getConfig().getDouble("Maps." + world.getName() + ".Locations.Spawns." + team + ".x");
        double y = plugin.getConfig().getDouble("Maps." + world.getName() + ".Locations.Spawns." + team + ".y");
        double z = plugin.getConfig().getDouble("Maps." + world.getName() + ".Locations.Spawns." + team + ".z");
        Location loc = new Location(world, x, y ,z);
        player.teleport(loc);
        player.setGameMode(GameMode.SURVIVAL);
    }

}
