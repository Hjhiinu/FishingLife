package com.FishingLife.fishinglife.util;

import com.FishingLife.fishinglife.fishinglife;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BannerPatternTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.BannerPattern;


public class ModTags {
    public static class BannersPattern {
        public static final TagKey<BannerPattern> ANCHOR_PATTERN_TAG = tag("anchor_pattern_tag");
        public static final TagKey<BannerPattern> SHIP_PATTERN_TAG = tag("ship_pattern_tag");
        public static final TagKey<BannerPattern> SEASHELL_PATTERN_TAG = tag("seashell_pattern_tag");
        public static final TagKey<BannerPattern> PIRATE_PATTERN_TAG = tag("pirate_pattern_tag");
        private static TagKey<BannerPattern> tag(String name) {
            return ModTags.BannersPattern.create(name);
        }
        private static TagKey<BannerPattern> create(String pName) {
            return TagKey.create(Registries.BANNER_PATTERN, new ResourceLocation(pName));
        }
    }
    public static class Items {
        public static final TagKey <Item> COMPAT_FISH = tag("compat_fish");

        public static final TagKey<Item> MODFISH = tag("modfish");

        public static final TagKey<Item> RAW_MEAT  =tag("raw_meat");
        public static final TagKey<Item> JUNGLE_FISHES = tag("jungle_fishes");

        public static final TagKey<Item> TEMPERATE_FISHES = tag("temperate_fishes");

        public static final TagKey<Item> CROPS = tag("crops");

        public static final TagKey<Item> FRUITS = tag("fruits");

        public static final TagKey<Item> DESERT_FISHES = tag("desert_fishes");

        public static final TagKey<Item> GENERAL_OCEAN_FISHES = tag("general_ocean_fishes");

        public static final TagKey<Item> WARM_OCEAN_FISHES = tag("warm_ocean_fishes");

        public static final TagKey<Item> COLD_OCEAN_FISHES = tag("cold_ocean_fishes");

        public static final TagKey<Item> BIG_FISHES = tag("big_fishes");

        public static final TagKey<Item> MEDIUM_FISHES = tag("medium_fishes");

        public static final TagKey<Item> SMALL_FISHES = tag("small_fishes");

        public static final TagKey<Item> CRAB=tag("crab");

        public static final TagKey<Item> SEA_URCHIN=tag("sea_urchin");

        public static final TagKey<Item> SHRIMP=tag("shrimp");

        public static final TagKey<Item> FISHING_TRASH = tag("fishing_trash");

        public static final TagKey<Item> CAVE_FISHES = tag("cave_fishes");

        public static final TagKey<Item> SWAMP_FISHES = tag("swamp_fishes");

        public static final TagKey<Item> MUSHROOM_ISLAND_FISHES = tag("mushroom_island_fishes");

        public static final TagKey<Item> FISH_PROCESSING_KNIFE = tag("fish_processing_knife");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(fishinglife.MOD_ID, name));
        }
    }


}
