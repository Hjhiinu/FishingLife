package com.FishingLife.fishinglife.registry;

import net.minecraft.world.food.FoodProperties;

public class    FishingLifeFoodsRegistry {
    public static final FoodProperties RAW_FISH = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).meat().build();
    public static final FoodProperties CROPS = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.6F).build();

    public static final FoodProperties COMMON_DISHES = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.8F).build();
}