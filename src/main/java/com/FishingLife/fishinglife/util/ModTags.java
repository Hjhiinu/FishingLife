package com.FishingLife.fishinglife.util;

import com.FishingLife.fishinglife.fishinglife;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import static net.minecraft.tags.TagEntry.tag;


public class ModTags {
    public static class Items {

        public static final TagKey<Item> MODFISH = tag("modfish");
        public static final TagKey<Item> JUNGLE_FISHES = tag("jungle_fishes");

        public static final TagKey<Item> TEMPERATE_FISHES = tag("temperate_fishes");

        public static final TagKey<Item> CROPS = tag("crops");

        public static final TagKey<Item> FRUITS = tag("fruits");


        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(fishinglife.MOD_ID, name));
        }
    }


}
