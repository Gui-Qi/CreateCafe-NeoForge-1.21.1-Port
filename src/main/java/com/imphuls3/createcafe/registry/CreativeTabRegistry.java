package com.imphuls3.createcafe.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.imphuls3.createcafe.CreateCafe.MODID;

public class CreativeTabRegistry {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB,MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CREATE_CAFE_TAB = TABS.register("create_cafe_items", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.create_cafe_items"))
            .icon(ItemRegistry.STRAWBERRY_TEA.get()::getDefaultInstance)
            .displayItems((parameters, output) -> {
                for (DeferredHolder<Item, ? extends Item> item : ItemRegistry.ITEMS.getEntries()){
                    output.accept(item.get());
                }
            }).build()
    );

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CREATE_CAFE_FLUID = TABS.register("create_cafe_fluids", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.create_cafe_fluids"))
            .icon(FluidRegistry.STRAWBERRY_TEA.getBucket().get()::getDefaultInstance).build()
    );

    public static void register(IEventBus eventBus){
        TABS.register(eventBus);
    }
}
