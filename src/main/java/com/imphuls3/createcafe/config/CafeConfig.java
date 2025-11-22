package com.imphuls3.createcafe.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class CafeConfig {
    //Server Configs
    public static final ModConfigSpec.Builder SERVER_BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec SERVER_SPEC;
    public static ModConfigSpec.IntValue effectDuration;

    static {

        SERVER_BUILDER.push("effect_duration");
        effectDuration = SERVER_BUILDER
                .comment("The duration of the effect that drinks give [Default: 10]")
                .defineInRange("effectDuration", 10, 0, Integer.MAX_VALUE);
        SERVER_BUILDER.pop();


        SERVER_SPEC = SERVER_BUILDER.build();
    }

    //Common Configs
    public static final ModConfigSpec.Builder COMMON_BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec COMMON_SPEC;
    public static ModConfigSpec.BooleanValue giveEmptyCups;

    static {

        COMMON_BUILDER.push("give_empty_cups");
        giveEmptyCups = COMMON_BUILDER
                .comment("Should drinks give empty cups after drinking them [Default: true]")
                .define("giveEmptyCups", true);
        COMMON_BUILDER.pop();

        COMMON_SPEC = COMMON_BUILDER.build();
    }
}
