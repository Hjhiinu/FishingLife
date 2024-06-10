package com.FishingLife.fishinglife.Potion;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import org.jetbrains.annotations.NotNull;

public class ModBrewingRecipe implements IBrewingRecipe {
    private final ItemStack input;
    private final ItemStack ingredient;
    private final ItemStack output;

    public ModBrewingRecipe(ItemStack input, ItemStack ingredient, ItemStack output) {
        this.input = input;
        this.ingredient = ingredient;
        this.output = output;
    }

    @Override
    public boolean isInput(ItemStack input) {
        return ItemStack.matches(this.input, input);
    }

    @Override
    public boolean isIngredient(ItemStack ingredient) {
        return ItemStack.isSameItem(this.ingredient, ingredient);
    }

    @Override
    public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
        if (!isInput(input) || !isIngredient(ingredient)) {
            return ItemStack.EMPTY;
        }
        return this.output.copy();
    }
}
