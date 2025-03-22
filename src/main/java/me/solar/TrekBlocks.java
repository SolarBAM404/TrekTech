package me.solar;

import me.solar.blocks.ReplicatorBlock;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class TrekBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(TrekTech.MODID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, TrekTech.MODID);

    public static final DeferredBlock<ReplicatorBlock> REPLICATOR_BLOCK = BLOCKS.registerBlock("replicator", ReplicatorBlock::new, BlockBehaviour.Properties.of().noOcclusion());

    public static void init(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
        BLOCK_ENTITIES.register(modEventBus);
    }
}
