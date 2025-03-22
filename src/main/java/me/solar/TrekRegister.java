package me.solar;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static me.solar.TrekTech.MODID;

public class TrekRegister {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MOD_TAB = CREATIVE_MODE_TABS.register("trek_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.trektech")) //The language key for the title of your CreativeModeTab
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(TrekItems.REPLICATOR_ITEM::toStack)
            .displayItems((parameters, output) -> {
                output.accept(TrekItems.REPLICATOR_ITEM.get()); // Add the example item to the tab. For your own tabs, this method is preferred over the event
            }).build());


    public static void init(IEventBus modEventBus) {
        CREATIVE_MODE_TABS.register(modEventBus);
    }

}
