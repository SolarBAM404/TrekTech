package me.solar.trektech.data;

import me.solar.trektech.TrekTech;
import me.solar.trektech.blocks.TrekBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ItemProvider extends ItemModelProvider {
    public ItemProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TrekTech.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleBlockItem(TrekBlocks.REPLICATOR_BLOCK.get());
    }
}
