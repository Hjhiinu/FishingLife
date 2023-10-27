package com.FishingLife.fishinglife.registry;

import com.FishingLife.fishinglife.fishinglife;
import net.minecraft.world.item.FishingRodItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.LootTableIdCondition;
public class FishingLifeItemsRegistry {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, fishinglife.MOD_ID);
    //Fishing Rods


    public static final RegistryObject<Item> PROFESSIONAL_FISHING_ROD = ITEMS.register("professional_fishing_rod", () -> new FishingRodItem(new Item.Properties().defaultDurability(125)));
    public static final RegistryObject<Item> ELITE_FISHING_ROD = ITEMS.register("elite_fishing_rod", () -> new FishingRodItem(new Item.Properties().defaultDurability(125).rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> MASTER_FISHING_ROD = ITEMS.register("master_fishing_rod", () -> new FishingRodItem(new Item.Properties().defaultDurability(125).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> LEGENDARY_FISHING_ROD = ITEMS.register("legendary_fishing_rod", () -> new FishingRodItem(new Item.Properties().defaultDurability(125).rarity(Rarity.RARE)));

    public static final RegistryObject<Item> PRIMEVAL_FISHING_ROD = ITEMS.register("primeval_fishing_rod", () -> new FishingRodItem(new Item.Properties().defaultDurability(125).rarity(Rarity.RARE)));

    public static final RegistryObject<Item> DIVINE_FISHING_ROD = ITEMS.register("divine_fishing_rod", () -> new FishingRodItem(new Item.Properties().defaultDurability(125).rarity(Rarity.EPIC)));



    //Condiment
    public static final RegistryObject<Item> SOY_SAUCE = ITEMS.register("soy_sauce",()->new Item(new Item.Properties()));

    public static final RegistryObject<Item> YEAST_POWDER = ITEMS.register("yeast_powder",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> VINEGAR = ITEMS.register("vinegar",()->new Item(new Item.Properties()));

    public static final RegistryObject<Item> MISO_SAUCE = ITEMS.register("miso_sauce",()->new Item(new Item.Properties()));

    public static final RegistryObject<Item> COOKING_WINE = ITEMS.register("cooking_wine",()->new Item(new Item.Properties()));

    //Fishes

    //freshwater

    //tropical fishes
    public static final RegistryObject<Item> ARAPAIMA_GIGAS = ITEMS.register("arapaima_gigas",
            () -> new Item(new Item.Properties().food(FishingLifeFoodsRegistry.RAW_FISH)));

    public static final RegistryObject<Item> SILVER_AROWANA = ITEMS.register("silver_arowana",
            () -> new Item(new Item.Properties().food(FishingLifeFoodsRegistry.RAW_FISH)));

    public static final RegistryObject<Item> BRYCON_HILARII = ITEMS.register("brycon_hilarii",
            () -> new Item(new Item.Properties().food(FishingLifeFoodsRegistry.RAW_FISH)));

    public static final RegistryObject<Item> HYDROLYCUS_ARMATUS = ITEMS.register("hydrolycus_armatus",
            () -> new Item(new Item.Properties().food(FishingLifeFoodsRegistry.RAW_FISH)));

    public static final RegistryObject<Item> SALMINUS = ITEMS.register("salminus",
            () -> new Item(new Item.Properties().food(FishingLifeFoodsRegistry.RAW_FISH)));

    public static final RegistryObject<Item> PIRANHA = ITEMS.register("piranha",
            () -> new Item(new Item.Properties().food(FishingLifeFoodsRegistry.RAW_FISH)));

    public static final RegistryObject<Item> ACANTHODORAS = ITEMS.register("acanthodoras",
            () -> new Item(new Item.Properties().food(FishingLifeFoodsRegistry.RAW_FISH)));

    public static final RegistryObject<Item> ELECTRIC_EEL = ITEMS.register("electric_eel",
            () -> new Item(new Item.Properties().food(FishingLifeFoodsRegistry.RAW_FISH)));

    public static final RegistryObject<Item> CETOPSIDIUM = ITEMS.register("cetopsidium",
            () -> new Item(new Item.Properties().food(FishingLifeFoodsRegistry.RAW_FISH)));

    public static final RegistryObject<Item> PANCAKE_STINGRAYS = ITEMS.register("pancake_stingrays",
            () -> new Item(new Item.Properties().food(FishingLifeFoodsRegistry.RAW_FISH)));

    public static final RegistryObject<Item>  PEACOCK_BASS= ITEMS.register("peacock_bass",
            () -> new Item(new Item.Properties().food(FishingLifeFoodsRegistry.RAW_FISH)));

    public static final RegistryObject<Item>  DISCUS= ITEMS.register("discus",
            () -> new Item(new Item.Properties().food(FishingLifeFoodsRegistry.RAW_FISH)));

    public static final RegistryObject<Item>  RAINBOW_FISH= ITEMS.register("rainbow_fish",
            () -> new Item(new Item.Properties().food(FishingLifeFoodsRegistry.RAW_FISH)));

    public static final RegistryObject<Item>  ELEPHANT_FISH= ITEMS.register("elephant_fish",
            () -> new Item(new Item.Properties().food(FishingLifeFoodsRegistry.RAW_FISH)));

    public static final RegistryObject<Item>  PANAQUE= ITEMS.register("panaque",
            () -> new Item(new Item.Properties().food(FishingLifeFoodsRegistry.RAW_FISH)));


    //Temperate fishes
    public static final RegistryObject<Item>  COMMON_CARP= ITEMS.register("common_carp",
            () -> new Item(new Item.Properties().food(FishingLifeFoodsRegistry.RAW_FISH)));

    public static final RegistryObject<Item>  LAKE_WHITEFISH= ITEMS.register("lake_whitefish",
            () -> new Item(new Item.Properties().food(FishingLifeFoodsRegistry.RAW_FISH)));

    public static final RegistryObject<Item>  ORANGESPOTTED_SUNFISH= ITEMS.register("orangespotted_sunfish",
            () -> new Item(new Item.Properties().food(FishingLifeFoodsRegistry.RAW_FISH)));

    public static final RegistryObject<Item> AMERICAN_SHAD = ITEMS.register("american_shad",
            () -> new Item(new Item.Properties().food(FishingLifeFoodsRegistry.RAW_FISH)));

    public static final RegistryObject<Item> BLACK_CRAPPIE = ITEMS.register("black_crappie",
            () -> new Item(new Item.Properties().food(FishingLifeFoodsRegistry.RAW_FISH)));

    public static final RegistryObject<Item> BROOK_TROUT = ITEMS.register("brook_trout",
            () -> new Item(new Item.Properties().food(FishingLifeFoodsRegistry.RAW_FISH)));

    public static final RegistryObject<Item> LONGNOSE_GAR = ITEMS.register("longnose_gar",
            () -> new Item(new Item.Properties().food(FishingLifeFoodsRegistry.RAW_FISH)));

    public static final RegistryObject<Item> SHORTNOSE_GAR = ITEMS.register("shortnose_gar",
            () -> new Item(new Item.Properties().food(FishingLifeFoodsRegistry.RAW_FISH)));




    //Other items
    public static final RegistryObject<Item> FISH_MEAT = ITEMS.register("fish_meat",()->new Item(new Item.Properties()));

    public static final RegistryObject<Item> CREAM = ITEMS.register("cream",()->new Item(new Item.Properties()));


    //Seeds
    public static final RegistryObject<Item> SCALLION_SEEDS = ITEMS.register("scallion_seeds",
            () -> new ItemNameBlockItem(FishingLifeBlocksRegistry.SCALLION_CROP.get(), new Item.Properties()));

    public static final RegistryObject<Item> GREEN_PEPPER_SEEDS = ITEMS.register("green_pepper_seeds",
            () -> new ItemNameBlockItem(FishingLifeBlocksRegistry.GREEN_PEPPER_CROP.get(), new Item.Properties()));

    public static final RegistryObject<Item> CHILI_PEPPER_SEEDS = ITEMS.register("chili_pepper_seeds",
            () -> new ItemNameBlockItem(FishingLifeBlocksRegistry.CHILI_PEPPER_CROP.get(), new Item.Properties()));

    public static final RegistryObject<Item> SOYBEAN_SEEDS = ITEMS.register("soybean_seeds",
            () -> new ItemNameBlockItem(FishingLifeBlocksRegistry.SOYBEAN_CROP.get(), new Item.Properties()));

    //Crops
    public static final RegistryObject<Item> SCALLION = ITEMS.register("scallion",
            () -> new Item(new Item.Properties().food(FishingLifeFoodsRegistry.CROPS)));

    public static final RegistryObject<Item> GREEN_PEPPER = ITEMS.register("green_pepper",
            () -> new Item(new Item.Properties().food(FishingLifeFoodsRegistry.CROPS)));

    public static final RegistryObject<Item> CHILI_PEPPER = ITEMS.register("chili_pepper",
            () -> new Item(new Item.Properties().food(FishingLifeFoodsRegistry.CROPS)));

    public static final RegistryObject<Item> SOYBEAN = ITEMS.register("soybean",
            () -> new Item(new Item.Properties().food(FishingLifeFoodsRegistry.CROPS)));

   /* public static final RegistryObject<Item> CUCUMBER = ITEMS.register("cucumber",
            () -> new Item(new Item.Properties().food(FishingLifeFoodsRegistry.CROPS)));


    public static final RegistryObject<Item> SPINACH = ITEMS.register("spinach",
            () -> new Item(new Item.Properties().food(FishingLifeFoodsRegistry.CROPS)));

    */

    //Fishing rods



    //Dishes
    public static final RegistryObject<Item>  BRAISED_FISH= ITEMS.register("braised_fish",
            () -> new Item(new Item.Properties().food(FishingLifeFoodsRegistry.COMMON_DISHES)));

    public static final RegistryObject<Item>  SWEET_AND_SOUR_FISH_SLICES= ITEMS.register("sweet_and_sour_fish_slices",
            () -> new Item(new Item.Properties().food(FishingLifeFoodsRegistry.COMMON_DISHES)));

    public static final RegistryObject<Item>  FISH_OMELETTE= ITEMS.register("fish_omelette",
            () -> new Item(new Item.Properties().food(FishingLifeFoodsRegistry.COMMON_DISHES)));

    public static final RegistryObject<Item>  MISO_GRILLED_FISH= ITEMS.register("miso_grilled_fish",
            () -> new Item(new Item.Properties().food(FishingLifeFoodsRegistry.COMMON_DISHES)));








    public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}
}

