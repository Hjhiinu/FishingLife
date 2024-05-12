package com.FishingLife.fishinglife.item.ItemUtil;

import com.FishingLife.fishinglife.capability.fishingMechanism.IntegrationProvider;
import com.FishingLife.fishinglife.client.fishingHUD.HUDIntegration;
import com.FishingLife.fishinglife.client.fishingHUD.HUDOverlay.FishVitalityValue;
import com.FishingLife.fishinglife.client.fishingHUD.HUDOverlay.FishingInteraction;
import com.FishingLife.fishinglife.client.fishingHUD.HUDOverlay.FishingLineLength;
import com.FishingLife.fishinglife.client.fishingHUD.HUDOverlay.FishingProcess;
import com.FishingLife.fishinglife.util.FishingGame.FishingGameFishLogicHandler;
import net.minecraft.advancements.CriteriaTriggers;
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
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.ItemFishedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@Mod.EventBusSubscriber
public class FishingRodItemTickevent {
    private static final Logger LOGGER = LogManager.getLogger();
    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            if (fishingrodPlayerDataUtil.isGameflag()) {
                HUDIntegration.allinit();
                fishingrodPlayerDataUtil.addTickcount();
                fishingrodPlayerDataUtil.addTensionTickcount();
                Player pPlayer=fishingrodPlayerDataUtil.getplayer();
                //LOGGER.info("Client Tick is "+fishingrodPlayerDataUtil.getTickcount());
                pPlayer.getCapability(IntegrationProvider.FISHING_INTEGRATION).ifPresent(fishing -> {
                    //total 10 phase
                    if(fishing.getTime()>0) {
                        fishing.timeDecreasing();
                    }
                    if (fishingrodPlayerDataUtil.getTension_tickcount()==fishingrodPlayerDataUtil.getTension_total_count()){
                        fishingrodPlayerDataUtil.setTension_tickcount(0);
                        fishing.setFishingline_strength(FishingGameFishLogicHandler.change_to_next_tension_position(fishing.getFishingline_strength()));
                        LOGGER.info("fishingline_value: "+fishing.getFishingline_strength());
                    }
                    if(FishingInteraction.isSuccessful()){
                        fishing.vitalityDecreasing();//determine if it is Successful for each tick
                        if(fishing.getFish_vitality()==0){
                            fishingrodPlayerDataUtil.setGameSuccess(true);
                        }
                    }
                    else{
                        if(fishingrodPlayerDataUtil.getTick_for_vitality()!=2) {//penalty for vitality
                            fishingrodPlayerDataUtil.addTickcount_Vitality();
                        }
                        else{
                            fishing.vitalityincreasing();
                           fishingrodPlayerDataUtil.setTick_for_vitality(0);
                        }
                    }
                });
                if (pPlayer.fishing == null) {    //use other item
                    setToDefault();
                    LOGGER.info("Cancel the fishing");
                } else {
                    if (fishingrodPlayerDataUtil.getTickcount() <= fishingrodPlayerDataUtil.getTotalcount()&&fishingrodPlayerDataUtil.isGameSuccess()) {
                        LOGGER.info("This is an TICK log message for end of fishing");
                        setToDefault();
                        int i=0;
                        if (!fishingrodPlayerDataUtil.getlevel().isClientSide) {
                            LOGGER.info("HOOKED IN: "+pPlayer.fishing.getHookedIn());
                            LOGGER.info("I IS 0, IS FISHING");
                            if (!pPlayer.fishing.level().isClientSide && pPlayer != null && !shouldStopFishing(pPlayer, pPlayer.fishing)) {
                                LOGGER.info("PROCEED TO CUSTOM FISHING");
                                //ItemFished Event
                                net.minecraftforge.event.entity.player.ItemFishedEvent new_event = new ItemFishedEvent(fishingrodPlayerDataUtil.getFishedItemList(), pPlayer.fishing.onGround() ? 2 : 1, pPlayer.fishing);
                                net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new_event);
                                LOGGER.info("POST ITEMFISHED EVENT");
                                if (new_event.isCanceled()) {
                                    LOGGER.info("ITEMFISHED EVENT CANCELLED OR FINISHED");
                                    i = new_event.getRodDamage();
                                    if (i==1) {   //Default: i=1 means getting fish
                                        pPlayer.level().addFreshEntity(new ExperienceOrb(pPlayer.level(), pPlayer.getX(), pPlayer.getY() + 0.5D, pPlayer.getZ() + 0.5D, pPlayer.fishing.random.nextInt(6) + 1));   //--edit random will cause multiple threads issues
                                        pPlayer.awardStat(Stats.FISH_CAUGHT, 1);
                                    }
                                }
                                else {
                                    CriteriaTriggers.FISHING_ROD_HOOKED.trigger((ServerPlayer) pPlayer, fishingrodPlayerDataUtil.getitemstack(), pPlayer.fishing, fishingrodPlayerDataUtil.getFishedItemList());
                                        for (ItemStack itemstack : fishingrodPlayerDataUtil.getFishedItemList()) {
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
                        }
                        finish(pPlayer,i);
                    }
                    else if (fishingrodPlayerDataUtil.getTickcount() == fishingrodPlayerDataUtil.getTotalcount()){
                        setToDefault();
                        int i=3;    //Damage is a part of penalty
                        finish(pPlayer,i);
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
    private static void finish(Player pPlayer, int i){
        pPlayer.fishing.discard();
        fishingrodPlayerDataUtil.getitemstack().hurtAndBreak(i, pPlayer, (p_41288_) -> {
            p_41288_.broadcastBreakEvent(fishingrodPlayerDataUtil.getHand());
        });
        fishingrodPlayerDataUtil.getlevel().playSound((Player) null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.FISHING_BOBBER_RETRIEVE, SoundSource.NEUTRAL, 1.0F, 0.4F / (fishingrodPlayerDataUtil.getlevel().getRandom().nextFloat() * 0.4F + 0.8F));
        pPlayer.gameEvent(GameEvent.ITEM_INTERACT_FINISH);
        LOGGER.info("ITEM INTERACT FINISH");
    }
    private static void setToDefault(){
        fishingrodPlayerDataUtil.setGameflag(false) ;
        fishingrodPlayerDataUtil.setTickcount(0);
        HUDIntegration.setInvisible();
    }
}
