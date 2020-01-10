package net.collat.pirateplunder.villagershops;

import net.collat.pirateplunder.CalculateItems;
import net.collat.pirateplunder.Main;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class ShopsGUIBuy implements Listener {

    private CalculateItems ci = new CalculateItems();

    public void buyItem(Player player, Material item, int amount, int cost, String type) {



        int diamond = ci.countDiamonds(player);
        int emerald = ci.countEmeralds(player);
        int gold = ci.countGold(player);
        int iron = ci.countIron(player);
        int coal = ci.countCoal(player);

        byte team = (byte) 0;
        if (Main.game.getPlayerTeam(player).getName().equals("Red")) {
            team = (byte) 14;
        } else if (Main.game.getPlayerTeam(player).getName().equals("White")) {
            team = (byte) 0;
        }

        if (type.equals("diamond")) {
            if (diamond >= cost) {
                Material itemType = Material.DIAMOND;
                addItem(player, item, amount, team, cost, itemType);
            } else {
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BASS, 1, 1);
            }
        } else if (type.equals("emerald")) {
            if (emerald >= cost) {
                Material itemType = Material.EMERALD;
                addItem(player, item, amount, team, cost, itemType);
            } else {
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BASS, 1, 1);
            }
        } else if (type.equals("gold")) {
            if (gold >= cost) {
                Material itemType = Material.GOLD_INGOT;
                addItem(player, item, amount, team, cost, itemType);
            } else {
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BASS, 1, 1);
            }
        } else if (type.equals("iron")) {
            if (iron >= cost) {
                Material itemType = Material.IRON_INGOT;
                addItem(player, item, amount, team, cost, itemType);
            } else {
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BASS, 1, 1);
            }
        } else if (type.equals("coal")) {
            if (coal >= cost) {
                Material itemType = Material.COAL;
                addItem(player, item, amount, team, cost, itemType);
            } else {
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BASS, 1, 1);
            }
        }
    }

    private void addItem(Player player, Material item, int amount, byte team, int cost, Material itemType) {
        player.getInventory().removeItem(new ItemStack(itemType, cost));

        if (player.getInventory().firstEmpty() == -1) {
            player.sendMessage("§4● §cInventory is full, dropping purchased items on ground!");
            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BASS, 1, 2);

            if (item != Material.WOOL) {
                player.getWorld().dropItem(player.getLocation(), new ItemStack(item, amount));
            } else {
                player.getWorld().dropItem(player.getLocation(), new ItemStack(item, amount, team));
            }
        } else {
            if (item != Material.WOOL) {
                player.getInventory().addItem(new ItemStack(item, amount));
            } else {
                player.getInventory().addItem(new ItemStack(item, amount, team));
            }
        }


        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_PLING, 1, 1);
    }

}
