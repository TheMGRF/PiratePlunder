package net.collat.pirateplunder;

import net.collat.gametemplate.CollatGameTeam;
import net.collat.gametemplate.CollatGameTemplate;
import net.collat.pirateplunder.itemgenerators.*;
import net.collat.pirateplunder.commands.Teams;
import net.collat.pirateplunder.events.*;
import net.collat.pirateplunder.utility.ExplosiveCake;
import net.collat.pirateplunder.utility.PlayerTracker;
import net.collat.pirateplunder.villagershops.*;
import net.collat.scoreboards.CollatScoreboards;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static CollatGameTemplate game;
    public static CollatScoreboards scoreboard;

    //
    // CONFIG FOR MAP SPAWN POINTS
    //

    public static int winPoints = 100000;

    public static int redScore = 0;
    public static int whiteScore = 0;

    public static boolean redChestState = true;
    public static boolean whiteChestState = true;

    //Two teams red & white

    public void onEnable() {
        game = getServer().getServicesManager().getRegistration(CollatGameTemplate.class).getProvider();
        scoreboard = getServer().getServicesManager().getRegistration(CollatScoreboards.class).getProvider();

        //Load The Config File
        loadConfig();

        //Register Teams
        game.newTeam(new CollatGameTeam("Red", 25, ChatColor.RED));
        game.newTeam(new CollatGameTeam("White", 25, ChatColor.WHITE));

        game.getTeam("Red").setAutoRespawn(true);
        game.getTeam("White").setAutoRespawn(true);

        //Register Events
        getServer().getPluginManager().registerEvents(new PlayerJoinGame(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinTeam(), this);
        getServer().getPluginManager().registerEvents(new PlayerLeaveGame(), this);
        getServer().getPluginManager().registerEvents(new PlayerPrevents(), this);
        getServer().getPluginManager().registerEvents(new PlayerTeamSelection(), this);
        getServer().getPluginManager().registerEvents(new PlayerArmourEquip(), this);
        getServer().getPluginManager().registerEvents(new Teams(), this);
        getServer().getPluginManager().registerEvents(new GameTNTExplode(), this);
        getServer().getPluginManager().registerEvents(new GameStart(), this);
        getServer().getPluginManager().registerEvents(new GameEnd(), this);
        getServer().getPluginManager().registerEvents(new GameCountdownStart(), this);
        getServer().getPluginManager().registerEvents(new GameSpawnGenerators(), this);
        getServer().getPluginManager().registerEvents(new PlayerRespawnEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeathEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerPlaceBlock(), this);
        getServer().getPluginManager().registerEvents(new PlayerBreakBlock(), this);

        //Item Generators
        getServer().getPluginManager().registerEvents(new CoalGenerators(), this);
        getServer().getPluginManager().registerEvents(new IronGenerators(), this);
        getServer().getPluginManager().registerEvents(new GoldGenerators(), this);
        getServer().getPluginManager().registerEvents(new EmeraldGenerators(), this);
        getServer().getPluginManager().registerEvents(new DiamondGenerators(), this);

        //Utility
        getServer().getPluginManager().registerEvents(new ExplosiveCake(), this);
        getServer().getPluginManager().registerEvents(new PlayerTracker(), this);

        //VillagerShops
        getServer().getPluginManager().registerEvents(new ShopsGUIBuy(), this);
        getServer().getPluginManager().registerEvents(new ShopsGUIInteract(), this);
        getServer().getPluginManager().registerEvents(new ShopsGUIMenu(), this);
        getServer().getPluginManager().registerEvents(new ShopsInteract(), this);
        getServer().getPluginManager().registerEvents(new ShopsSpawn(), this);

        //Extras
        getServer().getPluginManager().registerEvents(new DepositBoxes(), this);
        getServer().getPluginManager().registerEvents(new CalculateItems(), this);
        getServer().getPluginManager().registerEvents(new Beds(), this);
        getServer().getPluginManager().registerEvents(new Config(), this);
        getServer().getPluginManager().registerEvents(new Scoreboard(), this);

        //Register Commands
        this.getCommand("team").setExecutor(new Teams());
        this.getCommand("red").setExecutor(new Teams());
        this.getCommand("white").setExecutor(new Teams());
        this.getCommand("pp").setExecutor(new Config());

        //Remove Villager Shops
        String worldName = getConfig().getString("Active");

        for (Entity entity : Bukkit.getWorld(worldName).getEntities()) {
            if (entity.getType().equals(EntityType.VILLAGER)) {
                entity.remove();
            }
        }
    }

    public void loadConfig() {
        //getConfig().options().copyDefaults(true);
        saveConfig();
    }

}
