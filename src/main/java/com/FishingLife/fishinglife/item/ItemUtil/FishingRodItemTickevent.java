package com.FishingLife.fishinglife.item.ItemUtil;

import com.FishingLife.fishinglife.capability.fishingMechanism.IntegrationProvider;
import com.FishingLife.fishinglife.client.fishingHUD.HUDIntegration;
import com.FishingLife.fishinglife.client.fishingHUD.HUDOverlay.FishingProcess;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.ItemFishedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
@Mod.EventBusSubscriber
public class FishingRodItemTickevent {
    private static final Logger LOGGER = LogManager.getLogger();
    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            if (fishingrodPlayerDataUtil.isGameflag()) {
                HUDIntegration.allinit();
                fishingrodPlayerDataUtil.addTickcount();
                Player pPlayer=fishingrodPlayerDataUtil.getplayer();
                pPlayer.getCapability(IntegrationProvider.FISHING_INTEGRATION).ifPresent(fishing -> {
                    //total 10 phase
                    FishingProcess.set(fishingrodPlayerDataUtil.getTickcount()*10/fishingrodPlayerDataUtil.getTotalcount());
                    if(fishing.getTime()>0) {
                        fishing.timeDecreasing();
                    }
                });
                if (pPlayer.fishing == null) {    //use other item
                    fishingrodPlayerDataUtil.setGameflag(false) ;
                    HUDIntegration.setInvisible();
                    fishingrodPlayerDataUtil.setTickcount(0);
                    LOGGER.info("Cancel the fishing");
                } else {
                    if (fishingrodPlayerDataUtil.getTickcount() == fishingrodPlayerDataUtil.getTotalcount()) {
                        LOGGER.info("This is an TICK log message for end of fishing");
                        fishingrodPlayerDataUtil.setGameflag(false) ;
                        fishingrodPlayerDataUtil.setTickcount(0);
                        HUDIntegration.setInvisible();
                        int i=0;
                        if (!fishingrodPlayerDataUtil.getlevel().isClientSide) {
                            LOGGER.info("HOOKED IN: "+pPlayer.fishing.getHookedIn());
                            LOGGER.info("I IS 0, IS FISHING");
                            if (!pPlayer.fishing.level().isClientSide && pPlayer != null && !shouldStopFishing(pPlayer, pPlayer.fishing)) {
                                LOGGER.info("PROCEED TO CUSTOM FISHING");
                                LootParams lootparams = (new LootParams.Builder((ServerLevel) pPlayer.fishing.level())).withParameter(LootContextParams.ORIGIN, pPlayer.fishing.position()).withParameter(LootContextParams.TOOL, fishingrodPlayerDataUtil.getitemstack()).withParameter(LootContextParams.THIS_ENTITY, pPlayer.fishing).withParameter(LootContextParams.KILLER_ENTITY, pPlayer.fishing.getOwner()).withParameter(LootContextParams.THIS_ENTITY, pPlayer.fishing).withLuck((float) fishingrodPlayerDataUtil.getluck() + pPlayer.getLuck()).create(LootContextParamSets.FISHING);   //luck should also be localized
                                LootTable loottable = pPlayer.fishing.level().getServer().getLootData().getLootTable(BuiltInLootTables.FISHING);
                                List<ItemStack> list = loottable.getRandomItems(lootparams);
                                net.minecraftforge.event.entity.player.ItemFishedEvent new_event = new ItemFishedEvent(list, pPlayer.fishing.onGround() ? 2 : 1, pPlayer.fishing);
                                net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new_event);
                                LOGGER.info("POST ITEMFISHED EVENT");
                                if (new_event.isCanceled()) {
                                    LOGGER.info("ITEMFISHED EVENT CANCELLED");
                                    pPlayer.fishing.discard();
                                    i = new_event.getRodDamage();
                                }
                                CriteriaTriggers.FISHING_ROD_HOOKED.trigger((ServerPlayer) pPlayer, fishingrodPlayerDataUtil.getitemstack(), pPlayer.fishing, list);
                                LOGGER.info("LIST:"+list);
                                for (ItemStack itemstack : list) {
                                    ItemEntity itementity = new ItemEntity(pPlayer.fishing.level(), pPlayer.fishing.getX(), pPlayer.fishing.getY(), pPlayer.fishing.getZ(), itemstack);
                                    double d0 = pPlayer.getX() - pPlayer.fishing.getX();
                                    double d1 = pPlayer.getY() - pPlayer.fishing.getY();
                                    double d2 = pPlayer.getZ() - pPlayer.fishing.getZ();
                                    double d3 = 0.1D;
                                    itementity.setDeltaMovement(d0 * 0.1D, d1 * 0.1D + Math.sqrt(Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2)) * 0.08D, d2 * 0.1D);
                                    pPlayer.fishing.level().addFreshEntity(itementity);
                                    pPlayer.level().addFreshEntity(new ExperienceOrb(pPlayer.level(), pPlayer.getX(), pPlayer.getY() + 0.5D, pPlayer.getZ() + 0.5D, pPlayer.fishing.random.nextInt(6) + 1));   //--edit random will cause multiple threads issues
                                    if (itemstack.is(ItemTags.FISHES)) {
                                        pPlayer.awardStat(Stats.FISH_CAUGHT, 1);
                                    }
                                }
                                i = 1;
                            }
                        }
                        LOGGER.info("THE DAMAGE IS " + i);
                        pPlayer.fishing.discard();
                        fishingrodPlayerDataUtil.getitemstack().hurtAndBreak(i, pPlayer, (p_41288_) -> {
                            p_41288_.broadcastBreakEvent(fishingrodPlayerDataUtil.getHand());
                        });
                        fishingrodPlayerDataUtil.getlevel().playSound((Player) null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.FISHING_BOBBER_RETRIEVE, SoundSource.NEUTRAL, 1.0F, 0.4F / (fishingrodPlayerDataUtil.getlevel().getRandom().nextFloat() * 0.4F + 0.8F));
                        pPlayer.gameEvent(GameEvent.ITEM_INTERACT_FINISH);
                        LOGGER.info("ITEM INTERACT FINISH");
                    }
                }
            }
        }
    }

    private static boolean shouldStopFishing(Player pPlayer, FishingHook hook) {
        LOGGER.info("SHOULD STOP- "+hook);
        ItemStack itemstack = pPlayer.getMainHandItem();
        ItemStack itemstack1 = pPlayer.getOffhandItem();
        boolean flag = itemstack.canPerformAction(net.minecraftforge.common.ToolActions.FISHING_ROD_CAST);
        boolean flag1 = itemstack1.canPerformAction(net.minecraftforge.common.ToolActions.FISHING_ROD_CAST);
        if (!pPlayer.isRemoved() && pPlayer.isAlive() && (flag || flag1) && !(hook.distanceToSqr(pPlayer) > 1024.0D)) {
            LOGGER.info("SHOULD STOP- false");
            return false;
        } else {
            if(pPlayer.fishing!=null){
                LOGGER.info("SHOULD STOP- hook discard true");
                hook.discard();
            }
            LOGGER.info("SHOULD STOP- true");
            return true;
        }
    }
}
