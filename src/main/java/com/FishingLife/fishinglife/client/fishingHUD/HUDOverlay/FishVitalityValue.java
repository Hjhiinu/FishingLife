package com.FishingLife.fishinglife.client.fishingHUD.HUDOverlay;

import com.FishingLife.fishinglife.capability.fishingMechanism.IntegrationProvider;
import com.FishingLife.fishinglife.fishinglife;
import com.FishingLife.fishinglife.item.ItemUtil.fishingrodPlayerDataUtil;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class FishVitalityValue {
    private static final Logger LOGGER = LogManager.getLogger();
    private static boolean show=false;

    private static int processphase;
    private static final ResourceLocation FILLED_Vitality_Value = new ResourceLocation(fishinglife.MOD_ID,
            "textures/fishinghud/energy_filled.png");
    private static final ResourceLocation EMPTY_Vitality_Value = new ResourceLocation(fishinglife.MOD_ID,
            "textures/fishinghud/energy_empty.png");
    private static final ResourceLocation Vitality_ICON = new ResourceLocation(fishinglife.MOD_ID,
            "textures/fishinghud/energy_icon.png");

    public static void changeshow(boolean now){
        FishVitalityValue.show=now;
    }
    public static void init(){
        FishVitalityValue.show=true;
    }

    public static void set( int p) {
        FishVitalityValue.processphase= p;
    }
    public static final IGuiOverlay HUD_Fish_Vitality = ((gui, poseStack, partialTick, width, height) -> {
        if(show) {
            Player pPlayer=fishingrodPlayerDataUtil.getplayer();
            pPlayer.getCapability(IntegrationProvider.FISHING_INTEGRATION).ifPresent(fishing -> {
                //total 10 phase
                if(fishing.getFish_vitality()==500){
                    FishVitalityValue.set(10);
                }
                else if(fishing.getFish_vitality()!=0){//Vitality
                    FishVitalityValue.set(fishing.getFish_vitality()/50+1);
                }
                else{
                    FishVitalityValue.set(0);
                }
            });

            int x = width / 2;
            int y = height;
            int y_temp = height / 2;
            //LOGGER.info("HUD Tick")
            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            // RenderSystem.setShaderTexture(0, EMPTY_Vitality_Value);
            for (int i = 0; i <10; i++) {
                if(processphase>i) {
                    poseStack.blit(FILLED_Vitality_Value, x - 94 + (i * 9), y - 54 - y_temp - 40, 0, 0, 12, 12,
                            12, 12);
                }
            }
            poseStack.blit(Vitality_ICON, x - 94 - 18, y - 54 - y_temp - 40, 0, 0, 12, 12,
                    12, 12);
        }
    });
}
