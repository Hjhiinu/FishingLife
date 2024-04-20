package com.FishingLife.fishinglife.capability.fishingexperience;

import com.FishingLife.fishinglife.registry.FishingLifeBlocksRegistry;
import com.FishingLife.fishinglife.registry.FishingLifeItemsRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
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

    public static void Award(int level, Player player){
        if (level==3){
            ItemStack a=new ItemStack(Items.DIAMOND,2);
            giveItem(player,a);


        }
        else if (level==5){
            ItemStack a=new ItemStack(Items.DIAMOND,2);
            giveItem(player,a);

        }
        else if(level==10){
            ItemStack a=new ItemStack(FishingLifeBlocksRegistry.FISHINGMACHINE.get(),1);
             giveItem(player,a);

        }
        else if(level==15){
            ItemStack a=new ItemStack(Items.CRYING_OBSIDIAN,3);
            giveItem(player,a);

        }
        else if(level==20){
            ItemStack a=new ItemStack(Items.NETHERITE_INGOT,1);
            giveItem(player,a);

        }
        else if(level==25){
            ItemStack enchantedBook = new ItemStack(Items.ENCHANTED_BOOK,1);

            // Add the Mending enchantment to the book
            EnchantmentHelper.setEnchantments(Collections.singletonMap(Enchantments.MENDING, 1), enchantedBook);

            giveItem(player, enchantedBook);

        }
        else if(level==30){
            ItemStack a=new ItemStack(Items.EMERALD,15);
            giveItem(player,a);

        }
        else if(level==35){
            ItemStack a=new ItemStack(Items.ELYTRA,1);
            giveItem(player,a);

        }
        else if(level==40){
            ItemStack a=new ItemStack(Items.PLAYER_HEAD,1);
            giveItem(player,a);

        }
        else{
            int coinNum= (int) Math.ceil(level/10.0)*10;
            ItemStack a=new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), coinNum);
            giveItem(player, a);

        }
    }

    private static void giveItem(Player player, @Nonnull ItemStack stack) {
        player.getCapability(fishingexperienceProvider.PLAYER_FISHING_EXPERIENCE).ifPresent(fishingexperience -> {
            player.sendSystemMessage(Component.literal("You were awarded "+stack+"!")
                    .withStyle(ChatFormatting.DARK_AQUA));
        });
        if (!player.getInventory().add(stack)) {
            player.drop(stack, false);
        } else if (player instanceof ServerPlayer) {
            player.inventoryMenu.sendAllDataToRemote();
        }
    }
}

