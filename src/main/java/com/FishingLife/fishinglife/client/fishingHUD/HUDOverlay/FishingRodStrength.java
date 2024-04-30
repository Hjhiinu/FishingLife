package com.FishingLife.fishinglife.client.fishingHUD.HUDOverlay;

import com.FishingLife.fishinglife.fishinglife;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class FishingRodStrength{

    private static boolean show=false;

    private static boolean False=false;
    private static final ResourceLocation FILLED_STRENGTH_Value = new ResourceLocation(fishinglife.MOD_ID,
            "textures/fishinghud/processbar_full.png");
    private static final ResourceLocation EMPTY_STRENGTH_Value = new ResourceLocation(fishinglife.MOD_ID,
            "textures/fishinghud/processbar.png");
    private static final ResourceLocation ICON = new ResourceLocation(fishinglife.MOD_ID,
            "textures/fishinghud/fishingrod_strength_icon.png");
    public static void changeshow(boolean now){
        FishingRodStrength.show=now;
    }
    public static void init(){
        FishingRodStrength.show=true;
    }
    public static final IGuiOverlay HUD_FISHINGROD_STRENGTH = ((gui, poseStack, partialTick, width, height) -> {
        if(False) {
            int x = width / 2;
            int y = height;
            int y_temp = height / 2;

            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            // RenderSystem.setShaderTexture(0, EMPTY_Vitality_Value);
            for (int i = 0; i < 10; i++) {
                poseStack.blit(FILLED_STRENGTH_Value, x - 94 + (i * 9), y - 54 - y_temp - 26, 0, 0, 12, 12,
                        12, 12);
            }

            poseStack.blit(ICON, x - 94 - 18, y - 54 - y_temp - 26, 0, 0, 12, 12,
                    12, 12);
        }
    });

}


