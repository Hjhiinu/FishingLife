package com.FishingLife.fishinglife.client.fishingHUD.HUDOverlay;

import com.FishingLife.fishinglife.capability.fishingMechanism.IntegrationProvider;
import com.FishingLife.fishinglife.fishinglife;
import com.FishingLife.fishinglife.item.ItemUtil.fishingrodPlayerDataUtil;
import com.FishingLife.fishinglife.util.FishingGame.FishingGameFishLogicHandler;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class FishingLineLength {
    private static boolean show=false;
    private static int processphase;
    private static final ResourceLocation FILLED_LENGTH_Value = new ResourceLocation(fishinglife.MOD_ID,
            "textures/fishinghud/string_length_full.png");
    private static final ResourceLocation BLUE_LINE = new ResourceLocation(fishinglife.MOD_ID,
            "textures/fishinghud/blue_line.png");
    private static final ResourceLocation RED_LINE = new ResourceLocation(fishinglife.MOD_ID,
            "textures/fishinghud/red_line.png");
    private static final ResourceLocation EMPTY_LENGTH_Value = new ResourceLocation(fishinglife.MOD_ID,
            "textures/fishinghud/processbar.png");

    private static final ResourceLocation ICON = new ResourceLocation(fishinglife.MOD_ID,
            "textures/fishinghud/fishing_line_icon.png");

    public static void changeshow(boolean now){
        FishingLineLength.show=now;
    }
    public static void init(){
        FishingLineLength.show=true;
    }
    public static void set(int p) {
        FishingLineLength.processphase= p;
    }

    public static final IGuiOverlay HUD_FISHINGLINE_LENGTH = ((gui, poseStack, partialTick, width, height) -> {
        if(show) {
            int x = width / 2;
            int y = height;
            int y_temp = height / 2;

            Player pPlayer=fishingrodPlayerDataUtil.getplayer();
            pPlayer.getCapability(IntegrationProvider.FISHING_INTEGRATION).ifPresent(fishing -> {
                //total 13 phase
                if(fishing.getFishingline_strength()==130){
                    FishingLineLength.set(13);
                }
                else if(fishing.getFishingline_strength()!=0){//Vitality
                    FishingLineLength.set(fishing.getFishingline_strength()/10+1);
                }
                else{
                    FishingLineLength.set(0);
                }
            });

            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            // RenderSystem.setShaderTexture(0, EMPTY_Vitality_Value);
            for (int i = 0; i <13; i++) {
                if(processphase>i) {
                    poseStack.blit(FILLED_LENGTH_Value, x - 94 + (i * 9), y - 54 - y_temp - 13, 0, 0, 12, 12,
                            12, 12);
                }
            }
            poseStack.blit(ICON, x - 94 - 18, y - 54 - y_temp - 13, 0, 0, 12, 12,
                    12, 12);
            poseStack.blit(BLUE_LINE, x - 94 +27, y - 54 - y_temp - 13, 0, 0, 1, 16,
                    1, 16);
            poseStack.blit(RED_LINE, x - 94 +90, y - 54 - y_temp - 13, 0, 0, 1, 16,
                    1, 16);
        }

    });
}

