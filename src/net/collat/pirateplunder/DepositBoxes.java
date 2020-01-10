package net.collat.pirateplunder;

import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;
import net.collat.gametemplate.CollatGameTeam;
import net.collat.gametemplate.GameState;
import net.collat.gametemplate.events.GameStartEvent;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class DepositBoxes implements Listener {

    private Plugin plugin = Main.getPlugin(Main.class);

    private RandomFirework rf = new RandomFirework();
    private Scoreboard scoreboard = new Scoreboard();

    private String worldName = plugin.getConfig().getString("Active");
    private World world = Bukkit.getWorld(worldName);

    //Load Holograms + Chests
    @EventHandler
    public void onGameStart(GameStartEvent event) {
        //use team like deposit below

        for (CollatGameTeam team : Main.game.getTeams()) {
            double x = plugin.getConfig().getDouble("Maps." + world.getName() + ".Locations.Deposit." + team.getName() + ".x");
            double y = plugin.getConfig().getDouble("Maps." + world.getName() + ".Locations.Deposit." + team.getName() + ".y");
            double z = plugin.getConfig().getDouble("Maps." + world.getName() + ".Locations.Deposit." + team.getName() + ".z");
            Location loc1 = new Location(world, x, y, z);
            Location holo = new Location(world, x, y, z).add(0.5, 1.5, 0.5);

            loc1.getBlock().setType(Material.CHEST);

            Hologram teamHolo = HologramsAPI.createHologram(plugin, holo);
            if (team.getName().equals("Red")) {
                teamHolo.appendTextLine("§c§lRed's Chest");
            } else if (team.getName().equals("White")) {
                teamHolo.appendTextLine("§f§lWhite's Chest");
            } else {
                teamHolo.appendTextLine("§4§lERROR OCCURRED");
            }
            teamHolo.appendTextLine("§eProgress: §7▌▌▌▌▌▌▌▌▌▌");
        }
    }

    @EventHandler
    public void onDeposit(PlayerInteractEvent event) {
        if (Main.game.getGameState() == GameState.STARTED) {
            Player player = event.getPlayer();
            Block block = event.getClickedBlock();
            if (block != null) {
                if (block.getType() != Material.AIR) {
                    if (block.getType() == Material.CHEST) {
                        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                            String team = Main.game.getPlayerTeam(player).getName();

                            double x = plugin.getConfig().getDouble("Maps." + world.getName() + ".Locations.Deposit." + team + ".x");
                            double y = plugin.getConfig().getDouble("Maps." + world.getName() + ".Locations.Deposit." + team + ".y");
                            double z = plugin.getConfig().getDouble("Maps." + world.getName() + ".Locations.Deposit." + team + ".z");

                            if (x == block.getLocation().getX() && y == block.getLocation().getY() && z == block.getLocation().getZ()) {
                                event.setCancelled(true);
                                int players = Bukkit.getOnlinePlayers().size();
                                if (player.getInventory().getItemInMainHand() != null) {
                                    if (player.getInventory().getItemInMainHand().getType() != Material.AIR) {
                                        if (player.getInventory().getItemInMainHand().getType() == Material.DIAMOND) {
                                            depositItems(player, team, x, y, z, itemValue(1000, players));
                                        } else if (player.getInventory().getItemInMainHand().getType() == Material.EMERALD) {
                                            depositItems(player, team, x, y, z, itemValue(500, players));
                                        } else if (player.getInventory().getItemInMainHand().getType() == Material.GOLD_INGOT) {
                                            depositItems(player, team, x, y, z, itemValue(250, players));
                                        } else if (player.getInventory().getItemInMainHand().getType() == Material.IRON_INGOT) {
                                            depositItems(player, team, x, y, z, itemValue(100, players));
                                        } else if (player.getInventory().getItemInMainHand().getType() == Material.COAL) {
                                            depositItems(player, team, x, y, z, itemValue(25, players));
                                        }
                                    } else {
                                        player.sendMessage("§6● §eDeposit ingots and gems to earn more points!");
                                    }
                                } else {
                                    player.sendMessage("§6● §eDeposit ingots and gems to earn more points!");
                                }
                            } else {
                                String enemy;
                                if (team.equals("Red")) {
                                    enemy = "White";
                                } else {
                                    enemy = "Red";
                                }
                                x = plugin.getConfig().getDouble("Maps." + world.getName() + ".Locations.Deposit." + enemy + ".x");
                                y = plugin.getConfig().getDouble("Maps." + world.getName() + ".Locations.Deposit." + enemy + ".y");
                                z = plugin.getConfig().getDouble("Maps." + world.getName() + ".Locations.Deposit." + enemy + ".z");

                                if (x == block.getLocation().getX() && y == block.getLocation().getY() && z == block.getLocation().getZ()) {
                                    event.setCancelled(true);

                                    if (team.equals("Red")) {
                                        if (Main.whiteScore >= 90000) {
                                            Main.whiteScore -= itemValue(1000, Bukkit.getOnlinePlayers().size());
                                            player.getInventory().addItem(new ItemStack(Material.DIAMOND));
                                            player.playSound(player.getLocation(), Sound.ENTITY_HORSE_ARMOR, 0.5F, 1.5F);
                                            minusScorePopup(player, x, y, z, 1000.0);
                                        } else if (Main.whiteScore >= 75000) {
                                            Main.whiteScore -= itemValue(500, Bukkit.getOnlinePlayers().size());
                                            player.getInventory().addItem(new ItemStack(Material.EMERALD));
                                            player.playSound(player.getLocation(), Sound.ENTITY_HORSE_ARMOR, 0.5F, 1.5F);
                                            minusScorePopup(player, x, y, z, 500.0);
                                        } else if (Main.whiteScore >= 50000) {
                                            Main.whiteScore -= itemValue(250, Bukkit.getOnlinePlayers().size());
                                            player.getInventory().addItem(new ItemStack(Material.GOLD_INGOT));
                                            player.playSound(player.getLocation(), Sound.ENTITY_HORSE_ARMOR, 0.5F, 1.5F);
                                            minusScorePopup(player, x, y, z, 250.0);
                                        } else if (Main.whiteScore >= 25000) {
                                            Main.whiteScore -= itemValue(100, Bukkit.getOnlinePlayers().size());
                                            player.getInventory().addItem(new ItemStack(Material.IRON_INGOT));
                                            player.playSound(player.getLocation(), Sound.ENTITY_HORSE_ARMOR, 0.5F, 1.5F);
                                            minusScorePopup(player, x, y, z, 100.0);
                                        } else if (Main.whiteScore >= 25) {
                                            Main.whiteScore -= itemValue(25, Bukkit.getOnlinePlayers().size());
                                            player.getInventory().addItem(new ItemStack(Material.COAL));
                                            player.playSound(player.getLocation(), Sound.ENTITY_HORSE_ARMOR, 0.5F, 1.5F);
                                            minusScorePopup(player, x, y, z, 25.0);
                                        } else if (Main.whiteScore <= 0) {
                                            player.sendMessage("§4● §cThis chest is vulnerable! §lBreak it to stop White team from respawning!");
                                            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BASS, 0.5F, 1);
                                        } else {
                                            player.sendMessage("§4● §cThis chest is vulnerable! §lBreak it to stop White team from respawning!");
                                            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BASS, 0.5F, 1);
                                        }
                                        updateHologram(x, y, z, Main.whiteScore, "White");
                                    } else {
                                        if (Main.redScore >= 90000) {
                                            Main.redScore -= itemValue(1000, Bukkit.getOnlinePlayers().size());
                                            player.getInventory().addItem(new ItemStack(Material.DIAMOND));
                                            player.playSound(player.getLocation(), Sound.ENTITY_HORSE_ARMOR, 0.5F, 1.5F);
                                        } else if (Main.redScore >= 75000) {
                                            Main.redScore -= itemValue(500, Bukkit.getOnlinePlayers().size());
                                            player.getInventory().addItem(new ItemStack(Material.EMERALD));
                                            player.playSound(player.getLocation(), Sound.ENTITY_HORSE_ARMOR, 0.5F, 1.5F);
                                        } else if (Main.redScore >= 50000) {
                                            Main.redScore -= itemValue(250, Bukkit.getOnlinePlayers().size());
                                            player.getInventory().addItem(new ItemStack(Material.GOLD_INGOT));
                                            player.playSound(player.getLocation(), Sound.ENTITY_HORSE_ARMOR, 0.5F, 1.5F);
                                        } else if (Main.redScore >= 25000) {
                                            Main.redScore -= itemValue(100, Bukkit.getOnlinePlayers().size());
                                            player.getInventory().addItem(new ItemStack(Material.IRON_INGOT));
                                            player.playSound(player.getLocation(), Sound.ENTITY_HORSE_ARMOR, 0.5F, 1.5F);
                                        } else if (Main.redScore >= 25) {
                                            Main.redScore -= itemValue(25, Bukkit.getOnlinePlayers().size());
                                            player.getInventory().addItem(new ItemStack(Material.COAL));
                                            player.playSound(player.getLocation(), Sound.ENTITY_HORSE_ARMOR, 0.5F, 1.5F);
                                        } else if (Main.redScore <= 0) {
                                            player.sendMessage("§4● §cThis chest is vulnerable! §lBreak it to stop White team from respawning!");
                                            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BASS, 0.5F, 1);
                                        } else {
                                            player.sendMessage("§4● §cThis chest is vulnerable! §lBreak it to stop White team from respawning!");
                                            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BASS, 0.5F, 1);
                                        }
                                        updateHologram(x, y, z, Main.redScore, "Red");
                                    }
                                }
                                scoreboard.updateScoreboard();
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onBreak(BlockBreakEvent event) {
        if (Main.game.getGameState() == GameState.STARTED) {
            Player player = event.getPlayer();
            Block block = event.getBlock();
            if (block != null) {
                if (block.getType() != Material.AIR) {
                    if (block.getType() == Material.CHEST) {
                        if (Main.game.getPlayerTeam(player).getName() == "Red") {
                            double xw = plugin.getConfig().getDouble("Maps." + world.getName() + ".Locations.Deposit.White.x");
                            double yw = plugin.getConfig().getDouble("Maps." + world.getName() + ".Locations.Deposit.White.y");
                            double zw = plugin.getConfig().getDouble("Maps." + world.getName() + ".Locations.Deposit.White.z");

                            double xr = plugin.getConfig().getDouble("Maps." + world.getName() + ".Locations.Deposit.Red.x");
                            double yr = plugin.getConfig().getDouble("Maps." + world.getName() + ".Locations.Deposit.Red.y");
                            double zr = plugin.getConfig().getDouble("Maps." + world.getName() + ".Locations.Deposit.Red.z");

                            if (xw == block.getLocation().getX() && yw == block.getLocation().getY() && zw == block.getLocation().getZ()) {
                                event.setCancelled(true);
                                if (Main.whiteScore <= 0) {
                                    for (Player online : Bukkit.getOnlinePlayers()) {
                                        online.playSound(online.getLocation(), Sound.ENTITY_ENDERDRAGON_DEATH, 1, 1);
                                    }
                                    Main.whiteChestState = false;
                                    Bukkit.broadcastMessage("§f§lWHITES CHEST WAS DESTROYED");
                                    Main.game.getTeam("White").setAutoRespawn(false);
                                    block.setType(Material.BEDROCK);
                                } else {
                                    player.sendMessage("§4● §cWhite's chest needs to be empty before you can break it!");
                                }
                            } else if (xr == block.getLocation().getX() && yr == block.getLocation().getY() && zr == block.getLocation().getZ()) {
                                event.setCancelled(true);
                                player.sendMessage("§4● §cYou cannot break your own teams chest!");
                                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BASS, 1, 1);
                            }
                        } else {
                            double xr = plugin.getConfig().getDouble("Maps." + world.getName() + ".Locations.Deposit.Red.x");
                            double yr = plugin.getConfig().getDouble("Maps." + world.getName() + ".Locations.Deposit.Red.y");
                            double zr = plugin.getConfig().getDouble("Maps." + world.getName() + ".Locations.Deposit.Red.z");

                            double xw = plugin.getConfig().getDouble("Maps." + world.getName() + ".Locations.Deposit.White.x");
                            double yw = plugin.getConfig().getDouble("Maps." + world.getName() + ".Locations.Deposit.White.y");
                            double zw = plugin.getConfig().getDouble("Maps." + world.getName() + ".Locations.Deposit.White.z");

                            if (xr == block.getLocation().getX() && yr == block.getLocation().getY() && zr == block.getLocation().getZ()) {
                                event.setCancelled(true);
                                if (Main.redScore <= 0) {
                                    for (Player online : Bukkit.getOnlinePlayers()) {
                                        online.playSound(online.getLocation(), Sound.ENTITY_ENDERDRAGON_DEATH, 1, 1);
                                    }
                                    Main.redChestState = false;
                                    Bukkit.broadcastMessage("§c§lREDS CHEST WAS DESTROYED");
                                    Main.game.getTeam("Red").setAutoRespawn(false);
                                    block.setType(Material.BEDROCK);
                                } else {
                                    player.sendMessage("§4● §cRed's chest needs to be empty before you can break it!");
                                }
                            } else if (xw == block.getLocation().getX() && yw == block.getLocation().getY() && zw == block.getLocation().getZ()) {
                                event.setCancelled(true);
                                player.sendMessage("§4● §cYou cannot break your own teams chest!");
                                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BASS, 1, 1);
                            }
                        }
                    }
                }
            }
        }
    }

    private double itemValue(int value, int players) {
        return value * (2 - (1 / 100 * players));
    }

    private void depositItems(Player player, String team, double x, double y, double z, double score) {
        int teamScore = 0;
        player.getInventory().removeItem(new ItemStack(player.getInventory().getItemInMainHand().getType(), 1));

        if (team.equals("Red")) {
            teamScore = Main.redScore;
            Main.redScore += score;
            addScorePopup(player, x, y, z, score);
        } else if (team.equals("White")) {
            teamScore = Main.whiteScore;
            Main.whiteScore += score;
            addScorePopup(player, x, y, z, score);
        }

        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.5F, 1.6F);
        teamScore += score;

        updateHologram(x, y, z, teamScore, team);
        return;
    }

    private void addScorePopup(Player player, double x, double y, double z, double score) {
        Location holo = new Location(player.getWorld(), x, y, z).add(0.5, 2, 0.5);
        Hologram addScore = HologramsAPI.createHologram(plugin, holo);
        addScore.appendTextLine("§e§l+" + (int) score);
        Bukkit.getScheduler ().runTaskLater (plugin, () -> addScore.delete(), 5);
    }

    private void minusScorePopup(Player player, double x, double y, double z, double score) {
        Location holo = new Location(player.getWorld(), x, y, z).add(0.5, 2, 0.5);
        Hologram minusScore = HologramsAPI.createHologram(plugin, holo);
        minusScore.appendTextLine("§c§l-" + (int) score);
        Bukkit.getScheduler ().runTaskLater (plugin, () -> minusScore.delete(), 5);
    }

    private void updateHologram(double x, double y, double z, int teamScore, String team) {
        for (Hologram hologram : HologramsAPI.getHolograms(plugin)) {
            if (hologram.getX() == (x + 0.5)) {
                if (hologram.getY() == (y + 1.5)) {
                    if (hologram.getZ() == (z + 0.5)) {
                        hologram.removeLine(1);

                        if (teamScore >= (Main.winPoints + 1)) {
                            hologram.appendTextLine("§6§lWINNER");

                            for (int i = 0; i < 10; i++) {
                                rf.spawnFirework(hologram.getLocation());
                            }

                            announceWin(team);

                            Main.game.endGame();

                        } else if (teamScore >= Main.winPoints) {
                            hologram.appendTextLine("§eProgress: §a▌▌▌▌▌▌▌▌▌▌");
                        } else if (teamScore >= (0.9 * Main.winPoints)) {
                            hologram.appendTextLine("§eProgress: §a▌▌▌▌▌▌▌▌▌§7▌");
                        } else if (teamScore >= (0.8 * Main.winPoints)) {
                            hologram.appendTextLine("§eProgress: §a▌▌▌▌▌▌▌▌§7▌▌");
                        } else if (teamScore >= (0.7 * Main.winPoints)) {
                            hologram.appendTextLine("§eProgress: §a▌▌▌▌▌▌▌§7▌▌▌");
                        } else if (teamScore >= (0.6 * Main.winPoints)) {
                            hologram.appendTextLine("§eProgress: §a▌▌▌▌▌▌§7▌▌▌▌");
                        } else if (teamScore >= (0.5 * Main.winPoints)) {
                            hologram.appendTextLine("§eProgress: §a▌▌▌▌▌§7▌▌▌▌▌");
                        } else if (teamScore >= (0.4 * Main.winPoints)) {
                            hologram.appendTextLine("§eProgress: §a▌▌▌▌§7▌▌▌▌▌▌");
                        } else if (teamScore >= (0.3 * Main.winPoints)) {
                            hologram.appendTextLine("§eProgress: §a▌▌▌§7▌▌▌▌▌▌▌");
                        } else if (teamScore >= (0.2 * Main.winPoints)) {
                            hologram.appendTextLine("§eProgress: §a▌▌§7▌▌▌▌▌▌▌▌");
                        } else if (teamScore >= (0.1 * Main.winPoints)) {
                            hologram.appendTextLine("§eProgress: §a▌§7▌▌▌▌▌▌▌▌▌");
                        } else if (teamScore >= (0.05 * Main.winPoints)) {
                            hologram.appendTextLine("§eProgress: §a▌§7▌▌▌▌▌▌▌▌▌");
                        } else if (teamScore >= 1) {
                            hologram.appendTextLine("§eProgress: §a▌§7▌▌▌▌▌▌▌▌▌");
                        } else {
                            hologram.appendTextLine("§eProgress: §7▌▌▌▌▌▌▌▌▌▌");
                        }
                        scoreboard.updateScoreboard();
                    }
                }
            }
        }
    }

    public void announceWin(String team) {
        if (team.equals("Red")) {
            Bukkit.broadcastMessage("§6§lVICTORY FOR TEAM §c§lRED");
            for (Player online : Bukkit.getOnlinePlayers()) {
                if (Main.game.getPlayerTeam(online).getName().equals("Red")) {
                    victory(online);
                    for (int i = 0; i < 10; i++) {
                        rf.spawnFirework(online.getLocation());
                    }
                } else {
                    online.sendTitle("§4§lDEFEAT", "§fRed team won the game!", 10, 64, 10);
                }
            }
        } else if (team.equals("White")) {
            Bukkit.broadcastMessage("§6§lVICTORY FOR TEAM §f§lWHITE");
            for (Player online : Bukkit.getOnlinePlayers()) {
                if (Main.game.getPlayerTeam(online).getName().equals("White")) {
                    victory(online);
                    for (int i = 0; i < 10; i++) {
                        rf.spawnFirework(online.getLocation());
                    }
                } else {
                    online.sendTitle("§4§lDEFEAT", "§fWhite team won the game!", 10, 105, 10);
                }
            }
        }
        Main.game.endGame();
    }

    private void victory(Player online) {
        online.sendTitle("§6§lVICTORY", "§fYou won the game!", 10, 64, 10);

        Bukkit.getScheduler().runTaskLater(plugin, () -> online.sendTitle("§f§lVICTORY", "§fYou won the game!", 0, 64, 0), 20);
        Bukkit.getScheduler().runTaskLater(plugin, () -> online.sendTitle("§6§lVICTORY", "§fYou won the game!", 0, 64, 0), 25);
        Bukkit.getScheduler().runTaskLater(plugin, () -> online.sendTitle("§f§lVICTORY", "§fYou won the game!", 0, 64, 0), 30);
        Bukkit.getScheduler().runTaskLater(plugin, () -> online.sendTitle("§6§lVICTORY", "§fYou won the game!", 0, 64, 0), 35);
        Bukkit.getScheduler().runTaskLater(plugin, () -> online.sendTitle("§f§lVICTORY", "§fYou won the game!", 0, 64, 0), 40);
        Bukkit.getScheduler().runTaskLater(plugin, () -> online.sendTitle("§6§lVICTORY", "§fYou won the game!", 0, 64, 0), 45);
        Bukkit.getScheduler().runTaskLater(plugin, () -> online.sendTitle("§f§lVICTORY", "§fYou won the game!", 0, 64, 0), 50);
        Bukkit.getScheduler().runTaskLater(plugin, () -> online.sendTitle("§6§lVICTORY", "§fYou won the game!", 0, 64, 0), 55);
        Bukkit.getScheduler().runTaskLater(plugin, () -> online.sendTitle("§f§lVICTORY", "§fYou won the game!", 0, 64, 0), 60);
        Bukkit.getScheduler().runTaskLater(plugin, () -> online.sendTitle("§6§lVICTORY", "§fYou won the game!", 0, 64, 0), 65);
        Bukkit.getScheduler().runTaskLater(plugin, () -> online.sendTitle("§f§lVICTORY", "§fYou won the game!", 0, 64, 0), 70);
        Bukkit.getScheduler().runTaskLater(plugin, () -> online.sendTitle("§6§lVICTORY", "§fYou won the game!", 0, 64, 0), 75);
        Bukkit.getScheduler().runTaskLater(plugin, () -> online.sendTitle("§f§lVICTORY", "§fYou won the game!", 0, 64, 0), 80);
        Bukkit.getScheduler().runTaskLater(plugin, () -> online.sendTitle("§6§lVICTORY", "§fYou won the game!", 0, 64, 0), 85);
        Bukkit.getScheduler().runTaskLater(plugin, () -> online.sendTitle("§f§lVICTORY", "§fYou won the game!", 0, 64, 0), 90);
        Bukkit.getScheduler().runTaskLater(plugin, () -> online.sendTitle("§6§lVICTORY", "§fYou won the game!", 0, 64, 0), 95);
        Bukkit.getScheduler().runTaskLater(plugin, () -> online.sendTitle("§f§lVICTORY", "§fYou won the game!", 0, 64, 0), 100);
        Bukkit.getScheduler().runTaskLater(plugin, () -> online.sendTitle("§6§lVICTORY", "§fYou won the game!", 0, 64, 0), 105);
    }
}
