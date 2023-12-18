package your.plugin.package;

import org.bukkit.plugin.java.JavaPlugin;

public class MainPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Register your custom block
        BeaconBeamRemoverBlock beaconBeamRemoverBlock = new BeaconBeamRemoverBlock();
        Material material = Material.POLISHED_BLACKSTONE; // Change this to the desired material
        BlockData blockData = Bukkit.createBlockData(material);
        PaperBlockData paperBlockData = (PaperBlockData) blockData;

        // Set any additional Paper-specific data if needed
        // paperBlockData.setWhatever(...);

        // Register the block with Paper
        PaperPluginUtils.registerCustomBlock(beaconBeamRemoverBlock, paperBlockData);
    }
}
