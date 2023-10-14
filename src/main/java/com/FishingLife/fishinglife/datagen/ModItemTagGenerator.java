package com.FishingLife.fishinglife.datagen;

import com.FishingLife.fishinglife.fishinglife;
import com.FishingLife.fishinglife.registry.FishingLifeItemsRegistry;
import com.FishingLife.fishinglife.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
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
    }
}
