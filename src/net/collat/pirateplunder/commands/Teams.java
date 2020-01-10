package net.collat.pirateplunder.commands;

import net.collat.gametemplate.GameState;
import net.collat.pirateplunder.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Teams implements CommandExecutor, Listener {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("team")) {
            if (Main.game.getGameState() == GameState.IDLE) {
                if (args.length != 0) {
                    if (args[0].equalsIgnoreCase("red")) {
                        Main.game.setPlayerTeam(player, "Red");
                    } else if (args[0].equalsIgnoreCase("white")) {
                        Main.game.setPlayerTeam(player, "White");
                    } else {
                        player.sendMessage("§4● §c" + args[0] + " is not a valid team!");
                    }
                    return true;
                } else {
                    player.sendMessage("§4● §cYou must specify a team name!");
                    return true;
                }
            } else {
                player.sendMessage("§4● §cYou cannot switch teams one the game has started!");
                return true;
            }
        }

        if (cmd.getName().equalsIgnoreCase("red")) {
            if (Main.game.getGameState() == GameState.IDLE) {
                Main.game.setPlayerTeam(player, "Red");
            } else {
                player.sendMessage("§4● §cYou cannot switch teams one the game has started!");
            }
            return true;
        }

        if (cmd.getName().equalsIgnoreCase("white")) {
            if (Main.game.getGameState() == GameState.IDLE) {
                Main.game.setPlayerTeam(player, "White");
            } else {
                player.sendMessage("§4● §cYou cannot switch teams one the game has started!");
            }
            return true;
        }

        return false;
    }
}
