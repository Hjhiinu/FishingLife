package com.FishingLife.fishinglife.datagen;


import com.FishingLife.fishinglife.block.cropsBlock.ChiliPepperCropBlock;
import com.FishingLife.fishinglife.block.cropsBlock.GreenPepperCropBlock;
import com.FishingLife.fishinglife.block.cropsBlock.ScallionCropBlock;
import com.FishingLife.fishinglife.block.cropsBlock.SoybeanCropBlock;
import com.FishingLife.fishinglife.registry.FishingLifeBlocksRegistry;
import com.FishingLife.fishinglife.registry.FishingLifeItemsRegistry;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        //Normal Blocks

        this.dropSelf(FishingLifeBlocksRegistry.FERMENTER.get());
        this.dropSelf(FishingLifeBlocksRegistry.GENERAL_FISHERMAN_WORKBENCH.get());
        this.dropSelf(FishingLifeBlocksRegistry.JUNGLE_FISHERMAN_WORKBENCH.get());
        this.dropSelf(FishingLifeBlocksRegistry.DESERT_FISHERMAN_WORKBENCH.get());


        //Scallion
        LootItemCondition.Builder lootitemcondition$builder_scallion = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(FishingLifeBlocksRegistry.SCALLION_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ScallionCropBlock.AGE, 5));

        this.add(FishingLifeBlocksRegistry.SCALLION_CROP.get(), createCropDrops(FishingLifeBlocksRegistry.SCALLION_CROP.get(), FishingLifeItemsRegistry.SCALLION.get(),
                FishingLifeItemsRegistry.SCALLION_SEEDS.get(), lootitemcondition$builder_scallion));


        //Green Pepper
        LootItemCondition.Builder lootitemcondition$builder_green_pepper = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(FishingLifeBlocksRegistry.GREEN_PEPPER_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GreenPepperCropBlock.AGE, 5));

        this.add(FishingLifeBlocksRegistry.GREEN_PEPPER_CROP.get(), createCropDrops(FishingLifeBlocksRegistry.GREEN_PEPPER_CROP.get(), FishingLifeItemsRegistry.GREEN_PEPPER.get(),
                FishingLifeItemsRegistry.GREEN_PEPPER_SEEDS.get(), lootitemcondition$builder_green_pepper));

        //Chili Pepper
        LootItemCondition.Builder lootitemcondition$builder_chili_pepper = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(FishingLifeBlocksRegistry.CHILI_PEPPER_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ChiliPepperCropBlock.AGE, 5));

        this.add(FishingLifeBlocksRegistry.CHILI_PEPPER_CROP.get(), createCropDrops(FishingLifeBlocksRegistry.CHILI_PEPPER_CROP.get(), FishingLifeItemsRegistry.CHILI_PEPPER.get(),
                FishingLifeItemsRegistry.CHILI_PEPPER_SEEDS.get(), lootitemcondition$builder_chili_pepper));

        //Soybean
        LootItemCondition.Builder lootitemcondition$builder_soybean = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(FishingLifeBlocksRegistry.SOYBEAN_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SoybeanCropBlock.AGE, 5));

        this.add(FishingLifeBlocksRegistry.SOYBEAN_CROP.get(), createCropDrops(FishingLifeBlocksRegistry.SOYBEAN_CROP.get(), FishingLifeItemsRegistry.SOYBEAN.get(),
                FishingLifeItemsRegistry.SOYBEAN_SEEDS.get(), lootitemcondition$builder_soybean));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return FishingLifeBlocksRegistry.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}

