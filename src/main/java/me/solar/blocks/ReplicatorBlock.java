package me.solar.blocks;

import com.mojang.serialization.MapCodec;
import me.solar.TrekTech;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ReplicatorBlock extends Block{

    public static final MapCodec<ReplicatorBlock> CODEC = simpleCodec(ReplicatorBlock::new);

    public ReplicatorBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends Block> codec() {
        return super.codec();
    }
}
