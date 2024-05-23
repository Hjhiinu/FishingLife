package com.FishingLife.fishinglife.registry;


import com.FishingLife.fishinglife.fishinglife;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


@Mod.EventBusSubscriber(modid = fishinglife.MOD_ID)
public class ModFishLoot {

    public static final ResourceLocation FISHING_NET = register("fishing_machine/fishing_net");

    public static final ResourceLocation FISHING_TRASH = register("fishing_machine/fishing_trash");
    public static final ResourceLocation FISHINGLIFE_JUNK = register("gameplay/fishing/fishinglife_junk");
    public static final ResourceLocation FISHINGLIFE_TREASURE = register("gameplay/fishing/fishinglife_treasure");
    public static final ResourceLocation DESERT_FISH = register("gameplay/fishing/desert_fish");

    public static final ResourceLocation JUNGLE_FISH_BASIC = register("gameplay/fishing/jungle_fish_basic");

    public static final ResourceLocation JUNGLE_FISH_ADVANCED = register("gameplay/fishing/jungle_fish_advanced");

    public static final ResourceLocation GENERAL_RIVER_FISH_BASIC = register("gameplay/fishing/general_river_fish_basic");

    public static final ResourceLocation GENERAL_RIVER_FISH_ADVANCED = register("gameplay/fishing/general_river_fish_advanced");

    public static final ResourceLocation GENERAL_OCEAN_FISH = register("gameplay/fishing/general_ocean_fish");

    public static final ResourceLocation WARM_OCEAN_FISH = register("gameplay/fishing/warm_ocean_fish");

    public static final ResourceLocation COLD_OCEAN_FISH = register("gameplay/fishing/cold_ocean_fish");

    public static final ResourceLocation MUSHROOM_FIELD_FISH = register("gameplay/fishing/mushroom_field_fish");

    public static final ResourceLocation SWAMP_FISH = register("gameplay/fishing/swamp_fish");

    public static final ResourceLocation UNDERGROUND_FISH = register("gameplay/fishing/underground_fish");

    public static final ResourceLocation PROFESSIONAL_FISHINGROD_FISHING = register("gameplay/fishing/professional_fishing_rod/professional_fishingrod_fishing");

    public static final ResourceLocation ELITE_FISHINGROD_FISHING = register("gameplay/fishing/elite_fishing_rod/elite_fishingrod_fishing");

    public static final ResourceLocation MASTER_FISHINGROD_FISHING = register("gameplay/fishing/master_fishing_rod/master_fishingrod_fishing");

    public static final ResourceLocation MASTER_FISH = register("gameplay/fishing/master_fishing_rod/master_fish");

    public static final ResourceLocation ELITE_FISH = register("gameplay/fishing/elite_fishing_rod/elite_fish");

    public static final ResourceLocation PROFESSIONAL_FISH = register("gameplay/fishing/professional_fishing_rod/professional_fish");
    private static ResourceLocation register(String path) {
        return BuiltInLootTables.register(new ResourceLocation(fishinglife.MOD_ID, path));
    }
}


















