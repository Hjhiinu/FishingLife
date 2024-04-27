package com.FishingLife.fishinglife.client.fishingHUD;

import com.FishingLife.fishinglife.client.fishingHUD.HUDOverlay.*;
import com.FishingLife.fishinglife.util.FishingGame.FishingGameFishLogicHandler;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class HUDIntegration {
    public static void allinit(){
        FishingLineLength.init();
        FishingRodStrength.init();
        FishVitalityValue.init();
        FishingProcess.init();
        FishingInteraction.init();
    }

    public static void setInvisible(){
        FishingLineLength.changeshow(false);
        FishingRodStrength.changeshow(false);
        FishVitalityValue.changeshow(false);
        FishingProcess.changeshow(false);
        FishingInteraction.changeshow(false);
    }

    public static void gamePre_init(){
        FishingGameFishLogicHandler.game_start_init();
    }

}
