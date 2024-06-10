package com.FishingLife.fishinglife.datagen;

import com.FishingLife.fishinglife.fishinglife;
import com.FishingLife.fishinglife.registry.FishingLifeItemsRegistry;
import net.minecraft.data.PackOutput;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, fishinglife.MOD_ID, existingFileHelper);
    }



    @Override
    protected void registerModels() {
        simpleItem(FishingLifeItemsRegistry.ARAPAIMA_GIGAS);
        simpleItem(FishingLifeItemsRegistry.ACANTHODORAS);
        simpleItem(FishingLifeItemsRegistry.BRYCON_HILARII);
        simpleItem(FishingLifeItemsRegistry.CETOPSIDIUM);
        simpleItem(FishingLifeItemsRegistry.DISCUS);
        simpleItem(FishingLifeItemsRegistry.ELECTRIC_EEL);
        simpleItem(FishingLifeItemsRegistry.ELEPHANT_FISH);
        simpleItem(FishingLifeItemsRegistry.HYDROLYCUS_ARMATUS);
        simpleItem(FishingLifeItemsRegistry.PEACOCK_BASS);
        simpleItem(FishingLifeItemsRegistry.PIRANHA);
        simpleItem(FishingLifeItemsRegistry.PANCAKE_STINGRAYS);
        simpleItem(FishingLifeItemsRegistry.RAINBOW_FISH);
        simpleItem(FishingLifeItemsRegistry.SILVER_AROWANA);
        simpleItem(FishingLifeItemsRegistry.SALMINUS);
        simpleItem(FishingLifeItemsRegistry.PANAQUE);

        simpleItem(FishingLifeItemsRegistry.COMMON_CARP);
        simpleItem(FishingLifeItemsRegistry.LAKE_WHITEFISH);
        simpleItem(FishingLifeItemsRegistry.ORANGESPOTTED_SUNFISH);
        simpleItem(FishingLifeItemsRegistry.AMERICAN_SHAD);
        simpleItem(FishingLifeItemsRegistry.BLACK_CRAPPIE);
        simpleItem(FishingLifeItemsRegistry.BROOK_TROUT);
        simpleItem(FishingLifeItemsRegistry.LONGNOSE_GAR);
        simpleItem(FishingLifeItemsRegistry.SHORTNOSE_GAR);
        simpleItem(FishingLifeItemsRegistry.EUROPEAN_PERCH);
        simpleItem(FishingLifeItemsRegistry.EUROPEAN_GRAYLING);
        simpleItem(FishingLifeItemsRegistry.KOI);
        simpleItem(FishingLifeItemsRegistry.MUSKELLUNGE);
        simpleItem(FishingLifeItemsRegistry.PUMPKINSEED_SUNFISH);
        simpleItem(FishingLifeItemsRegistry.TENCH);
        simpleItem(FishingLifeItemsRegistry.WALLEYE);

        simpleItem(FishingLifeItemsRegistry.AFRICAN_BARB); // African Barb
        simpleItem(FishingLifeItemsRegistry.AFRICAN_DESERT_CATFISH); // African Desert Catfish
        simpleItem(FishingLifeItemsRegistry.AFRICAN_LUNGFISH); // African Lungfish
        simpleItem(FishingLifeItemsRegistry.AUSTRALIAN_DESERT_GOBY); // Australian Desert Goby
        simpleItem(FishingLifeItemsRegistry.DESERT_ZEBRAFISH); // Desert Zebrafish
        simpleItem(FishingLifeItemsRegistry.EGYPTIAN_MOUTHBROODER); // Egyptian Mouthbrooder
        simpleItem(FishingLifeItemsRegistry.HIGHLAND_SWORDTAIL); // Highland Swordtail
        simpleItem(FishingLifeItemsRegistry.NILE_PERCH); // Nile Perch
        simpleItem(FishingLifeItemsRegistry.NOTHOBRANCHIUS_FURZERI); // Nothobranchius Furzeri

        simpleItem(FishingLifeItemsRegistry.ANCHOVY); // Anchovy
        simpleItem(FishingLifeItemsRegistry.CRIMSON_SNAPPER); // Crimson Snapper
        simpleItem(FishingLifeItemsRegistry.FLYINGFISH); // Flyingfish
        simpleItem(FishingLifeItemsRegistry.LUTJANUS_SEBAE); // Lutjanus Sebae
        simpleItem(FishingLifeItemsRegistry.MAHI_MAHI); // Mahi Mahi
        simpleItem(FishingLifeItemsRegistry.PAMPUS_ARGENTEUS); // Pampus Argenteus
        simpleItem(FishingLifeItemsRegistry.PARROTFISH); // Parrotfish
        simpleItem(FishingLifeItemsRegistry.PSETTA_MAXIMA); // Psetta Maxima
        simpleItem(FishingLifeItemsRegistry.STRIPED_BEAKFISH); // Striped Beakfish

        simpleItem(FishingLifeItemsRegistry.BLACK_SCRAPER); // Black Scraper
        simpleItem(FishingLifeItemsRegistry.HAIRTAIL); // Hairtail
        simpleItem(FishingLifeItemsRegistry.MACKEREL); // Mackerel
        simpleItem(FishingLifeItemsRegistry.PACIFIC_SAURY); // Pacific Saury
        simpleItem(FishingLifeItemsRegistry.POMFRET); // Pomfret
        simpleItem(FishingLifeItemsRegistry.RED_HORSEHEAD_FISH); // Red Horsehead Fish
        simpleItem(FishingLifeItemsRegistry.RED_SNAPPER); // Red Snapper
        simpleItem(FishingLifeItemsRegistry.SARDINE); // Sardine
        simpleItem(FishingLifeItemsRegistry.SOLE_FISH); // Sole Fish
        simpleItem(FishingLifeItemsRegistry.YELLOW_CROAKER); // Yellow Croaker

        simpleItem(FishingLifeItemsRegistry.WHITE_HAKE);
        simpleItem(FishingLifeItemsRegistry.CAPELIN);
        simpleItem(FishingLifeItemsRegistry.ARCTIC_SKATE);
        simpleItem(FishingLifeItemsRegistry.ALASKA_POLLOCK);
        simpleItem(FishingLifeItemsRegistry.RAINBOW_TROUT);
        simpleItem(FishingLifeItemsRegistry.ARCTIC_CHAR);
        simpleItem(FishingLifeItemsRegistry.HADDOCK);
        simpleItem(FishingLifeItemsRegistry.ATLANTIC_COD);
        simpleItem(FishingLifeItemsRegistry.FOURHORN_SCULPIN);

        simpleItem(FishingLifeItemsRegistry.SPLASH_TETRA);
        simpleItem(FishingLifeItemsRegistry.CONGO_TETRA);
        simpleItem(FishingLifeItemsRegistry.CENTRAL_MUDMINNOW);
        simpleItem(FishingLifeItemsRegistry.BANDED_PYGMY_SUNFISH);
        simpleItem(FishingLifeItemsRegistry.FLORIDA_GAR);
        simpleItem(FishingLifeItemsRegistry.BLUENOSE_SHINER);
        simpleItem(FishingLifeItemsRegistry.BARRENS_TOPMINNOW);
        simpleItem(FishingLifeItemsRegistry.EVERGLADES_PYGMY_SUNFISH);

        simpleItem(FishingLifeItemsRegistry.RED_MUSHROOM_FISH);
        simpleItem(FishingLifeItemsRegistry.BROWN_MUSHROOM_FISH);

        simpleItem(FishingLifeItemsRegistry.SCALLION_SEEDS);
        simpleItem(FishingLifeItemsRegistry.SCALLION);
        simpleItem(FishingLifeItemsRegistry.GREEN_PEPPER_SEEDS);
        simpleItem(FishingLifeItemsRegistry.GREEN_PEPPER);
        simpleItem(FishingLifeItemsRegistry.CHILI_PEPPER_SEEDS);
        simpleItem(FishingLifeItemsRegistry.CHILI_PEPPER);
        simpleItem(FishingLifeItemsRegistry.SOYBEAN_SEEDS);
        simpleItem(FishingLifeItemsRegistry.SOYBEAN);
        simpleItem(FishingLifeItemsRegistry.BOK_CHOY_SEEDS);
        simpleItem(FishingLifeItemsRegistry.BOK_CHOY);
        simpleItem(FishingLifeItemsRegistry.PADDY_SEEDS);
        simpleItem(FishingLifeItemsRegistry.PADDY);

        simpleItem(FishingLifeItemsRegistry.FISH_ROE);
        simpleItem(FishingLifeItemsRegistry.FISH_GILL);
        simpleItem(FishingLifeItemsRegistry.FISH_SCALE);
        simpleItem(FishingLifeItemsRegistry.FISH_FIN);

        simpleItem(FishingLifeItemsRegistry.IRON_FISH_PROCESSING_KNIFE);
        simpleItem(FishingLifeItemsRegistry.DIAMOND_FISH_PROCESSING_KNIFE);

        simpleItem(FishingLifeItemsRegistry.FISH_MEAT);
        simpleItem(FishingLifeItemsRegistry.CREAM);

        simpleItem(FishingLifeItemsRegistry.VINEGAR);
        simpleItem(FishingLifeItemsRegistry.COOKING_WINE);
        simpleItem(FishingLifeItemsRegistry.SOY_SAUCE);
        simpleItem(FishingLifeItemsRegistry.YEAST_POWDER);
        simpleItem(FishingLifeItemsRegistry.MISO_SAUCE);

        simpleItem(FishingLifeItemsRegistry.MEXICAN_TETRA);
        simpleItem(FishingLifeItemsRegistry.MADAGASCAR_BLIND_CAVE_FISH);
        simpleItem(FishingLifeItemsRegistry.TROGLOGLANIS_PATTERSONI);
        simpleItem(FishingLifeItemsRegistry.TOOTHLESS_BLIND_CAT);
        simpleItem(FishingLifeItemsRegistry.BLIND_CAVE_FISH);


        simpleItem(FishingLifeItemsRegistry.BRAISED_FISH);
        simpleItem(FishingLifeItemsRegistry.SWEET_AND_SOUR_FISH_SLICES);
        simpleItem(FishingLifeItemsRegistry.FISH_OMELETTE);
        simpleItem(FishingLifeItemsRegistry.MISO_GRILLED_FISH);
        simpleItem(FishingLifeItemsRegistry.FISH_SANDWICH);
        simpleItem(FishingLifeItemsRegistry.FISH_SUSHI);
        simpleItem(FishingLifeItemsRegistry.FISH_RICE_ROLL);
        simpleItem(FishingLifeItemsRegistry.COOKED_CRAB);
        simpleItem(FishingLifeItemsRegistry.COOKED_FISH_MEAT);
        simpleItem(FishingLifeItemsRegistry.COOKED_SHRIMP);
        simpleItem(FishingLifeItemsRegistry.COOKED_SEA_URCHIN);

        simpleItem(FishingLifeItemsRegistry.DESERTFISH_COLLECTION); // Desertfish Collection
        simpleItem(FishingLifeItemsRegistry.TEMPERATEFISH_COLLECTION); // Temperatefish Collection
        simpleItem(FishingLifeItemsRegistry.JUNGLEFISH_COLLECTION); // Junglefish Collection
        simpleItem(FishingLifeItemsRegistry.OCEAN_COLLECTION);

        simpleItem(FishingLifeItemsRegistry.ARISQUEDO_COIN);
        simpleItem(FishingLifeItemsRegistry.ARISQUEDO_GOLD_COIN);


        simpleItem(FishingLifeItemsRegistry.PURPLE_SEA_URCHIN);
        simpleItem(FishingLifeItemsRegistry.SLATE_PENCIL_URCHIN);
        simpleItem(FishingLifeItemsRegistry.WHITE_SEA_URCHIN);
        simpleItem(FishingLifeItemsRegistry.GREEN_SEA_URCHIN);
        simpleItem(FishingLifeItemsRegistry.RED_SEA_URCHIN);
        simpleItem(FishingLifeItemsRegistry.PINK_SHRIMP);
        simpleItem(FishingLifeItemsRegistry.BLUE_SHRIMP);
        simpleItem(FishingLifeItemsRegistry.SPOT_PRAWN);
        simpleItem(FishingLifeItemsRegistry.NORTHERN_SHRIMP);
        simpleItem(FishingLifeItemsRegistry.WHITE_SHRIMP);
        simpleItem(FishingLifeItemsRegistry.TIGER_SHRIMP);
        simpleItem(FishingLifeItemsRegistry.PACIFIC_WHITE_SHRIMP);
        simpleItem(FishingLifeItemsRegistry.SWIMMING_CRAB);
        simpleItem(FishingLifeItemsRegistry.SOFT_SHELL_CRAB);
        simpleItem(FishingLifeItemsRegistry.EUROPEAN_GREEN_CRAB);
        simpleItem(FishingLifeItemsRegistry.STONE_CRAB);
        simpleItem(FishingLifeItemsRegistry.SNOW_CRAB);
        simpleItem(FishingLifeItemsRegistry.MUD_CRAB);
        simpleItem(FishingLifeItemsRegistry.RED_ROCK_CRAB);
        simpleItem(FishingLifeItemsRegistry.DUNGENESS_CRAB);
        simpleItem(FishingLifeItemsRegistry.BLUE_CRAB);

        simpleItem(FishingLifeItemsRegistry.SMALL_NET_WITH_BASIC_BAITS);
        simpleItem(FishingLifeItemsRegistry.MEDIUM_NET_WITH_BASIC_BAITS);
        simpleItem(FishingLifeItemsRegistry.LARGE_NET_WITH_BASIC_BAITS);
        simpleItem(FishingLifeItemsRegistry.SMALL_NET_WITH_ADVANCED_BAITS);
        simpleItem(FishingLifeItemsRegistry.MEDIUM_NET_WITH_ADVANCED_BAITS);
        simpleItem(FishingLifeItemsRegistry.LARGE_NET_WITH_ADVANCED_BAITS);
        simpleItem(FishingLifeItemsRegistry.SMALL_NET_WITH_PREMIUM_BAITS);
        simpleItem(FishingLifeItemsRegistry.MEDIUM_NET_WITH_PREMIUM_BAITS);
        simpleItem(FishingLifeItemsRegistry.LARGE_NET_WITH_PREMIUM_BAITS);
        simpleItem(FishingLifeItemsRegistry.SMALL_NET_WITH_ULTIMATE_BAITS);
        simpleItem(FishingLifeItemsRegistry.MEDIUM_NET_WITH_ULTIMATE_BAITS);
        simpleItem(FishingLifeItemsRegistry.LARGE_NET_WITH_ULTIMATE_BAITS);



        simpleItem(FishingLifeItemsRegistry.PROFESSIONAL_FISHING_ROD);
        simpleItem(FishingLifeItemsRegistry.ELITE_FISHING_ROD);
        simpleItem(FishingLifeItemsRegistry.MASTER_FISHING_ROD);
        simpleItem(FishingLifeItemsRegistry.LEGENDARY_FISHING_ROD);
        simpleItem(FishingLifeItemsRegistry.PRIMEVAL_FISHING_ROD);
        simpleItem(FishingLifeItemsRegistry.DIVINE_FISHING_ROD);

        simpleItem(FishingLifeItemsRegistry.SEDUCTIVE_HAZARD_ZEST);


        simpleItem(FishingLifeItemsRegistry.GENERAL_FISHING_LINE);

        simpleItem(FishingLifeItemsRegistry.PLASTIC_TRASH);
        simpleItem(FishingLifeItemsRegistry.REINFORCED_PLASTIC);


        simpleItem(FishingLifeItemsRegistry.BASIC_BAITS);
        simpleItem(FishingLifeItemsRegistry.ADVANCED_BAITS);
        simpleItem(FishingLifeItemsRegistry.PREMIUM_BAITS);
        simpleItem(FishingLifeItemsRegistry.ULTIMATE_BAITS);
        simpleItem(FishingLifeItemsRegistry.SMALL_FISHING_NET);
        simpleItem(FishingLifeItemsRegistry.MEDIUM_FISHING_NET);
        simpleItem(FishingLifeItemsRegistry.LARGE_FISHING_NET);

        simpleItem(FishingLifeItemsRegistry.CHAINMAIL_PIECE);

        trimmedArmorItem(FishingLifeItemsRegistry.SCALE_HELMET);
        trimmedArmorItem(FishingLifeItemsRegistry.SCALE_CHESTPLATE);
        trimmedArmorItem(FishingLifeItemsRegistry.SCALE_LEGGINGS);
        trimmedArmorItem(FishingLifeItemsRegistry.SCALE_BOOTS);

        trimmedArmorItem(FishingLifeItemsRegistry.ADVANCED_TURTLE_SHELL);
    }
    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = fishinglife.MOD_ID; // Change this to your mod id

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.entrySet().forEach(entry -> {

                ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
                float trimValue = entry.getValue();

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + armorItem;
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = new ResourceLocation(MOD_ID, armorItemPath);
                ResourceLocation trimResLoc = new ResourceLocation(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = new ResourceLocation(MOD_ID, currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                new ResourceLocation(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(fishinglife.MOD_ID,"item/" + item.getId().getPath()));
    }

}
