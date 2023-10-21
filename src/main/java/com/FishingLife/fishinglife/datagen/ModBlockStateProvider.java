package com.FishingLife.fishinglife.datagen;

import com.FishingLife.fishinglife.block.cropsBlock.ChiliPepperCropBlock;
import com.FishingLife.fishinglife.block.cropsBlock.GreenPepperCropBlock;
import com.FishingLife.fishinglife.block.cropsBlock.ScallionCropBlock;
import com.FishingLife.fishinglife.fishinglife;

import com.FishingLife.fishinglife.registry.FishingLifeBlocksRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;



public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, fishinglife.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        //Normal Blocks
        simpleBlockWithItem(FishingLifeBlocksRegistry.FERMENTER.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/fermenter")));
        //Crop  Blocks
        makeScallionCrop((CropBlock) FishingLifeBlocksRegistry.SCALLION_CROP.get(), "scallion_stage", "scallion_stage");
        makeGreenPepperCrop((CropBlock) FishingLifeBlocksRegistry.GREEN_PEPPER_CROP.get(), "green_pepper_stage", "green_pepper_stage");
        makeChiliPepperCrop((CropBlock) FishingLifeBlocksRegistry.CHILI_PEPPER_CROP.get(), "chili_pepper_stage", "chili_pepper_stage");
    }






    //Scallion
    public void makeScallionCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> scallionStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }
    private ConfiguredModel[] scallionStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((ScallionCropBlock) block).getAgeProperty()),
                new ResourceLocation(fishinglife.MOD_ID, "block/" + textureName + state.getValue(((ScallionCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }
    //Green Pepper
    public void makeGreenPepperCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> greenpepperStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }
    private ConfiguredModel[] greenpepperStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((GreenPepperCropBlock) block).getAgeProperty()),
                new ResourceLocation(fishinglife.MOD_ID, "block/" + textureName + state.getValue(((GreenPepperCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }
    //Chili Pepper
    public void makeChiliPepperCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> chilipepperStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }
    private ConfiguredModel[] chilipepperStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((ChiliPepperCropBlock) block).getAgeProperty()),
                new ResourceLocation(fishinglife.MOD_ID, "block/" + textureName + state.getValue(((ChiliPepperCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }







    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
