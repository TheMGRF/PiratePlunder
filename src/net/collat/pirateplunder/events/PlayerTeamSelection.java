package net.collat.pirateplunder.events;

import net.collat.gametemplate.GameState;
import net.collat.pirateplunder.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class PlayerTeamSelection implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (player.getInventory().getItemInMainHand().getType() != Material.AIR) {
            if (player.getInventory().getItemInMainHand().getItemMeta().hasDisplayName()) {
                if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("§6Team Selector")) {
                    if (Main.game.getGameState() == GameState.IDLE) {
                        teamSelector(player);
                    } else {
                        player.sendMessage("§4● §cYou cannot switch teams once the game has started!");
                    }
                }
            }
        }
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent event) {
        if (event.getInventory() != null) {
            if (event.getInventory().getName().equals("§cTeam Selector")) {
                Player player = (Player) event.getWhoClicked();
                event.setCancelled(true);
                if (event.getCurrentItem() != null) {
                    if (event.getCurrentItem().getType() != Material.AIR) {
                        if (event.getCurrentItem().getItemMeta().hasDisplayName()) {
                            if (event.getCurrentItem().getItemMeta().getDisplayName().contains("§c§nRed Team")) {
                                joinTeam(player, "Red");
                                teamSelector(player);
                            } else if (event.getCurrentItem().getItemMeta().getDisplayName().contains("§f§nWhite Team")) {
                                joinTeam(player, "White");
                                teamSelector(player);
                            }
                        }
                    }
                }
            }
        }
    }

    public void teamSelector(Player player) {

        int redTotal = Main.game.getTeam("Red").getPlayerAmount();
        int whiteTotal = Main.game.getTeam("White").getPlayerAmount();

        Inventory inv = Bukkit.createInventory(null, 9, "§cTeam Selector");

        //Red Team
        ItemStack red = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 14);
        ItemMeta redMeta = red.getItemMeta();
        redMeta.setDisplayName("§c§nRed Team§7 (" + redTotal + "/25)");

        ArrayList<String> redLore = new ArrayList<>();
        redLore.add("");
        if (Main.game.getPlayerTeam(player).getName().equals("Red")) {
            redMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
            redMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

            redLore.add("§7► §aCurrent team!");
            redLore.add("");
            redLore.add("§eMembers:");
            for (Player member : Main.game.getTeam("Red").getPlayers()) {
                redLore.add(" §7► §6" + member.getDisplayName());
            }
        } else {
            redLore.add("§7► §aClick to join!");
            redLore.add("");
            redLore.add("§eMembers:");
            if (Main.game.getTeam("Red").getPlayers().size() != 0) {
                for (Player member : Main.game.getTeam("Red").getPlayers()) {
                    redLore.add(" §7► §6" + member.getDisplayName());
                }
            } else {
                redLore.add(" §7► §6none");
            }
        }

        redMeta.setLore(redLore);
        red.setItemMeta(redMeta);

        inv.setItem(3, red);

        //white Team
        ItemStack white = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 0);
        ItemMeta whiteMeta = white.getItemMeta();
        whiteMeta.setDisplayName("§f§nWhite Team§7 (" + whiteTotal + "/25)");

        ArrayList<String> whiteLore = new ArrayList<>();
        whiteLore.add("");
        if (Main.game.getPlayerTeam(player).getName().equals("White")) {
            whiteMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
            whiteMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            whiteLore.add("§7► §aCurrent team!");
            whiteLore.add("");
            whiteLore.add("§eMembers:");
            for (Player member : Main.game.getTeam("White").getPlayers()) {
                whiteLore.add(" §7► §6" + member.getDisplayName());
            }
        } else {
            whiteLore.add("§7► §aClick to join!");
            whiteLore.add("");
            whiteLore.add("§eMembers:");
            if (Main.game.getTeam("White").getPlayers().size() != 0) {
                for (Player member : Main.game.getTeam("White").getPlayers()) {
                    whiteLore.add(" §7► §6" + member.getDisplayName());
                }
            } else {
                whiteLore.add(" §7► §6none");
            }
        }

        whiteMeta.setLore(whiteLore);
        white.setItemMeta(whiteMeta);

        inv.setItem(5, white);

        player.openInventory(inv);
    }

    public void joinTeam(Player player, String team) {
        Main.game.setPlayerTeam(player, team);
    }

}


