package me.solar.trektech.blocks;

import me.solar.trektech.blocks.custom.ReplicatorBlock;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import static me.solar.trektech.TrekTech.MODID;

public class TrekBlocks {

    public static DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);

    public static DeferredBlock<ReplicatorBlock> REPLICATOR_BLOCK = BLOCKS.registerBlock("replicator", ReplicatorBlock::new);

    public static void init(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }

}
