package net.collat.pirateplunder;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class CalculateItems implements Listener {

    public int countDiamonds(Player player) {
        int item = 0;

        for (ItemStack loopItem : player.getInventory().getContents()) {
            if (loopItem != null) {
                if (loopItem.getType().equals(Material.DIAMOND)) {
                    item = item + loopItem.getAmount();
                }
            }
        }
        return item;
    }

    public int countEmeralds(Player player) {
        int item = 0;

        for (ItemStack loopItem : player.getInventory().getContents()) {
            if (loopItem != null) {
                if (loopItem.getType().equals(Material.EMERALD)) {
                    item = item + loopItem.getAmount();
                }
            }
        }
        return item;
    }

    public int countGold(Player player) {
        int item = 0;

        for (ItemStack loopItem : player.getInventory().getContents()) {
            if (loopItem != null) {
                if (loopItem.getType().equals(Material.GOLD_INGOT)) {
                    item = item + loopItem.getAmount();
                }
            }
        }
        return item;
    }

    public int countIron(Player player) {
        int item = 0;

        for (ItemStack loopItem : player.getInventory().getContents()) {
            if (loopItem != null) {
                if (loopItem.getType().equals(Material.IRON_INGOT)) {
                    item = item + loopItem.getAmount();
                }
            }
        }
        return item;
    }

    public int countCoal(Player player) {
        int item = 0;

        for (ItemStack loopItem : player.getInventory().getContents()) {
            if (loopItem != null) {
                if (loopItem.getType().equals(Material.COAL)) {
                    item = item + loopItem.getAmount();
                }
            }
        }
        return item;
    }
}
