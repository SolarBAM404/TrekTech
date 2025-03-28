package me.solar.trektech.items;

import me.solar.trektech.blocks.TrekBlocks;
import me.solar.trektech.blocks.custom.ReplicatorBlock;
import net.minecraft.world.item.BlockItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.IModBusEvent;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class TrekItems {

    public static DeferredRegister.Items ITEMS = DeferredRegister.createItems("trektech");

    public static Supplier<BlockItem> REPLICATOR_ITEM = ITEMS.registerSimpleBlockItem(TrekBlocks.REPLICATOR_BLOCK);

    public static void init(IEventBus event) {
        ITEMS.register(event);
    }
}
