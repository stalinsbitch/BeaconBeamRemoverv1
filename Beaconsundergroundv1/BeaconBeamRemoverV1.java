package com.beaconbeamremoverv1;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;

public class BeaconBeamRemoverV1 implements Listener {

    private final Plugin plugin;

    public BeaconBeamRemoverV1(Plugin plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        Block placedBlock = event.getBlockPlaced();

        if (placedBlock.getType() == Material.BEACON && isDirectlyAboveBeacon(placedBlock)) {
            ItemStack beaconRemover = createBeaconRemoverItem();
            player.getInventory().addItem(beaconRemover);
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Block brokenBlock = event.getBlock();

        if (brokenBlock.getType() == Material.IRON_BLOCK && brokenBlock.hasMetadata("beaconRemover")) {
            // Handle dropping the item
            // ...

            event.setCancelled(true); // Cancel the normal block break behavior
        }
    }

    private boolean isDirectlyAboveBeacon(Block block) {
        // Check if the block is directly above a beacon
        // ...
        return true; // Replace this with your actual implementation
    }

    private ItemStack createBeaconRemoverItem() {
        ItemStack item = new ItemStack(Items.IRON_BLOCK);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("Beacon Beam Remover");
        meta.addEnchant(Enchantment.LUCK, 1, true);
        // Add lore or other meta information if needed

        item.setItemMeta(meta);
        item.setMetadata("beaconRemover", new FixedMetadataValue(plugin, true));

        return item;
    }
}
