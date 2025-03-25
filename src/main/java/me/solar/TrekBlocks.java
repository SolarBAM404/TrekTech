package me.solar;

import me.solar.blockentities.ReplicatorBlockEntity;
import me.solar.blocks.ReplicatorBlock;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class TrekBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(TrekTech.MODID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, TrekTech.MODID);

    public static final DeferredBlock<ReplicatorBlock> REPLICATOR_BLOCK = BLOCKS.registerBlock("replicator", ReplicatorBlock::new, BlockBehaviour.Properties.of().noOcclusion());
    public static final Supplier<BlockEntityType<ReplicatorBlockEntity>> REPLICATOR_BLOCK_ENTITY = BLOCK_ENTITIES.register("replicator", () -> new BlockEntityType(ReplicatorBlockEntity::new, REPLICATOR_BLOCK.get()));

    public static void init(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
        BLOCK_ENTITIES.register(modEventBus);
    }
}
