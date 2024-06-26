package com.FishingLife.fishinglife.ModVillager;

import com.FishingLife.fishinglife.fishinglife;
import com.FishingLife.fishinglife.registry.FishingLifeBlocksRegistry;
import com.google.common.collect.ImmutableSet;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, fishinglife.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, fishinglife.MOD_ID);
    public static final RegistryObject<PoiType> JUNGLE_FISHERMAN_POI = POI_TYPES.register("jungle_fisherman_poi",
            () -> new PoiType(ImmutableSet.copyOf(FishingLifeBlocksRegistry.JUNGLE_FISHERMAN_WORKBENCH.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<PoiType> DESERT_FISHERMAN_POI = POI_TYPES.register("desert_fisherman_poi",
            () -> new PoiType(ImmutableSet.copyOf(FishingLifeBlocksRegistry.DESERT_FISHERMAN_WORKBENCH.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<PoiType> GENERAL_FISHERMAN_POI = POI_TYPES.register("general_fisherman_poi",
            () -> new PoiType(ImmutableSet.copyOf(FishingLifeBlocksRegistry.GENERAL_FISHERMAN_WORKBENCH.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<PoiType> COLLECTOR_POI = POI_TYPES.register("collector_poi",
            () -> new PoiType(ImmutableSet.copyOf(Blocks.AMETHYST_BLOCK.getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<PoiType> SEAEFOOD_WHOLESALE_MERCHANT_POI = POI_TYPES.register("seafood_wholesale_merchant_poi",
            () -> new PoiType(ImmutableSet.copyOf(FishingLifeBlocksRegistry.FISHINGMACHINE.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<PoiType> OCEAN_FISHERMAN_POI = POI_TYPES.register("ocean_fisherman_poi",
            () -> new PoiType(ImmutableSet.copyOf(FishingLifeBlocksRegistry.OCEAN_FISHERMAN_WORKBENCH.get().getStateDefinition().getPossibleStates()),
                    1, 1));




    /////////////////////////////////////////////////
    public static final RegistryObject<VillagerProfession> JUNGLE_FISHERMAN =
            VILLAGER_PROFESSIONS.register("jungle_fisherman", () -> new VillagerProfession("jungle_fisherman",
                    holder -> holder.get() == JUNGLE_FISHERMAN_POI.get(), holder -> holder.get() == JUNGLE_FISHERMAN_POI.get(),
                    ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_FISHERMAN));

    public static final RegistryObject<VillagerProfession> DESERT_FISHERMAN =
            VILLAGER_PROFESSIONS.register("desert_fisherman", () -> new VillagerProfession("desert_fisherman",
                    holder -> holder.get() == DESERT_FISHERMAN_POI.get(), holder -> holder.get() == DESERT_FISHERMAN_POI.get(),
                    ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_FISHERMAN));

    public static final RegistryObject<VillagerProfession> GENERAL_FISHERMAN =
            VILLAGER_PROFESSIONS.register("general_fisherman", () -> new VillagerProfession("general_fisherman",
                    holder -> holder.get() == GENERAL_FISHERMAN_POI.get(), holder -> holder.get() == GENERAL_FISHERMAN_POI.get(),
                    ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_FISHERMAN));

    public static final RegistryObject<VillagerProfession> COLLECTOR =
            VILLAGER_PROFESSIONS.register("collector", () -> new VillagerProfession("collector",
                    holder -> holder.get() == COLLECTOR_POI.get(), holder -> holder.get() == COLLECTOR_POI.get(),
                    ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_LIBRARIAN));

    public static final RegistryObject<VillagerProfession> SEAEFOOD_WHOLESALE_MERCHANT =
            VILLAGER_PROFESSIONS.register("seafood_wholesale_merchant", () -> new VillagerProfession("seafood_wholesale_merchant",
                    holder -> holder.get() == SEAEFOOD_WHOLESALE_MERCHANT_POI.get(), holder -> holder.get() == SEAEFOOD_WHOLESALE_MERCHANT_POI.get(),
                    ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_FISHERMAN));

    public static final RegistryObject<VillagerProfession> OCEAN_FISHERMAN =
            VILLAGER_PROFESSIONS.register("ocean_fisherman", () -> new VillagerProfession("ocean_fisherman",
                    holder -> holder.get() == OCEAN_FISHERMAN_POI.get(), holder -> holder.get() == OCEAN_FISHERMAN_POI.get(),
                    ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_FISHERMAN));





    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
