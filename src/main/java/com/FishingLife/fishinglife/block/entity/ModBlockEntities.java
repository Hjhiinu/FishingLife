package com.FishingLife.fishinglife.block.entity;

import com.FishingLife.fishinglife.fishinglife;
import com.FishingLife.fishinglife.registry.FishingLifeBlocksRegistry;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, fishinglife.MOD_ID);

    public static final RegistryObject<BlockEntityType<FermenterBlockEntity>> FERMENTATION_PROCESS_BE =
            BLOCK_ENTITIES.register("fermentation_process_be", () ->
                    BlockEntityType.Builder.of(FermenterBlockEntity::new,
                            FishingLifeBlocksRegistry.FERMENTER.get()).build(null));

    public static final RegistryObject<BlockEntityType<FishingMachineBlockEntity>> FISHINGMACHINE_PROCESS_BE =
            BLOCK_ENTITIES.register("fishingmachine_process_be", () ->
                    BlockEntityType.Builder.of(FishingMachineBlockEntity::new,
                            FishingLifeBlocksRegistry.FISHINGMACHINE.get()).build(null));



    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
