package com.FishingLife.fishinglife.item.ItemUtil;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class fishingrodPlayerDataUtil {
    private static Player player;

    private static Level level;

    private static ItemStack Itemstack;

    private static InteractionHand hand;

    private static boolean gameflag=false;

    private static int tickcount=0;

    private static final int totalcount=500;

    private static int luck;

    private static boolean gameSuccess;


    public static Player getplayer() {
        return player;
    }
    public static Level getlevel() {
        return level;
    }
    public static boolean isGameflag() {
        return gameflag;
    }
    public static int getluck() {
        return luck;
    }

    public static int getTickcount() {
        return tickcount;
    }

    public static int getTotalcount() {
        return totalcount;
    }

    public static InteractionHand getHand() {
        return hand;
    }

    public static ItemStack getitemstack() {
        return Itemstack;
    }
    public static void setGameflag(boolean pgameflag) {
        fishingrodPlayerDataUtil.gameflag = pgameflag;
    }

    public static void setHand(InteractionHand phand) {
        fishingrodPlayerDataUtil.hand = phand;
    }

    public static void setplayer(Player pplayer) {
        fishingrodPlayerDataUtil.player = pplayer;
    }

    public static void setitemstack(ItemStack pitemstack) {
        fishingrodPlayerDataUtil.Itemstack = pitemstack;
    }

    public static void setlevel(Level plevel) {
        fishingrodPlayerDataUtil.level = plevel;
    }

    public static void setLuck(int pluck) {
        fishingrodPlayerDataUtil.luck = pluck;
    }

    public static void setTickcount(int ptickcount) {
        fishingrodPlayerDataUtil.tickcount = ptickcount;
    }

    public static void setGameSuccess(boolean gameSuccess) {
        fishingrodPlayerDataUtil.gameSuccess = gameSuccess;
    }

    public static void addTickcount(){
        fishingrodPlayerDataUtil.tickcount++;
    }

    public static boolean isGameSuccess() {
        return gameSuccess;
    }
}
