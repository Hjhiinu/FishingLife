package com.FishingLife.fishinglife.item.ItemUtil;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;

public class fishingrodPlayerDataUtil {
    private static Player player;

    private static Level level;

    private static ItemStack Itemstack;

    private static InteractionHand hand;

    private static boolean gameflag=false;

    private static int tick_for_vitality;

    private static int tickcount=0;

    private static int tension_tickcount=0;

    private static final int tension_total_count=60;

    private static final int totalcount=900;


    private static int luck;

    private static boolean gameSuccess;

    private static List<ItemStack> fishedItemList;


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

    public static int getTick_for_vitality() {
        return tick_for_vitality;
    }

    public static List<ItemStack> getFishedItemList() {
        return fishedItemList;
    }

    public static void setFishedItemList(List<ItemStack> fishedItemList) {
        fishingrodPlayerDataUtil.fishedItemList = fishedItemList;
    }

    public static void setTick_for_vitality(int tick_for_vitality) {
        fishingrodPlayerDataUtil.tick_for_vitality = tick_for_vitality;
    }

    public static void addTickcount(){
        fishingrodPlayerDataUtil.tickcount++;
    }
    public static void addTensionTickcount(){
        fishingrodPlayerDataUtil.tension_tickcount++;
    }

    public static void setTension_tickcount(int tension_tickcount) {
        fishingrodPlayerDataUtil.tension_tickcount = tension_tickcount;
    }

    public static int getTension_tickcount() {
        return tension_tickcount;
    }

    public static int getTension_total_count() {
        return tension_total_count;
    }
    public static void addTickcount_Vitality(){
        fishingrodPlayerDataUtil.tick_for_vitality++;
    }

    public static boolean isGameSuccess() {
        return gameSuccess;
    }
}
