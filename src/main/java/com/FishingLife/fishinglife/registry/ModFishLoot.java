package com.FishingLife.fishinglife.registry;

import com.teammetallurgy.aquaculture.misc.AquaConfig;
import com.FishingLife.fishinglife.fishinglife;
import com.teammetallurgy.aquaculture.Aquaculture;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.FishingHookPredicate;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static com.teammetallurgy.aquaculture.init.AquaLootTables.*;


@Mod.EventBusSubscriber(modid = fishinglife.MOD_ID)
public class ModFishLoot {
    public static final ResourceLocation COMPAT_FISHINGLIFE_JUNK = register("gameplay/compat_fishing/compat_junk");

    public static final ResourceLocation COMPAT_FISHINGLIFE_FISH = register("gameplay/compat_fishing/compat_fish");

    public static final ResourceLocation COMPAT_FISHINGLIFE_TREASURE = register("gameplay/compat_fishing/compat_treasure");

    public static final ResourceLocation COMPAT_FISHING = register("gameplay/compat_fishing/fishing");
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
    @SubscribeEvent
    public static void onLootTableLoad(LootTableLoadEvent event) {
        if(ModList.get().isLoaded("aquaculture")) {
            ResourceLocation name = event.getName();
            LootPool pool = event.getTable().getPool("main");
            if (name.equals(COMPAT_FISHINGLIFE_FISH)) {
                if (pool != null) {
                    addEntry(pool, getInjectEntry(FISH, 1, 0));
                }
            }
            else if(name.equals(COMPAT_FISHINGLIFE_JUNK)){
                if (pool != null) {
                    addEntry(pool, getInjectEntry(JUNK, 1, 0));
                }
            }
            else {
                if (pool != null) {
                    if (AquaConfig.NEPTUNIUM_OPTIONS.addNeptunesBountyToLoot.get()) {
                        LootPoolEntryContainer neptuniumEntry = LootTableReference.lootTableReference(NEPTUNIUM).setWeight(1).setQuality(2).when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, EntityPredicate.Builder.entity().subPredicate(FishingHookPredicate.inOpenWater(true)))).build();
                        addEntry(pool, neptuniumEntry);
                    }
                }
            }
        }

    }

    private static LootPoolEntryContainer getInjectEntry(ResourceLocation location, int weight, int quality) {
        return LootTableReference.lootTableReference(location).setWeight(weight).setQuality(quality).build();
    }

    private static void addEntry(LootPool pool, LootPoolEntryContainer entry) {
        try {
            Field entries = ObfuscationReflectionHelper.findField(LootPool.class, "f_79023_");
            entries.setAccessible(true);

            LootPoolEntryContainer[] lootPoolEntriesArray = (LootPoolEntryContainer[]) entries.get(pool);
            ArrayList<LootPoolEntryContainer> newLootEntries = new ArrayList<>(List.of(lootPoolEntriesArray));

            if (newLootEntries.stream().anyMatch(e -> e == entry)) {
                throw new RuntimeException("Attempted to add a duplicate entry to pool: " + entry);
            }

            newLootEntries.add(entry);

            LootPoolEntryContainer[] newLootEntriesArray = new LootPoolEntryContainer[newLootEntries.size()];
            newLootEntries.toArray(newLootEntriesArray);
            entries.set(pool, newLootEntriesArray);
        } catch (IllegalAccessException e) {
            Aquaculture.LOG.error("Error occurred when attempting to add a new entry, to the fishing loot table");
            e.printStackTrace();
        }
    }
}


















