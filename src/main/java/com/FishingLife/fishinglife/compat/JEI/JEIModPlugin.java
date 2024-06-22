package com.FishingLife.fishinglife.compat.JEI;

import com.FishingLife.fishinglife.GUIscreen.FermenterScreen;
import com.FishingLife.fishinglife.GUIscreen.FishingMachineScreen;
import com.FishingLife.fishinglife.Modrecipe.FermenterRecipe;
import com.FishingLife.fishinglife.Modrecipe.FishingMachineRecipe;
import com.FishingLife.fishinglife.fishinglife;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

@JeiPlugin
public class JEIModPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(fishinglife.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new FishingMachineCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new FermenterCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<FishingMachineRecipe> fishingMachineRecipes = recipeManager.getAllRecipesFor(FishingMachineRecipe.Type.INSTANCE);
        registration.addRecipes(FishingMachineCategory.FISHING_MACHINE_RECIPE_TYPE, fishingMachineRecipes);

        List<FermenterRecipe> fermenterRecipes = recipeManager.getAllRecipesFor(FermenterRecipe.Type.INSTANCE);
        registration.addRecipes(FermenterCategory.FERMENTER_RECIPE_TYPE, fermenterRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(FishingMachineScreen.class, 60, 30, 20, 30,
                FishingMachineCategory.FISHING_MACHINE_RECIPE_TYPE);

        registration.addRecipeClickArea(FermenterScreen.class, 60, 30, 20, 30,
                FermenterCategory.FERMENTER_RECIPE_TYPE);
    }
}
