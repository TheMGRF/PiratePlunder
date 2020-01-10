package net.collat.pirateplunder.villagershops;

import net.collat.gametemplate.GameState;
import net.collat.pirateplunder.Main;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class ShopsInteract implements Listener {

    private ShopsGUIMenu sgm = new ShopsGUIMenu();

    @EventHandler
    private void onDamage(EntityDamageEvent event) {
        if (event.getEntity().getType().equals(EntityType.VILLAGER)){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onTrade(PlayerInteractEntityEvent event) {
        if (event.getRightClicked().getType().equals(EntityType.VILLAGER)) {
            if (Main.game.getGameState() == GameState.STARTED) {
                Player player = event.getPlayer();
                event.setCancelled(true);
                sgm.shopGUI(player);
            }
        }
    }

}
