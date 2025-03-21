package me.solar;

import me.solar.blocks.ReplicatorBlock;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Registration {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(TrekTech.MODID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TrekTech.MODID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, TrekTech.MODID);


    public static final DeferredBlock<ReplicatorBlock> REPLICATOR_BLOCK = BLOCKS.register("replicator", ReplicatorBlock::new);
    public static final DeferredItem<Item> REPLICATOR_ITEM = ITEMS.register("replicator", () -> new BlockItem(REPLICATOR_BLOCK.get(), new Item.Properties()));

    public static void init(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        BLOCK_ENTITIES.register(modEventBus);
    }

    static void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(REPLICATOR_ITEM.get());
        }
    }
}
