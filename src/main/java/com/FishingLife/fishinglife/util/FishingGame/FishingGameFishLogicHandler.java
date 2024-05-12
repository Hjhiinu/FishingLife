package com.FishingLife.fishinglife.util.FishingGame;

import com.FishingLife.fishinglife.client.fishingHUD.HUDOverlay.FishingInteraction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Random;

public class FishingGameFishLogicHandler {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final ArrayList<Integer> divisibleByThree = new ArrayList<>();

    private static final int min_moving_distance=10; //10 pixels per move

    private static int counter_for_speed; //counter for each stage, reset each pixel

    private static int counter_for_position; //counter for each stage, reset in each movement

    private static int counter_for_tension_speed;

    private static int counter_for_tension_position;

    private static final int[] speed= {5,4,3};  //unit: tick/pixel

    private static final int[] speed_special= {5,4,3,2};  //unit: tick/0pixel

    private static int starting_position;  //Not the starting point for the game, the starting point for each movement

    private static int x_left_boundary;

    private static int x_right_boundary;

    private static int moving_distance; //moving distance for one period

    private static int excited;//0: tired, 1: medium, 2: excited

    private static int state_last_tension;
    private static boolean tension_direction;
    private static int tension_moving_distance;
    private static boolean reeling_in;
    private static boolean casting_out;
    private static int moving_speed;       //level 1: 6 pixels per seconds, level 2: 10 pixels per seconds, level 3: 15 pixels per seconds, level 4: 20 pixels per seconds, level 5: 25 pixels per seconds
    private static boolean direction;      //true right, false left

    private static final Random random = new Random();

    public static void tension_init(){
        setTension_direction(random.nextBoolean());
        setTension_moving_distance(divisibleByThree.get(random.nextInt(divisibleByThree.size())));
        setCounter_for_tension_speed(0);
        setCounter_for_tension_position(0);
        directlySetExcited(2);
        setState_last_tension(random.nextInt(5)+2);
        LOGGER.info("TENSION INIT");
    }

    public static void game_start_init(){
        setDirection(random.nextBoolean());
        setMoving_distance(divisibleByThree.get(random.nextInt(divisibleByThree.size())));
        setMoving_speed(speed[random.nextInt(speed.length)]);
        setCounter_for_speed(0);
        setCounter_for_position(0);
    }
    public static int change_to_next_tension_position(int pre_position){
        int pos;
        int temp_excited=getExcited();
        counter_for_tension_speed++;

        if(temp_excited==0){
            pos= pre_position -10;
        }
        else if(temp_excited==1){
            pos= pre_position+random.nextInt(31) - 15;
        }
        else{
            pos= pre_position +10;
        }
        LOGGER.info("POSITION IS "+pos+" with excite "+ temp_excited);
        if(counter_for_tension_speed==state_last_tension){

            setCounter_for_tension_speed(0);
            setExcited();
            LOGGER.info("Change the tension state to" +getExcited());
            setState_last_tension(random.nextInt(5)+2);
        }
        return pos;
    }

    public static int change_to_next_position(int pre_position){  //change next position every tick
        counter_for_speed++;
        counter_for_position=counter_for_position+3;

        if(counter_for_speed==moving_speed){
            setCounter_for_speed(0);
            if(direction){
                if(pre_position+3>=x_right_boundary){
                    setDirection(false);
                    return pre_position-3;
                }
                else{
                    return pre_position+3;
                }
            }
            else{
                if(pre_position-3<=x_left_boundary){
                    setDirection(true);
                    return pre_position+3;
                }
                else{
                    return pre_position-3;
                }
            }
        }
        return pre_position;
    }
    public static void Init_randomNumberDivisibleByThree() {
        for (int i = 10; i <= 175; i++) {
            if (i % 3 == 0) {
                divisibleByThree.add(i);
            }
        }
    }
    public static boolean getSuccess_each_tick(int left, int right, int pos){
        return pos>=left&&pos<=right;
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

    public static void setTension_direction(boolean tension_direction) {
        FishingGameFishLogicHandler.tension_direction = tension_direction;
    }

    public static void setTension_moving_distance(int tension_moving_distance) {
        FishingGameFishLogicHandler.tension_moving_distance = tension_moving_distance;
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

    public static void setCounter_for_tension_position(int counter_for_tension_position) {
        FishingGameFishLogicHandler.counter_for_tension_position = counter_for_tension_position;
    }

    public static void setCounter_for_tension_speed(int counter_for_tension_speed) {
        FishingGameFishLogicHandler.counter_for_tension_speed = counter_for_tension_speed;
    }

    public static int getCounter_for_position() {
        return counter_for_position;
    }

    public static int getMoving_distance() {
        return moving_distance;
    }

    public static int getExcited() {
        return excited;
    }
    public static void setExcited() {
        FishingGameFishLogicHandler.excited= random.nextInt(3);
    }
    public static void directlySetExcited(int a){
        FishingGameFishLogicHandler.excited=a;
    }

    public static void setState_last_tension(int state_last_tension) {
        FishingGameFishLogicHandler.state_last_tension = state_last_tension;
    }

    public static int getState_last_tension() {
        return state_last_tension;
    }
}
