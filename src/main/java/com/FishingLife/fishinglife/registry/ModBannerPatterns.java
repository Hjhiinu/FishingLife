package com.FishingLife.fishinglife.registry;

import com.FishingLife.fishinglife.fishinglife;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraft.world.level.block.entity.BannerPattern.Builder;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBannerPatterns {
    public static final DeferredRegister<BannerPattern> BANNER_PATTERNS = DeferredRegister.create(Registries.BANNER_PATTERN, "fishinglife");

    public static final RegistryObject<BannerPattern> ANCHOR_PATTERN = BANNER_PATTERNS.register("anchor", () -> new BannerPattern("anchor"));
    public static final RegistryObject<BannerPattern> SEASHELL_PATTERN = BANNER_PATTERNS.register("seashell", () -> new BannerPattern("seashell"));
    public static final RegistryObject<BannerPattern> PIRATE_PATTERN = BANNER_PATTERNS.register("pirate", () -> new BannerPattern("pirate"));
    public static final RegistryObject<BannerPattern> SHIP_PATTERN = BANNER_PATTERNS.register("ship", () -> new BannerPattern("ship"));

    public static void register(IEventBus eventBus){
            BANNER_PATTERNS.register(eventBus);
    }

}