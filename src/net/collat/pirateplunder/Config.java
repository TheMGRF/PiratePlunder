package net.collat.pirateplunder;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class Config implements Listener, CommandExecutor {

    private Plugin plugin = Main.getPlugin(Main.class);

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equals("pp")) {
            Player player = (Player) sender;
            if (player.isOp()) {
                if (args.length != 0) {
                    if (args[0].equals("reload")) {
                        plugin.reloadConfig();
                        plugin.saveConfig();
                        player.sendMessage("§aConfig reloaded!");
                        return true;
                    } else if (args[0].equals("save")) {
                        plugin.saveConfig();
                        player.sendMessage("§aConfig saved!");
                        return true;
                    } else {
                        player.sendMessage("§c/pp <reload/save>");
                        return true;
                    }
                } else {
                    player.sendMessage("§c/pp <reload/save>");
                    return true;
                }
            }
        }
        return false;
    }
}
