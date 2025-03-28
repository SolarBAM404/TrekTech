package me.solar.trektech.data;

import me.solar.trektech.TrekTech;
import me.solar.trektech.blocks.TrekBlocks;
//import me.solar.trektech.TrekItems;
import me.solar.trektech.blocks.custom.ReplicatorBlock;
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
//        add(TrekItems.REPLICATOR_ITEM.get(), "Replicator");

        // Menu
//        add(ReplicatorBlock.SCREEN_TREKTECH_REPLICATOR, "Replicator");

        // Creative Mode Tabs
        add("itemGroup.trektech", "Trek Tech");
    }
}
