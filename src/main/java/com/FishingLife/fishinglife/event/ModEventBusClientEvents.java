package com.FishingLife.fishinglife.event;

import com.FishingLife.fishinglife.block.entity.ModBlockEntities;
import com.FishingLife.fishinglife.block.entity.renderer.ChoppingBoardBlockEntityRenderer;
import com.FishingLife.fishinglife.fishinglife;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.client.event.EntityRenderersEvent;

@Mod.EventBusSubscriber(modid = fishinglife.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {

    @SubscribeEvent
    public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.CHOPPING_BOARD_PROCESS_BE.get(), ChoppingBoardBlockEntityRenderer::new);
    }
}
