package com.imphuls3.createcafe;

import com.imphuls3.createcafe.common.effect.EffectRegistry;
import com.imphuls3.createcafe.config.CafeConfig;
import com.imphuls3.createcafe.registry.*;
import com.tterrag.registrate.Registrate;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;

@Mod(CreateCafe.MODID)
public class CreateCafe {
    public static final String MODID = "createcafe";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final Registrate REGISTRATE = Registrate.create(MODID)
            .defaultCreativeTab(CreativeTabRegistry.CREATE_CAFE_TAB.getKey());
    public static final Registrate FLUIDREGISTRATE = Registrate.create(MODID)
            .defaultCreativeTab(CreativeTabRegistry.CREATE_CAFE_FLUID.getKey());


    public CreateCafe(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        ItemRegistry.register(modEventBus);
        BlockRegistry.register(modEventBus);

        FluidTypeRegistry.register(modEventBus);
        FluidRegistry.register(modEventBus);

        EffectRegistry.register(modEventBus);
        CreativeTabRegistry.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);

        modContainer.registerConfig(ModConfig.Type.SERVER, CafeConfig.SERVER_SPEC);
        modContainer.registerConfig(ModConfig.Type.COMMON, CafeConfig.COMMON_SPEC);
    }


    public static Registrate registrate(){
        return REGISTRATE;
    }

    public static Registrate fluidRegistrate(){
        return FLUIDREGISTRATE;
    }

    private void commonSetup(FMLCommonSetupEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

}
