package com.FishingLife.fishinglife.datagen;

import com.FishingLife.fishinglife.fishinglife;
import com.FishingLife.fishinglife.registry.FishingLifeItemsRegistry;
import com.FishingLife.fishinglife.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BannerPatternTagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModBannerTagGenerator extends BannerPatternTagsProvider {
    public ModBannerTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, fishinglife.MOD_ID, existingFileHelper);
    }
    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.BannersPattern.ANCHOR_PATTERN_TAG)
                .add(ResourceKey.create(Registries.BANNER_PATTERN, new ResourceLocation("fishinglife", "anchor")
                ));
        this.tag(ModTags.BannersPattern.PIRATE_PATTERN_TAG)
                .add(ResourceKey.create(Registries.BANNER_PATTERN, new ResourceLocation("fishinglife", "pirate")
                ));
        this.tag(ModTags.BannersPattern.SEASHELL_PATTERN_TAG)
                .add(ResourceKey.create(Registries.BANNER_PATTERN, new ResourceLocation("fishinglife", "seashell")
                ));
        this.tag(ModTags.BannersPattern.SHIP_PATTERN_TAG)
                .add(ResourceKey.create(Registries.BANNER_PATTERN, new ResourceLocation("fishinglife", "ship")
                ));
    }
}
