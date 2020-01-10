package net.collat.pirateplunder.utility;

import net.collat.pirateplunder.Main;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerTracker implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        if (player.getInventory().getItemInMainHand().hasItemMeta()) {
            if (player.getInventory().getItemInMainHand().getItemMeta().hasDisplayName()) {
                if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("§c§lPlayer Tracker")) {
                    for (Player online : Bukkit.getOnlinePlayers()) {
                        if (Main.game.getPlayerTeam(online).getName() != Main.game.getPlayerTeam(player).getName()) {
                            player.setCompassTarget(online.getLocation());
                            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new ComponentBuilder("§eTracking " + online.getCustomName()).create());
                        }
                    }
                }
            }
        }
    }

}
