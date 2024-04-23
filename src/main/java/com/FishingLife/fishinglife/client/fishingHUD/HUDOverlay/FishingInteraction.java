package com.FishingLife.fishinglife.client.fishingHUD.HUDOverlay;

import com.FishingLife.fishinglife.fishinglife;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class FishingInteraction {
    private static boolean show=true;

    private static int gameYlevel;

    private static int gameleftboundary;

    private static int gamerightboundary;

    private static int fish_left_boundary;

    private static int fish_right_boundary;

    private static int player_right_boundary;

    private static int player_left_boundary;
    private static final ResourceLocation FISH = new ResourceLocation(fishinglife.MOD_ID,
            "textures/fishinghud/fish.png");
    private static final ResourceLocation BOUNDARY = new ResourceLocation(fishinglife.MOD_ID,
            "textures/fishinghud/boundary.png");

    private static final ResourceLocation ICON = new ResourceLocation(fishinglife.MOD_ID,
            "textures/fishinghud/player_icon.png");

    public static void changeshow(boolean now){
        FishingInteraction.show=now;
    }
    public static void init(){
        FishingInteraction.show=true;
    }

    public static void resetFishBoundary(){
        FishingInteraction.fish_left_boundary=0;
        FishingInteraction.fish_right_boundary=0;
    }

    public static void resetPlayerBoundary(){
        FishingInteraction.player_left_boundary=0;
        FishingInteraction.player_right_boundary=0;
    }

    public static int getGameleftboundary() {
        return gameleftboundary;
    }

    public static int getGamerightboundary() {
        return gamerightboundary;
    }

    public static int getGameYlevel() {
        return gameYlevel;
    }

    public static void setGameYlevel(int gameYlevel) {
        FishingInteraction.gameYlevel = gameYlevel;
    }

    public static void setGameleftboundary(int gameleftboundary) {
        FishingInteraction.gameleftboundary = gameleftboundary;
    }

    public static void setGamerightboundary(int gamerightboundary) {
        FishingInteraction.gamerightboundary = gamerightboundary;
    }

    public static void setFish_right_boundary(int fish_right_boundary) {
        FishingInteraction.fish_right_boundary = fish_right_boundary;
    }

    public static void setFish_left_boundary(int fish_left_boundary) {
        FishingInteraction.fish_left_boundary = fish_left_boundary;
    }

    public static void setPlayer_left_boundary(int player_left_boundary) {
        FishingInteraction.player_left_boundary = player_left_boundary;
    }

    public static void setPlayer_right_boundary(int player_right_boundary) {
        FishingInteraction.player_right_boundary = player_right_boundary;
    }

    public static int getFish_left_boundary() {
        return fish_left_boundary;
    }

    public static int getFish_right_boundary() {
        return fish_right_boundary;
    }

    public static int getPlayer_left_boundary() {
        return player_left_boundary;
    }

    public static int getPlayer_right_boundary() {
        return player_right_boundary;
    }

    public static final IGuiOverlay HUD_FISHING_CORE = ((gui, poseStack, partialTick, width, height) -> {
        if(show) {
            int x = width / 2;
            int y = height;
            int y_temp = height / 2;

            setGameYlevel(y - 54 - y_temp +20);//adjust the gamebar based on the size of screen    icon should be y - 54 - y_temp +10
            setGameleftboundary(x - 75);//make the system more dynamic
            setGamerightboundary(x+100);

            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

            poseStack.blit(BOUNDARY, x +100 , y - 54 - y_temp +20 , 0, 0, 16, 16,
                    16, 16);
            poseStack.blit(FISH, x +100 , y - 54 - y_temp +20, 0, 0, 16, 16,
                    16, 16);
            poseStack.blit(ICON, x - 94 - 18, y - 54 - y_temp +10, 0, 0, 32, 32,
                    32, 32);
        }

    });
}
