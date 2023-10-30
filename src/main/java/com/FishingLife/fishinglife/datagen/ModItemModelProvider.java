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

        simpleItem(FishingLifeItemsRegistry.SCALLION_SEEDS);
        simpleItem(FishingLifeItemsRegistry.SCALLION);
        simpleItem(FishingLifeItemsRegistry.GREEN_PEPPER_SEEDS);
        simpleItem(FishingLifeItemsRegistry.GREEN_PEPPER);
        simpleItem(FishingLifeItemsRegistry.CHILI_PEPPER_SEEDS);
        simpleItem(FishingLifeItemsRegistry.CHILI_PEPPER);
        simpleItem(FishingLifeItemsRegistry.SOYBEAN_SEEDS);
        simpleItem(FishingLifeItemsRegistry.SOYBEAN);

        simpleItem(FishingLifeItemsRegistry.FISH_MEAT);
        simpleItem(FishingLifeItemsRegistry.CREAM);

        simpleItem(FishingLifeItemsRegistry.VINEGAR);
        simpleItem(FishingLifeItemsRegistry.COOKING_WINE);
        simpleItem(FishingLifeItemsRegistry.SOY_SAUCE);
        simpleItem(FishingLifeItemsRegistry.YEAST_POWDER);
        simpleItem(FishingLifeItemsRegistry.MISO_SAUCE);


        simpleItem(FishingLifeItemsRegistry.BRAISED_FISH);
        simpleItem(FishingLifeItemsRegistry.SWEET_AND_SOUR_FISH_SLICES);
        simpleItem(FishingLifeItemsRegistry.FISH_OMELETTE);
        simpleItem(FishingLifeItemsRegistry.MISO_GRILLED_FISH);






        simpleItem(FishingLifeItemsRegistry.PROFESSIONAL_FISHING_ROD);


        simpleItem(FishingLifeItemsRegistry.ELITE_FISHING_ROD);


        simpleItem(FishingLifeItemsRegistry.MASTER_FISHING_ROD);

        simpleItem(FishingLifeItemsRegistry.LEGENDARY_FISHING_ROD);


        simpleItem(FishingLifeItemsRegistry.PRIMEVAL_FISHING_ROD);

        simpleItem(FishingLifeItemsRegistry.DIVINE_FISHING_ROD);




    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(fishinglife.MOD_ID,"item/" + item.getId().getPath()));
    }

}
