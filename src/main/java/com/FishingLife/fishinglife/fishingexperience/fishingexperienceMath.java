package com.FishingLife.fishinglife.fishingexperience;

public class fishingexperienceMath {
    private final int maxLevel = 200;    // Maximum level
    private static final double K = 1000;       // Carrying capacity (Max XP)
    private static final double a = 0.03;       // Growth rate
    private static final double b = 100;        // Midpoint
    public static int calculateXPForLevel(int level) {   //Logistic Growth
        double xp = K / (1 + Math.exp(-a * (level - b)));
        return (int) Math.ceil(xp);
    }
    public static int calculateXPForLevelingUp(int level,int currentxp){   //Calculating the exact experience player need to level up
        return calculateXPForLevel(level)-currentxp;
    }

}
