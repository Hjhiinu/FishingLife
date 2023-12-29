package com.FishingLife.fishinglife.registry;

import com.FishingLife.fishinglife.fishinglife;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;


public class FishingLifeCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS= DeferredRegister.create(Registries.CREATIVE_MODE_TAB, fishinglife.MOD_ID);
    public static final RegistryObject<CreativeModeTab> FISHINGLIFE_TAB= CREATIVE_MODE_TABS.register("fishinglife_tab",
            ()->CreativeModeTab.builder().icon(()->new ItemStack(FishingLifeItemsRegistry.ARAPAIMA_GIGAS.get()))
                    .title(Component.translatable("creativetab.fishinglife_tab"))
                    .displayItems((pParameters,pOutput)->{
                        //Fishes

                        //Jungle Fishes
                        pOutput.accept(FishingLifeItemsRegistry.ARAPAIMA_GIGAS.get()); // Arapaima
                        pOutput.accept(FishingLifeItemsRegistry.SILVER_AROWANA.get()); // Silver Arowana
                        pOutput.accept(FishingLifeItemsRegistry.BRYCON_HILARII.get()); // Brycon hilarii
                        pOutput.accept(FishingLifeItemsRegistry.HYDROLYCUS_ARMATUS.get()); // Hydrolycus armatus
                        pOutput.accept(FishingLifeItemsRegistry.SALMINUS.get()); // Salminus
                        pOutput.accept(FishingLifeItemsRegistry.PIRANHA.get()); // Piranha
                        pOutput.accept(FishingLifeItemsRegistry.ACANTHODORAS.get()); // Acanthodoras
                        pOutput.accept(FishingLifeItemsRegistry.ELECTRIC_EEL.get()); // Electric Eel
                        pOutput.accept(FishingLifeItemsRegistry.CETOPSIDIUM.get()); // Cetopsidium
                        pOutput.accept(FishingLifeItemsRegistry.PANCAKE_STINGRAYS.get());//Pancake stingrays
                        pOutput.accept(FishingLifeItemsRegistry.PEACOCK_BASS.get());//Peacock bass
                        pOutput.accept(FishingLifeItemsRegistry.DISCUS.get());//Discus
                        pOutput.accept(FishingLifeItemsRegistry.RAINBOW_FISH.get());//Rainbow Fish
                        pOutput.accept(FishingLifeItemsRegistry.ELEPHANT_FISH.get());//Elephant Fish
                        pOutput.accept(FishingLifeItemsRegistry.PANAQUE.get());//Panaque

                        //Temperate Fishes
                        pOutput.accept(FishingLifeItemsRegistry.COMMON_CARP.get()); // Common Carp
                        pOutput.accept(FishingLifeItemsRegistry.LAKE_WHITEFISH.get()); // Lake Whitefish
                        pOutput.accept(FishingLifeItemsRegistry.ORANGESPOTTED_SUNFISH.get()); // Orange-Spotted Sunfish
                        pOutput.accept(FishingLifeItemsRegistry.AMERICAN_SHAD.get()); // American Shad
                        pOutput.accept(FishingLifeItemsRegistry.BLACK_CRAPPIE.get()); // Black Crappie
                        pOutput.accept(FishingLifeItemsRegistry.BROOK_TROUT.get()); // Brook Trout
                        pOutput.accept(FishingLifeItemsRegistry.LONGNOSE_GAR.get()); // Longnose Gar
                        pOutput.accept(FishingLifeItemsRegistry.SHORTNOSE_GAR.get()); // Shortnose Gar
                        pOutput.accept(FishingLifeItemsRegistry.EUROPEAN_PERCH.get()); // European Perch
                        pOutput.accept(FishingLifeItemsRegistry.EUROPEAN_GRAYLING.get()); // European Grayling
                        pOutput.accept(FishingLifeItemsRegistry.KOI.get()); // Koi
                        pOutput.accept(FishingLifeItemsRegistry.MUSKELLUNGE.get()); // Muskellunge
                        pOutput.accept(FishingLifeItemsRegistry.PUMPKINSEED_SUNFISH.get()); // Pumpkinseed Sunfish
                        pOutput.accept(FishingLifeItemsRegistry.TENCH.get()); // Tench
                        pOutput.accept(FishingLifeItemsRegistry.WALLEYE.get()); // Walleye

                        //Desert Fishes
                        pOutput.accept(FishingLifeItemsRegistry.AFRICAN_BARB.get()); // African Barb
                        pOutput.accept(FishingLifeItemsRegistry.AFRICAN_DESERT_CATFISH.get()); // African Desert Catfish
                        pOutput.accept(FishingLifeItemsRegistry.AFRICAN_LUNGFISH.get()); // African Lungfish
                        pOutput.accept(FishingLifeItemsRegistry.AUSTRALIAN_DESERT_GOBY.get()); // Australian Desert Goby
                        pOutput.accept(FishingLifeItemsRegistry.DESERT_ZEBRAFISH.get()); // Desert Zebrafish
                        pOutput.accept(FishingLifeItemsRegistry.EGYPTIAN_MOUTHBROODER.get()); // Egyptian Mouthbrooder
                        pOutput.accept(FishingLifeItemsRegistry.HIGHLAND_SWORDTAIL.get()); // Highland Swordtail
                        pOutput.accept(FishingLifeItemsRegistry.NILE_PERCH.get()); // Nile Perch
                        pOutput.accept(FishingLifeItemsRegistry.NOTHOBRANCHIUS_FURZERI.get()); // Nothobranchius Furzeri

                        //All Ocean Fishes
                        pOutput.accept(FishingLifeItemsRegistry.BLACK_SCRAPER.get()); // Black Scraper
                        pOutput.accept(FishingLifeItemsRegistry.HAIRTAIL.get()); // Hairtail
                        pOutput.accept(FishingLifeItemsRegistry.MACKEREL.get()); // Mackerel
                        pOutput.accept(FishingLifeItemsRegistry.PACIFIC_SAURY.get()); // Pacific Saury
                        pOutput.accept(FishingLifeItemsRegistry.POMFRET.get()); // Pomfret
                        pOutput.accept(FishingLifeItemsRegistry.RED_HORSEHEAD_FISH.get()); // Red Horsehead Fish
                        pOutput.accept(FishingLifeItemsRegistry.RED_SNAPPER.get()); // Red Snapper
                        pOutput.accept(FishingLifeItemsRegistry.SARDINE.get()); // Sardine
                        pOutput.accept(FishingLifeItemsRegistry.SOLE_FISH.get()); // Sole Fish
                        pOutput.accept(FishingLifeItemsRegistry.YELLOW_CROAKER.get()); // Yellow Croaker


                        //Warm Ocean Fishes
                        pOutput.accept(FishingLifeItemsRegistry.ANCHOVY.get()); // Anchovy
                        pOutput.accept(FishingLifeItemsRegistry.CRIMSON_SNAPPER.get()); // Crimson Snapper
                        pOutput.accept(FishingLifeItemsRegistry.FLYINGFISH.get()); // Flyingfish
                        pOutput.accept(FishingLifeItemsRegistry.LUTJANUS_SEBAE.get()); // Lutjanus Sebae
                        pOutput.accept(FishingLifeItemsRegistry.MAHI_MAHI.get()); // Mahi Mahi
                        pOutput.accept(FishingLifeItemsRegistry.PAMPUS_ARGENTEUS.get()); // Pampus Argenteus
                        pOutput.accept(FishingLifeItemsRegistry.PARROTFISH.get()); // Parrotfish
                        pOutput.accept(FishingLifeItemsRegistry.PSETTA_MAXIMA.get()); // Psetta Maxima
                        pOutput.accept(FishingLifeItemsRegistry.STRIPED_BEAKFISH.get()); // Striped Beakfish



                        //Fishes Collection

                        pOutput.accept(FishingLifeItemsRegistry.DESERTFISH_COLLECTION.get()); // Desertfish Collection
                        pOutput.accept(FishingLifeItemsRegistry.TEMPERATEFISH_COLLECTION.get()); // Temperatefish Collection
                        pOutput.accept(FishingLifeItemsRegistry.JUNGLEFISH_COLLECTION.get()); // Junglefish Collection


                        // Seeds
                        pOutput.accept(FishingLifeItemsRegistry.SCALLION_SEEDS.get());//Scallion seeds
                        pOutput.accept(FishingLifeItemsRegistry.GREEN_PEPPER_SEEDS.get());//Green pepper seeds
                        pOutput.accept(FishingLifeItemsRegistry.CHILI_PEPPER_SEEDS.get());//Chili pepper seeds
                        pOutput.accept(FishingLifeItemsRegistry.SOYBEAN_SEEDS.get());//Soybean seeds
                        pOutput.accept(FishingLifeItemsRegistry.BOK_CHOY_SEEDS.get());//Bok Choy seeds
                        pOutput.accept(FishingLifeItemsRegistry.PADDY_SEEDS.get());

                        //Crops
                        pOutput.accept(FishingLifeItemsRegistry.SCALLION.get());//Scallion
                        pOutput.accept(FishingLifeItemsRegistry.GREEN_PEPPER.get());//Green pepper
                        pOutput.accept(FishingLifeItemsRegistry.CHILI_PEPPER.get());//Chili pepper
                        pOutput.accept(FishingLifeItemsRegistry.SOYBEAN.get());//Soybean
                        pOutput.accept(FishingLifeItemsRegistry.BOK_CHOY.get());//Bok Choy
                        pOutput.accept(FishingLifeItemsRegistry.PADDY.get());

                        //Condiment
                        pOutput.accept(FishingLifeItemsRegistry.SOY_SAUCE.get()); // Soy Sauce
                        pOutput.accept(FishingLifeItemsRegistry.YEAST_POWDER.get()); // Yeast Powder
                        pOutput.accept(FishingLifeItemsRegistry.VINEGAR.get()); // Vinegar
                        pOutput.accept(FishingLifeItemsRegistry.MISO_SAUCE.get()); // Miso Sauce
                        pOutput.accept(FishingLifeItemsRegistry.COOKING_WINE.get()); // Cooking Wine

                        //Other items
                        pOutput.accept(FishingLifeItemsRegistry.FISH_MEAT.get());//Fish meat
                        pOutput.accept(FishingLifeItemsRegistry.CREAM.get());//Cream

                        //Dishes
                        pOutput.accept(FishingLifeItemsRegistry.BRAISED_FISH.get());//Braised Fish
                        pOutput.accept(FishingLifeItemsRegistry.SWEET_AND_SOUR_FISH_SLICES.get());//Sweet and Sour Fish Slices
                        pOutput.accept(FishingLifeItemsRegistry.FISH_OMELETTE.get());//Fish Omelette
                        pOutput.accept(FishingLifeItemsRegistry.MISO_GRILLED_FISH.get());//Miso Grilled Fish
                        pOutput.accept(FishingLifeItemsRegistry.FISH_SANDWICH.get());
                        pOutput.accept(FishingLifeItemsRegistry.FISH_SUSHI.get());
                        pOutput.accept(FishingLifeItemsRegistry.FISH_RICE_ROLL.get());



                        //Fishing rods
                        pOutput.accept(FishingLifeItemsRegistry.PROFESSIONAL_FISHING_ROD.get()); // Professional Fishing Rod
                        pOutput.accept(FishingLifeItemsRegistry.ELITE_FISHING_ROD.get()); // Elite Fishing Rod
                        pOutput.accept(FishingLifeItemsRegistry.MASTER_FISHING_ROD.get()); // Master Fishing Rod
                        pOutput.accept(FishingLifeItemsRegistry.LEGENDARY_FISHING_ROD.get()); // Legendary Fishing Rod
                        pOutput.accept(FishingLifeItemsRegistry.PRIMEVAL_FISHING_ROD.get()); // Primeval Fishing Rod
                        pOutput.accept(FishingLifeItemsRegistry.DIVINE_FISHING_ROD.get()); // Divine Fishing Rod



                        //Currency
                        pOutput.accept(FishingLifeItemsRegistry.ARISQUEDO_COIN.get());
                        //Blocks
                        pOutput.accept(FishingLifeBlocksRegistry.FERMENTER.get());//Fermenter
                        pOutput.accept(FishingLifeBlocksRegistry.FISHINGMACHINE.get());//Fishing Machine

                        pOutput.accept(FishingLifeBlocksRegistry.JUNGLE_FISHERMAN_WORKBENCH.get());
                        pOutput.accept(FishingLifeBlocksRegistry.GENERAL_FISHERMAN_WORKBENCH.get());
                        pOutput.accept(FishingLifeBlocksRegistry.DESERT_FISHERMAN_WORKBENCH.get());


                    })
                    .build());
    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }


}
