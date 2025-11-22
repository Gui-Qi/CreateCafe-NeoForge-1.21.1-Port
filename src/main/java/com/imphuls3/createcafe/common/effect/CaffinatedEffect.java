package com.imphuls3.createcafe.common.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;


public class CaffinatedEffect extends MobEffect {

    public CaffinatedEffect(MobEffectCategory category, int color) {
        super(category, color);
    }


    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier){
        return duration <= 1 && !(duration <= -1);
    }

    @Override
    public boolean applyEffectTick(@NotNull LivingEntity entity, int amplifier){
        entity.addEffect(new MobEffectInstance(EffectRegistry.CAFFEINE_CRASH, 10 * 20, amplifier));
        return false;
    }
}


