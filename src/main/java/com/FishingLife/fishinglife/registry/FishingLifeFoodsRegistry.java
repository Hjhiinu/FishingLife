package com.FishingLife.fishinglife.registry;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class    FishingLifeFoodsRegistry {
    public static final FoodProperties RAW_FISH = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).meat().build();
    public static final FoodProperties CROPS = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.6F).build();
    public static final FoodProperties PEPPER_SHAKE=(new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE,40,0),1.0F).alwaysEat().build();
    public static final FoodProperties GENERAL_DISHES = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.6F).build();
    public static final FoodProperties COMMON_DISHES = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.8F).build();
}