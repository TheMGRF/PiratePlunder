package net.collat.pirateplunder.events;

import net.collat.pirateplunder.Main;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class PlayerArmourEquip implements Listener {

    @EventHandler
    public void onArmourEquip(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (player.getInventory().getItemInMainHand().getType() == Material.LEATHER_HELMET) {
            dyeArmour(player, player.getInventory().getItemInMainHand());
        } else if (player.getInventory().getItemInMainHand().getType() == Material.LEATHER_CHESTPLATE) {
            dyeArmour(player, player.getInventory().getItemInMainHand());
        } else if (player.getInventory().getItemInMainHand().getType() == Material.LEATHER_LEGGINGS) {
            dyeArmour(player, player.getInventory().getItemInMainHand());
        } else if (player.getInventory().getItemInMainHand().getType() == Material.LEATHER_BOOTS) {
            dyeArmour(player, player.getInventory().getItemInMainHand());
        }
    }

    @EventHandler
    private void onArmourPickup(PlayerPickupItemEvent event) {
        Player player = event.getPlayer();

        if (event.getItem().getItemStack().getType() == Material.LEATHER_CHESTPLATE) {
            dyeArmour(player, event.getItem().getItemStack());
        } else if (event.getItem().getItemStack().getType() == Material.LEATHER_CHESTPLATE) {
            dyeArmour(player, event.getItem().getItemStack());
        } else if (event.getItem().getItemStack().getType() == Material.LEATHER_LEGGINGS) {
            dyeArmour(player, event.getItem().getItemStack());
        } else if (event.getItem().getItemStack().getType() == Material.LEATHER_BOOTS) {
            dyeArmour(player, event.getItem().getItemStack());
        }
    }

    @EventHandler
    private void onArmourDrop(PlayerDropItemEvent event) {
        Player player = event.getPlayer();

        if (event.getItemDrop().getItemStack().getType() == Material.LEATHER_HELMET) {
            dyeArmour(player, event.getItemDrop().getItemStack());
        }
        else if (event.getItemDrop().getItemStack().getType() == Material.LEATHER_CHESTPLATE) {
            dyeArmour(player, event.getItemDrop().getItemStack());
        } else if (event.getItemDrop().getItemStack().getType() == Material.LEATHER_LEGGINGS) {
            dyeArmour(player, event.getItemDrop().getItemStack());
        } else if (event.getItemDrop().getItemStack().getType() == Material.LEATHER_BOOTS) {
            dyeArmour(player, event.getItemDrop().getItemStack());
        }
    }

    private void dyeArmour(Player player, ItemStack armour) {
        LeatherArmorMeta armourMeta = (LeatherArmorMeta) armour.getItemMeta();
        if (Main.game.getPlayerTeam(player).getName() == "Red") {
            armourMeta.setColor(Color.fromRGB(255, 26, 26));
        } else if (Main.game.getPlayerTeam(player).getName() == "White") {
            armourMeta.setColor(Color.WHITE);
        }

        armour.setItemMeta(armourMeta);
    }

}
