package net.collat.pirateplunder.villagershops;

import net.collat.pirateplunder.CalculateItems;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ShopsGUIInteract implements Listener {

    private ShopsGUIMenu sgm = new ShopsGUIMenu();
    private ShopsGUIBuy sgb = new ShopsGUIBuy();
    private CalculateItems ci = new CalculateItems();

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getInventory().getName().contains("§cShop")) {
            event.setCancelled(true);
            Player player = (Player) event.getWhoClicked();
            if (event.getCurrentItem() != null) {
                if (event.getCurrentItem().getType() != Material.AIR) {
                    if (event.getCurrentItem().getItemMeta().hasDisplayName()) {

                        int diamond = ci.countDiamonds(player);
                        int emerald = ci.countEmeralds(player);
                        int gold = ci.countGold(player);

                        String itemName = event.getCurrentItem().getItemMeta().getDisplayName();
                        if (itemName.equals("§cGo Back")) {
                            sgm.shopGUI(player);
                        } else if (itemName.equals("§6Building Blocks")) {
                            player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1, 1);
                            sgm.blocksGUI(player);
                        } else if (itemName.equals("§6Weapons")) {
                            player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1, 1);
                            sgm.weaponsGUI(player);
                        } else if (itemName.equals("§6Armour")) {
                            player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1, 1);
                            sgm.armourGUI(player);
                        } else if (itemName.equals("§6Tools")) {
                            player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1, 1);
                            sgm.toolsGUI(player);
                        } else if (itemName.equals("§6Utility")) {
                            player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1, 1);
                            sgm.utilityGUI(player);

                        } else if (itemName.equals("§6Dyed Wool §7(x4)")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 4, "iron");
                            sgm.blocksGUI(player);
                        } else if (itemName.equals("§6Dyed Wool §7(x16)")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 16, "iron");
                            sgm.blocksGUI(player);
                        } else if (itemName.equals("§6Dyed Wool §7(x32)")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 32, "iron");
                            sgm.blocksGUI(player);
                        } else if (itemName.equals("§6Dyed Wool §7(x64)")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 64, "iron");
                            sgm.blocksGUI(player);

                        } else if (itemName.equals("§6Sandstone §7(x4)")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 20, "iron");
                            sgm.blocksGUI(player);
                        } else if (itemName.equals("§6Sandstone §7(x16)")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 80, "iron");
                            sgm.blocksGUI(player);
                        } else if (itemName.equals("§6Sandstone §7(x32)")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 160, "iron");
                            sgm.blocksGUI(player);
                        } else if (itemName.equals("§6Sandstone §7(x64)")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 320, "iron");
                            sgm.blocksGUI(player);

                        } else if (itemName.equals("§6Wood §7(x4)")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 32, "iron");
                            sgm.blocksGUI(player);
                        } else if (itemName.equals("§6Wood §7(x16)")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 128, "iron");
                            sgm.blocksGUI(player);
                        } else if (itemName.equals("§6Wood §7(x32)")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 256, "iron");
                            sgm.blocksGUI(player);
                        } else if (itemName.equals("§6Wood §7(x64)")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 512, "iron");
                            sgm.blocksGUI(player);

                        } else if (itemName.equals("§6Obsidian §7(x4)")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 24, "gold");
                            sgm.blocksGUI(player);
                        } else if (itemName.equals("§6Obsidian §7(x16)")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 42, "gold");
                            sgm.blocksGUI(player);
                        } else if (itemName.equals("§6Obsidian §7(x32)")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 84, "gold");
                            sgm.blocksGUI(player);
                        } else if (itemName.equals("§6Obsidian §7(x64)")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 168, "gold");
                            sgm.blocksGUI(player);

                            //change sgm blocks to sgm weapons
                        } else if (itemName.equals("§6Wooden Sword")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 15, "coal");
                            sgm.weaponsGUI(player);
                        } else if (itemName.equals("§6Stone Sword")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 32, "iron");
                            sgm.weaponsGUI(player);
                        } else if (itemName.equals("§6Iron Sword")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 25, "gold");
                            sgm.weaponsGUI(player);
                        } else if (itemName.equals("§6Diamond Sword")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 5, "diamond");
                            sgm.weaponsGUI(player);

                        } else if (itemName.equals("§6Wooden Axe")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 21, "coal");
                            sgm.weaponsGUI(player);
                        } else if (itemName.equals("§6Stone Axe")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 36, "iron");
                            sgm.weaponsGUI(player);
                        } else if (itemName.equals("§6Iron Axe")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 29, "gold");
                            sgm.weaponsGUI(player);
                        } else if (itemName.equals("§6Diamond Axe")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 7, "diamond");
                            sgm.weaponsGUI(player);

                        } else if (itemName.equals("§6Bow 1")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 8, "emerald");
                            sgm.weaponsGUI(player);
                        } else if (itemName.equals("§6Bow 2")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 12, "emerald");
                            sgm.weaponsGUI(player);
                        } else if (itemName.equals("§6Bow 3")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 12, "emerald");
                            sgm.weaponsGUI(player);
                        } else if (itemName.equals("§6Bow 4")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 16, "emerald");
                            sgm.weaponsGUI(player);

                        } else if (itemName.equals("§6Fishing Rod")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 23, "gold");
                            sgm.weaponsGUI(player);
                        } else if (itemName.equals("§6Flint and Steel")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 45, "iron");
                            sgm.weaponsGUI(player);
                        } else if (itemName.equals("§6Arrows §7(x8)")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 3, "gold");
                            sgm.weaponsGUI(player);
                        } else if (itemName.equals("§6Lava Bucket")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 2, "emerald");
                            sgm.weaponsGUI(player);


                        } else if (itemName.equals("§6Leather Helmet")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 5, "iron");
                            sgm.armourGUI(player);
                        } else if (itemName.equals("§6Leather Chestplate")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 12, "iron");
                            sgm.armourGUI(player);
                        } else if (itemName.equals("§6Leather Leggings")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 9, "iron");
                            sgm.armourGUI(player);
                        } else if (itemName.equals("§6Leather Boots")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 4, "iron");
                            sgm.armourGUI(player);

                        } else if (itemName.equals("§6Chain Helmet")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 25, "iron");
                            sgm.armourGUI(player);
                        } else if (itemName.equals("§6Chain Chestplate")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 36, "iron");
                            sgm.armourGUI(player);
                        } else if (itemName.equals("§6Chain Leggings")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 30, "iron");
                            sgm.armourGUI(player);
                        } else if (itemName.equals("§6Chain Boots")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 24, "iron");
                            sgm.armourGUI(player);

                        } else if (itemName.equals("§6Iron Helmet")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 20, "gold");
                            sgm.armourGUI(player);
                        } else if (itemName.equals("§6Iron Chestplate")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 28, "gold");
                            sgm.armourGUI(player);
                        } else if (itemName.equals("§6Iron Leggings")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 26, "gold");
                            sgm.armourGUI(player);
                        } else if (itemName.equals("§6Iron Boots")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 19, "gold");
                            sgm.armourGUI(player);

                        } else if (itemName.equals("§6Diamond Helmet")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 25, "emerald");
                            sgm.armourGUI(player);
                        } else if (itemName.equals("§6Diamond Chestplate")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 30, "emerald");
                            sgm.armourGUI(player);
                        } else if (itemName.equals("§6Diamond Leggings")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 28, "emerald");
                            sgm.armourGUI(player);
                        } else if (itemName.equals("§6Diamond Boots")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 23, "emerald");
                            sgm.armourGUI(player);


                        } else if (itemName.equals("§6Wood Pickaxe")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 22, "coal");
                            sgm.toolsGUI(player);
                        } else if (itemName.equals("§6Wood Shovel")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 16, "coal");
                            sgm.toolsGUI(player);
                        } else if (itemName.equals("§6Wood Hoe")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 19, "coal");
                            sgm.toolsGUI(player);

                        } else if (itemName.equals("§6Stone Pickaxe")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 23, "iron");
                            sgm.toolsGUI(player);
                        } else if (itemName.equals("§6Stone Shovel")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 20, "iron");
                            sgm.toolsGUI(player);
                        } else if (itemName.equals("§6Stone Hoe")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 18, "iron");
                            sgm.toolsGUI(player);

                        } else if (itemName.equals("§6Iron Pickaxe")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 34, "gold");
                            sgm.toolsGUI(player);
                        } else if (itemName.equals("§6Iron Shovel")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 30, "gold");
                            sgm.toolsGUI(player);
                        } else if (itemName.equals("§6Iron Hoe")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 27, "gold");
                            sgm.toolsGUI(player);

                        } else if (itemName.equals("§6Diamond Pickaxe")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 18, "diamond");
                            sgm.toolsGUI(player);
                        } else if (itemName.equals("§6Diamond Shovel")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 16, "diamond");
                            sgm.toolsGUI(player);
                        } else if (itemName.equals("§6Diamond Hoe")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 13, "diamond");
                            sgm.toolsGUI(player);


                        } else if (itemName.equals("§6Enderpearl")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 7, "emerald");
                            sgm.utilityGUI(player);
                        } else if (itemName.equals("§6TNT")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 56, "gold");
                            sgm.utilityGUI(player);
                        } else if (itemName.equals("§6Player Tracker")) {
                            //sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 15, "diamond");

                            if (diamond >= 15) {
                                player.getInventory().removeItem(new ItemStack(Material.DIAMOND, 15));

                                ItemStack tracker = new ItemStack(Material.COMPASS);
                                ItemMeta trackerMeta = tracker.getItemMeta();
                                trackerMeta.setDisplayName("§c§lPlayer Tracker");
                                tracker.setItemMeta(trackerMeta);

                                player.getInventory().addItem(tracker);

                                sgm.utilityGUI(player);
                                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_PLING, 1, 1);
                            } else {
                                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BASS, 1, 1);
                            }

                        } else if (itemName.equals("§6Explosive Cake")) {
                            //sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 16, "emerald");

                            if (diamond >= 16) {
                                player.getInventory().removeItem(new ItemStack(Material.EMERALD, 16));

                                ItemStack cake = new ItemStack(Material.CAKE);
                                ItemMeta cakeMeta = cake.getItemMeta();
                                cakeMeta.setDisplayName("§d§lExplosive Cake");

                                ArrayList<String> cakeLore = new ArrayList<>();
                                cakeLore.add("");
                                cakeLore.add("§eWill explode §63 seconds §eafter it is placed.");

                                cakeMeta.setLore(cakeLore);

                                cake.setItemMeta(cakeMeta);

                                player.getInventory().addItem(cake);

                                sgm.utilityGUI(player);
                                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_PLING, 1, 1);
                            } else {
                                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BASS, 1, 1);
                            }
                        } else if (itemName.equals("§6Chest")) {
                            sgb.buyItem(player, event.getCurrentItem().getType(), event.getCurrentItem().getAmount(), 26, "gold");
                            sgm.utilityGUI(player);
                        }

                    }

                }
            }

        }
    }

}
