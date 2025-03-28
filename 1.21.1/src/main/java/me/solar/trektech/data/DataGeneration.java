package me.solar.trektech.data;

import me.solar.trektech.data.EnglishUsLanguage;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = "trektech")
public class DataGeneration {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        // other providers here
        generator.addProvider(
                event.includeClient(),
                new BlockProvider(output, existingFileHelper)
        );
        generator.addProvider(
                event.includeClient(),
                new ItemProvider(output, existingFileHelper)
        );
        generator.addProvider(
                event.includeClient(),
                new EnglishUsLanguage(output)
        );
        generator.addProvider(
                event.includeClient(),
                new EnglishGbLanguage(output)
        );
    }

}
