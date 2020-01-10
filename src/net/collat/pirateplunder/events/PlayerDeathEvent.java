package net.collat.pirateplunder.events;

import net.collat.gametemplate.events.GamePlayerDeathEvent;
import net.collat.pirateplunder.DepositBoxes;
import net.collat.pirateplunder.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class PlayerDeathEvent implements Listener {

    private Plugin plugin = Main.getPlugin(Main.class);

    private DepositBoxes db = new DepositBoxes();

    @EventHandler
    public void onCollatDeath(GamePlayerDeathEvent event) {
        Player player = event.getVictim();

        Bukkit.getScheduler ().runTaskLater (plugin, () -> deathCheck(player), 1);
    }

    private void deathCheck(Player player) {
        int teamAlive = 1337;

        if (Main.game.getPlayerTeam(player).getName().equals("Red")) {
            if (Main.redChestState == false) {
                teamAlive = 0;
                for (Player teamMate : Main.game.getPlayerTeam(player).getPlayers()) {
                    if (teamMate.getGameMode() != GameMode.SPECTATOR) {
                        teamAlive++;
                    }
                }
            }
        } else {
            if (Main.whiteChestState == false) {
                teamAlive = 0;
                for (Player teamMate : Main.game.getPlayerTeam(player).getPlayers()) {
                    if (teamMate.getGameMode() != GameMode.SPECTATOR) {
                        teamAlive++;
                    }
                }
            }
        }

        lifeCheck(teamAlive, player);
    }

    private void lifeCheck(int teamAlive, Player player) {
        if (teamAlive == 0) {
            if (Main.game.getPlayerTeam(player).getName().equals("Red")) {
                db.announceWin("White");
            } else {
                db.announceWin("Red");
            }
        }
    }

}
