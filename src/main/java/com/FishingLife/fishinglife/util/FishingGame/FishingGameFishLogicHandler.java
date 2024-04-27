package com.FishingLife.fishinglife.util.FishingGame;

import com.FishingLife.fishinglife.client.fishingHUD.HUDOverlay.FishingInteraction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Random;

public class FishingGameFishLogicHandler {
    private static final Logger LOGGER = LogManager.getLogger();

    private static ArrayList<Integer> divisibleByFour = new ArrayList<>();

    private static final int min_moving_distance=10; //10 pixels per move

    private static int counter_for_speed; //counter for each stage, reset each pixel

    private static int counter_for_position; //counter for each stage, reset in each movement

    private static final int[] speed= {3, 2, 1};  //unit: tick/pixel

    private static int starting_position;  //Not the starting point for the game, the starting point for each movement

    private static int x_left_boundary;

    private static int x_right_boundary;

    private static int moving_distance; //moving distance for one period
    private static boolean switch_direction;  //true switch, false stay the same
    private static int moving_speed;       //level 1: 6 pixels per seconds, level 2: 10 pixels per seconds, level 3: 15 pixels per seconds, level 4: 20 pixels per seconds, level 5: 25 pixels per seconds
    private static boolean direction;      //true right, false left

    private static final Random random = new Random();

    public static void game_start_init(){
        setDirection(random.nextBoolean());
        setMoving_distance(divisibleByFour.get(random.nextInt(divisibleByFour.size())));
        setMoving_speed(speed[random.nextInt(speed.length)]);
        setCounter_for_speed(0);
        setCounter_for_position(0);
    }


    public static int change_to_next_position(int pre_position){  //change next position every tick
        counter_for_speed++;
        counter_for_position=counter_for_position+4;

        if(counter_for_speed==moving_speed){
            setCounter_for_speed(0);
            if(direction){
                if(pre_position+4>=x_right_boundary){
                    LOGGER.info("Pre_position "+pre_position);
                    setDirection(false);
                    return pre_position-4;
                }
                else{
                    return pre_position+4;
                }
            }
            else{
                if(pre_position-4<=x_left_boundary){
                    LOGGER.info("Pre_position "+pre_position);
                    setDirection(true);
                    return pre_position+4;
                }
                else{
                    return pre_position-4;
                }
            }

        }
        return pre_position;
    }
    public static void Init_randomNumberDivisibleByFour() {
        for (int i = 10; i <= 175; i++) {
            if (i % 4 == 0) {
                divisibleByFour.add(i);
            }
        }
    }
    public static void setDirection(boolean direction) {
        FishingGameFishLogicHandler.direction = direction;
    }

    public static void setMoving_distance(int moving_distance) {
        FishingGameFishLogicHandler.moving_distance = moving_distance;
    }

    public static void setMoving_speed(int moving_speed) {
        FishingGameFishLogicHandler.moving_speed = moving_speed;
    }

    public static void setStarting_position(int starting_position) {
        FishingGameFishLogicHandler.starting_position = starting_position;
    }

    public static void setX_left_boundary(int x_left_boundary) {
        FishingGameFishLogicHandler.x_left_boundary = x_left_boundary;
       // LOGGER.info("Proceed Left");
    }

    public static void setX_right_boundary(int x_right_boundary) {
        FishingGameFishLogicHandler.x_right_boundary = x_right_boundary;
       // LOGGER.info("Proceed right");
    }

    public static void setCounter_for_speed(int counter_for_speed) {
        FishingGameFishLogicHandler.counter_for_speed = counter_for_speed;
    }

    public static void setCounter_for_position(int counter_for_position) {
        FishingGameFishLogicHandler.counter_for_position = counter_for_position;
    }

    public static int getCounter_for_position() {
        return counter_for_position;
    }

    public static int getMoving_distance() {
        return moving_distance;
    }
}
