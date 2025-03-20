package me.solar;

import me.solar.blocks.ReplicatorBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;

public class TrekBlocks {

    public static DeferredBlock<ReplicatorBlock> REPLICATOR_BLOCK = TrekTech.BLOCKS.register("replicator", registryName ->
            new ReplicatorBlock(BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK,registryName)
                )));

    public static void init() {
        TrekTech.getLOGGER().info("Blocks loaded, " + REPLICATOR_BLOCK.get().getName());
    }

}
