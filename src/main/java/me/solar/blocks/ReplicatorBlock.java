package me.solar.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ReplicatorBlock extends Block{

    public ReplicatorBlock() {
        super(BlockBehaviour.Properties.of()
                .strength(5.0f, 6.0f)
                .sound(SoundType.METAL));
    }
}
