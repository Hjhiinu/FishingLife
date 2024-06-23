package com.FishingLife.fishinglife;

import com.FishingLife.fishinglife.GUIscreen.FermenterScreen;
import com.FishingLife.fishinglife.GUIscreen.FishingMachineScreen;
import com.FishingLife.fishinglife.GUIscreen.ModMenuTypes;
import com.FishingLife.fishinglife.ModVillager.ModVillagers;
import com.FishingLife.fishinglife.Modrecipe.ModRecipes;

import com.FishingLife.fishinglife.block.entity.ModBlockEntities;
import com.FishingLife.fishinglife.config.FishingLifeConfig;
import com.FishingLife.fishinglife.entity.ModEntity;
import com.FishingLife.fishinglife.item.ArmorItem.ArmorEffectHandler;
import com.FishingLife.fishinglife.loot.ModLootModifiers;
import com.FishingLife.fishinglife.registry.*;
import com.FishingLife.fishinglife.util.FishingGame.FishingGameFishLogicHandler;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.VillagerRenderer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.*;

import org.slf4j.Logger;



// The value here should match an entry in the META-INF/mods.toml file
@Mod(fishinglife.MOD_ID)
public class fishinglife
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "fishinglife";

    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public static LootItemConditionType BIOME_TAG_CHECK;





    public fishinglife()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading


        modEventBus.addListener(this::commonSetup);


        ModLootModifiers.register(modEventBus);
        FishingLifeCreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);
        FishingLifeItemsRegistry.ITEMS.register(modEventBus);
        FishingLifeBlocksRegistry.BLOCKS.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModRecipes.register(modEventBus);
        ModVillagers.register(modEventBus);
        ModEntity.register(modEventBus);
        ModBannerPatterns.register(modEventBus);
        modEventBus.register(FishingLifePotionRecipeRegistry.class);
        MinecraftForge.EVENT_BUS.register(new ArmorEffectHandler());

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
      //  ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, FishingLifeConfig.SPEC,"fishinglife-common.toml");

    }



    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }


    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());

            EntityRenderers.register(ModEntity.NEWVILLAGER.get(), VillagerRenderer::new);
            MenuScreens.register(ModMenuTypes.FERMENTER_MENU.get(), FermenterScreen::new);
            MenuScreens.register(ModMenuTypes.FISHING_MACHINE_MENU.get(), FishingMachineScreen::new);

            FishingGameFishLogicHandler.Init_randomNumberDivisibleByThree();
        }
    }

}
