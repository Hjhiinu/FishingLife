package com.FishingLife.fishinglife.compat.JEI;

import com.FishingLife.fishinglife.Modrecipe.FishingMachineRecipe;
import com.FishingLife.fishinglife.fishinglife;
import com.FishingLife.fishinglife.registry.FishingLifeBlocksRegistry;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class FishingMachineCategory implements IRecipeCategory<FishingMachineRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(fishinglife.MOD_ID, "machine_fishing");
    public static final ResourceLocation TEXTURE = new ResourceLocation(fishinglife.MOD_ID,
            "textures/gui/fishingmachine_gui.png");

    public static final RecipeType<FishingMachineRecipe> FISHING_MACHINE_RECIPE_TYPE =
            new RecipeType<>(UID, FishingMachineRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public FishingMachineCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(FishingLifeBlocksRegistry.FISHINGMACHINE.get()));
    }

    @Override
    public RecipeType<FishingMachineRecipe> getRecipeType() {
        return FISHING_MACHINE_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.fishinglife.fishingmachine");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, FishingMachineRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 33, 11).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 80, 11).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT, 127, 11).addIngredients(recipe.getIngredients().get(2));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 80, 59).addItemStack(recipe.getResultItem(null));
    }
}
