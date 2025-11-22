package com.imphuls3.createcafe.registry;

import com.imphuls3.createcafe.common.block.CassavaBlock;
import com.imphuls3.createcafe.common.block.CoffeeBlock;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.imphuls3.createcafe.CreateCafe.MODID;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(BuiltInRegistries.BLOCK, MODID);

    //Crops:
    public static final DeferredHolder<Block, Block> COFFEE = BLOCKS.register("coffee_crop",
            () -> new CoffeeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).noOcclusion()));

    public static final DeferredHolder<Block, Block> CASSAVA = BLOCKS.register("cassava_crop",
            () -> new CassavaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).noOcclusion()));

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
