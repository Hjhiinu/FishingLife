package com.FishingLife.fishinglife.registry;

import com.FishingLife.fishinglife.block.ModBlock;
import com.FishingLife.fishinglife.block.cropsBlock.*;
import com.FishingLife.fishinglife.block.utilBlock.Fermenter;
import com.FishingLife.fishinglife.block.utilBlock.FishingMachine;
import com.FishingLife.fishinglife.fishinglife;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class FishingLifeBlocksRegistry {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, fishinglife.MOD_ID);


    //General Block
    public static final RegistryObject<Block> JUNGLE_FISHERMAN_WORKBENCH= registerBlock("jungle_fisherman_workbench",
            () -> new ModBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion().sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> GENERAL_FISHERMAN_WORKBENCH= registerBlock("general_fisherman_workbench",
            () -> new ModBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion().sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> DESERT_FISHERMAN_WORKBENCH= registerBlock("desert_fisherman_workbench",
            () -> new ModBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion().sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> OCEAN_FISHERMAN_WORKBENCH= registerBlock("ocean_fisherman_workbench",
            () -> new ModBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion().sound(SoundType.AMETHYST)));


    //UtilBlock

    public static final RegistryObject<Block> FERMENTER = registerBlock("fermenter",
            () -> new Fermenter(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> FISHINGMACHINE = registerBlock("fishingmachine",
            () -> new FishingMachine(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).noOcclusion()));
    //CropBlock
    public static final RegistryObject<Block> SCALLION_CROP = BLOCKS.register("scallion_crop",
            () -> new ScallionCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));

    public static final RegistryObject<Block> GREEN_PEPPER_CROP = BLOCKS.register("green_pepper_crop",
            () -> new GreenPepperCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));

    public static final RegistryObject<Block> CHILI_PEPPER_CROP = BLOCKS.register("chili_pepper_crop",
            () -> new ChiliPepperCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));

    public static final RegistryObject<Block> SOYBEAN_CROP = BLOCKS.register("soybean_crop",
            () -> new SoybeanCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));

    public static final RegistryObject<Block> BOK_CHOY_CROP = BLOCKS.register("bok_choy_crop",
            () -> new BokChoyCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));

    public static final RegistryObject<Block> PADDY_CROP = BLOCKS.register("paddy_crop",
            () -> new PaddyCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;

    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return FishingLifeItemsRegistry.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
