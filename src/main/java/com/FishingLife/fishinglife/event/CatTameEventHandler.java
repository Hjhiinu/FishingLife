package com.FishingLife.fishinglife.event;

import com.FishingLife.fishinglife.fishinglife;
import com.FishingLife.fishinglife.util.ModTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.animal.CatVariant;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = fishinglife.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CatTameEventHandler {

    @SubscribeEvent
    public static void onPlayerInteractWithEntity(PlayerInteractEvent.EntityInteract event) {
        if (event.getTarget() instanceof Cat) {
            Player player = event.getEntity();
            ItemStack itemstack = player.getItemInHand(event.getHand());

            if (itemstack.is(ModTags.Items.MODFISH)) {
                Cat cat = (Cat) event.getTarget();
                Level world = player.level();

                if (!world.isClientSide) {
                    if (cat.isTame()) {
                        // Heal the cat if it is already tamed
                        if(cat.getHealth() < cat.getMaxHealth()) {
                            cat.heal(5.0F); // Heal 5 health points
                            if (!player.isCreative()) {
                                itemstack.shrink(1);
                            }
                            event.setCancellationResult(InteractionResult.SUCCESS);
                            event.setCanceled(true);
                        }
                        event.setCancellationResult(InteractionResult.PASS);
                        event.setCanceled(true);
                    } else if (!cat.isTame() && !cat.isInSittingPose()) {
                        CatVariant originalType = cat.getVariant();
                        // Attempt to tame the cat
                        if (world.random.nextInt(3) == 0) { // 33% chance to tame the cat
                            cat.tame(player);
                            cat.setOwnerUUID(player.getUUID());
                            cat.setVariant(originalType); // Random cat type
                            cat.setOrderedToSit(true); // Make the cat sit after taming
                            cat.level().broadcastEntityEvent(cat, (byte)7); // Hearts animation
                        } else {
                            cat.level().broadcastEntityEvent(cat, (byte)6); // Smoke animation
                        }
                        if (!player.isCreative()) {
                            itemstack.shrink(1);
                        }
                        event.setCancellationResult(InteractionResult.SUCCESS);
                        event.setCanceled(true);
                    }
                } else {
                    event.setCancellationResult(InteractionResult.PASS);
                    event.setCanceled(true);
                }
            }
        }
    }
}

