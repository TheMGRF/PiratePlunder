package net.collat.pirateplunder;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Beds implements Listener {

    @EventHandler
    public void bouncyBed(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Location loc = player.getLocation();
        World world = player.getWorld();
        Block blockUnderPlayer = world.getBlockAt(loc);

        if(blockUnderPlayer.getType().equals(Material.BED_BLOCK)) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 10, 1, false, false));
            if(!player.isOnGround()) {
                player.playSound(loc, Sound.ENTITY_ITEMFRAME_ROTATE_ITEM, 1, (float) 0.5);
            }
        }

    }

}
