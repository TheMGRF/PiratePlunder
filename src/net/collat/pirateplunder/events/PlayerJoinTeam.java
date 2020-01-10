package net.collat.pirateplunder.events;

import net.collat.gametemplate.events.GamePlayerJoinTeamEvent;
import net.collat.pirateplunder.Main;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerJoinTeam implements Listener {

    @EventHandler
    public void joinTeam(GamePlayerJoinTeamEvent event) {
        Player player = event.getPlayer();
        player.sendMessage("§2● §aYou have joined team " + Main.game.getPlayerTeam(player).getName());
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.5F, 1);
    }

}
