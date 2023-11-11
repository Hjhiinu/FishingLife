package com.FishingLife.fishinglife.datagen;

import com.FishingLife.fishinglife.fishinglife;
import com.FishingLife.fishinglife.registry.FishingLifeBlocksRegistry;
import com.FishingLife.fishinglife.registry.FishingLifeItemsRegistry;
import com.FishingLife.fishinglife.util.ModTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {




    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }



    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, FishingLifeItemsRegistry.CREAM.get())
                .pattern("S")
                .pattern("W")
                .define('S', Items.SUGAR)
                .define('W', Items.MILK_BUCKET)
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .unlockedBy(getHasName(Items.MILK_BUCKET), has(Items.MILK_BUCKET))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, FishingLifeBlocksRegistry.FERMENTER.get())
                .pattern("SQS")
                .pattern("SXS")
                .pattern("WWW")
                .define('S', ItemTags.PLANKS)
                .define('W', ItemTags.STONE_TOOL_MATERIALS)
                .define('X', Items.BUCKET)
                .define('Q', Items.IRON_BARS)
                .unlockedBy("has_cobblestone", has(ItemTags.STONE_TOOL_MATERIALS))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, FishingLifeItemsRegistry.BRAISED_FISH.get())
                .pattern(" Q ")
                .pattern("WXS")
                .define('S', FishingLifeItemsRegistry.FISH_MEAT.get())
                .define('W', FishingLifeItemsRegistry.SCALLION.get())
                .define('X', FishingLifeItemsRegistry.SOY_SAUCE.get())
                .define('Q', Items.SUGAR)
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .unlockedBy(getHasName(FishingLifeItemsRegistry.FISH_MEAT.get()), has(FishingLifeItemsRegistry.FISH_MEAT.get()))
                .unlockedBy(getHasName(FishingLifeItemsRegistry.SCALLION.get()), has(FishingLifeItemsRegistry.SCALLION.get()))
                .unlockedBy(getHasName(FishingLifeItemsRegistry.SOY_SAUCE.get()), has(FishingLifeItemsRegistry.SOY_SAUCE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, FishingLifeItemsRegistry.MISO_GRILLED_FISH.get())
                .pattern(" Q ")
                .pattern("WXS")
                .define('S', FishingLifeItemsRegistry.FISH_MEAT.get())
                .define('W', FishingLifeItemsRegistry.SCALLION.get())
                .define('X', FishingLifeItemsRegistry.SOY_SAUCE.get())
                .define('Q', Items.SUGAR)
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .unlockedBy(getHasName(FishingLifeItemsRegistry.FISH_MEAT.get()), has(FishingLifeItemsRegistry.FISH_MEAT.get()))
                .unlockedBy(getHasName(FishingLifeItemsRegistry.SCALLION.get()), has(FishingLifeItemsRegistry.SCALLION.get()))
                .unlockedBy(getHasName(FishingLifeItemsRegistry.SOY_SAUCE.get()), has(FishingLifeItemsRegistry.SOY_SAUCE.get()))
                .save(pWriter);




    }



}
