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

    private static int player_boundary_position;

    private static int fish_position;

    private static int gameYlevel;

    private static int gameleftboundary;

    private static int gamerightboundary;

    private static int successful_left;

    private static int successful_right;

    private static boolean successful;
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

    public static boolean isSuccessful() {
        return successful;
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
    public static void setPlayer_boundary_position_left() {
        FishingInteraction.player_boundary_position = FishingInteraction.player_boundary_position-15;
    }
    public static void setPlayer_boundary_position_right() {
        FishingInteraction.player_boundary_position = FishingInteraction.player_boundary_position+15;
    }
    public static void setPlayer_boundary_position(int p) {
        FishingInteraction.player_boundary_position =p;
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

                FishingGameFishLogicHandler.setX_left_boundary(left);
                FishingGameFishLogicHandler.setX_right_boundary(right);
                fish_position = left + random.nextInt(right - left + 1);// point here is the starting point of the game
                setPlayer_boundary_position(fish_position);
                //Reset Starting point
                FishingGameFishLogicHandler.setStarting_position(fish_position);
                HUDIntegration.gamePre_init();

                successful_left=0;
                successful_right=0;
                successful=false;
            }
            else{
                //LOGGER.info("Tick is not 1!");
                fish_position=FishingGameFishLogicHandler.change_to_next_position(fish_position);   //reset the logic setting each position phase
                if (FishingGameFishLogicHandler.getCounter_for_position()==FishingGameFishLogicHandler.getMoving_distance()){
                    FishingGameFishLogicHandler.game_start_init();
                }
                //Define the icon boundary and compare the values in each tick.
                successful_left=fish_position;
                successful_right=fish_position+18;
                successful=FishingGameFishLogicHandler.getSuccess_each_tick(successful_left,successful_right, player_boundary_position);
            }




            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

            poseStack.blit(BOUNDARY,player_boundary_position , y - 54 - y_temp +20 , 0, 0, 33, 16,      //delta x= +18
                    33, 16);
            poseStack.blit(FISH, fish_position , y - 54 - y_temp +20, 0, 0, 16, 16,
                    16, 16);
            poseStack.blit(ICON, x - 94 - 18, y - 54 - y_temp +10, 0, 0, 32, 32,
                    32, 32);
        }

    });
}
