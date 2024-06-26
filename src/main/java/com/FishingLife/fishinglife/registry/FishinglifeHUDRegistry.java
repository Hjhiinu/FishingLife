package com.FishingLife.fishinglife.registry;

import com.FishingLife.fishinglife.client.fishingHUD.HUDOverlay.*;
import com.FishingLife.fishinglife.fishinglife;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class FishinglifeHUDRegistry {
    @Mod.EventBusSubscriber(modid = fishinglife.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {

        @SubscribeEvent
        public static void registerGuiOverlays(RegisterGuiOverlaysEvent event) {
            event.registerAboveAll("fish_vitality", FishVitalityValue.HUD_Fish_Vitality);
            event.registerAboveAll("fishingrod_strength", FishingRodStrength.HUD_FISHINGROD_STRENGTH);
            event.registerAboveAll("fishingline_length", FishingLineLength.HUD_FISHINGLINE_LENGTH);
            event.registerAboveAll("fishing_time", FishingProcess.HUD_TIME);
            event.registerAboveAll("fishing_core", FishingInteraction.HUD_FISHING_CORE);
        }
    }
}
