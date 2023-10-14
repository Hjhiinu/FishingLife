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


                        // Seeds
                        pOutput.accept(FishingLifeItemsRegistry.SCALLION_SEEDS.get());//Scallion seeds
                        pOutput.accept(FishingLifeItemsRegistry.GREEN_PEPPER_SEEDS.get());//Green pepper seeds
                        pOutput.accept(FishingLifeItemsRegistry.CHILI_PEPPER_SEEDS.get());//Chili pepper seeds
                        //Crops
                        pOutput.accept(FishingLifeItemsRegistry.SCALLION.get());//Scallion
                        pOutput.accept(FishingLifeItemsRegistry.GREEN_PEPPER.get());//Green pepper
                        pOutput.accept(FishingLifeItemsRegistry.CHILI_PEPPER.get());//Chili pepper


                    })
                    .build());
    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }


}
