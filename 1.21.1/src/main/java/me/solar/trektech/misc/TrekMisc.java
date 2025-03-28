package me.solar.trektech.misc;

import me.solar.trektech.TrekTech;
import me.solar.trektech.items.TrekItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class TrekMisc {

    public static DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB, TrekTech.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MOD_TAB = CREATIVE_MODE_TABS.register("trek_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.trektech")) //The language key for the title of your CreativeModeTab
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> new ItemStack(TrekItems.REPLICATOR_ITEM.get()))
            .build());

    public static void init(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

    public static void creativeTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == MOD_TAB.get()) {
            event.accept(TrekItems.REPLICATOR_ITEM.get());
        }
    }
}
