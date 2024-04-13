package com.FishingLife.fishinglife.fishingexperience;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import static com.FishingLife.fishinglife.fishingexperience.fishingexperienceMath.calculateXPForLevelingUp;
import static com.FishingLife.fishinglife.fishingexperience.fishinglifeLevelUpAward.Award;

public class fishingexperience {
    private int fishingexperience;

    private int fishingexperience_level;
    private final int MAX_fishingexperience_level=200;
    private final int MIN_fishingexperience_level=1;

    private int MAX_fishingexperience_for_current_level;

    public fishingexperience(){
        this.fishingexperience=0;
        this.fishingexperience_level=1;
        reset_experience_needed_to_level_up(this.fishingexperience_level);

    }

    public void setFishingexperience(int a) {
         this.fishingexperience = a;
    }
    public void setFishinglevel(int a) {
        this.fishingexperience_level = a;
    }
    public void init_fishingexperiencelevel(){
        this.fishingexperience_level=1;
    }
    public void init_experience_for_current_level(){
        reset_experience_needed_to_level_up(1);
    }
    public int getFishingexperience_level(){return this.fishingexperience_level;}

    public void increasefishingexperienceLevel(){
        this.fishingexperience_level++;
    }
    public int getfishingexperience() {
        return this.fishingexperience;
    }
    public int getMAX_fishingexperience_for_current_level() {
        return this.MAX_fishingexperience_for_current_level;
    }
    public void addfishingexperience(int add, Player player) {

            if(this.fishingexperience+add>=this.MAX_fishingexperience_for_current_level){
                this.fishingexperience=this.fishingexperience+add-this.MAX_fishingexperience_for_current_level;
                increasefishingexperienceLevel();
                reset_experience_needed_to_level_up(this.fishingexperience_level);
                player.getCapability(fishingexperienceProvider.PLAYER_FISHING_EXPERIENCE).ifPresent(fishingexperience -> {
                    player.sendSystemMessage(Component.literal("Levelling Up! Your fishing level is "+ getFishingexperience_level())
                            .withStyle(ChatFormatting.GOLD));
                    player.sendSystemMessage(Component.literal("You need "+ getMAX_fishingexperience_for_current_level()+"xp to level up")
                            .withStyle(ChatFormatting.DARK_AQUA));

                        ItemStack stack=Award(this.fishingexperience_level,player);
                        player.sendSystemMessage(Component.literal("You were awarded "+stack+"!")
                                .withStyle(ChatFormatting.DARK_AQUA));

                });
        }
        else{
            this.fishingexperience=fishingexperience+add;
            player.getCapability(fishingexperienceProvider.PLAYER_FISHING_EXPERIENCE).ifPresent(fishingexperience -> {
                player.sendSystemMessage(Component.literal("You still need "+ calculateXPForLevelingUp(this.fishingexperience_level, this.fishingexperience)+"xp to level up to level "+this.fishingexperience_level+"!")
                        .withStyle(ChatFormatting.DARK_AQUA));
            });

        }
    }
    public void reset_experience_needed_to_level_up(int level){
        this.MAX_fishingexperience_for_current_level=fishingexperienceMath.calculateXPForLevel(level);
    }


    public void copyFrom(fishingexperience source) {
        this.fishingexperience = source.fishingexperience;
        this.fishingexperience_level = source.fishingexperience_level;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("fishing_experience", fishingexperience);
        nbt.putInt("fishing_experience_level", fishingexperience_level);
    }

    public void loadNBTData(CompoundTag nbt) {
        fishingexperience = nbt.getInt("fishing_experience");
        fishingexperience_level = nbt.getInt("fishing_experience_level");
    }
}
