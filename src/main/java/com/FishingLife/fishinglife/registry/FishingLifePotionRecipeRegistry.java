package com.FishingLife.fishinglife.registry;

import com.FishingLife.fishinglife.Potion.ModBrewingRecipe;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

public class FishingLifePotionRecipeRegistry {

    public static void registerBrewingRecipes() {

        BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(
                PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.AWKWARD),
                new ItemStack(FishingLifeItemsRegistry.FISH_GILL.get()),
                PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER_BREATHING)
        ));

        BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(
                PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), Potions.AWKWARD),
                new ItemStack(FishingLifeItemsRegistry.FISH_GILL.get()),
                PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), Potions.WATER_BREATHING)
        ));

        BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(
                PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), Potions.AWKWARD),
                new ItemStack(FishingLifeItemsRegistry.FISH_GILL.get()),
                PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), Potions.WATER_BREATHING)
        ));
/*
        BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(
                PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), Potions.AWKWARD),
                new ItemStack(FishingLifeItemsRegistry.FISH_GILL.get()),
                PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), Potions.WATER_BREATHING)
        ));

 */
    }


}
