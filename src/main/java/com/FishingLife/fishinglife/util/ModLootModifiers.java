/*package com.fisherman_alike.util;

import com.fisherman_alike.Fisherman_alike;
import com.mojang.serialization.Codec;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModLootModifiers {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Fisherman_alike.MOD_ID);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ARAPAIMA =
            LOOT_MODIFIER_SERIALIZERS.register("arapaima_fishing", ArapaimaModifier.CODEC);



    public static void register(IEventBus bus) {
        LOOT_MODIFIER_SERIALIZERS.register(bus);
    }

}

 */


