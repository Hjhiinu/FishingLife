package com.FishingLife.fishinglife.util;

import com.FishingLife.fishinglife.fishinglife;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;


public class ModTags {
    public static class Items {

        public static final TagKey<Item> MODFISH = tag("modfish");
        public static final TagKey<Item> JUNGLE_FISHES = tag("jungle_fishes");

        public static final TagKey<Item> TEMPERATE_FISHES = tag("temperate_fishes");

        public static final TagKey<Item> CROPS = tag("crops");

        public static final TagKey<Item> FRUITS = tag("fruits");

        public static final TagKey<Item> DESERT_FISHES = tag("desert_fishes");

        public static final TagKey<Item> WARM_OCEAN_FISHES = tag("warm_ocean_fishes");

        public static final TagKey<Item> COLD_OCEAN_FISHES = tag("cold_ocean_fishes");

        public static final TagKey<Item> BIG_FISHES = tag("big_fishes");

        public static final TagKey<Item> MEDIUM_FISHES = tag("medium_fishes");

        public static final TagKey<Item> SMALL_FISHES = tag("small_fishes");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(fishinglife.MOD_ID, name));
        }
    }


}
