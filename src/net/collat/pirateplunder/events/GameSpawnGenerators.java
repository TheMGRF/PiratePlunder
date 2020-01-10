package net.collat.pirateplunder.events;

import net.collat.gametemplate.events.GameStartEvent;
import net.collat.pirateplunder.itemgenerators.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class GameSpawnGenerators implements Listener {

    CoalGenerators coal = new CoalGenerators();
    IronGenerators iron = new IronGenerators();
    GoldGenerators gold = new GoldGenerators();
    EmeraldGenerators emerald = new EmeraldGenerators();
    DiamondGenerators diamond = new DiamondGenerators();

    @EventHandler
    public void onGameStart(GameStartEvent event) {
        coal.spawnCoalGenerator();
        iron.spawnIronGenerator();
        gold.spawnGoldGenerator();
        emerald.spawnEmeraldGenerator();
        diamond.spawnDiamondGenerator();
    }

}
