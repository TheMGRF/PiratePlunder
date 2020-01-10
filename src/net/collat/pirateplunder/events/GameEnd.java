package net.collat.pirateplunder.events;

import net.collat.gametemplate.events.GameEndEvent;
import net.collat.pirateplunder.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;

public class GameEnd implements Listener {

    private Plugin plugin = Main.getPlugin(Main.class);

    @EventHandler
    public void onGameEnd(GameEndEvent event) {

        String worldName = plugin.getConfig().getString("Active");

        for (Entity entity : Bukkit.getWorld(worldName).getEntities()) {
            if (entity.getType().equals(EntityType.VILLAGER)) {
                entity.remove();
            }
        }
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        if (event.getMessage().equals("!killvillagers")) {
            event.setCancelled(true);
            String worldName = plugin.getConfig().getString("Active");

            for (Entity entity : Bukkit.getWorld(worldName).getEntities()) {
                if (entity.getType().equals(EntityType.VILLAGER)) {
                    entity.remove();
                }
            }
        }
    }

}
