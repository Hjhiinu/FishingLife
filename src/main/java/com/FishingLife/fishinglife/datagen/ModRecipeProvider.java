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

        //Shaped

        //Fishing Rod
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, FishingLifeItemsRegistry.PROFESSIONAL_FISHING_ROD.get())
                .pattern("K")
                .pattern("S")
                .pattern("W")
                .define('S', Items.FISHING_ROD)
                .define('W', Items.SALMON)
                .define('K', Items.COD)
                .unlockedBy(getHasName(Items.FISHING_ROD), has(Items.FISHING_ROD))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, FishingLifeItemsRegistry.ELITE_FISHING_ROD.get())
                .pattern(" K ")
                .pattern("QSQ")
                .pattern("W D")
                .define('S', FishingLifeItemsRegistry.PROFESSIONAL_FISHING_ROD.get())
                .define('W', FishingLifeItemsRegistry.TEMPERATEFISH_COLLECTION.get())
                .define('K', FishingLifeItemsRegistry.DESERTFISH_COLLECTION.get())
                .define('D', FishingLifeItemsRegistry.JUNGLEFISH_COLLECTION.get())
                .define('Q', Items.IRON_BARS)
                .unlockedBy(getHasName(FishingLifeItemsRegistry.PROFESSIONAL_FISHING_ROD.get()), has(FishingLifeItemsRegistry.PROFESSIONAL_FISHING_ROD.get()))
                .save(pWriter);



        //Materials
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, FishingLifeItemsRegistry.CREAM.get())
                .pattern("S")
                .pattern("W")
                .define('S', Items.SUGAR)
                .define('W', Items.MILK_BUCKET)
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .unlockedBy(getHasName(Items.MILK_BUCKET), has(Items.MILK_BUCKET))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, FishingLifeItemsRegistry.REINFORCED_PLASTIC.get())
                .pattern("S S")
                .pattern(" W ")
                .pattern(" Q ")
                .define('S', FishingLifeItemsRegistry.PLASTIC_TRASH.get())
                .define('W', Items.QUARTZ)
                .define('Q', Items.SAND)
                .unlockedBy(getHasName(FishingLifeItemsRegistry.PLASTIC_TRASH.get()), has(FishingLifeItemsRegistry.PLASTIC_TRASH.get()))
                .save(pWriter);




        //Blocks
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
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, FishingLifeBlocksRegistry.GENERAL_FISHERMAN_WORKBENCH.get())
                .pattern("QQQ")
                .pattern("SXS")
                .pattern("RRR")
                .define('X',  ModTags.Items.TEMPERATE_FISHES)
                .define('S',Items.IRON_BARS)
                .define('Q',ItemTags.STONE_TOOL_MATERIALS)
                .define('R',ItemTags.PLANKS)
                .unlockedBy("has_cobblestone", has(ItemTags.STONE_TOOL_MATERIALS))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, FishingLifeBlocksRegistry.DESERT_FISHERMAN_WORKBENCH.get())
                .pattern("QQQ")
                .pattern("SXS")
                .pattern("RRR")
                .define('X',  ModTags.Items.DESERT_FISHES)
                .define('S',Items.IRON_BARS)
                .define('Q',ItemTags.STONE_TOOL_MATERIALS)
                .define('R',ItemTags.PLANKS)
                .unlockedBy("has_cobblestone", has(ItemTags.STONE_TOOL_MATERIALS))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, FishingLifeBlocksRegistry.JUNGLE_FISHERMAN_WORKBENCH.get())
                .pattern("QQQ")
                .pattern("SXS")
                .pattern("RRR")
                .define('X',  ModTags.Items.JUNGLE_FISHES)
                .define('S',Items.IRON_BARS)
                .define('Q',ItemTags.STONE_TOOL_MATERIALS)
                .define('R',ItemTags.PLANKS)
                .unlockedBy("has_cobblestone", has(ItemTags.STONE_TOOL_MATERIALS))
                .save(pWriter);
        //Food

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

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, FishingLifeItemsRegistry.FISH_OMELETTE.get())
                .pattern(" Q ")
                .pattern("SXS")
                .define('X',  FishingLifeItemsRegistry.FISH_MEAT.get())
                .define('S',Items.EGG)
                .define('Q',FishingLifeItemsRegistry.GREEN_PEPPER.get())
                .unlockedBy(getHasName(Items.EGG), has(Items.EGG))
                .unlockedBy(getHasName(FishingLifeItemsRegistry.FISH_MEAT.get()), has(FishingLifeItemsRegistry.FISH_MEAT.get()))
                .unlockedBy(getHasName(FishingLifeItemsRegistry.GREEN_PEPPER.get()), has(FishingLifeItemsRegistry.GREEN_PEPPER.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, FishingLifeItemsRegistry.SWEET_AND_SOUR_FISH_SLICES.get())
                .pattern(" Q ")
                .pattern("WXS")
                .define('X',  FishingLifeItemsRegistry.FISH_MEAT.get())
                .define('S',Items.SUGAR)
                .define('Q',FishingLifeItemsRegistry.VINEGAR.get())
                .define('W', FishingLifeItemsRegistry.SCALLION.get())
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .unlockedBy(getHasName(FishingLifeItemsRegistry.FISH_MEAT.get()), has(FishingLifeItemsRegistry.FISH_MEAT.get()))
                .unlockedBy(getHasName(FishingLifeItemsRegistry.SCALLION.get()), has(FishingLifeItemsRegistry.SCALLION.get()))
                .unlockedBy(getHasName(FishingLifeItemsRegistry.VINEGAR.get()), has(FishingLifeItemsRegistry.VINEGAR.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, FishingLifeItemsRegistry.PEPPER_SHAKE.get())

                .pattern("WXS")
                .pattern(" Q ")
                .define('X',  FishingLifeItemsRegistry.GREEN_PEPPER.get())
                .define('S',FishingLifeItemsRegistry.CHILI_PEPPER.get())
                .define('Q',Items.BOWL)
                .define('W', FishingLifeItemsRegistry.CREAM.get())
                .unlockedBy(getHasName(Items.BOWL), has(Items.BOWL))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, FishingLifeItemsRegistry.FISH_SANDWICH.get())

                .pattern("WXS")
                .pattern(" Q ")
                .define('X',  Items.BREAD)
                .define('S',FishingLifeItemsRegistry.CHILI_PEPPER.get())
                .define('Q',FishingLifeItemsRegistry.GREEN_PEPPER.get())
                .define('W',FishingLifeItemsRegistry.FISH_MEAT.get())
                .unlockedBy(getHasName(Items.BREAD), has(Items.BREAD))
                .unlockedBy(getHasName(FishingLifeItemsRegistry.FISH_MEAT.get()), has(FishingLifeItemsRegistry.FISH_MEAT.get()))
                .unlockedBy(getHasName(FishingLifeItemsRegistry.GREEN_PEPPER.get()), has(FishingLifeItemsRegistry.GREEN_PEPPER.get()))
                .unlockedBy(getHasName(FishingLifeItemsRegistry.CHILI_PEPPER.get()), has(FishingLifeItemsRegistry.CHILI_PEPPER.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, FishingLifeItemsRegistry.FISH_SUSHI.get())
                .pattern(" QQ")
                .pattern(" XX")

                .define('X', FishingLifeItemsRegistry.PADDY.get())
                .define('Q',FishingLifeItemsRegistry.FISH_MEAT.get())

                .unlockedBy(getHasName(FishingLifeItemsRegistry.FISH_MEAT.get()), has(FishingLifeItemsRegistry.FISH_MEAT.get()))
                .unlockedBy(getHasName(FishingLifeItemsRegistry.PADDY.get()), has(FishingLifeItemsRegistry.PADDY.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, FishingLifeItemsRegistry.FISH_RICE_ROLL.get())
                .pattern(" Q ")
                .pattern("WXS")
                .pattern(" X ")
                .define('X',  Items.KELP)
                .define('S',FishingLifeItemsRegistry.CHILI_PEPPER.get())
                .define('Q',FishingLifeItemsRegistry.PADDY.get())
                .define('W',FishingLifeItemsRegistry.FISH_MEAT.get())
                .unlockedBy(getHasName(Items.KELP), has(Items.KELP))
                .unlockedBy(getHasName(FishingLifeItemsRegistry.FISH_MEAT.get()), has(FishingLifeItemsRegistry.FISH_MEAT.get()))
                .unlockedBy(getHasName(FishingLifeItemsRegistry.PADDY.get()), has(FishingLifeItemsRegistry.PADDY.get()))
                .unlockedBy(getHasName(FishingLifeItemsRegistry.CHILI_PEPPER.get()), has(FishingLifeItemsRegistry.CHILI_PEPPER.get()))
                .save(pWriter);








        //Shapeless
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, FishingLifeItemsRegistry.POTATO_STRIPS.get(), 4)
                .requires(Items.POTATO)
                .unlockedBy(getHasName(Items.POTATO), has(Items.POTATO))
                .save(pWriter);



        /*


        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, FishingLifeItemsRegistry.FISH_MEAT.get(), 1)
                .requires(ModTags.Items.SMALL_FISHES)

                .save(pWriter);

         */




    }



}
