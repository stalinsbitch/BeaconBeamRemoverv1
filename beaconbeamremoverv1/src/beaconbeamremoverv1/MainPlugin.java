package beaconbeamremoverv1;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class BeaconBeamRemoverBlock implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        // Check if the broken block is an instance of your custom block
        if (isCustomBlock(event.getBlock())) {
            // Prevent the block from dropping default items
            event.setDropItems(false);

            // Handle custom logic when the block is broken
            onCustomBlockBreak(event.getPlayer(), event.getBlock());
        }
    }

    private boolean isCustomBlock(Block block) {
        // Implement logic to determine if the block is your custom block
        // For example, check the block type, block data, or other characteristics
        return block.getType() == Material.POLISHED_BLACKSTONE;
    }

    private void onCustomBlockBreak(Player player, Block block) {
        // Implement custom logic when the block is broken
        // For example, drop an item representing the block
        ItemStack customItem = new ItemStack(Material.POLISHED_BLACKSTONE);
        customItem.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
        player.getInventory().addItem(customItem);
    }

    public BlockData getBlockData() {
        // Implement logic to create and return the BlockData for your custom block
        return Material.POLISHED_BLACKSTONE.createBlockData();
    }
}
