package com.FishingLife.fishinglife.datagen;

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
import net.minecraft.world.item.crafting.RecipeSerializer;
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
        //Armor
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, Items.CHAINMAIL_HELMET)
                .pattern("KKK")
                .pattern("K K")
                .define('K', FishingLifeItemsRegistry.CHAINMAIL_PIECE.get())
                .unlockedBy(getHasName(FishingLifeItemsRegistry.CHAINMAIL_PIECE.get()), has(FishingLifeItemsRegistry.CHAINMAIL_PIECE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, Items.CHAINMAIL_BOOTS)
                .pattern("K K")
                .pattern("K K")
                .define('K', FishingLifeItemsRegistry.CHAINMAIL_PIECE.get())
                .unlockedBy(getHasName(FishingLifeItemsRegistry.CHAINMAIL_PIECE.get()), has(FishingLifeItemsRegistry.CHAINMAIL_PIECE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, Items.CHAINMAIL_LEGGINGS)
                .pattern("KKK")
                .pattern("K K")
                .pattern("K K")
                .define('K', FishingLifeItemsRegistry.CHAINMAIL_PIECE.get())
                .unlockedBy(getHasName(FishingLifeItemsRegistry.CHAINMAIL_PIECE.get()), has(FishingLifeItemsRegistry.CHAINMAIL_PIECE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, Items.CHAINMAIL_CHESTPLATE)
                .pattern("K K")
                .pattern("KKK")
                .pattern("KKK")
                .define('K', FishingLifeItemsRegistry.CHAINMAIL_PIECE.get())
                .unlockedBy(getHasName(FishingLifeItemsRegistry.CHAINMAIL_PIECE.get()), has(FishingLifeItemsRegistry.CHAINMAIL_PIECE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, FishingLifeItemsRegistry.SCALE_HELMET.get())
                .pattern("KKK")
                .pattern("K K")
                .define('K', FishingLifeItemsRegistry.FISH_GILL.get())
                .unlockedBy(getHasName(FishingLifeItemsRegistry.FISH_GILL.get()), has(FishingLifeItemsRegistry.FISH_GILL.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, FishingLifeItemsRegistry.SCALE_BOOTS.get())
                .pattern("K K")
                .pattern("K K")
                .define('K', FishingLifeItemsRegistry.FISH_GILL.get())
                .unlockedBy(getHasName(FishingLifeItemsRegistry.FISH_GILL.get()), has(FishingLifeItemsRegistry.FISH_GILL.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, FishingLifeItemsRegistry.SCALE_LEGGINGS.get())
                .pattern("KKK")
                .pattern("K K")
                .pattern("K K")
                .define('K', FishingLifeItemsRegistry.FISH_GILL.get())
                .unlockedBy(getHasName(FishingLifeItemsRegistry.FISH_GILL.get()), has(FishingLifeItemsRegistry.FISH_GILL.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, FishingLifeItemsRegistry.SCALE_CHESTPLATE.get())
                .pattern("K K")
                .pattern("KKK")
                .pattern("KKK")
                .define('K', FishingLifeItemsRegistry.FISH_GILL.get())
                .unlockedBy(getHasName(FishingLifeItemsRegistry.FISH_GILL.get()), has(FishingLifeItemsRegistry.FISH_GILL.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, FishingLifeItemsRegistry.ADVANCED_TURTLE_SHELL.get())
                .pattern(" W ")
                .pattern("QKQ")
                .define('Q', FishingLifeItemsRegistry.FISH_GILL.get())
                .define('K', Items.TURTLE_HELMET)
                .define('W', FishingLifeItemsRegistry.REINFORCED_PLASTIC.get())
                .unlockedBy(getHasName(FishingLifeItemsRegistry.FISH_GILL.get()), has(FishingLifeItemsRegistry.FISH_GILL.get()))
                .unlockedBy(getHasName(FishingLifeItemsRegistry.REINFORCED_PLASTIC.get()), has(FishingLifeItemsRegistry.REINFORCED_PLASTIC.get()))
                .unlockedBy(getHasName(Items.TURTLE_HELMET), has(Items.TURTLE_HELMET))
                .save(pWriter);

        //Fishing net
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, FishingLifeItemsRegistry.SMALL_FISHING_NET.get())
                .pattern(" K ")
                .pattern("KSK")
                .pattern(" K ")
                .define('S', Items.SLIME_BALL)
                .define('K', Items.STRING)
                .unlockedBy(getHasName(Items.STRING), has(Items.STRING))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, FishingLifeItemsRegistry.MEDIUM_FISHING_NET.get())
                .pattern("SK ")
                .pattern("KWK")
                .pattern(" KS")
                .define('S', Items.SLIME_BALL)
                .define('K', Items.STRING)
                .define('W', FishingLifeItemsRegistry.SMALL_FISHING_NET.get())
                .unlockedBy(getHasName(Items.STRING), has(Items.STRING))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, FishingLifeItemsRegistry.LARGE_FISHING_NET.get())
                .pattern("SYS")
                .pattern("KWK")
                .pattern("SYS")
                .define('S', Items.IRON_BARS)
                .define('K', Items.COBWEB)
                .define('W', FishingLifeItemsRegistry.MEDIUM_FISHING_NET.get())
                .define('Y', FishingLifeItemsRegistry.REINFORCED_PLASTIC.get())
                .unlockedBy(getHasName(Items.STRING), has(Items.STRING))
                .save(pWriter);
        //Baits
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, FishingLifeItemsRegistry.ULTIMATE_BAITS.get())
                .pattern(" Y ")
                .pattern("KWK")
                .pattern(" Y ")
                .define('K', ModTags.Items.RAW_MEAT)
                .define('W', FishingLifeItemsRegistry.SEDUCTIVE_HAZARD_ZEST.get())
                .define('Y', Items.COCOA_BEANS)
                .unlockedBy("has_raw_meat", has(ModTags.Items.RAW_MEAT))
                .save(pWriter);
        //SEDUCTIVE_HAZARD_ZEST
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, FishingLifeItemsRegistry.SEDUCTIVE_HAZARD_ZEST.get())
                .pattern("KYK")
                .pattern(" W ")
                .pattern("SYS")
                .define('K', Items.CHORUS_FLOWER)
                .define('W', Items.WITHER_ROSE)
                .define('Y', Items.SHROOMLIGHT)
                .define('S',Items.SPORE_BLOSSOM)
                .unlockedBy(getHasName(Items.SHROOMLIGHT), has(Items.SHROOMLIGHT))
                .save(pWriter);

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

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, FishingLifeItemsRegistry.MASTER_FISHING_ROD.get())
                .pattern("AKA")
                .pattern("QSQ")
                .pattern("WDP")
                .define('S', FishingLifeItemsRegistry.ELITE_FISHING_ROD.get())
                .define('W', Items.CRIMSON_FUNGUS)
                .define('P', Items.WARPED_FUNGUS)
                .define('K', Items.AMETHYST_SHARD)
                .define('D', Items.LAVA_BUCKET)
                .define('A', FishingLifeItemsRegistry.REINFORCED_PLASTIC.get())
                .define('Q', Items.NETHERITE_SCRAP)
                .unlockedBy(getHasName(FishingLifeItemsRegistry.ELITE_FISHING_ROD.get()), has(FishingLifeItemsRegistry.ELITE_FISHING_ROD.get()))
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
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, FishingLifeItemsRegistry.CHAINMAIL_PIECE.get())
                .pattern("SWS")
                .define('S', Items.IRON_NUGGET)
                .define('W', FishingLifeItemsRegistry.FISH_SCALE.get())
                .unlockedBy(getHasName(Items.IRON_NUGGET), has(Items.IRON_NUGGET))
                .unlockedBy(getHasName(FishingLifeItemsRegistry.FISH_SCALE.get()), has(FishingLifeItemsRegistry.FISH_SCALE.get()))
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
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, FishingLifeBlocksRegistry.GENERAL_FISHERMAN_WORKBENCH.get())
                .pattern("QQQ")
                .pattern("SXS")
                .pattern("RRR")
                .define('X',  FishingLifeItemsRegistry.TEMPERATEFISH_COLLECTION.get())
                .define('S',Items.IRON_BARS)
                .define('Q',ItemTags.STONE_TOOL_MATERIALS)
                .define('R',ItemTags.PLANKS)
                .unlockedBy("has_cobblestone", has(ItemTags.STONE_TOOL_MATERIALS))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, FishingLifeBlocksRegistry.DESERT_FISHERMAN_WORKBENCH.get())
                .pattern("QQQ")
                .pattern("SXS")
                .pattern("RRR")
                .define('X',  FishingLifeItemsRegistry.DESERTFISH_COLLECTION.get())
                .define('S',Items.IRON_BARS)
                .define('Q',ItemTags.STONE_TOOL_MATERIALS)
                .define('R',ItemTags.PLANKS)
                .unlockedBy("has_cobblestone", has(ItemTags.STONE_TOOL_MATERIALS))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, FishingLifeBlocksRegistry.JUNGLE_FISHERMAN_WORKBENCH.get())
                .pattern("QQQ")
                .pattern("SXS")
                .pattern("RRR")
                .define('X',  FishingLifeItemsRegistry.JUNGLEFISH_COLLECTION.get())
                .define('S',Items.IRON_BARS)
                .define('Q',ItemTags.STONE_TOOL_MATERIALS)
                .define('R',ItemTags.PLANKS)
                .unlockedBy("has_cobblestone", has(ItemTags.STONE_TOOL_MATERIALS))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, FishingLifeBlocksRegistry.OCEAN_FISHERMAN_WORKBENCH.get())
                .pattern("QQQ")
                .pattern("SXS")
                .pattern("RRR")
                .define('X',  FishingLifeItemsRegistry.OCEAN_COLLECTION.get())
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

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, FishingLifeItemsRegistry.ARISQUEDO_GOLD_COIN.get(), 1)
                .requires(FishingLifeItemsRegistry.ARISQUEDO_COIN.get())
                .requires(FishingLifeItemsRegistry.ARISQUEDO_COIN.get())
                .requires(FishingLifeItemsRegistry.ARISQUEDO_COIN.get())
                .requires(FishingLifeItemsRegistry.ARISQUEDO_COIN.get())
                .requires(FishingLifeItemsRegistry.ARISQUEDO_COIN.get())
                .requires(FishingLifeItemsRegistry.ARISQUEDO_COIN.get())
                .requires(FishingLifeItemsRegistry.ARISQUEDO_COIN.get())
                .requires(FishingLifeItemsRegistry.ARISQUEDO_COIN.get())
                .requires(FishingLifeItemsRegistry.ARISQUEDO_COIN.get())

                .unlockedBy(getHasName(FishingLifeItemsRegistry.ARISQUEDO_COIN.get()), has(FishingLifeItemsRegistry.ARISQUEDO_COIN.get()))
                .save(pWriter);
        //Bait
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, FishingLifeItemsRegistry.BASIC_BAITS.get(), 2)
                .requires(ModTags.Items.RAW_MEAT)
                .unlockedBy("has_raw_meat", has(ModTags.Items.RAW_MEAT))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, FishingLifeItemsRegistry.ADVANCED_BAITS.get(), 2)
                .requires(ModTags.Items.RAW_MEAT)
                .requires(ModTags.Items.RAW_MEAT)
                .unlockedBy("has_raw_meat", has(ModTags.Items.RAW_MEAT))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, FishingLifeItemsRegistry.PREMIUM_BAITS.get(), 2)
                .requires(ModTags.Items.RAW_MEAT)
                .requires(Items.COCOA_BEANS)
                .requires(ModTags.Items.RAW_MEAT)
                .unlockedBy("has_raw_meat", has(ModTags.Items.RAW_MEAT))
                .save(pWriter);
        //Collection
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, FishingLifeItemsRegistry.OCEAN_COLLECTION.get())
                .requires(Items.HORN_CORAL)
                .requires(Items.FIRE_CORAL)
                .requires(Items.TUBE_CORAL)
                .requires(Items.BRAIN_CORAL)
                .requires(Items.BUBBLE_CORAL)
                .requires(ModTags.Items.COLD_OCEAN_FISHES)
                .requires(ModTags.Items.WARM_OCEAN_FISHES)
                .requires(ModTags.Items.GENERAL_OCEAN_FISHES)
                .unlockedBy(getHasName(Items.HORN_CORAL), has(Items.HORN_CORAL))
                .unlockedBy(getHasName(Items.FIRE_CORAL), has(Items.FIRE_CORAL))
                .unlockedBy(getHasName(Items.TUBE_CORAL), has(Items.TUBE_CORAL))
                .unlockedBy(getHasName(Items.BRAIN_CORAL), has(Items.BRAIN_CORAL))
                .unlockedBy(getHasName(Items.BUBBLE_CORAL), has(Items.BUBBLE_CORAL))
                .unlockedBy("has_general_ocean_fishes", has(ModTags.Items.GENERAL_OCEAN_FISHES))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, FishingLifeItemsRegistry.JUNGLEFISH_COLLECTION.get())
                .requires(FishingLifeItemsRegistry.HYDROLYCUS_ARMATUS.get())
                .requires(FishingLifeItemsRegistry.SALMINUS.get())
                .requires(FishingLifeItemsRegistry.PIRANHA.get())
                .requires(FishingLifeItemsRegistry.ACANTHODORAS.get())
                .requires(FishingLifeItemsRegistry.CETOPSIDIUM.get())
                .requires(FishingLifeItemsRegistry.PANCAKE_STINGRAYS.get())
                .requires(FishingLifeItemsRegistry.PEACOCK_BASS.get())
                .requires(FishingLifeItemsRegistry.DISCUS.get())
                .requires(FishingLifeItemsRegistry.RAINBOW_FISH.get())
                .unlockedBy("has_jungle_fishes", has(ModTags.Items.JUNGLE_FISHES))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, FishingLifeItemsRegistry.DESERTFISH_COLLECTION.get())
                .requires(FishingLifeItemsRegistry.AFRICAN_BARB.get())
                .requires(FishingLifeItemsRegistry.AFRICAN_DESERT_CATFISH.get())
                .requires(FishingLifeItemsRegistry.AFRICAN_LUNGFISH.get())
                .requires(FishingLifeItemsRegistry.AUSTRALIAN_DESERT_GOBY.get())
                .requires(FishingLifeItemsRegistry.DESERT_ZEBRAFISH.get())
                .requires(FishingLifeItemsRegistry.HIGHLAND_SWORDTAIL.get())
                .requires(FishingLifeItemsRegistry.NILE_PERCH.get())
                .requires(FishingLifeItemsRegistry.EGYPTIAN_MOUTHBROODER.get())
                .requires(FishingLifeItemsRegistry.NOTHOBRANCHIUS_FURZERI.get())
                .unlockedBy("has_desert_fishes", has(ModTags.Items.DESERT_FISHES))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, FishingLifeItemsRegistry.TEMPERATEFISH_COLLECTION.get())
                .requires(FishingLifeItemsRegistry.COMMON_CARP.get())
                .requires(FishingLifeItemsRegistry.LAKE_WHITEFISH.get())
                .requires(FishingLifeItemsRegistry.AMERICAN_SHAD.get())
                .requires(FishingLifeItemsRegistry.ORANGESPOTTED_SUNFISH.get())
                .requires(FishingLifeItemsRegistry.BLACK_CRAPPIE.get())
                .requires(FishingLifeItemsRegistry.BROOK_TROUT.get())
                .requires(FishingLifeItemsRegistry.LONGNOSE_GAR.get())
                .requires(FishingLifeItemsRegistry.SHORTNOSE_GAR.get())
                .requires(FishingLifeItemsRegistry.EUROPEAN_PERCH.get())
                .unlockedBy("has_temperate_fishes", has(ModTags.Items.TEMPERATE_FISHES))
                .save(pWriter);

        cookRecipes(pWriter, "smoking", RecipeSerializer.SMOKING_RECIPE, 100);
        cookRecipes(pWriter, "campfire_cooking", RecipeSerializer.CAMPFIRE_COOKING_RECIPE, 600);
        /*


        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, FishingLifeItemsRegistry.FISH_MEAT.get(), 1)
                .requires(ModTags.Items.SMALL_FISHES)

                .save(pWriter);

         */




    }


    protected static void cookRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer, String pCookingMethod, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, int pCookingTime) {
        simpleCookingRecipe(pFinishedRecipeConsumer, pCookingMethod, pCookingSerializer, pCookingTime, FishingLifeItemsRegistry.FISH_MEAT.get(), FishingLifeItemsRegistry.COOKED_FISH_MEAT.get(), 0.35F);

    }


}
