package com.FishingLife.fishinglife.util;


import com.FishingLife.fishinglife.fishinglife;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditions;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
@Mod.EventBusSubscriber(modid = fishinglife.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class fishloothandler {
    @SubscribeEvent
    public static void registerFishies(RegisterEvent event) {
        if (event.getRegistryKey().equals(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS)) {
            fishinglife.BIOME_TAG_CHECK = LootItemConditions.register(new ResourceLocation(fishinglife.MOD_ID, "biome_tag_check").toString(), new BiomeTagCheck.BiomeTagCheckSerializer());
        }
    }
}
