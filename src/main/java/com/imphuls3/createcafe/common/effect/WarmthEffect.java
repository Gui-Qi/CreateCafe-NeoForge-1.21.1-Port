package com.imphuls3.createcafe.common.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class WarmthEffect extends MobEffect {
    public WarmthEffect (MobEffectCategory category, int color){
        super(category, color);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier){
        return duration % 4 == 0;
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier){
        entity.setTicksFrozen(0);
        return true;
    }
}
