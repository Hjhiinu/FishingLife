package com.FishingLife.fishinglife.datagen;

import com.FishingLife.fishinglife.fishinglife;
import com.FishingLife.fishinglife.registry.FishingLifeItemsRegistry;
import net.minecraft.data.PackOutput;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
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




        simpleItem(FishingLifeItemsRegistry.SCALLION_SEEDS);
        simpleItem(FishingLifeItemsRegistry.SCALLION);
        simpleItem(FishingLifeItemsRegistry.GREEN_PEPPER_SEEDS);
        simpleItem(FishingLifeItemsRegistry.GREEN_PEPPER);
        simpleItem(FishingLifeItemsRegistry.CHILI_PEPPER_SEEDS);
        simpleItem(FishingLifeItemsRegistry.CHILI_PEPPER);


        simpleItem(FishingLifeItemsRegistry.FISH_MEAT);
        simpleItem(FishingLifeItemsRegistry.CREAM);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(fishinglife.MOD_ID,"item/" + item.getId().getPath()));
    }

}
