package net.collat.pirateplunder.events;

import net.collat.gametemplate.events.GameStartEvent;
import net.collat.pirateplunder.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;
import java.util.List;

public class GameStart implements Listener {

    private Plugin plugin = Main.getPlugin(Main.class);

    @EventHandler
    public void onGameStart(GameStartEvent event) {

        String worldName = plugin.getConfig().getString("Active");

        //Set not list
        List teams = Arrays.asList("Red", "White");

        for (Object team : teams) {
            startTP(worldName, team.toString());
        }

        //Close Player Inventories
        for (Player online : Bukkit.getOnlinePlayers()) {
            online.closeInventory();
        }

    }

    private void startTP(String worldName, String team) {
        World world = Bukkit.getWorld(worldName);
        double x = plugin.getConfig().getDouble("Maps." + world.getName() + ".Locations.Spawns." + team + ".x");
        double y = plugin.getConfig().getDouble("Maps." + world.getName() + ".Locations.Spawns." + team + ".y");
        double z = plugin.getConfig().getDouble("Maps." + world.getName() + ".Locations.Spawns." + team + ".z");
        Location loc = new Location(world, x, y ,z);

        for (Player player : Main.game.getTeam(team).getPlayers()) {
            player.teleport(loc);
        }
    }

}
