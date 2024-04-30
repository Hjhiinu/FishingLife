package com.FishingLife.fishinglife.capability.fishingMechanism;

import net.minecraft.nbt.CompoundTag;

public class Integration {
    private double fishingline_strength;

    private double fishingrod_strength;

    private int fish_vitality;

    private double time;
    private final int MIN = 0;
    private final int MAX = 100;
    public Integration(){
        this.fishingline_strength=100;
        this.fishingrod_strength=100;
        this.fish_vitality=100;
        this.time=100;
    }

    public void resetALL(){
        this.fishingline_strength=100;
        this.fishingrod_strength=100;
        this.fish_vitality=100;
        this.time=100;
    }

    public double getTime() {
        return this.time;
    }

    public int getFish_vitality() {
        return this.fish_vitality;
    }

    public double getFishingline_strength() {
        return this.fishingline_strength;
    }

    public double getFishingrod_strength() {
        return this.fishingrod_strength;
    }

    public void timeDecreasing() {
        this.time = Math.max(time -1, MIN);
    }

    public void vitalityDecreasing(){subFish_vitality(2);}

    public void vitalityincreasing(){addFish_vitality(1);}
    public void addFishingline_strength(int add) {
        this.fishingline_strength = Math.min(fishingline_strength + add, MAX);
    }

    public void addFishingrod_strength(int add) {
        this.fishingrod_strength = Math.min(fishingrod_strength + add, MAX);
    }

    public void addFish_vitality(int add) {
        this.fish_vitality = Math.min(fish_vitality + add, MAX);
    }

    public void subFishingline_strength(int sub) {
        this.fishingline_strength = Math.max(fishingline_strength - sub, MIN);
    }
    public void subFishingrod_strength(int sub) {
        this.fishingline_strength = Math.max(fishingline_strength - sub, MIN);
    }
    public void subFish_vitality(int sub) {
        this.fish_vitality = Math.max(fish_vitality - sub, MIN);
    }


        public void copyFrom(Integration source) {
        this.fish_vitality = source.fish_vitality;
        this.fishingline_strength= source.fishingline_strength;
        this.fishingrod_strength=source.fishingrod_strength;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putDouble("fishingline_strength", fishingline_strength);
        nbt.putDouble("fishingrod_strength", fishingrod_strength);
        nbt.putDouble("fish_vitality", fish_vitality);
    }

    public void loadNBTData(CompoundTag nbt) {
        fishingline_strength = nbt.getDouble("fishingline_strength");
        fish_vitality=nbt.getInt("fish_vitality");
        fishingrod_strength=nbt.getDouble("fishingrod_strength");

    }
}
