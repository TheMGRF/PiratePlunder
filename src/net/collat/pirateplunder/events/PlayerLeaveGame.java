package net.collat.pirateplunder.events;

import net.collat.pirateplunder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeaveGame implements Listener {

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        Main.winPoints -= 1000;
    }

}
