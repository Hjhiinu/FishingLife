package com.FishingLife.fishinglife.util;

import com.FishingLife.fishinglife.capability.fishingexperience.fishingexperienceProvider;
import com.FishingLife.fishinglife.fishinglife;
import com.FishingLife.fishinglife.registry.FishingLifeItemsRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
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
        Player player=event.getEntity();
        ItemStack compare=player.getMainHandItem();
        boolean k=compare.is(FishingLifeItemsRegistry.ELITE_FISHING_ROD.get())||compare.is(FishingLifeItemsRegistry.MASTER_FISHING_ROD.get());


        if (!event.getDrops().isEmpty()) {
            ItemStack fish = event.getDrops().get(0);
            player.sendSystemMessage(Component.literal("You got "+ fish.getDisplayName().getString()+" !"));
            if(fish.is(ModTags.Items.MODFISH)) {
                assignRandomQuality(fish,k,player);
            }
            else if(fish.is(ItemTags.FISHES)){
                player.getCapability(fishingexperienceProvider.PLAYER_FISHING_EXPERIENCE).ifPresent(fishingexperience -> {
                    fishingexperience.addfishingexperience(10,player);
                    player.sendSystemMessage(Component.literal("You got 10xp!")
                            .withStyle(ChatFormatting.AQUA));
                });
            }
            else if(fish.is(ModTags.Items.FISHING_TRASH)){
                player.getCapability(fishingexperienceProvider.PLAYER_FISHING_EXPERIENCE).ifPresent(fishingexperience -> {
                    fishingexperience.addfishingexperience(5,player);
                    player.sendSystemMessage(Component.literal("You got 5xp!")
                            .withStyle(ChatFormatting.DARK_GRAY));
                });
            }
            else{
                player.getCapability(fishingexperienceProvider.PLAYER_FISHING_EXPERIENCE).ifPresent(fishingexperience -> {
                    fishingexperience.addfishingexperience(20,player);
                    player.sendSystemMessage(Component.literal("You got 20xp!")
                            .withStyle(ChatFormatting.LIGHT_PURPLE));
                });
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



    public static void assignCertainQuality(ItemStack object, int quality){
        if (object.isEmpty()) {
            return;
        }
        if (!object.hasTag()) {
            object.setTag(new CompoundTag());
        }
        CompoundTag tag = object.getTag();
        if(tag != null) {
            if (quality == 1) {

                tag.putString("Quality", "Common");
            } else if (quality == 2) {
                tag.putString("Quality", "Rare");
            } else if (quality == 3) {
                tag.putString("Quality", "Special");
            }
            else{
                tag.putString("Quality", "Extraordinary");
            }
        }
    }

    private static void assignRandomQuality(ItemStack fish,boolean isHoldingCustomRod, Player player) {
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
                    player.getCapability(fishingexperienceProvider.PLAYER_FISHING_EXPERIENCE).ifPresent(fishingexperience -> {
                        fishingexperience.addfishingexperience(25,player);
                        player.sendSystemMessage(Component.literal("You got 25xp!")
                                .withStyle(ChatFormatting.GOLD));
                    });
                    tag.putString("Quality", "Extraordinary");

                } else if (random > 2 && random <= 4.5) {
                    player.getCapability(fishingexperienceProvider.PLAYER_FISHING_EXPERIENCE).ifPresent(fishingexperience -> {
                        fishingexperience.addfishingexperience(20,player);
                        player.sendSystemMessage(Component.literal("You got 20xp!")
                                .withStyle(ChatFormatting.LIGHT_PURPLE));
                    });
                    tag.putString("Quality", "Special");
                } else if (random > 4.5 && random <= 7) {
                    player.getCapability(fishingexperienceProvider.PLAYER_FISHING_EXPERIENCE).ifPresent(fishingexperience -> {
                        fishingexperience.addfishingexperience(15,player);
                        player.sendSystemMessage(Component.literal("You got 15xp!")
                                .withStyle(ChatFormatting.BLUE));
                    });
                    tag.putString("Quality", "Rare");

                } else  {
                    player.getCapability(fishingexperienceProvider.PLAYER_FISHING_EXPERIENCE).ifPresent(fishingexperience -> {
                        fishingexperience.addfishingexperience(10,player);
                        player.sendSystemMessage(Component.literal("You got 10xp!")
                                .withStyle(ChatFormatting.AQUA));
                    });
                    tag.putString("Quality", "Common");
                }

            } else {
                if (random <= 3) {

                    player.getCapability(fishingexperienceProvider.PLAYER_FISHING_EXPERIENCE).ifPresent(fishingexperience -> {
                        fishingexperience.addfishingexperience(20,player);
                        player.sendSystemMessage(Component.literal("You got 20xp!")
                                .withStyle(ChatFormatting.LIGHT_PURPLE));
                    });
                    tag.putString("Quality", "Special");

                } else if (random > 3 && random <= 6) {
                    player.getCapability(fishingexperienceProvider.PLAYER_FISHING_EXPERIENCE).ifPresent(fishingexperience -> {
                        fishingexperience.addfishingexperience(15,player);
                        player.sendSystemMessage(Component.literal("You got 15xp!")
                                .withStyle(ChatFormatting.BLUE));
                    });
                    tag.putString("Quality", "Rare");

                } else  {
                    player.getCapability(fishingexperienceProvider.PLAYER_FISHING_EXPERIENCE).ifPresent(fishingexperience -> {
                        fishingexperience.addfishingexperience(10,player);
                        player.sendSystemMessage(Component.literal("You got 10xp!")
                                .withStyle(ChatFormatting.AQUA));
                    });
                    tag.putString("Quality", "Common");

                }

            }
        }
    }




}
