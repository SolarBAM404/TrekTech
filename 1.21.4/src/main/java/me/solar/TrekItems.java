package me.solar;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static me.solar.TrekBlocks.REPLICATOR_BLOCK;

public class TrekItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TrekTech.MODID);

    public static final DeferredItem<Item> REPLICATOR_ITEM = ITEMS.registerItem("replicator", (props) -> new BlockItem(REPLICATOR_BLOCK.get(), props), new Item.Properties());

    public static void init(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }

}
