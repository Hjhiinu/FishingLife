package com.FishingLife.fishinglife.event;

import com.FishingLife.fishinglife.client.fishingHUD.HUDOverlay.FishingInteraction;
import com.FishingLife.fishinglife.fishinglife;
import com.FishingLife.fishinglife.util.Keybinding.KeyBinding;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ClientKeyBindingEvent {
    @Mod.EventBusSubscriber(modid = fishinglife.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            if(KeyBinding.LEFT_KEY.consumeClick()) {
                FishingInteraction.setPlayer_boundary_position_left();
            }
            if(KeyBinding.RIGHT_KEY.consumeClick()) {
                FishingInteraction.setPlayer_boundary_position_right();
            }
        }
    }

    @Mod.EventBusSubscriber(modid = fishinglife.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyBinding.LEFT_KEY);
            event.register(KeyBinding.RIGHT_KEY);
        }
    }
}
