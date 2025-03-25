package me.solar.data;

import me.solar.TrekBlocks;
import me.solar.TrekItems;
import me.solar.TrekTech;
import me.solar.blockentities.ReplicatorBlockEntity;
import me.solar.blocks.ReplicatorBlock;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class EnglishGbLanguage extends LanguageProvider {

    public EnglishGbLanguage(PackOutput output) {
        super(output, TrekTech.MODID, "en_gb");
    }

    @Override
    protected void addTranslations() {

        // Blocks
        add(TrekBlocks.REPLICATOR_BLOCK.get(), "Replicator Block");

        // Items
        add(ReplicatorBlock.SCREEN_TREKTECH_REPLICATOR, "Replicator");

        // GUI
        add("container.replicator", "Replicator");

        // Creative Mode Tabs
        add("itemGroup.trektech", "Trek Tech");
    }
}
