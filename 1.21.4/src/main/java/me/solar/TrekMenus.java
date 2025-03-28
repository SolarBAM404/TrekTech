package me.solar;

import me.solar.menus.ReplicatorMenu;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class TrekMenus {

    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(BuiltInRegistries.MENU, TrekTech.MODID);

    public static final Supplier<MenuType<ReplicatorMenu>> REPLICATOR_MENU = MENU_TYPES.register("replicator", () -> new MenuType<>(ReplicatorMenu::new, FeatureFlags.DEFAULT_FLAGS));

    public static void init(IEventBus modEventBus) {
        MENU_TYPES.register(modEventBus);
    }


}
