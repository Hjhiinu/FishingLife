package com.FishingLife.fishinglife.registry;

//import com.FishingLife.fishinglife.block.cropsBlock.ScallionCropBlock;
import com.FishingLife.fishinglife.block.cropsBlock.ChiliPepperCropBlock;
import com.FishingLife.fishinglife.block.cropsBlock.GreenPepperCropBlock;
import com.FishingLife.fishinglife.block.cropsBlock.ScallionCropBlock;
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



    //CropBlock
    public static final RegistryObject<Block> SCALLION_CROP = BLOCKS.register("scallion_crop",
            () -> new ScallionCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));

    public static final RegistryObject<Block> GREEN_PEPPER_CROP = BLOCKS.register("green_pepper_crop",
            () -> new GreenPepperCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));

    public static final RegistryObject<Block> CHILI_PEPPER_CROP = BLOCKS.register("chili_pepper_crop",
            () -> new ChiliPepperCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));



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
