package com.imphuls3.createcafe.common.effect;

import com.imphuls3.createcafe.CreateCafe;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.awt.*;

public class EffectRegistry {
    public static DeferredRegister<MobEffect> MOD_EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, CreateCafe.MODID);

    public static Holder<MobEffect> CAFFINATED = MOD_EFFECTS.register("caffeinated",
            () -> new CaffinatedEffect(MobEffectCategory.BENEFICIAL, new Color(255, 200, 0).getRGB())
                    .addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.withDefaultNamespace("effect.caffeinated"), 0.2F, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    public static Holder<MobEffect> CAFFEINE_CRASH = MOD_EFFECTS.register("caffeine_crash",
            () -> new CrashEffect(MobEffectCategory.HARMFUL, new Color(20, 50, 110).getRGB())
                    .addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.withDefaultNamespace("effect.caffeine_crash"), -0.15F, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    public static void register(IEventBus eventBus) {
        MOD_EFFECTS.register(eventBus);
    }
}
