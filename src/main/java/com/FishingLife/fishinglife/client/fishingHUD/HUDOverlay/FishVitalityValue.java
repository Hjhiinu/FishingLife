package com.FishingLife.fishinglife.client.fishingHUD.HUDOverlay;

import com.FishingLife.fishinglife.fishinglife;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;


public class FishVitalityValue {

    private static boolean show=false;
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
    public static final IGuiOverlay HUD_Fish_Vitality = ((gui, poseStack, partialTick, width, height) -> {
        if(show) {
            int x = width / 2;
            int y = height;
            int y_temp = height / 2;

            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            // RenderSystem.setShaderTexture(0, EMPTY_Vitality_Value);
            for (int i = 0; i < 10; i++) {
                poseStack.blit(FILLED_Vitality_Value, x - 94 + (i * 9), y - 54 - y_temp - 40, 0, 0, 12, 12,
                        12, 12);
            }

            poseStack.blit(Vitality_ICON, x - 94 - 18, y - 54 - y_temp - 40, 0, 0, 12, 12,
                    12, 12);
        }
    });
}
