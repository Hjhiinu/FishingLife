package com.FishingLife.fishinglife.compat.JEI;

import com.FishingLife.fishinglife.Modrecipe.FermenterRecipe;
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

public class FermenterCategory implements IRecipeCategory<FermenterRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(fishinglife.MOD_ID, "fermenting");
    public static final ResourceLocation TEXTURE = new ResourceLocation(fishinglife.MOD_ID,
            "textures/gui/fermenter_gui.png");

    public static final RecipeType<FermenterRecipe> FERMENTER_RECIPE_TYPE =
            new RecipeType<>(UID, FermenterRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public FermenterCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(FishingLifeBlocksRegistry.FERMENTER.get()));
    }

    @Override
    public RecipeType<FermenterRecipe> getRecipeType() {
        return FERMENTER_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.fishinglife.fermenter");
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
    public void setRecipe(IRecipeLayoutBuilder builder, FermenterRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 61, 11).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 100, 11).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 80, 59).addItemStack(recipe.getResultItem(null));
    }
}