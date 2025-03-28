package me.solar.data;

import me.solar.TrekBlocks;
import me.solar.TrekTech;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.Variant;
import net.minecraft.client.data.models.blockstates.VariantProperties;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class BlockProvider extends ModelProvider {

    public BlockProvider(PackOutput output) {
        super(output, TrekTech.MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, @NotNull ItemModelGenerators itemModels) {
        ResourceLocation resourceLocation = ModelLocationUtils.getModelLocation(TrekBlocks.REPLICATOR_BLOCK.get());

        blockModels.blockStateOutput.accept(
                MultiVariantGenerator.multiVariant(TrekBlocks.REPLICATOR_BLOCK.get(),
                    Variant.variant().with(VariantProperties.MODEL, resourceLocation))
                    .with(BlockModelGenerators.createHorizontalFacingDispatch())
        );
    }
}
