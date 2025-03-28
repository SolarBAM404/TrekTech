package me.solar.trektech.data;

import me.solar.trektech.blocks.TrekBlocks;
import me.solar.trektech.TrekTech;
import me.solar.trektech.blocks.custom.ReplicatorBlock;
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
//        add(ReplicatorBlock.SCREEN_TREKTECH_REPLICATOR, "Replicator");

        // GUI
        add("container.replicator", "Replicator");

        // Creative Mode Tabs
        add("itemGroup.trektech", "Trek Tech");
    }
}
