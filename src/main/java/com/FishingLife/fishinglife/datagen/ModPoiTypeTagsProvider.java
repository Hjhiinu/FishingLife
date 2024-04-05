package com.FishingLife.fishinglife.datagen;


import com.FishingLife.fishinglife.fishinglife;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PoiTypeTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.PoiTypeTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModPoiTypeTagsProvider extends PoiTypeTagsProvider {
    public ModPoiTypeTagsProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pProvider, fishinglife.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(PoiTypeTags.ACQUIRABLE_JOB_SITE)
                .addOptional(new ResourceLocation(fishinglife.MOD_ID, "jungle_fisherman_poi"))
                .addOptional(new ResourceLocation(fishinglife.MOD_ID, "general_fisherman_poi"))
         .addOptional(new ResourceLocation(fishinglife.MOD_ID, "desert_fisherman_poi"))
         .addOptional(new ResourceLocation(fishinglife.MOD_ID, "collector_poi"))
         .addOptional(new ResourceLocation(fishinglife.MOD_ID, "seafood_wholesale_merchant_poi"))
        .addOptional(new ResourceLocation(fishinglife.MOD_ID, "ocean_fisherman_poi"));


    }

}