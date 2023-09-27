package com.FishingLife.fishinglife.util;

import com.FishingLife.fishinglife.fishinglife;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;


public class ModTags {
    public static final TagKey<Item> JUNGLE_FISHES = modItemTag("jungle_fishes");

    private static TagKey<Item> modItemTag(String name) {
        return ItemTags.create(new ResourceLocation(fishinglife.MOD_ID,name));
    }

    //private static TagKey<Block> modBlockTag(String path) {
      //  return null;
    //}
}
