package net.collat.pirateplunder.villagershops;

import net.collat.pirateplunder.CalculateItems;
import net.collat.pirateplunder.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ShopsGUIMenu implements Listener {

    private CalculateItems ci = new CalculateItems();

    //SHOP GUI
    public void shopGUI(Player player) {
        player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1, 1);
        Inventory inv = Bukkit.createInventory(null, 27, "§cShop");

        //Blocks
        ItemStack blocks = new ItemStack(Material.BRICK, 1);
        ItemMeta blocksMeta = blocks.getItemMeta();

        blocksMeta.setDisplayName("§6Building Blocks");

        ArrayList<String> blocksLore = new ArrayList<>();
        blocksLore.add("§7Click to purchase building blocks!");

        blocksMeta.setLore(blocksLore);
        blocks.setItemMeta(blocksMeta);

        inv.setItem(11, blocks);

        //Weapons
        ItemStack weapons = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta weaponsMeta = weapons.getItemMeta();

        weaponsMeta.setDisplayName("§6Weapons");

        ArrayList<String> weaponsLore = new ArrayList<>();
        weaponsLore.add("§7Click to purchase a variety of weapons!");

        weaponsMeta.setLore(weaponsLore);
        weaponsMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        weapons.setItemMeta(weaponsMeta);

        inv.setItem(12, weapons);

        //Armour
        ItemStack armour = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
        ItemMeta armourMeta = armour.getItemMeta();

        armourMeta.setDisplayName("§6Armour");

        ArrayList<String> armourLore = new ArrayList<>();
        armourLore.add("§7Click to purchase different types of armour!");

        armourMeta.setLore(armourLore);
        armourMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        armour.setItemMeta(armourMeta);

        inv.setItem(13, armour);

        //Tools
        ItemStack tools = new ItemStack(Material.STONE_PICKAXE, 1);
        ItemMeta toolsMeta = tools.getItemMeta();

        toolsMeta.setDisplayName("§6Tools");

        ArrayList<String> toolsLore = new ArrayList<>();
        toolsLore.add("§7Click to purchase a variety of tools!");

        toolsMeta.setLore(toolsLore);
        toolsMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        tools.setItemMeta(toolsMeta);

        inv.setItem(14, tools);

        //Utility
        ItemStack utility = new ItemStack(Material.TNT, 1);
        ItemMeta utilityMeta = utility.getItemMeta();

        utilityMeta.setDisplayName("§6Utility");

        ArrayList<String> utilityLore = new ArrayList<>();
        utilityLore.add("§7Click to purchase useful items like TNT!");

        utilityMeta.setLore(utilityLore);
        utilityMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        utility.setItemMeta(utilityMeta);

        inv.setItem(15, utility);

        player.openInventory(inv);
    }

    public void blocksGUI(Player player) {
        int gold = ci.countGold(player);
        int iron = ci.countIron(player);

        Inventory inv = Bukkit.createInventory(null, 54, "§cShop §8(Blocks)");

        //Wool
        if (Main.game.getPlayerTeam(player).getName().equals("Red")) {
            teamWool(inv, (byte) 14, iron);
        } else if (Main.game.getPlayerTeam(player).getName().equals("White")) {
            teamWool(inv, (byte) 0, iron);
        }

        //Sandstone
        ItemStack sandstone4;
        if (Main.game.getPlayerTeam(player).getName().equals("Red")) {
            sandstone4 = new ItemStack(Material.RED_SANDSTONE, 4);
        } else {
            sandstone4 = new ItemStack(Material.SANDSTONE, 4);
        }
        ItemMeta sandstone4Meta = sandstone4.getItemMeta();

        sandstone4Meta.setDisplayName("§6Sandstone §7(x4)");

        ArrayList<String> sandstone4Lore = new ArrayList<>();
        sandstone4Lore.add("");
        sandstone4Lore.add("§eCost: §f20 Iron");
        sandstone4Lore.add("");
        if (iron >= 20) {
            sandstone4Lore.add("§a§oClick to purchase");
            addEnchantStyle(sandstone4Meta);
        } else {
            sandstone4Lore.add("§c§oYou cannot afford this");
        }

        sandstone4Meta.setLore(sandstone4Lore);

        sandstone4.setItemMeta(sandstone4Meta);

        inv.setItem(12, sandstone4);

        ItemStack sandstone16;
        if (Main.game.getPlayerTeam(player).getName().equals("Red")) {
            sandstone16 = new ItemStack(Material.RED_SANDSTONE, 16);
        } else {
            sandstone16 = new ItemStack(Material.SANDSTONE, 16);
        }
        ItemMeta sandstone16Meta = sandstone16.getItemMeta();

        sandstone16Meta.setDisplayName("§6Sandstone §7(x16)");

        ArrayList<String> sandstone16lore = new ArrayList<>();
        sandstone16lore.add("");
        sandstone16lore.add("§eCost: §f80 Iron");
        sandstone16lore.add("");
        if (iron >= 80) {
            sandstone16lore.add("§a§oClick to purchase");
            addEnchantStyle(sandstone16Meta);
        } else {
            sandstone16lore.add("§c§oYou cannot afford this");
        }

        sandstone16Meta.setLore(sandstone16lore);

        sandstone16.setItemMeta(sandstone16Meta);

        inv.setItem(21, sandstone16);

        ItemStack sandstone32;
        if (Main.game.getPlayerTeam(player).getName().equals("Red")) {
            sandstone32 = new ItemStack(Material.RED_SANDSTONE, 32);
        } else {
            sandstone32 = new ItemStack(Material.SANDSTONE, 32);
        }
        ItemMeta sandstone32Meta = sandstone32.getItemMeta();

        sandstone32Meta.setDisplayName("§6Sandstone §7(x32)");

        ArrayList<String> sandstone32lore = new ArrayList<>();
        sandstone32lore.add("");
        sandstone32lore.add("§eCost: §f160 Iron");
        sandstone32lore.add("");
        if (iron >= 160) {
            sandstone32lore.add("§a§oClick to purchase");
            addEnchantStyle(sandstone32Meta);
        } else {
            sandstone32lore.add("§c§oYou cannot afford this");
        }

        sandstone32Meta.setLore(sandstone32lore);

        sandstone32.setItemMeta(sandstone32Meta);

        inv.setItem(30, sandstone32);

        ItemStack sandstone64;
        if (Main.game.getPlayerTeam(player).getName().equals("Red")) {
            sandstone64 = new ItemStack(Material.RED_SANDSTONE, 64);
        } else {
            sandstone64 = new ItemStack(Material.SANDSTONE, 64);
        }
        ItemMeta sandstone64Meta = sandstone64.getItemMeta();

        sandstone64Meta.setDisplayName("§6Sandstone §7(x64)");

        ArrayList<String> sandstone64lore = new ArrayList<>();
        sandstone64lore.add("");
        sandstone64lore.add("§eCost: §f320 Iron");
        sandstone64lore.add("");
        if (iron >= 320) {
            sandstone64lore.add("§a§oClick to purchase");
            addEnchantStyle(sandstone64Meta);
        } else {
            sandstone64lore.add("§c§oYou cannot afford this");
        }

        sandstone64Meta.setLore(sandstone64lore);

        sandstone64.setItemMeta(sandstone64Meta);

        inv.setItem(39, sandstone64);

        //Wood
        ItemStack wood4;
        if (Main.game.getPlayerTeam(player).getName().equals("Red")) {
            wood4 = new ItemStack(Material.WOOD, 4, (byte) 4);
        } else {
            wood4 = new ItemStack(Material.WOOD, 4, (byte) 0);
        }
        ItemMeta wood4Meta = wood4.getItemMeta();

        wood4Meta.setDisplayName("§6Wood §7(x4)");

        ArrayList<String> wood4Lore = new ArrayList<>();
        wood4Lore.add("");
        wood4Lore.add("§eCost: §f32 Iron");
        wood4Lore.add("");
        if (iron >= 32) {
            wood4Lore.add("§a§oClick to purchase");
            addEnchantStyle(wood4Meta);
        } else {
            wood4Lore.add("§c§oYou cannot afford this");
        }

        wood4Meta.setLore(wood4Lore);

        wood4.setItemMeta(wood4Meta);

        inv.setItem(14, wood4);

        ItemStack wood16;
        if (Main.game.getPlayerTeam(player).getName().equals("Red")) {
            wood16 = new ItemStack(Material.WOOD, 16, (byte) 4);
        } else {
            wood16 = new ItemStack(Material.WOOD, 16, (byte) 0);
        }
        ItemMeta wood16Meta = wood16.getItemMeta();

        wood16Meta.setDisplayName("§6Wood §7(x16)");

        ArrayList<String> wood16lore = new ArrayList<>();
        wood16lore.add("");
        wood16lore.add("§eCost: §f128 Iron");
        wood16lore.add("");
        if (iron >= 128) {
            wood16lore.add("§a§oClick to purchase");
            addEnchantStyle(wood16Meta);
        } else {
            wood16lore.add("§c§oYou cannot afford this");
        }

        wood16Meta.setLore(wood16lore);

        wood16.setItemMeta(wood16Meta);

        inv.setItem(23, wood16);

        ItemStack wood32;
        if (Main.game.getPlayerTeam(player).getName().equals("Red")) {
            wood32 = new ItemStack(Material.WOOD, 32, (byte) 4);
        } else {
            wood32 = new ItemStack(Material.WOOD, 32, (byte) 0);
        }
        ItemMeta wood32Meta = wood32.getItemMeta();

        wood32Meta.setDisplayName("§6Wood §7(x32)");

        ArrayList<String> wood32lore = new ArrayList<>();
        wood32lore.add("");
        wood32lore.add("§eCost: §f256 Iron");
        wood32lore.add("");
        if (iron >= 256) {
            wood32lore.add("§a§oClick to purchase");
            addEnchantStyle(wood32Meta);
        } else {
            wood32lore.add("§c§oYou cannot afford this");
        }

        wood32Meta.setLore(wood32lore);

        wood32.setItemMeta(wood32Meta);

        inv.setItem(32, wood32);

        ItemStack wood64;
        if (Main.game.getPlayerTeam(player).getName().equals("Red")) {
            wood64 = new ItemStack(Material.WOOD, 64, (byte) 4);
        } else {
            wood64 = new ItemStack(Material.WOOD, 64, (byte) 0);
        }
        ItemMeta wood64Meta = wood64.getItemMeta();

        wood64Meta.setDisplayName("§6Wood §7(x64)");

        ArrayList<String> wood64lore = new ArrayList<>();
        wood64lore.add("");
        wood64lore.add("§eCost: §f512 Iron");
        wood64lore.add("");
        if (iron >= 512) {
            wood64lore.add("§a§oClick to purchase");
            addEnchantStyle(wood64Meta);
        } else {
            wood64lore.add("§c§oYou cannot afford this");
        }

        wood64Meta.setLore(wood64lore);

        wood64.setItemMeta(wood64Meta);

        inv.setItem(41, wood64);

        //Obsidian
        ItemStack obsidian4 = new ItemStack(Material.OBSIDIAN, 4);
        ItemMeta obsidian4Meta = obsidian4.getItemMeta();

        obsidian4Meta.setDisplayName("§6Obsidian §7(x4)");

        ArrayList<String> obsidian4Lore = new ArrayList<>();
        obsidian4Lore.add("");
        obsidian4Lore.add("§eCost: §f24 Gold");
        obsidian4Lore.add("");
        if (gold >= 24) {
            obsidian4Lore.add("§a§oClick to purchase");
            addEnchantStyle(obsidian4Meta);
        } else {
            obsidian4Lore.add("§c§oYou cannot afford this");
        }

        obsidian4Meta.setLore(obsidian4Lore);

        obsidian4.setItemMeta(obsidian4Meta);

        inv.setItem(16, obsidian4);

        ItemStack obsidian16 = new ItemStack(Material.OBSIDIAN, 16);
        ItemMeta obsidian16Meta = obsidian16.getItemMeta();

        obsidian16Meta.setDisplayName("§6Obsidian §7(x16)");

        ArrayList<String> obsidian16lore = new ArrayList<>();
        obsidian16lore.add("");
        obsidian16lore.add("§eCost: §f42 Gold");
        obsidian16lore.add("");
        if (gold >= 42) {
            obsidian16lore.add("§a§oClick to purchase");
            addEnchantStyle(obsidian16Meta);
        } else {
            obsidian16lore.add("§c§oYou cannot afford this");
        }

        obsidian16Meta.setLore(obsidian16lore);

        obsidian16.setItemMeta(obsidian16Meta);

        inv.setItem(25, obsidian16);

        ItemStack obsidian32 = new ItemStack(Material.OBSIDIAN, 32);
        ItemMeta obsidian32Meta = obsidian32.getItemMeta();

        obsidian32Meta.setDisplayName("§6Obsidian §7(x32)");

        ArrayList<String> obsidian32lore = new ArrayList<>();
        obsidian32lore.add("");
        obsidian32lore.add("§eCost: §f84 Gold");
        obsidian32lore.add("");
        if (gold >= 84) {
            obsidian32lore.add("§a§oClick to purchase");
            addEnchantStyle(obsidian32Meta);
        } else {
            obsidian32lore.add("§c§oYou cannot afford this");
        }

        obsidian32Meta.setLore(obsidian32lore);

        obsidian32.setItemMeta(obsidian32Meta);

        inv.setItem(34, obsidian32);

        ItemStack obsidian64 = new ItemStack(Material.OBSIDIAN, 64);
        ItemMeta obsidian64Meta = obsidian64.getItemMeta();

        obsidian64Meta.setDisplayName("§6Obsidian §7(x64)");

        ArrayList<String> obsidian64lore = new ArrayList<>();
        obsidian64lore.add("");
        obsidian64lore.add("§eCost: §f168 Gold");
        obsidian64lore.add("");
        if (gold >= 168) {
            obsidian64lore.add("§a§oClick to purchase");
            addEnchantStyle(obsidian64Meta);
        } else {
            obsidian64lore.add("§c§oYou cannot afford this");
        }

        obsidian64Meta.setLore(obsidian64lore);

        obsidian64.setItemMeta(obsidian64Meta);

        inv.setItem(43, obsidian64);

        //Return
        returnItem(inv, 45);

        player.openInventory(inv);
    }

    private void teamWool(Inventory inv, byte team, int iron) {
        ItemStack wool4 = new ItemStack(Material.WOOL, 4, team);
        ItemMeta wool4Meta = wool4.getItemMeta();

        wool4Meta.setDisplayName("§6Dyed Wool §7(x4)");

        ArrayList<String> wool4lore = new ArrayList<>();
        wool4lore.add("");
        wool4lore.add("§eCost: §f4 Iron");
        wool4lore.add("");
        if (iron >= 4) {
            wool4lore.add("§a§oClick to purchase");
            addEnchantStyle(wool4Meta);
        } else {
            wool4lore.add("§c§oYou cannot afford this");
        }

        wool4Meta.setLore(wool4lore);

        wool4.setItemMeta(wool4Meta);

        inv.setItem(10, wool4);

        ItemStack wool16 = new ItemStack(Material.WOOL, 16, team);
        ItemMeta wool16Meta = wool16.getItemMeta();

        wool16Meta.setDisplayName("§6Dyed Wool §7(x16)");

        ArrayList<String> wool16lore = new ArrayList<>();
        wool16lore.add("");
        wool16lore.add("§eCost: §f16 Iron");
        wool16lore.add("");
        if (iron >= 16) {
            wool16lore.add("§a§oClick to purchase");
            addEnchantStyle(wool16Meta);
        } else {
            wool16lore.add("§c§oYou cannot afford this");
        }

        wool16Meta.setLore(wool16lore);

        wool16.setItemMeta(wool16Meta);

        inv.setItem(19, wool16);

        ItemStack wool32 = new ItemStack(Material.WOOL, 32, team);
        ItemMeta wool32Meta = wool32.getItemMeta();

        wool32Meta.setDisplayName("§6Dyed Wool §7(x32)");

        ArrayList<String> wool32lore = new ArrayList<>();
        wool32lore.add("");
        wool32lore.add("§eCost: §f32 Iron");
        wool32lore.add("");
        if (iron >= 32) {
            wool32lore.add("§a§oClick to purchase");
            addEnchantStyle(wool32Meta);
        } else {
            wool32lore.add("§c§oYou cannot afford this");
        }

        wool32Meta.setLore(wool32lore);

        wool32.setItemMeta(wool32Meta);

        inv.setItem(28, wool32);

        ItemStack wool64 = new ItemStack(Material.WOOL, 64, team);
        ItemMeta wool64Meta = wool64.getItemMeta();

        wool64Meta.setDisplayName("§6Dyed Wool §7(x64)");

        ArrayList<String> wool64lore = new ArrayList<>();
        wool64lore.add("");
        wool64lore.add("§eCost: §f64 Iron");
        wool64lore.add("");
        if (iron >= 64) {
            wool64lore.add("§a§oClick to purchase");
            addEnchantStyle(wool64Meta);
        } else {
            wool64lore.add("§c§oYou cannot afford this");
        }

        wool64Meta.setLore(wool64lore);

        wool64.setItemMeta(wool64Meta);

        inv.setItem(37, wool64);
    }

    public void weaponsGUI(Player player) {
        Inventory inv = Bukkit.createInventory(null, 54, "§cShop §8(Weapons)");

        int diamond = ci.countDiamonds(player);
        int emerald = ci.countEmeralds(player);
        int gold = ci.countGold(player);
        int iron = ci.countIron(player);
        int coal = ci.countCoal(player);

        //WOOD SWORD
        ItemStack woodSword = new ItemStack(Material.WOOD_SWORD);
        ItemMeta woodSwordMeta = woodSword.getItemMeta();

        woodSwordMeta.setDisplayName("§6Wooden Sword");

        ArrayList<String> woodSwordLore = new ArrayList<>();
        woodSwordLore.add("");
        woodSwordLore.add("§eCost: §f15 Coal");
        woodSwordLore.add("");
        if (coal >= 15) {
            woodSwordLore.add("§a§oClick to purchase");
            addEnchantStyle(woodSwordMeta);
        } else {
            woodSwordLore.add("§c§oYou cannot afford this");
        }

        woodSwordMeta.setLore(woodSwordLore);

        woodSwordMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        woodSword.setItemMeta(woodSwordMeta);

        inv.setItem(10, woodSword);

        //STONE SWORD
        ItemStack stoneSword = new ItemStack(Material.STONE_SWORD);
        ItemMeta stoneSwordMeta = stoneSword.getItemMeta();

        stoneSwordMeta.setDisplayName("§6Stone Sword");

        ArrayList<String> stoneSwordLore = new ArrayList<>();
        stoneSwordLore.add("");
        stoneSwordLore.add("§eCost: §f32 Iron");
        stoneSwordLore.add("");
        if (iron >= 32) {
            stoneSwordLore.add("§a§oClick to purchase");
            addEnchantStyle(stoneSwordMeta);
        } else {
            stoneSwordLore.add("§c§oYou cannot afford this");
        }

        stoneSwordMeta.setLore(stoneSwordLore);

        stoneSwordMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        stoneSword.setItemMeta(stoneSwordMeta);

        inv.setItem(12, stoneSword);

        //IRON SWORD
        ItemStack ironSword = new ItemStack(Material.IRON_SWORD);
        ItemMeta ironSwordMeta = ironSword.getItemMeta();

        ironSwordMeta.setDisplayName("§6Iron Sword");

        ArrayList<String> ironSwordLore = new ArrayList<>();
        ironSwordLore.add("");
        ironSwordLore.add("§eCost: §f25 Gold");
        ironSwordLore.add("");
        if (gold >= 25) {
            ironSwordLore.add("§a§oClick to purchase");
            addEnchantStyle(ironSwordMeta);
        } else {
            ironSwordLore.add("§c§oYou cannot afford this");
        }

        ironSwordMeta.setLore(ironSwordLore);

        ironSwordMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ironSword.setItemMeta(ironSwordMeta);

        inv.setItem(14, ironSword);

        //DIAMOND SWORD
        ItemStack diamondSword = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta diamondSwordMeta = diamondSword.getItemMeta();

        diamondSwordMeta.setDisplayName("§6Diamond Sword");

        ArrayList<String> diamondSwordLore = new ArrayList<>();
        diamondSwordLore.add("");
        diamondSwordLore.add("§eCost: §f5 Diamond");
        diamondSwordLore.add("");
        if (diamond >= 5) {
            diamondSwordLore.add("§a§oClick to purchase");
            addEnchantStyle(diamondSwordMeta);
        } else {
            diamondSwordLore.add("§c§oYou cannot afford this");
        }

        diamondSwordMeta.setLore(diamondSwordLore);

        diamondSwordMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        diamondSword.setItemMeta(diamondSwordMeta);

        inv.setItem(16, diamondSword);

        //WOOD AXE
        ItemStack woodAxe = new ItemStack(Material.WOOD_AXE);
        ItemMeta woodAxeMeta = woodAxe.getItemMeta();

        woodAxeMeta.setDisplayName("§6Wooden Axe");

        ArrayList<String> woodAxeLore = new ArrayList<>();
        woodAxeLore.add("");
        woodAxeLore.add("§eCost: §f21 Coal");
        woodAxeLore.add("");
        if (coal >= 21) {
            woodAxeLore.add("§a§oClick to purchase");
            addEnchantStyle(woodAxeMeta);
        } else {
            woodAxeLore.add("§c§oYou cannot afford this");
        }

        woodAxeMeta.setLore(woodAxeLore);

        woodAxeMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        woodAxe.setItemMeta(woodAxeMeta);

        inv.setItem(19, woodAxe);

        //STONE AXE
        ItemStack stoneAxe = new ItemStack(Material.STONE_AXE);
        ItemMeta stoneAxeMeta = stoneAxe.getItemMeta();

        stoneAxeMeta.setDisplayName("§6Stone Axe");

        ArrayList<String> stoneAxeLore = new ArrayList<>();
        stoneAxeLore.add("");
        stoneAxeLore.add("§eCost: §f36 Iron");
        stoneAxeLore.add("");
        if (iron >= 36) {
            stoneAxeLore.add("§a§oClick to purchase");
            addEnchantStyle(stoneAxeMeta);
        } else {
            stoneAxeLore.add("§c§oYou cannot afford this");
        }

        stoneAxeMeta.setLore(stoneAxeLore);

        stoneAxeMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        stoneAxe.setItemMeta(stoneAxeMeta);

        inv.setItem(21, stoneAxe);

        //IRON AXE
        ItemStack ironAxe = new ItemStack(Material.IRON_AXE);
        ItemMeta ironAxeMeta = ironAxe.getItemMeta();

        ironAxeMeta.setDisplayName("§6Iron Axe");

        ArrayList<String> ironAxeLore = new ArrayList<>();
        ironAxeLore.add("");
        ironAxeLore.add("§eCost: §f29 Gold");
        ironAxeLore.add("");
        if (gold >= 29) {
            ironAxeLore.add("§a§oClick to purchase");
            addEnchantStyle(ironAxeMeta);
        } else {
            ironAxeLore.add("§c§oYou cannot afford this");
        }

        ironAxeMeta.setLore(ironAxeLore);

        ironAxeMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ironAxe.setItemMeta(ironAxeMeta);

        inv.setItem(23, ironAxe);

        //DIAMOND AXE
        ItemStack diamondAxe = new ItemStack(Material.DIAMOND_AXE);
        ItemMeta diamondAxeMeta = diamondAxe.getItemMeta();

        diamondAxeMeta.setDisplayName("§6Diamond Axe");

        ArrayList<String> diamondAxeLore = new ArrayList<>();
        diamondAxeLore.add("");
        diamondAxeLore.add("§eCost: §f7 Diamond");
        diamondAxeLore.add("");
        if (diamond >= 7) {
            diamondAxeLore.add("§a§oClick to purchase");
            addEnchantStyle(diamondAxeMeta);
        } else {
            diamondAxeLore.add("§c§oYou cannot afford this");
        }

        diamondAxeMeta.setLore(diamondAxeLore);

        diamondAxeMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        diamondAxe.setItemMeta(diamondAxeMeta);

        inv.setItem(25, diamondAxe);

        //Bow 1
        ItemStack bow = new ItemStack(Material.BOW);
        ItemMeta bowMeta = bow.getItemMeta();

        bowMeta.setDisplayName("§6Bow 1");

        ArrayList<String> bowLore = new ArrayList<>();
        bowLore.add("");
        bowLore.add("§eCost: §f8 Emerald");
        bowLore.add("");
        if (emerald >= 8) {
            bowLore.add("§a§oClick to purchase");
            addEnchantStyle(bowMeta);
        } else {
            bowLore.add("§c§oYou cannot afford this");
        }

        bowMeta.setLore(bowLore);

        bow.setItemMeta(bowMeta);

        inv.setItem(28, bow);

        //Bow 2
        ItemStack bow1 = new ItemStack(Material.BOW);
        ItemMeta bow1Meta = bow1.getItemMeta();

        bow1Meta.setDisplayName("§6Bow 2");

        ArrayList<String> bow1Lore = new ArrayList<>();
        bow1Lore.add("§7Power I");
        bow1Lore.add("");
        bow1Lore.add("§eCost: §f12 Emerald");
        bow1Lore.add("");
        if (emerald >= 12) {
            bow1Lore.add("§a§oClick to purchase");
            addEnchantStyle(bow1Meta);
        } else {
            bow1Lore.add("§c§oYou cannot afford this");
        }

        bow1Meta.setLore(bow1Lore);

        bow1.setItemMeta(bow1Meta);

        inv.setItem(30, bow1);

        //Bow 3
        ItemStack bow2 = new ItemStack(Material.BOW);
        ItemMeta bow2Meta = bow2.getItemMeta();

        bow2Meta.setDisplayName("§6Bow 3");

        ArrayList<String> bow2Lore = new ArrayList<>();
        bow2Lore.add("§7Punch I");
        bow2Lore.add("");
        bow2Lore.add("§eCost: §f12 Emerald");
        bow2Lore.add("");
        if (emerald >= 12) {
            bow2Lore.add("§a§oClick to purchase");
            addEnchantStyle(bow2Meta);
        } else {
            bow2Lore.add("§c§oYou cannot afford this");
        }

        bow2Meta.setLore(bow2Lore);

        bow2.setItemMeta(bow2Meta);

        inv.setItem(32, bow2);

        //Bow 4
        ItemStack bow3 = new ItemStack(Material.BOW);
        ItemMeta bow3Meta = bow3.getItemMeta();

        bow3Meta.setDisplayName("§6Bow 4");

        ArrayList<String> bow3Lore = new ArrayList<>();
        bow3Lore.add("§7Punch II");
        bow3Lore.add("");
        bow3Lore.add("§eCost: §f16 Emerald");
        bow3Lore.add("");
        if (emerald >= 16) {
            bow3Lore.add("§a§oClick to purchase");
            addEnchantStyle(bow3Meta);
        } else {
            bow3Lore.add("§c§oYou cannot afford this");
        }

        bow3Meta.setLore(bow3Lore);

        bow3.setItemMeta(bow3Meta);

        inv.setItem(34, bow3);

        //Fishing Rod
        ItemStack fishing = new ItemStack(Material.FISHING_ROD);
        ItemMeta fishingMeta = fishing.getItemMeta();

        fishingMeta.setDisplayName("§6Fishing Rod");

        ArrayList<String> fishingLore = new ArrayList<>();
        fishingLore.add("");
        fishingLore.add("§eCost: §f23 Gold");
        fishingLore.add("");
        if (gold >= 23) {
            fishingLore.add("§a§oClick to purchase");
            addEnchantStyle(fishingMeta);
        } else {
            fishingLore.add("§c§oYou cannot afford this");
        }

        fishingMeta.setLore(fishingLore);

        fishing.setItemMeta(fishingMeta);

        inv.setItem(37, fishing);

        //flint
        ItemStack flint = new ItemStack(Material.FLINT_AND_STEEL);
        ItemMeta flintMeta = flint.getItemMeta();

        flintMeta.setDisplayName("§6Flint and Steel");

        ArrayList<String> flintLore = new ArrayList<>();
        flintLore.add("");
        flintLore.add("§eCost: §f45 Iron");
        flintLore.add("");
        if (iron >= 45) {
            flintLore.add("§a§oClick to purchase");
            addEnchantStyle(flintMeta);
        } else {
            flintLore.add("§c§oYou cannot afford this");
        }

        flintMeta.setLore(flintLore);

        flint.setItemMeta(flintMeta);

        inv.setItem(39, flint);

        //Arrows 8
        ItemStack arrows8 = new ItemStack(Material.ARROW, 8);
        ItemMeta arrows8Meta = arrows8.getItemMeta();

        arrows8Meta.setDisplayName("§6Arrows §7(x8)");

        ArrayList<String> arrows8Lore = new ArrayList<>();
        arrows8Lore.add("");
        arrows8Lore.add("§eCost: §f3 Gold");
        arrows8Lore.add("");
        if (gold >= 3) {
            arrows8Lore.add("§a§oClick to purchase");
            addEnchantStyle(arrows8Meta);
        } else {
            arrows8Lore.add("§c§oYou cannot afford this");
        }

        arrows8Meta.setLore(arrows8Lore);

        arrows8.setItemMeta(arrows8Meta);

        inv.setItem(41, arrows8);

        //Lava
        ItemStack lava = new ItemStack(Material.LAVA_BUCKET, 1);
        ItemMeta lavaMeta = lava.getItemMeta();

        lavaMeta.setDisplayName("§6Lava Bucket");

        ArrayList<String> lavaLore = new ArrayList<>();
        lavaLore.add("");
        lavaLore.add("§eCost: §f2 Emerald");
        lavaLore.add("");
        if (emerald >= 2) {
            lavaLore.add("§a§oClick to purchase");
            addEnchantStyle(lavaMeta);
        } else {
            lavaLore.add("§c§oYou cannot afford this");
        }

        lavaMeta.setLore(lavaLore);

        lava.setItemMeta(lavaMeta);

        inv.setItem(43, lava);

        //Return
        returnItem(inv, 45);

        player.openInventory(inv);
    }

    public void armourGUI(Player player) {
        int gold = ci.countGold(player);
        int iron = ci.countIron(player);
        int emerald = ci.countEmeralds(player);

        Inventory inv = Bukkit.createInventory(null, 54, "§cShop §8(Armour)");

        //Leather Helmet
        ItemStack leatherHelmet = new ItemStack(Material.LEATHER_HELMET);
        ItemMeta leatherHelmetMeta = leatherHelmet.getItemMeta();

        leatherHelmetMeta.setDisplayName("§6Leather Helmet");

        ArrayList<String> leatherHelmetLore = new ArrayList<>();
        leatherHelmetLore.add("");
        leatherHelmetLore.add("§eCost: §f5 Iron");
        leatherHelmetLore.add("");
        if (iron >= 5) {
            leatherHelmetLore.add("§a§oClick to purchase");
            addEnchantStyle(leatherHelmetMeta);
        } else {
            leatherHelmetLore.add("§c§oYou cannot afford this");
        }

        leatherHelmetMeta.setLore(leatherHelmetLore);

        leatherHelmetMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        leatherHelmet.setItemMeta(leatherHelmetMeta);

        inv.setItem(10, leatherHelmet);

        //Leather Chestplate
        ItemStack leatherChestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
        ItemMeta leatherChestplateMeta = leatherChestplate.getItemMeta();

        leatherChestplateMeta.setDisplayName("§6Leather Chestplate");

        ArrayList<String> leatherChestplateLore = new ArrayList<>();
        leatherChestplateLore.add("");
        leatherChestplateLore.add("§eCost: §f12 Iron");
        leatherChestplateLore.add("");
        if (iron >= 12) {
            leatherChestplateLore.add("§a§oClick to purchase");
            addEnchantStyle(leatherChestplateMeta);
        } else {
            leatherChestplateLore.add("§c§oYou cannot afford this");
        }

        leatherChestplateMeta.setLore(leatherChestplateLore);

        leatherChestplateMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        leatherChestplate.setItemMeta(leatherChestplateMeta);

        inv.setItem(19, leatherChestplate);

        //Leather Leggings
        ItemStack leatherLeggings = new ItemStack(Material.LEATHER_LEGGINGS);
        ItemMeta leatherLeggingsMeta = leatherLeggings.getItemMeta();

        leatherLeggingsMeta.setDisplayName("§6Leather Leggings");

        ArrayList<String> leatherLeggingsLore = new ArrayList<>();
        leatherLeggingsLore.add("");
        leatherLeggingsLore.add("§eCost: §f9 Iron");
        leatherLeggingsLore.add("");
        if (iron >= 9) {
            leatherLeggingsLore.add("§a§oClick to purchase");
            addEnchantStyle(leatherLeggingsMeta);
        } else {
            leatherLeggingsLore.add("§c§oYou cannot afford this");
        }

        leatherLeggingsMeta.setLore(leatherLeggingsLore);

        leatherLeggingsMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        leatherLeggings.setItemMeta(leatherLeggingsMeta);

        inv.setItem(28, leatherLeggings);

        //Leather Boots
        ItemStack leatherBoots = new ItemStack(Material.LEATHER_BOOTS);
        ItemMeta leatherBootsMeta = leatherBoots.getItemMeta();

        leatherBootsMeta.setDisplayName("§6Leather Boots");

        ArrayList<String> leatherBootsLore = new ArrayList<>();
        leatherBootsLore.add("");
        leatherBootsLore.add("§eCost: §f4 Iron");
        leatherBootsLore.add("");
        if (iron >= 4) {
            leatherBootsLore.add("§a§oClick to purchase");
            addEnchantStyle(leatherBootsMeta);
        } else {
            leatherBootsLore.add("§c§oYou cannot afford this");
        }

        leatherBootsMeta.setLore(leatherBootsLore);

        leatherBootsMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        leatherBoots.setItemMeta(leatherBootsMeta);

        inv.setItem(37, leatherBoots);

        //Chain Helmet
        ItemStack chainHelmet = new ItemStack(Material.CHAINMAIL_HELMET);
        ItemMeta chainHelmetMeta = chainHelmet.getItemMeta();

        chainHelmetMeta.setDisplayName("§6Chain Helmet");

        ArrayList<String> chainHelmetLore = new ArrayList<>();
        chainHelmetLore.add("");
        chainHelmetLore.add("§eCost: §f25 Iron");
        chainHelmetLore.add("");
        if (iron >= 25) {
            chainHelmetLore.add("§a§oClick to purchase");
            addEnchantStyle(chainHelmetMeta);
        } else {
            chainHelmetLore.add("§c§oYou cannot afford this");
        }

        chainHelmetMeta.setLore(chainHelmetLore);

        chainHelmetMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        chainHelmet.setItemMeta(chainHelmetMeta);

        inv.setItem(12, chainHelmet);

        //Chain Chestplate
        ItemStack chainChestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
        ItemMeta chainChestplateMeta = chainChestplate.getItemMeta();

        chainChestplateMeta.setDisplayName("§6Chain Chestplate");

        ArrayList<String> chainChestplateLore = new ArrayList<>();
        chainChestplateLore.add("");
        chainChestplateLore.add("§eCost: §f36 Iron");
        chainChestplateLore.add("");
        if (iron >= 36) {
            chainChestplateLore.add("§a§oClick to purchase");
            addEnchantStyle(chainChestplateMeta);
        } else {
            chainChestplateLore.add("§c§oYou cannot afford this");
        }

        chainChestplateMeta.setLore(chainChestplateLore);

        chainChestplateMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        chainChestplate.setItemMeta(chainChestplateMeta);

        inv.setItem(21, chainChestplate);

        //Chain Leggings
        ItemStack chainLeggings = new ItemStack(Material.CHAINMAIL_LEGGINGS);
        ItemMeta chainLeggingsMeta = chainLeggings.getItemMeta();

        chainLeggingsMeta.setDisplayName("§6Chain Leggings");

        ArrayList<String> chainLeggingsLore = new ArrayList<>();
        chainLeggingsLore.add("");
        chainLeggingsLore.add("§eCost: §f30 Iron");
        chainLeggingsLore.add("");
        if (iron >= 30) {
            chainLeggingsLore.add("§a§oClick to purchase");
            addEnchantStyle(chainLeggingsMeta);
        } else {
            chainLeggingsLore.add("§c§oYou cannot afford this");
        }

        chainLeggingsMeta.setLore(chainLeggingsLore);

        chainLeggingsMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        chainLeggings.setItemMeta(chainLeggingsMeta);

        inv.setItem(30, chainLeggings);

        //Chain Boots
        ItemStack chainBoots = new ItemStack(Material.CHAINMAIL_BOOTS);
        ItemMeta chainBootsMeta = chainBoots.getItemMeta();

        chainBootsMeta.setDisplayName("§6Chain Boots");

        ArrayList<String> chainBootsLore = new ArrayList<>();
        chainBootsLore.add("");
        chainBootsLore.add("§eCost: §f24 Iron");
        chainBootsLore.add("");
        if (iron >= 24) {
            chainBootsLore.add("§a§oClick to purchase");
            addEnchantStyle(chainBootsMeta);
        } else {
            chainBootsLore.add("§c§oYou cannot afford this");
        }

        chainBootsMeta.setLore(chainBootsLore);

        chainBootsMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        chainBoots.setItemMeta(chainBootsMeta);

        inv.setItem(39, chainBoots);

        //Iron Helmet
        ItemStack ironHelmet = new ItemStack(Material.IRON_HELMET);
        ItemMeta ironHelmetMeta = ironHelmet.getItemMeta();

        ironHelmetMeta.setDisplayName("§6Iron Helmet");

        ArrayList<String> ironHelmetLore = new ArrayList<>();
        ironHelmetLore.add("");
        ironHelmetLore.add("§eCost: §f20 Gold");
        ironHelmetLore.add("");
        if (gold >= 20) {
            ironHelmetLore.add("§a§oClick to purchase");
            addEnchantStyle(ironHelmetMeta);
        } else {
            ironHelmetLore.add("§c§oYou cannot afford this");
        }

        ironHelmetMeta.setLore(ironHelmetLore);

        ironHelmetMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ironHelmet.setItemMeta(ironHelmetMeta);

        inv.setItem(14, ironHelmet);

        //Iron Chestplate
        ItemStack ironChestplate = new ItemStack(Material.IRON_CHESTPLATE);
        ItemMeta ironChestplateMeta = ironChestplate.getItemMeta();

        ironChestplateMeta.setDisplayName("§6Iron Chestplate");

        ArrayList<String> ironChestplateLore = new ArrayList<>();
        ironChestplateLore.add("");
        ironChestplateLore.add("§eCost: §f28 Gold");
        ironChestplateLore.add("");
        if (gold >= 28) {
            ironChestplateLore.add("§a§oClick to purchase");
            addEnchantStyle(ironChestplateMeta);
        } else {
            ironChestplateLore.add("§c§oYou cannot afford this");
        }

        ironChestplateMeta.setLore(ironChestplateLore);

        ironChestplateMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ironChestplate.setItemMeta(ironChestplateMeta);

        inv.setItem(23, ironChestplate);

        //Iron Leggings
        ItemStack ironLeggings = new ItemStack(Material.IRON_LEGGINGS);
        ItemMeta ironLeggingsMeta = ironLeggings.getItemMeta();

        ironLeggingsMeta.setDisplayName("§6Iron Leggings");

        ArrayList<String> ironLeggingsLore = new ArrayList<>();
        ironLeggingsLore.add("");
        ironLeggingsLore.add("§eCost: §f26 Gold");
        ironLeggingsLore.add("");
        if (gold >= 26) {
            ironLeggingsLore.add("§a§oClick to purchase");
            addEnchantStyle(ironLeggingsMeta);
        } else {
            ironLeggingsLore.add("§c§oYou cannot afford this");
        }

        ironLeggingsMeta.setLore(ironLeggingsLore);

        ironLeggingsMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ironLeggings.setItemMeta(ironLeggingsMeta);

        inv.setItem(32, ironLeggings);

        //Iron Boots
        ItemStack ironBoots = new ItemStack(Material.IRON_BOOTS);
        ItemMeta ironBootsMeta = ironBoots.getItemMeta();

        ironBootsMeta.setDisplayName("§6Iron Boots");

        ArrayList<String> ironBootsLore = new ArrayList<>();
        ironBootsLore.add("");
        ironBootsLore.add("§eCost: §f19 Gold");
        ironBootsLore.add("");
        if (gold >= 19) {
            ironBootsLore.add("§a§oClick to purchase");
            addEnchantStyle(ironBootsMeta);
        } else {
            ironBootsLore.add("§c§oYou cannot afford this");
        }

        ironBootsMeta.setLore(ironBootsLore);

        ironBootsMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ironBoots.setItemMeta(ironBootsMeta);

        inv.setItem(41, ironBoots);

        //Diamond Helmet
        ItemStack diamondHelmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta diamondHelmetMeta = diamondHelmet.getItemMeta();

        diamondHelmetMeta.setDisplayName("§6Diamond Helmet");

        ArrayList<String> diamondHelmetLore = new ArrayList<>();
        diamondHelmetLore.add("");
        diamondHelmetLore.add("§eCost: §f25 Emerald");
        diamondHelmetLore.add("");
        if (emerald >= 25) {
            diamondHelmetLore.add("§a§oClick to purchase");
            addEnchantStyle(diamondHelmetMeta);
        } else {
            diamondHelmetLore.add("§c§oYou cannot afford this");
        }

        diamondHelmetMeta.setLore(diamondHelmetLore);

        diamondHelmetMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        diamondHelmet.setItemMeta(diamondHelmetMeta);

        inv.setItem(16, diamondHelmet);

        //Diamond Chestplate
        ItemStack diamondChestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta diamondChestplateMeta = diamondChestplate.getItemMeta();

        diamondChestplateMeta.setDisplayName("§6Diamond Chestplate");

        ArrayList<String> diamondChestplateLore = new ArrayList<>();
        diamondChestplateLore.add("");
        diamondChestplateLore.add("§eCost: §f30 Emerald");
        diamondChestplateLore.add("");
        if (emerald >= 30) {
            diamondChestplateLore.add("§a§oClick to purchase");
            addEnchantStyle(diamondChestplateMeta);
        } else {
            diamondChestplateLore.add("§c§oYou cannot afford this");
        }

        diamondChestplateMeta.setLore(diamondChestplateLore);

        diamondChestplateMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        diamondChestplate.setItemMeta(diamondChestplateMeta);

        inv.setItem(25, diamondChestplate);

        //Diamond Leggings
        ItemStack diamondLeggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta diamondLeggingsMeta = diamondLeggings.getItemMeta();

        diamondLeggingsMeta.setDisplayName("§6Diamond Leggings");

        ArrayList<String> diamondLeggingsLore = new ArrayList<>();
        diamondLeggingsLore.add("");
        diamondLeggingsLore.add("§eCost: §f28 Emerald");
        diamondLeggingsLore.add("");
        if (emerald >= 28) {
            diamondLeggingsLore.add("§a§oClick to purchase");
            addEnchantStyle(diamondLeggingsMeta);
        } else {
            diamondLeggingsLore.add("§c§oYou cannot afford this");
        }

        diamondLeggingsMeta.setLore(diamondLeggingsLore);

        diamondLeggingsMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        diamondLeggings.setItemMeta(diamondLeggingsMeta);

        inv.setItem(34, diamondLeggings);

        //Diamond Boots
        ItemStack diamondBoots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta diamondBootsMeta = diamondBoots.getItemMeta();

        diamondBootsMeta.setDisplayName("§6Diamond Boots");

        ArrayList<String> diamondBootsLore = new ArrayList<>();
        diamondBootsLore.add("");
        diamondBootsLore.add("§eCost: §f23 Emerald");
        diamondBootsLore.add("");
        if (emerald >= 23) {
            diamondBootsLore.add("§a§oClick to purchase");
            addEnchantStyle(diamondBootsMeta);
        } else {
            diamondBootsLore.add("§c§oYou cannot afford this");
        }

        diamondBootsMeta.setLore(diamondBootsLore);

        diamondBootsMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        diamondBoots.setItemMeta(diamondBootsMeta);

        inv.setItem(43, diamondBoots);

        //Return
        returnItem(inv, 45);

        player.openInventory(inv);
    }

    public void toolsGUI(Player player) {
        int coal = ci.countCoal(player);
        int gold = ci.countGold(player);
        int iron = ci.countIron(player);
        int diamond = ci.countDiamonds(player);

        Inventory inv = Bukkit.createInventory(null, 45, "§cShop §8(Tools)");

        //Wood Pick
        ItemStack woodPick = new ItemStack(Material.WOOD_PICKAXE);
        ItemMeta woodPickMeta = woodPick.getItemMeta();

        woodPickMeta.setDisplayName("§6Wood Pickaxe");

        ArrayList<String> woodPickLore = new ArrayList<>();
        woodPickLore.add("");
        woodPickLore.add("§eCost: §f22 Coal");
        woodPickLore.add("");
        if (coal >= 22) {
            woodPickLore.add("§a§oClick to purchase");
            addEnchantStyle(woodPickMeta);
        } else {
            woodPickLore.add("§c§oYou cannot afford this");
        }

        woodPickMeta.setLore(woodPickLore);

        woodPickMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        woodPick.setItemMeta(woodPickMeta);

        inv.setItem(10, woodPick);

        //Wood Shovel
        ItemStack woodShovel = new ItemStack(Material.WOOD_SPADE);
        ItemMeta woodShovelMeta = woodShovel.getItemMeta();

        woodShovelMeta.setDisplayName("§6Wood Shovel");

        ArrayList<String> woodShovelLore = new ArrayList<>();
        woodShovelLore.add("");
        woodShovelLore.add("§eCost: §f16 Coal");
        woodShovelLore.add("");
        if (coal >= 16) {
            woodShovelLore.add("§a§oClick to purchase");
            addEnchantStyle(woodShovelMeta);
        } else {
            woodShovelLore.add("§c§oYou cannot afford this");
        }

        woodShovelMeta.setLore(woodShovelLore);

        woodShovelMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        woodShovel.setItemMeta(woodShovelMeta);
        inv.setItem(19, woodShovel);

        //Wood Hoe
        ItemStack woodHoe = new ItemStack(Material.WOOD_HOE);
        ItemMeta woodHoeMeta = woodHoe.getItemMeta();

        woodHoeMeta.setDisplayName("§6Wood Hoe");

        ArrayList<String> woodHoeLore = new ArrayList<>();
        woodHoeLore.add("");
        woodHoeLore.add("§eCost: §f19 Coal");
        woodHoeLore.add("");
        if (coal >= 19) {
            woodHoeLore.add("§a§oClick to purchase");
            addEnchantStyle(woodHoeMeta);
        } else {
            woodHoeLore.add("§c§oYou cannot afford this");
        }

        woodHoeMeta.setLore(woodHoeLore);

        woodHoeMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        woodHoe.setItemMeta(woodHoeMeta);
        inv.setItem(28, woodHoe);

        //Stone Pick
        ItemStack stonePick = new ItemStack(Material.STONE_PICKAXE);
        ItemMeta stonePickMeta = stonePick.getItemMeta();

        stonePickMeta.setDisplayName("§6Stone Pickaxe");

        ArrayList<String> stonePickLore = new ArrayList<>();
        stonePickLore.add("");
        stonePickLore.add("§eCost: §f23 Iron");
        stonePickLore.add("");
        if (iron >= 23) {
            stonePickLore.add("§a§oClick to purchase");
            addEnchantStyle(stonePickMeta);
        } else {
            stonePickLore.add("§c§oYou cannot afford this");
        }

        stonePickMeta.setLore(stonePickLore);

        stonePickMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        stonePick.setItemMeta(stonePickMeta);

        inv.setItem(12, stonePick);

        //Stone Shovel
        ItemStack stoneShovel = new ItemStack(Material.STONE_SPADE);
        ItemMeta stoneShovelMeta = stoneShovel.getItemMeta();

        stoneShovelMeta.setDisplayName("§6Stone Shovel");

        ArrayList<String> stoneShovelLore = new ArrayList<>();
        stoneShovelLore.add("");
        stoneShovelLore.add("§eCost: §f20 Iron");
        stoneShovelLore.add("");
        if (iron >= 20) {
            stoneShovelLore.add("§a§oClick to purchase");
            addEnchantStyle(stoneShovelMeta);
        } else {
            stoneShovelLore.add("§c§oYou cannot afford this");
        }

        stoneShovelMeta.setLore(stoneShovelLore);

        stoneShovelMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        stoneShovel.setItemMeta(stoneShovelMeta);

        inv.setItem(21, stoneShovel);

        //Stone Hoe
        ItemStack stoneHoe = new ItemStack(Material.STONE_HOE);
        ItemMeta stoneHoeMeta = stoneHoe.getItemMeta();

        stoneHoeMeta.setDisplayName("§6Stone Hoe");

        ArrayList<String> stoneHoeLore = new ArrayList<>();
        stoneHoeLore.add("");
        stoneHoeLore.add("§eCost: §f18 Iron");
        stoneHoeLore.add("");
        if (iron >= 18) {
            stoneHoeLore.add("§a§oClick to purchase");
            addEnchantStyle(stoneHoeMeta);
        } else {
            stoneHoeLore.add("§c§oYou cannot afford this");
        }

        stoneHoeMeta.setLore(stoneHoeLore);

        stoneHoeMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        stoneHoe.setItemMeta(stoneHoeMeta);

        inv.setItem(30, stoneHoe);

        //Iron Pick
        ItemStack ironPick = new ItemStack(Material.IRON_PICKAXE);
        ItemMeta ironPickMeta = ironPick.getItemMeta();

        ironPickMeta.setDisplayName("§6Iron Pickaxe");

        ArrayList<String> ironPickLore = new ArrayList<>();
        ironPickLore.add("");
        ironPickLore.add("§eCost: §f34 Gold");
        ironPickLore.add("");
        if (gold >= 34) {
            ironPickLore.add("§a§oClick to purchase");
            addEnchantStyle(ironPickMeta);
        } else {
            ironPickLore.add("§c§oYou cannot afford this");
        }

        ironPickMeta.setLore(ironPickLore);

        ironPickMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ironPick.setItemMeta(ironPickMeta);

        inv.setItem(14, ironPick);

        //Iron Shovel
        ItemStack ironShovel = new ItemStack(Material.IRON_SPADE);
        ItemMeta ironShovelMeta = ironShovel.getItemMeta();

        ironShovelMeta.setDisplayName("§6Iron Shovel");

        ArrayList<String> ironShovelLore = new ArrayList<>();
        ironShovelLore.add("");
        ironShovelLore.add("§eCost: §f30 Gold");
        ironShovelLore.add("");
        if (gold >= 30) {
            ironShovelLore.add("§a§oClick to purchase");
            addEnchantStyle(ironShovelMeta);
        } else {
            ironShovelLore.add("§c§oYou cannot afford this");
        }

        ironShovelMeta.setLore(ironShovelLore);

        ironShovelMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ironShovel.setItemMeta(ironShovelMeta);

        inv.setItem(23, ironShovel);

        //Iron Hoe
        ItemStack ironHoe = new ItemStack(Material.IRON_HOE);
        ItemMeta ironHoeMeta = ironHoe.getItemMeta();

        ironHoeMeta.setDisplayName("§6Iron Hoe");

        ArrayList<String> ironHoeLore = new ArrayList<>();
        ironHoeLore.add("");
        ironHoeLore.add("§eCost: §f27 Gold");
        ironHoeLore.add("");
        if (gold >= 27) {
            ironHoeLore.add("§a§oClick to purchase");
            addEnchantStyle(ironHoeMeta);
        } else {
            ironHoeLore.add("§c§oYou cannot afford this");
        }

        ironHoeMeta.setLore(ironHoeLore);

        ironHoeMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ironHoe.setItemMeta(ironHoeMeta);

        inv.setItem(32, ironHoe);

        //Diamond Pick
        ItemStack diamondPick = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta diamondPickMeta = diamondPick.getItemMeta();

        diamondPickMeta.setDisplayName("§6Diamond Pickaxe");

        ArrayList<String> diamondPickLore = new ArrayList<>();
        diamondPickLore.add("");
        diamondPickLore.add("§eCost: §f18 Diamond");
        diamondPickLore.add("");
        if (diamond >= 18) {
            diamondPickLore.add("§a§oClick to purchase");
            addEnchantStyle(diamondPickMeta);
        } else {
            diamondPickLore.add("§c§oYou cannot afford this");
        }

        diamondPickMeta.setLore(diamondPickLore);

        diamondPickMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        diamondPick.setItemMeta(diamondPickMeta);

        inv.setItem(16, diamondPick);

        //Diamond Shovel
        ItemStack diamondShovel = new ItemStack(Material.DIAMOND_SPADE);
        ItemMeta diamondShovelMeta = diamondShovel.getItemMeta();

        diamondShovelMeta.setDisplayName("§6Diamond Shovel");

        ArrayList<String> diamondShovelLore = new ArrayList<>();
        diamondShovelLore.add("");
        diamondShovelLore.add("§eCost: §f16 Diamond");
        diamondShovelLore.add("");
        if (diamond >= 16) {
            diamondShovelLore.add("§a§oClick to purchase");
            addEnchantStyle(diamondShovelMeta);
        } else {
            diamondShovelLore.add("§c§oYou cannot afford this");
        }

        diamondShovelMeta.setLore(diamondShovelLore);

        diamondShovelMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        diamondShovel.setItemMeta(diamondShovelMeta);

        inv.setItem(25, diamondShovel);

        //Diamond Hoe
        ItemStack diamondHoe = new ItemStack(Material.DIAMOND_HOE);
        ItemMeta diamondHoeMeta = diamondHoe.getItemMeta();

        diamondHoeMeta.setDisplayName("§6Diamond Hoe");

        ArrayList<String> diamondHoeLore = new ArrayList<>();
        diamondHoeLore.add("");
        diamondHoeLore.add("§eCost: §f13 Diamond");
        diamondHoeLore.add("");
        if (diamond >= 13) {
            diamondHoeLore.add("§a§oClick to purchase");
            addEnchantStyle(diamondHoeMeta);
        } else {
            diamondHoeLore.add("§c§oYou cannot afford this");
        }

        diamondHoeMeta.setLore(diamondHoeLore);

        diamondHoeMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        diamondHoe.setItemMeta(diamondHoeMeta);

        inv.setItem(34, diamondHoe);

        //Return
        returnItem(inv, 36);

        player.openInventory(inv);
    }

    public void utilityGUI(Player player) {
        int gold = ci.countGold(player);
        int emerald = ci.countEmeralds(player);
        int diamond = ci.countDiamonds(player);

        Inventory inv = Bukkit.createInventory(null, 27, "§cShop §8(Utility)");

        //Enderpearl
        ItemStack enderpearl = new ItemStack(Material.ENDER_PEARL);
        ItemMeta enderpearlMeta = enderpearl.getItemMeta();

        enderpearlMeta.setDisplayName("§6Enderpearl");

        ArrayList<String> enderpearlLore = new ArrayList<>();
        enderpearlLore.add("");
        enderpearlLore.add("§eCost: §f7 Emerald");
        enderpearlLore.add("");
        if (emerald >= 7) {
            enderpearlLore.add("§a§oClick to purchase");
            addEnchantStyle(enderpearlMeta);
        } else {
            enderpearlLore.add("§c§oYou cannot afford this");
        }

        enderpearlMeta.setLore(enderpearlLore);

        enderpearlMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        enderpearl.setItemMeta(enderpearlMeta);

        inv.setItem(11, enderpearl);

        //TNT
        ItemStack tnt = new ItemStack(Material.TNT);
        ItemMeta tntMeta = tnt.getItemMeta();

        tntMeta.setDisplayName("§6TNT");

        ArrayList<String> tntLore = new ArrayList<>();
        tntLore.add("");
        tntLore.add("§eCost: §f56 Gold");
        tntLore.add("");
        if (gold >= 56) {
            tntLore.add("§a§oClick to purchase");
            addEnchantStyle(tntMeta);
        } else {
            tntLore.add("§c§oYou cannot afford this");
        }

        tntMeta.setLore(tntLore);

        tntMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        tnt.setItemMeta(tntMeta);

        inv.setItem(12, tnt);

        //Player Tracker
        ItemStack compass = new ItemStack(Material.COMPASS);
        ItemMeta compassMeta = compass.getItemMeta();

        compassMeta.setDisplayName("§6Player Tracker");

        ArrayList<String> compassLore = new ArrayList<>();
        compassLore.add("");
        compassLore.add("§eCost: §f15 Diamond");
        compassLore.add("");
        if (diamond >= 15) {
            compassLore.add("§a§oClick to purchase");
            addEnchantStyle(compassMeta);
        } else {
            compassLore.add("§c§oYou cannot afford this");
        }

        compassMeta.setLore(compassLore);

        compassMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        compass.setItemMeta(compassMeta);

        inv.setItem(13, compass);

        //Cake
        ItemStack cake = new ItemStack(Material.CAKE);
        ItemMeta cakeMeta = cake.getItemMeta();

        cakeMeta.setDisplayName("§6Explosive Cake");

        ArrayList<String> cakeLore = new ArrayList<>();
        cakeLore.add("");
        cakeLore.add("§eCost: §f16 Diamond");
        cakeLore.add("");
        if (diamond >= 16) {
            cakeLore.add("§a§oClick to purchase");
            addEnchantStyle(cakeMeta);
        } else {
            cakeLore.add("§c§oYou cannot afford this");
        }

        cakeMeta.setLore(cakeLore);

        cakeMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        cake.setItemMeta(cakeMeta);

        inv.setItem(14, cake);

        //Chest
        ItemStack chest = new ItemStack(Material.CHEST);
        ItemMeta chestMeta = chest.getItemMeta();

        chestMeta.setDisplayName("§6Chest");

        ArrayList<String> chestLore = new ArrayList<>();
        chestLore.add("");
        chestLore.add("§eCost: §f26 Gold");
        chestLore.add("");
        if (gold >= 26) {
            chestLore.add("§a§oClick to purchase");
            addEnchantStyle(chestMeta);
        } else {
            chestLore.add("§c§oYou cannot afford this");
        }

        chestMeta.setLore(chestLore);

        chestMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        chest.setItemMeta(chestMeta);

        inv.setItem(15, chest);

        //Return
        returnItem(inv, 18);

        player.openInventory(inv);
    }

    public void returnItem(Inventory inv, int slot) {
        ItemStack returnItem = new ItemStack(Material.ARROW, 1);
        ItemMeta returnItemMeta = returnItem.getItemMeta();

        returnItemMeta.setDisplayName("§cGo Back");

        ArrayList<String> returnItemLore = new ArrayList<>();
        returnItemLore.add("§7Click to return to the main menu");

        returnItemMeta.setLore(returnItemLore);
        returnItem.setItemMeta(returnItemMeta);

        inv.setItem(slot, returnItem);
    }

    private void addEnchantStyle(ItemMeta meta) {
        meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
    }

}
