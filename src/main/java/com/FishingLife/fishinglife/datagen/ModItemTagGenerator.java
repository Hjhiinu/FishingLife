package com.FishingLife.fishinglife.datagen;

import com.FishingLife.fishinglife.fishinglife;
import com.FishingLife.fishinglife.registry.FishingLifeItemsRegistry;
import com.FishingLife.fishinglife.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
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
        this.tag(ModTags.Items.FISHING_TRASH)
                .add(Items.LEATHER_BOOTS,
                        Items.LEATHER,
                        Items.BONE,
                        Items.STRING,
                        Items.ROTTEN_FLESH,
                        Items.STICK,
                        Items.BOWL,
                        Items.POTION,
                        Items.INK_SAC,
                        Items.TRIPWIRE_HOOK,
                        Items.LILY_PAD,
                        FishingLifeItemsRegistry.SCALLION_SEEDS.get(),
                        FishingLifeItemsRegistry.GREEN_PEPPER_SEEDS.get(),
                        FishingLifeItemsRegistry.CHILI_PEPPER_SEEDS.get(),
                        FishingLifeItemsRegistry.SOYBEAN_SEEDS.get(),
                        FishingLifeItemsRegistry.BOK_CHOY_SEEDS.get(),
                        FishingLifeItemsRegistry.PADDY_SEEDS.get(),
                        FishingLifeItemsRegistry.PLASTIC_TRASH.get());

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
        this.tag(ModTags.Items.CAVE_FISHES).add(
                FishingLifeItemsRegistry.MEXICAN_TETRA.get(),
                FishingLifeItemsRegistry.MADAGASCAR_BLIND_CAVE_FISH.get(),
                FishingLifeItemsRegistry.TROGLOGLANIS_PATTERSONI.get(),
                FishingLifeItemsRegistry.TOOTHLESS_BLIND_CAT.get(),
                FishingLifeItemsRegistry.BLIND_CAVE_FISH.get()

                );
        this.tag(ModTags.Items.CRAB).add(
            FishingLifeItemsRegistry.SWIMMING_CRAB.get(),
            FishingLifeItemsRegistry.SOFT_SHELL_CRAB.get(),
            FishingLifeItemsRegistry.EUROPEAN_GREEN_CRAB.get(),
            FishingLifeItemsRegistry.STONE_CRAB.get(),
            FishingLifeItemsRegistry.SNOW_CRAB.get(),
            FishingLifeItemsRegistry.MUD_CRAB.get(),
            FishingLifeItemsRegistry.RED_ROCK_CRAB.get(),
            FishingLifeItemsRegistry.DUNGENESS_CRAB.get(),
            FishingLifeItemsRegistry.BLUE_CRAB.get()
        );

        this.tag(ModTags.Items.SEA_URCHIN).add(
            FishingLifeItemsRegistry.PURPLE_SEA_URCHIN.get(),
            FishingLifeItemsRegistry.SLATE_PENCIL_URCHIN.get(),
            FishingLifeItemsRegistry.WHITE_SEA_URCHIN.get(),
            FishingLifeItemsRegistry.GREEN_SEA_URCHIN.get(),
            FishingLifeItemsRegistry.RED_SEA_URCHIN.get()
        );

        this.tag(ModTags.Items.SHRIMP).add(
            FishingLifeItemsRegistry.PINK_SHRIMP.get(),
            FishingLifeItemsRegistry.BLUE_SHRIMP.get(),
        FishingLifeItemsRegistry.SPOT_PRAWN.get(),
        FishingLifeItemsRegistry.NORTHERN_SHRIMP.get(),
        FishingLifeItemsRegistry.WHITE_SHRIMP.get(),
        FishingLifeItemsRegistry.TIGER_SHRIMP.get(),
        FishingLifeItemsRegistry.PACIFIC_WHITE_SHRIMP.get()

        );
        this.tag(ModTags.Items.RAW_MEAT)
                .add(Items.BEEF,
                        Items.PORKCHOP,
                        Items.COD,
                        Items.SALMON,
                        Items.MUTTON,
                        Items.RABBIT,
                        Items.ROTTEN_FLESH,
                        Items.TROPICAL_FISH,
                        Items.PUFFERFISH,
                        FishingLifeItemsRegistry.ARAPAIMA_GIGAS.get(),
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
                        FishingLifeItemsRegistry.STRIPED_BEAKFISH.get(),

                        FishingLifeItemsRegistry.BLACK_SCRAPER.get(),
                        FishingLifeItemsRegistry.HAIRTAIL.get(),
                        FishingLifeItemsRegistry.MACKEREL.get(),
                        FishingLifeItemsRegistry.PACIFIC_SAURY.get(),
                        FishingLifeItemsRegistry.POMFRET.get(),
                        FishingLifeItemsRegistry.RED_HORSEHEAD_FISH.get(),
                        FishingLifeItemsRegistry.RED_SNAPPER.get(),
                        FishingLifeItemsRegistry.SARDINE.get(),
                        FishingLifeItemsRegistry.SOLE_FISH.get(),
                        FishingLifeItemsRegistry.YELLOW_CROAKER.get(),

                        FishingLifeItemsRegistry.WHITE_HAKE.get(),
                        FishingLifeItemsRegistry.CAPELIN.get(),
                        FishingLifeItemsRegistry.ARCTIC_SKATE.get(),
                        FishingLifeItemsRegistry.ALASKA_POLLOCK.get(),
                        FishingLifeItemsRegistry.RAINBOW_TROUT.get(),
                        FishingLifeItemsRegistry.ARCTIC_CHAR.get(),
                        FishingLifeItemsRegistry.HADDOCK.get(),
                        FishingLifeItemsRegistry.ATLANTIC_COD.get(),
                        FishingLifeItemsRegistry.FOURHORN_SCULPIN.get(),

                        FishingLifeItemsRegistry.MEXICAN_TETRA.get(),
                        FishingLifeItemsRegistry.MADAGASCAR_BLIND_CAVE_FISH.get(),
                        FishingLifeItemsRegistry.TROGLOGLANIS_PATTERSONI.get(),
                        FishingLifeItemsRegistry.TOOTHLESS_BLIND_CAT.get(),
                        FishingLifeItemsRegistry.BLIND_CAVE_FISH.get()

                        );


        this.tag(ModTags.Items.CROPS)
                .add(FishingLifeItemsRegistry.SCALLION.get(),
                        FishingLifeItemsRegistry.GREEN_PEPPER.get(),
                        FishingLifeItemsRegistry.CHILI_PEPPER.get(),
                        FishingLifeItemsRegistry.SOYBEAN.get(),
                        FishingLifeItemsRegistry.BOK_CHOY.get(),
                        FishingLifeItemsRegistry.PADDY.get()




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
                        FishingLifeItemsRegistry.STRIPED_BEAKFISH.get(),

                        FishingLifeItemsRegistry.BLACK_SCRAPER.get(),
                        FishingLifeItemsRegistry.HAIRTAIL.get(),
                        FishingLifeItemsRegistry.MACKEREL.get(),
                        FishingLifeItemsRegistry.PACIFIC_SAURY.get(),
                        FishingLifeItemsRegistry.POMFRET.get(),
                        FishingLifeItemsRegistry.RED_HORSEHEAD_FISH.get(),
                        FishingLifeItemsRegistry.RED_SNAPPER.get(),
                        FishingLifeItemsRegistry.SARDINE.get(),
                        FishingLifeItemsRegistry.SOLE_FISH.get(),
                        FishingLifeItemsRegistry.YELLOW_CROAKER.get(),

                        FishingLifeItemsRegistry.WHITE_HAKE.get(),
                        FishingLifeItemsRegistry.CAPELIN.get(),
                        FishingLifeItemsRegistry.ARCTIC_SKATE.get(),
                        FishingLifeItemsRegistry.ALASKA_POLLOCK.get(),
                        FishingLifeItemsRegistry.RAINBOW_TROUT.get(),
                        FishingLifeItemsRegistry.ARCTIC_CHAR.get(),
                        FishingLifeItemsRegistry.HADDOCK.get(),
                        FishingLifeItemsRegistry.ATLANTIC_COD.get(),
                        FishingLifeItemsRegistry.FOURHORN_SCULPIN.get(),

                        FishingLifeItemsRegistry.MEXICAN_TETRA.get(),
                        FishingLifeItemsRegistry.MADAGASCAR_BLIND_CAVE_FISH.get(),
                        FishingLifeItemsRegistry.TROGLOGLANIS_PATTERSONI.get(),
                        FishingLifeItemsRegistry.TOOTHLESS_BLIND_CAT.get(),
                        FishingLifeItemsRegistry.BLIND_CAVE_FISH.get()





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
        this.tag(ModTags.Items.GENERAL_OCEAN_FISHES)
                .add(FishingLifeItemsRegistry.BLACK_SCRAPER.get(),
                        FishingLifeItemsRegistry.HAIRTAIL.get(),
                        FishingLifeItemsRegistry.MACKEREL.get(),
                        FishingLifeItemsRegistry.PACIFIC_SAURY.get(),
                        FishingLifeItemsRegistry.POMFRET.get(),
                        FishingLifeItemsRegistry.RED_HORSEHEAD_FISH.get(),
                        FishingLifeItemsRegistry.RED_SNAPPER.get(),
                        FishingLifeItemsRegistry.SARDINE.get(),
                        FishingLifeItemsRegistry.SOLE_FISH.get(),
                        FishingLifeItemsRegistry.YELLOW_CROAKER.get());

        this.tag(ModTags.Items.COLD_OCEAN_FISHES)
                .add(FishingLifeItemsRegistry.WHITE_HAKE.get(),
                        FishingLifeItemsRegistry.CAPELIN.get(),
                        FishingLifeItemsRegistry.ARCTIC_SKATE.get(),
                        FishingLifeItemsRegistry.ALASKA_POLLOCK.get(),
                        FishingLifeItemsRegistry.RAINBOW_TROUT.get(),
                        FishingLifeItemsRegistry.ARCTIC_CHAR.get(),
                        FishingLifeItemsRegistry.HADDOCK.get(),
                        FishingLifeItemsRegistry.ATLANTIC_COD.get(),
                        FishingLifeItemsRegistry.FOURHORN_SCULPIN.get()
                        );
        this.tag(ModTags.Items.BIG_FISHES)
                .add(FishingLifeItemsRegistry.ARAPAIMA_GIGAS.get(),
                        FishingLifeItemsRegistry.SILVER_AROWANA.get(),
                        FishingLifeItemsRegistry.HYDROLYCUS_ARMATUS.get(),
                        FishingLifeItemsRegistry.PEACOCK_BASS.get(),
                        FishingLifeItemsRegistry.NILE_PERCH.get(),
                        FishingLifeItemsRegistry.MAHI_MAHI.get(),
                        FishingLifeItemsRegistry.LUTJANUS_SEBAE.get(),
                        FishingLifeItemsRegistry.PAMPUS_ARGENTEUS.get(),
                        FishingLifeItemsRegistry.PARROTFISH.get(),
                        FishingLifeItemsRegistry.PSETTA_MAXIMA.get(),
                        FishingLifeItemsRegistry.LONGNOSE_GAR.get(),
                        FishingLifeItemsRegistry.SHORTNOSE_GAR.get(),
                        FishingLifeItemsRegistry.BLACK_SCRAPER.get(),
                        FishingLifeItemsRegistry.HAIRTAIL.get(),
                        FishingLifeItemsRegistry.POMFRET.get(),
                        FishingLifeItemsRegistry.RED_HORSEHEAD_FISH.get(),
                        FishingLifeItemsRegistry.RED_SNAPPER.get(),
                        FishingLifeItemsRegistry.ALASKA_POLLOCK.get(),
                        FishingLifeItemsRegistry.ATLANTIC_COD.get(),
                        FishingLifeItemsRegistry.HADDOCK.get(),
                        FishingLifeItemsRegistry.TROGLOGLANIS_PATTERSONI.get()

                        );
        this.tag(ModTags.Items.MEDIUM_FISHES)
                .add(FishingLifeItemsRegistry.BRYCON_HILARII.get(),
                        FishingLifeItemsRegistry.SALMINUS.get(),
                        FishingLifeItemsRegistry.PIRANHA.get(),
                        FishingLifeItemsRegistry.ACANTHODORAS.get(),
                        FishingLifeItemsRegistry.ELECTRIC_EEL.get(),
                        FishingLifeItemsRegistry.PANCAKE_STINGRAYS.get(),
                        FishingLifeItemsRegistry.DISCUS.get(),
                        FishingLifeItemsRegistry.ELEPHANT_FISH.get(),
                        FishingLifeItemsRegistry.PANAQUE.get(),
                        FishingLifeItemsRegistry.COMMON_CARP.get(),
                        FishingLifeItemsRegistry.LAKE_WHITEFISH.get(),
                        FishingLifeItemsRegistry.AMERICAN_SHAD.get(),
                        FishingLifeItemsRegistry.BLACK_CRAPPIE.get(),
                        FishingLifeItemsRegistry.BROOK_TROUT.get(),
                        FishingLifeItemsRegistry.EUROPEAN_PERCH.get(),
                        FishingLifeItemsRegistry.KOI.get(),
                        FishingLifeItemsRegistry.MUSKELLUNGE.get(),
                        FishingLifeItemsRegistry.TENCH.get(),
                        FishingLifeItemsRegistry.WALLEYE.get(),
                        FishingLifeItemsRegistry.AFRICAN_BARB.get(),
                        FishingLifeItemsRegistry.AFRICAN_DESERT_CATFISH.get(),
                        FishingLifeItemsRegistry.AUSTRALIAN_DESERT_GOBY.get(),
                        FishingLifeItemsRegistry.HIGHLAND_SWORDTAIL.get(),
                        FishingLifeItemsRegistry.CRIMSON_SNAPPER.get(),
                        FishingLifeItemsRegistry.FLYINGFISH.get(),
                        FishingLifeItemsRegistry.STRIPED_BEAKFISH.get(),
                        FishingLifeItemsRegistry.RAINBOW_FISH.get(),
                        FishingLifeItemsRegistry.MACKEREL.get(),
                        FishingLifeItemsRegistry.PACIFIC_SAURY.get(),
                        FishingLifeItemsRegistry.YELLOW_CROAKER.get(),
                        FishingLifeItemsRegistry.ARCTIC_CHAR.get(),
                        FishingLifeItemsRegistry.RAINBOW_TROUT.get(),
                        FishingLifeItemsRegistry.FOURHORN_SCULPIN.get(),
                        FishingLifeItemsRegistry.MEXICAN_TETRA.get(),
                        FishingLifeItemsRegistry.MADAGASCAR_BLIND_CAVE_FISH.get(),
                        FishingLifeItemsRegistry.TOOTHLESS_BLIND_CAT.get()
                        );
        this.tag(ModTags.Items.SMALL_FISHES)
                .add(FishingLifeItemsRegistry.CETOPSIDIUM.get(),
                        FishingLifeItemsRegistry.ORANGESPOTTED_SUNFISH.get(),
                        FishingLifeItemsRegistry.EUROPEAN_GRAYLING.get(),
                        FishingLifeItemsRegistry.PUMPKINSEED_SUNFISH.get(),
                        FishingLifeItemsRegistry.AFRICAN_LUNGFISH.get(),
                        FishingLifeItemsRegistry.DESERT_ZEBRAFISH.get(),
                        FishingLifeItemsRegistry.EGYPTIAN_MOUTHBROODER.get(),
                        FishingLifeItemsRegistry.NOTHOBRANCHIUS_FURZERI.get(),
                        FishingLifeItemsRegistry.ANCHOVY.get(),
                        FishingLifeItemsRegistry.SARDINE.get(),
                        FishingLifeItemsRegistry.SOLE_FISH.get(),
                        FishingLifeItemsRegistry.WHITE_HAKE.get(),
                        FishingLifeItemsRegistry.CAPELIN.get(),
                        FishingLifeItemsRegistry.ARCTIC_SKATE.get(),
                        FishingLifeItemsRegistry.BLIND_CAVE_FISH.get()
                        );
    }
}
