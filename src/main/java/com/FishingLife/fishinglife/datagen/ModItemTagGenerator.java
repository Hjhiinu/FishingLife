package com.FishingLife.fishinglife.datagen;

import com.FishingLife.fishinglife.fishinglife;
import com.FishingLife.fishinglife.registry.FishingLifeItemsRegistry;
import com.FishingLife.fishinglife.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MinecartItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_,
                               CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, fishinglife.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Items.JUNGLE_FISHES)
                .add(FishingLifeItemsRegistry.ARAPAIMA_GIGAS.get(),
                        FishingLifeItemsRegistry.ACANTHODORAS.get(),
                        FishingLifeItemsRegistry.BRYCON_HILARII.get(),
                        FishingLifeItemsRegistry.CETOPSIDIUM.get(),
                        FishingLifeItemsRegistry.DISCUS.get(),
                        FishingLifeItemsRegistry.ELECTRIC_EEL.get(),
                        FishingLifeItemsRegistry.ELEPHANT_FISH.get(),
                        FishingLifeItemsRegistry.HYDROLYCUS_ARMATUS.get(),
                        FishingLifeItemsRegistry.PEACOCK_BASS.get(),
                        FishingLifeItemsRegistry.PIRANHA.get(),
                        FishingLifeItemsRegistry.PANCAKE_STINGRAYS.get(),
                        FishingLifeItemsRegistry.RAINBOW_FISH.get(),
                        FishingLifeItemsRegistry.SILVER_AROWANA.get(),
                        FishingLifeItemsRegistry.SALMINUS.get(),
                        FishingLifeItemsRegistry.PANAQUE.get()


                );




        this.tag(ModTags.Items.CROPS)
                .add(FishingLifeItemsRegistry.SCALLION.get(),
                        FishingLifeItemsRegistry.GREEN_PEPPER.get(),
                        FishingLifeItemsRegistry.CHILI_PEPPER.get()




                );


        this.tag(ModTags.Items.MODFISH)
                .add(FishingLifeItemsRegistry.ARAPAIMA_GIGAS.get(),
                FishingLifeItemsRegistry.ACANTHODORAS.get(),
                FishingLifeItemsRegistry.BRYCON_HILARII.get(),
                FishingLifeItemsRegistry.CETOPSIDIUM.get(),
                FishingLifeItemsRegistry.DISCUS.get(),
                FishingLifeItemsRegistry.ELECTRIC_EEL.get(),
                FishingLifeItemsRegistry.ELEPHANT_FISH.get(),
                FishingLifeItemsRegistry.HYDROLYCUS_ARMATUS.get(),
                FishingLifeItemsRegistry.PEACOCK_BASS.get(),
                FishingLifeItemsRegistry.PIRANHA.get(),
                FishingLifeItemsRegistry.PANCAKE_STINGRAYS.get(),
                FishingLifeItemsRegistry.RAINBOW_FISH.get(),
                FishingLifeItemsRegistry.SILVER_AROWANA.get(),
                FishingLifeItemsRegistry.SALMINUS.get(),
                FishingLifeItemsRegistry.PANAQUE.get(),
                        FishingLifeItemsRegistry.COMMON_CARP.get(),
                        FishingLifeItemsRegistry.LAKE_WHITEFISH.get(),
                        FishingLifeItemsRegistry.ORANGESPOTTED_SUNFISH.get(),
                        FishingLifeItemsRegistry.AMERICAN_SHAD.get(),
                        FishingLifeItemsRegistry.BLACK_CRAPPIE.get(),
                        FishingLifeItemsRegistry.BROOK_TROUT.get(),
                        FishingLifeItemsRegistry.LONGNOSE_GAR.get(),
                        FishingLifeItemsRegistry.SHORTNOSE_GAR.get(),
                        FishingLifeItemsRegistry.EUROPEAN_PERCH.get(),
                        FishingLifeItemsRegistry.EUROPEAN_GRAYLING.get(),
                        FishingLifeItemsRegistry.KOI.get(),
                        FishingLifeItemsRegistry.MUSKELLUNGE.get(),
                        FishingLifeItemsRegistry.PUMPKINSEED_SUNFISH.get(),
                        FishingLifeItemsRegistry.TENCH.get(),
                        FishingLifeItemsRegistry.WALLEYE.get(),
                        FishingLifeItemsRegistry.AFRICAN_BARB.get(),
                        FishingLifeItemsRegistry.AFRICAN_DESERT_CATFISH.get(),
                        FishingLifeItemsRegistry.AFRICAN_LUNGFISH.get(),
                        FishingLifeItemsRegistry.AUSTRALIAN_DESERT_GOBY.get(),
                        FishingLifeItemsRegistry.DESERT_ZEBRAFISH.get(),
                        FishingLifeItemsRegistry.EGYPTIAN_MOUTHBROODER.get(),
                        FishingLifeItemsRegistry.HIGHLAND_SWORDTAIL.get(),
                        FishingLifeItemsRegistry.NILE_PERCH.get(),
                        FishingLifeItemsRegistry.NOTHOBRANCHIUS_FURZERI.get(),

                        FishingLifeItemsRegistry.ANCHOVY.get(),
                        FishingLifeItemsRegistry.CRIMSON_SNAPPER.get(),
                        FishingLifeItemsRegistry.FLYINGFISH.get(),
                        FishingLifeItemsRegistry.LUTJANUS_SEBAE.get(),
                        FishingLifeItemsRegistry.MAHI_MAHI.get(),
                        FishingLifeItemsRegistry.PAMPUS_ARGENTEUS.get(),
                        FishingLifeItemsRegistry.PARROTFISH.get(),
                        FishingLifeItemsRegistry.PSETTA_MAXIMA.get(),
                        FishingLifeItemsRegistry.STRIPED_BEAKFISH.get()




                        );
        this.tag(ModTags.Items.FRUITS)
                .add(Items.APPLE


                );


        this.tag(ModTags.Items.TEMPERATE_FISHES)
                .add(FishingLifeItemsRegistry.COMMON_CARP.get(),
                        FishingLifeItemsRegistry.LAKE_WHITEFISH.get(),
                        FishingLifeItemsRegistry.ORANGESPOTTED_SUNFISH.get(),
                        FishingLifeItemsRegistry.AMERICAN_SHAD.get(),
                        FishingLifeItemsRegistry.BLACK_CRAPPIE.get(),
                        FishingLifeItemsRegistry.BROOK_TROUT.get(),
                        FishingLifeItemsRegistry.LONGNOSE_GAR.get(),
                        FishingLifeItemsRegistry.SHORTNOSE_GAR.get(),
                        FishingLifeItemsRegistry.EUROPEAN_PERCH.get(),
                        FishingLifeItemsRegistry.EUROPEAN_GRAYLING.get(),
                        FishingLifeItemsRegistry.KOI.get(),
                        FishingLifeItemsRegistry.MUSKELLUNGE.get(),
                        FishingLifeItemsRegistry.PUMPKINSEED_SUNFISH.get(),
                        FishingLifeItemsRegistry.TENCH.get(),
                        FishingLifeItemsRegistry.WALLEYE.get()


                );
        this.tag(ModTags.Items.DESERT_FISHES)
                .add(FishingLifeItemsRegistry.AFRICAN_BARB.get(),
                        FishingLifeItemsRegistry.AFRICAN_DESERT_CATFISH.get(),
                        FishingLifeItemsRegistry.AFRICAN_LUNGFISH.get(),
                        FishingLifeItemsRegistry.AUSTRALIAN_DESERT_GOBY.get(),
                        FishingLifeItemsRegistry.DESERT_ZEBRAFISH.get(),
                        FishingLifeItemsRegistry.EGYPTIAN_MOUTHBROODER.get(),
                        FishingLifeItemsRegistry.HIGHLAND_SWORDTAIL.get(),
                        FishingLifeItemsRegistry.NILE_PERCH.get(),
                        FishingLifeItemsRegistry.NOTHOBRANCHIUS_FURZERI.get());

        this.tag(ModTags.Items.WARM_OCEAN_FISHES)
                .add(FishingLifeItemsRegistry.ANCHOVY.get(),
                        FishingLifeItemsRegistry.CRIMSON_SNAPPER.get(),
                        FishingLifeItemsRegistry.FLYINGFISH.get(),
                        FishingLifeItemsRegistry.LUTJANUS_SEBAE.get(),
                        FishingLifeItemsRegistry.MAHI_MAHI.get(),
                        FishingLifeItemsRegistry.PAMPUS_ARGENTEUS.get(),
                        FishingLifeItemsRegistry.PARROTFISH.get(),
                        FishingLifeItemsRegistry.PSETTA_MAXIMA.get(),
                        FishingLifeItemsRegistry.STRIPED_BEAKFISH.get()
                        );
    }
}
