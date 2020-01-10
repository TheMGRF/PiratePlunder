package net.collat.pirateplunder.events;

import net.collat.gametemplate.events.GameCountdownStartEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class GameCountdownStart implements Listener {

    @EventHandler
    public void onCountdown(GameCountdownStartEvent event) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            clearStartItems(player);
        }
    }

    private void clearStartItems(Player player) {
        for (ItemStack item : player.getInventory()) {
            if (item != null) {
                if (item.getItemMeta().hasDisplayName()) {
                    if (item.getItemMeta().getDisplayName().equals("§6Team Selector") || item.getItemMeta().getDisplayName().equals("§6Loadouts")) {
                        player.getInventory().removeItem(item);
                    }
                }
            }
        }
    }

}
