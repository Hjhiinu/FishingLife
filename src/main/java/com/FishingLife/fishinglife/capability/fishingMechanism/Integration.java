package com.FishingLife.fishinglife.capability.fishingMechanism;

import net.minecraft.nbt.CompoundTag;
import java.util.Random;

public class Integration {
    private int fishingline_strength;

    private int fish_vitality;

    private double time;
    private final int MIN = 0;
    private final int MAX = 100;

    private final int fishingline_strength_MAX=130;
    private final int viatlity_MAX = 500;
    private static final Random random = new Random();

    public Integration(){
        this.fishingline_strength=130;
        this.fish_vitality=500;
        this.time=100;
    }

    public void resetALL(){
        this.fishingline_strength=130;
        this.fish_vitality=500;
        this.time=100;
    }

    public double getTime() {
        return this.time;
    }

    public int getFish_vitality() {
        return this.fish_vitality;
    }

    public int getFishingline_strength() {
        return this.fishingline_strength;
    }

    public void timeDecreasing() {
        this.time = Math.max(time -1, MIN);
    }

    public void vitalityDecreasing(){subFish_vitality(5);}

    public void vitalityincreasing(){addFish_vitality(2);}
    public void addFishingline_strength(int add) {
        this.fishingline_strength = Math.min(fishingline_strength + add, fishingline_strength_MAX);
    }

    public void addFish_vitality(int add) {
        this.fish_vitality = Math.min(fish_vitality + add, viatlity_MAX);
    }

    public void subFishingline_strength(int sub) {
        this.fishingline_strength = Math.max(fishingline_strength - sub, MIN);
    }
    public void subFish_vitality(int sub) {
        this.fish_vitality = Math.max(fish_vitality - sub, MIN);
    }

    public void generateRandomTension(){
        this.fishingline_strength=random.nextInt(21) + 60;
    }
    public void setFishingline_strength(int strength){
        if(strength<=MIN){
            this.fishingline_strength=MIN;
        }
        else if(strength>=fishingline_strength_MAX){
            this.fishingline_strength=fishingline_strength_MAX;
        }
        else{
            this.fishingline_strength=strength;
        }

    }

        public void copyFrom(Integration source) {
        this.fish_vitality = source.fish_vitality;
        this.fishingline_strength= source.fishingline_strength;}

    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("fishingline_strength", fishingline_strength);
        nbt.putInt("fish_vitality", fish_vitality);
    }

    public void loadNBTData(CompoundTag nbt) {
        fishingline_strength = nbt.getInt("fishingline_strength");
        fish_vitality=nbt.getInt("fish_vitality");
    }
}
