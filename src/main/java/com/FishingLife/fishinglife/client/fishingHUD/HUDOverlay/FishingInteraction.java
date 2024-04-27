package com.FishingLife.fishinglife.client.fishingHUD.HUDOverlay;

import com.FishingLife.fishinglife.client.fishingHUD.HUDIntegration;
import com.FishingLife.fishinglife.fishinglife;
import com.FishingLife.fishinglife.item.ItemUtil.fishingrodPlayerDataUtil;
import com.FishingLife.fishinglife.util.FishingGame.FishingGameFishLogicHandler;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class FishingInteraction {
    private static final Random random = new Random();
    private static final Logger LOGGER = LogManager.getLogger();
    private static boolean show=false;

    private static int startingpoint;

    private static int fish_position;

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

    public static int getFish_position() {
        return fish_position;
    }

    public static void setFish_position(int fish_position) {
        FishingInteraction.fish_position = fish_position;
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
        LOGGER.info("FishingGame setleftboundary "+FishingInteraction.gameleftboundary);

    }

    public static void setGamerightboundary(int gamerightboundary) {
        FishingInteraction.gamerightboundary = gamerightboundary;
        LOGGER.info("FishingGame setrightboundary "+FishingInteraction.gamerightboundary);
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
            //LOGGER.info("Tick Game is"+fishingrodPlayerDataUtil.getTickcount());
            if(fishingrodPlayerDataUtil.getTickcount()==1) {
                //LOGGER.info("Tick is 1!");
                //Reset all the data
                int level=y - 54 - y_temp +20;
                setGameYlevel(level);//adjust the gamebar based on the size of screen    icon should be y - 54 - y_temp +10
                int left=x-75;
                int right=x+100;

                setGameleftboundary(left);//make the system more dynamic
                setGamerightboundary(right);
                //LOGGER.info("FishingScreen X Left is"+left);
               // LOGGER.info("FishingScreen X right is"+right);
                FishingGameFishLogicHandler.setX_left_boundary(left);
                FishingGameFishLogicHandler.setX_right_boundary(right);
                fish_position = left + random.nextInt(right - left + 1);// point here is the starting point of the game
                //Reset Starting point
                FishingGameFishLogicHandler.setStarting_position(fish_position);
                HUDIntegration.gamePre_init();
            }
            else{
                //LOGGER.info("Tick is not 1!");
                fish_position=FishingGameFishLogicHandler.change_to_next_position(fish_position);   //reset the logic setting each position phase
                if (FishingGameFishLogicHandler.getCounter_for_position()==FishingGameFishLogicHandler.getMoving_distance()){
                    FishingGameFishLogicHandler.game_start_init();
                }
            }




            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

            poseStack.blit(BOUNDARY, x +100, y - 54 - y_temp +20 , 0, 0, 16, 16,      //delta x= +13 or -14 to be the boundary condition, which x_actual is the center of image
                    16, 16);
            poseStack.blit(FISH, fish_position , y - 54 - y_temp +20, 0, 0, 16, 16,
                    16, 16);
            poseStack.blit(ICON, x - 94 - 18, y - 54 - y_temp +10, 0, 0, 32, 32,
                    32, 32);
        }

    });
}
