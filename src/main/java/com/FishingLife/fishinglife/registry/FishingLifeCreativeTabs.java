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

                        pOutput.accept(FishingLifeItemsRegistry.ARAPAIMA_GIGAS.get()); // Arapaima
                        pOutput.accept(FishingLifeItemsRegistry.SILVER_AROWANA.get()); // Silver Arowana
                        pOutput.accept(FishingLifeItemsRegistry.BRYCON_HILARII.get()); // Brycon hilarii
                        pOutput.accept(FishingLifeItemsRegistry.HYDROLYCUS_ARMATUS.get()); // Hydrolycus armatus
                        pOutput.accept(FishingLifeItemsRegistry.SALMINUS.get()); // Salminus
                        pOutput.accept(FishingLifeItemsRegistry.PIRANHA.get()); // Piranha
                        pOutput.accept(FishingLifeItemsRegistry.ACANTHODORAS.get()); // Acanthodoras
                        pOutput.accept(FishingLifeItemsRegistry.ELECTRIC_EEL.get()); // Electric Eel
                        pOutput.accept(FishingLifeItemsRegistry.CETOPSIDIUM.get()); // Cetopsidium



                    })
                    .build());
    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }


}
