package com.imphuls3.createcafe.common.item.foods;

import com.imphuls3.createcafe.config.CafeConfig;
import com.imphuls3.createcafe.registry.ItemRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

import java.util.List;

public class CafeDrink extends Item {
    String type;
    public String fruit;

    public CafeDrink(Properties properties, String type){
        super(properties);
        this.type = type;
        this.fruit = type.replace("milk_tea","");
    }

    @Override
    public void appendHoverText(ItemStack itemStack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag advanced){
        super.appendHoverText(itemStack, context, tooltip, advanced);
        tooltip.add(Component.translatable("tooltip.createcafe."+ type).withStyle(ChatFormatting.BLUE));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity){
        super.finishUsingItem(itemStack, level, livingEntity);
        if(CafeConfig.giveEmptyCups.get()) {
            if(livingEntity instanceof ServerPlayer serverPlayer){
                CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, itemStack);
                serverPlayer.awardStat(Stats.ITEM_USED.get(this));
            }

            if (itemStack.isEmpty()){
                return new ItemStack(ItemRegistry.EMPTY_BOBA_CUP.get());
            } else {
                if (livingEntity instanceof Player && !((Player)livingEntity).getAbilities().instabuild){
                    ItemStack itemStack1 = new ItemStack(ItemRegistry.EMPTY_BOBA_CUP.get());
                    Player player = (Player)livingEntity;
                    if (!player.getInventory().add(itemStack1)){
                        player.drop(itemStack1,false);
                    }
                }
            }
        }
        return itemStack;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack itemStack){
        return UseAnim.DRINK;
    }

    @Override
    public SoundEvent getDrinkingSound(){
        return SoundEvents.GENERIC_DRINK;
    }
}
