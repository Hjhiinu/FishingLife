package com.FishingLife.fishinglife.util;

import com.FishingLife.fishinglife.fishinglife;

import com.FishingLife.fishinglife.registry.FishingLifeItemsRegistry;
import net.minecraft.ChatFormatting;

import net.minecraft.nbt.CompoundTag;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.player.ItemFishedEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = fishinglife.MOD_ID)
public class FishQualityEventHandler{
    @SubscribeEvent
    public static void onItemFished(ItemFishedEvent event) {
        boolean k=event.getEntity().getMainHandItem().getItem().equals(FishingLifeItemsRegistry.PROFESSIONAL_FISHING_ROD.get());
       // System.out.println(k);

        if (!event.getDrops().isEmpty()) {
            if(event.getDrops().get(0).is(ModTags.Items.MODFISH)) {
                ItemStack fish = event.getDrops().get(0);


                assignRandomQuality(fish,k);
            }

        }
    }
    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void onTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        if (!stack.isEmpty() && stack != null && stack.hasTag() && stack.getTag() != null) {

            if (stack.getTag().contains("Quality")) {
                String quality = stack.getTag().getString("Quality");
                /*
                double age = stack.getTag().getDouble("Age");
                BigDecimal bd = new BigDecimal(age);
                bd = bd.round(new MathContext(3));
*/


                MutableComponent string = Component.translatable("fishinglife.Quality.quality",quality);
                event.getToolTip().add(string.withStyle(string.getStyle().withItalic(true).withColor(ChatFormatting.DARK_AQUA)));

               // MutableComponent decimalAge = Component.translatable("fishinglife.Age.age",bd);
                //event.getToolTip().add(decimalAge.withStyle(decimalAge.getStyle().withItalic(true).withColor(ChatFormatting.YELLOW)));

            }
        }
    }





    private static void assignRandomQuality(ItemStack fish,boolean isHoldingCustomRod) {
        if (fish.isEmpty()) {
            return;
        }



// Your existing random and fish tag logic
        double random = 1 + Math.random() * (11 - 1);
        double random_basic=1+ Math.random() * (10 - 1);
        //double age= Math.random() * 3;
        if (!fish.hasTag()) {
            fish.setTag(new CompoundTag());
        }

        CompoundTag tag = fish.getTag();
        if(tag != null) {
            if (isHoldingCustomRod) {
                //tag.putDouble("Age", ageran);
                if (random <= 2) {

                    tag.putString("Quality", "Extraordinary");

                } else if (random > 2 && random <= 4.5) {

                    tag.putString("Quality", "Special");

                } else if (random > 4.5 && random <= 7) {

                    tag.putString("Quality", "Rare");

                } else if (random > 7) {

                    tag.putString("Quality", "Common");
                }

            } else {
                if (random <= 3) {


                    tag.putString("Quality", "Special");

                } else if (random > 3 && random <= 6) {

                    tag.putString("Quality", "Rare");

                } else if (random > 6 && random <= 10) {

                    tag.putString("Quality", "Common");

                }

            }
        }
    }




}
