package me.solar.data;

import me.solar.TrekBlocks;
import me.solar.TrekItems;
import me.solar.TrekTech;
import me.solar.blocks.ReplicatorBlock;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class EnglishUsLanguage extends LanguageProvider {

    public EnglishUsLanguage(PackOutput output) {
        super(output, TrekTech.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {

        // Blocks
        add(TrekBlocks.REPLICATOR_BLOCK.get(), "Replicator Block");

        // Items
        add(TrekItems.REPLICATOR_ITEM.get(), "Replicator");

        // Menu
        add(ReplicatorBlock.SCREEN_TREKTECH_REPLICATOR, "Replicator");

        // Creative Mode Tabs
        add("itemGroup.trektech", "Trek Tech");
    }
}
