package com.FishingLife.fishinglife.client.fishingHUD;

import com.FishingLife.fishinglife.client.fishingHUD.HUDOverlay.FishVitalityValue;
import com.FishingLife.fishinglife.client.fishingHUD.HUDOverlay.FishingLineLength;
import com.FishingLife.fishinglife.client.fishingHUD.HUDOverlay.FishingProcess;
import com.FishingLife.fishinglife.client.fishingHUD.HUDOverlay.FishingRodStrength;
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
    }

    public static void setInvisible(){
        FishingLineLength.changeshow(false);
        FishingRodStrength.changeshow(false);
        FishVitalityValue.changeshow(false);
        FishingProcess.changeshow(false);
    }

}
