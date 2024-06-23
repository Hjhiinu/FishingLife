package com.FishingLife.fishinglife.config;

import com.electronwill.nightconfig.core.file.FileConfig;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.loading.FMLPaths;

import java.io.File;

public class FishingLifeConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> is_fishinggame;
    public static final ForgeConfigSpec.ConfigValue<Boolean> compat_other_mod_fish;

    static {
        BUILDER.push("Configs for FishingLife");
        is_fishinggame = BUILDER.define("Enable fishing game?", true);
        compat_other_mod_fish = BUILDER.define("Enable mod fishing rod to get fishes in other mod? For example, Aquaculture 2", true);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
