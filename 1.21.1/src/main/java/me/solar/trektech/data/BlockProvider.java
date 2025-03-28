package me.solar.trektech.data;

import me.solar.trektech.blocks.TrekBlocks;
import me.solar.trektech.TrekTech;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class BlockProvider extends BlockStateProvider {

    private final ExistingFileHelper existingFileHelper;

    private final ResourceLocation replicationBlock = modLoc("block/replicator");

    public BlockProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TrekTech.MODID, exFileHelper);
        this.existingFileHelper = exFileHelper;
    }

    @Override
    protected void registerStatesAndModels() {
    }
}
