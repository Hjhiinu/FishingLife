package com.FishingLife.fishinglife.registry;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class    FishingLifeFoodsRegistry {
    public static final FoodProperties RAW_FISH = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).effect(new MobEffectInstance(MobEffects.CONFUSION,60,0),1.0F).meat().build();
    public static final FoodProperties RAW_FOOD_OTHER_THAN_FISH = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).meat().build();
    public static final FoodProperties CROPS = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.6F).build();
    public static final FoodProperties PEPPER_SHAKE=(new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE,40,0),1.0F).alwaysEat().build();
    public static final FoodProperties Fish_sushi = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.8F).build();
    public static final FoodProperties Fish_sandwich = (new FoodProperties.Builder()).nutrition(10).saturationMod(0.8F).build();
    public static final FoodProperties Fish_rice_roll = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.8F).build();
    public static final FoodProperties Miso_grilled_fish = (new FoodProperties.Builder()).nutrition(10).saturationMod(0.7F).build();
    public static final FoodProperties Fish_omelette = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.6F).build();
    public static final FoodProperties Sweet_and_sour_fish_slices = (new FoodProperties.Builder()).nutrition(9).saturationMod(0.9F).build();
    public static final FoodProperties Braised_fish = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.7F).build();
    public static final FoodProperties Stir_fried_bamboo_shoots_with_pickled_vegetables= (new FoodProperties.Builder()).nutrition(8).saturationMod(0.7F).build();
    public static final FoodProperties Stir_fried_pork_with_pickled_vegetables= (new FoodProperties.Builder()).nutrition(10).saturationMod(0.8F).build();
    public static final FoodProperties Crispy_creamy_caviar_fish_roll= (new FoodProperties.Builder()).nutrition(11).saturationMod(0.8F).build();
    public static final FoodProperties Pickled_vegetables= (new FoodProperties.Builder()).nutrition(3).saturationMod(0.1F).build();
    public static final FoodProperties Fried_shrimp_and_seaweed_rice_bowl= (new FoodProperties.Builder()).nutrition(12).saturationMod(0.9F).build();

    public static final FoodProperties Sea_urchin_vegetable_rice_bowl= (new FoodProperties.Builder()).nutrition(10).saturationMod(0.7F).build();

    public static final FoodProperties Sea_urchin_sushi= (new FoodProperties.Builder()).nutrition(7).saturationMod(0.8F).build();

    public static final FoodProperties Boiled_shrimp_with_greens= (new FoodProperties.Builder()).nutrition(9).saturationMod(0.8F).build();
    public static final FoodProperties Scrambled_eggs_with_shrimp= (new FoodProperties.Builder()).nutrition(9).saturationMod(0.9F).build();
    public static final FoodProperties Fried_egg_with_bacon= (new FoodProperties.Builder()).nutrition(9).saturationMod(0.7F).build();
    public static final FoodProperties Creamy_baked_mushroom_stuffed_bread_with_caviar= (new FoodProperties.Builder()).nutrition(13).saturationMod(1.2F).build();
    public static final FoodProperties Fried_fish_fins= (new FoodProperties.Builder()).nutrition(7).saturationMod(0.6F).build();
    public static final FoodProperties Steamed_fish_fins_with_vegetables= (new FoodProperties.Builder()).nutrition(8).saturationMod(0.7F).build();










}