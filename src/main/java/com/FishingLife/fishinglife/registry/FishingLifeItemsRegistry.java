package com.FishingLife.fishinglife.registry;

import com.FishingLife.fishinglife.fishinglife;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
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

    //Fishes
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

    //Crops
    public static final RegistryObject<Item> SCALLION = ITEMS.register("scallion",
            () -> new Item(new Item.Properties().food(FishingLifeFoodsRegistry.CROPS)));

    public static final RegistryObject<Item> GREEN_PEPPER = ITEMS.register("green_pepper",
            () -> new Item(new Item.Properties().food(FishingLifeFoodsRegistry.CROPS)));

    public static final RegistryObject<Item> CHILI_PEPPER = ITEMS.register("chili_pepper",
            () -> new Item(new Item.Properties().food(FishingLifeFoodsRegistry.CROPS)));

    public static final RegistryObject<Item> CUCUMBER = ITEMS.register("cucumber",
            () -> new Item(new Item.Properties().food(FishingLifeFoodsRegistry.CROPS)));


    public static final RegistryObject<Item> SPINACH = ITEMS.register("spinach",
            () -> new Item(new Item.Properties().food(FishingLifeFoodsRegistry.CROPS)));

    public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}
}

