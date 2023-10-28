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





                        // Seeds
                        pOutput.accept(FishingLifeItemsRegistry.SCALLION_SEEDS.get());//Scallion seeds
                        pOutput.accept(FishingLifeItemsRegistry.GREEN_PEPPER_SEEDS.get());//Green pepper seeds
                        pOutput.accept(FishingLifeItemsRegistry.CHILI_PEPPER_SEEDS.get());//Chili pepper seeds
                        pOutput.accept(FishingLifeItemsRegistry.SOYBEAN_SEEDS.get());//Soybean seeds
                        //Crops
                        pOutput.accept(FishingLifeItemsRegistry.SCALLION.get());//Scallion
                        pOutput.accept(FishingLifeItemsRegistry.GREEN_PEPPER.get());//Green pepper
                        pOutput.accept(FishingLifeItemsRegistry.CHILI_PEPPER.get());//Chili pepper
                        pOutput.accept(FishingLifeItemsRegistry.SOYBEAN.get());//Soybean

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


                        //Blocks
                        pOutput.accept(FishingLifeBlocksRegistry.FERMENTER.get());//Fermenter

                    })
                    .build());
    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }


}
