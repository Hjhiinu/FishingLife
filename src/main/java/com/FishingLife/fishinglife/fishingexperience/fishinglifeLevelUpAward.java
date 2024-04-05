package com.FishingLife.fishinglife.fishingexperience;

import com.FishingLife.fishinglife.registry.FishingLifeBlocksRegistry;
import com.FishingLife.fishinglife.registry.FishingLifeItemsRegistry;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;

import javax.annotation.Nonnull;
import java.util.Collections;

public class fishinglifeLevelUpAward {
    private static final int[] SPECIAL_LEVELS = {3, 5, 10, 15, 20, 25, 30, 35, 40};   //Will add more awards in the future
    public static boolean checkIfAward(int level){
        for (int specialLevel : SPECIAL_LEVELS) {
            if (level == specialLevel) {
                return true;
            }
        }
        return false;
    }

    public static ItemStack Award(int level, Player player){
        if (level==3){
            return giveItem(player,new ItemStack(Items.DIAMOND,2));
        }
        else if (level==5){
            return giveItem(player,new ItemStack(Items.DIAMOND,2));
        }
        else if(level==10){
            return giveItem(player,new ItemStack(FishingLifeBlocksRegistry.FISHINGMACHINE.get(),1));
        }
        else if(level==15){
            return giveItem(player,new ItemStack(Items.CRYING_OBSIDIAN,3));
        }
        else if(level==20){
            return giveItem(player,new ItemStack(Items.NETHERITE_INGOT,1));
        }
        else if(level==25){
            ItemStack enchantedBook = new ItemStack(Items.ENCHANTED_BOOK,1);

            // Add the Mending enchantment to the book
            EnchantmentHelper.setEnchantments(Collections.singletonMap(Enchantments.MENDING, 1), enchantedBook);

            return giveItem(player, enchantedBook);
        }
        else if(level==30){
            return giveItem(player,new ItemStack(Items.EMERALD,15));
        }
        else if(level==35){
            return giveItem(player,new ItemStack(Items.ELYTRA,1));
        }
        else if(level==40){
            return giveItem(player,new ItemStack(Items.PLAYER_HEAD,1));
        }
        else{
            int coinNum= (int) Math.ceil(level/10.0)*10;
            return giveItem(player, new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), coinNum));
        }
    }

    private static ItemStack giveItem(Player player, @Nonnull ItemStack stack) {
        if (!player.getInventory().add(stack)) {
            player.drop(stack, false);
        } else if (player instanceof ServerPlayer) {
            player.inventoryMenu.sendAllDataToRemote();
        }
        return stack;
    }
}

