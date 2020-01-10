package net.collat.pirateplunder.events;

import net.collat.gametemplate.GameState;
import net.collat.gametemplate.events.GamePlayerJoinEvent;
import net.collat.pirateplunder.Main;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class PlayerJoinGame implements Listener {

    private Plugin plugin = Main.getPlugin(Main.class);

    //Lobby
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (plugin.getConfig().getString("Active").equals("world")) {
            World world = Bukkit.getWorld("world");

            double x = plugin.getConfig().getDouble("Maps.world.Locations.Lobby.x");
            double y = plugin.getConfig().getDouble("Maps.world.Locations.Lobby.y");
            double z = plugin.getConfig().getDouble("Maps.world.Locations.Lobby.z");

            Location loc = new Location(world, x,y ,z);
            player.teleport(loc);

            //Old system for dynamically setting win points
            //Main.winPoints += 1000;
        }
    }

    //Giving hotbar items
    // DOM IS WRITING THE THING TO GIVE ITEMS SO IS GUD
    @EventHandler
    public void onGameJoin(GamePlayerJoinEvent event) {
        if (Main.game.getGameState() != GameState.STARTED) {
            Player player = event.getPlayer();
            Inventory inv = player.getInventory();

            ItemStack teams = new ItemStack(Material.NETHER_STAR);
            ItemMeta teamsMeta = teams.getItemMeta();
            teamsMeta.setDisplayName("§6Team Selector");
            teams.setItemMeta(teamsMeta);
            inv.setItem(3, teams);

            ItemStack loadouts = new ItemStack(Material.BOOK);
            ItemMeta loadoutsMeta = loadouts.getItemMeta();

            loadoutsMeta.setDisplayName("§6Loadouts");
            loadouts.setItemMeta(loadoutsMeta);
            inv.setItem(5, loadouts);

            player.setGameMode(GameMode.SURVIVAL);

            welcomeMessage(player);
        }
    }

    private void welcomeMessage(Player player) {
        player.sendMessage("");
        player.sendMessage("                       §f§lWelcome To §3§lPirate Plunder");
        player.sendMessage("");
        player.sendMessage("§bThe first team to fill their chest with loot or totally eliminate the enemy team wins!");
        player.sendMessage("");
        player.sendMessage("                               §6§lGood Luck!");
        player.sendMessage("");
    }
}
