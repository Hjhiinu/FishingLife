package com.FishingLife.fishinglife.item;
import com.FishingLife.fishinglife.capability.fishingMechanism.IntegrationProvider;
import com.FishingLife.fishinglife.client.fishingHUD.HUDIntegration;
import com.FishingLife.fishinglife.config.FishingLifeConfig;
import com.FishingLife.fishinglife.item.ItemUtil.fishingrodPlayerDataUtil;
import com.FishingLife.fishinglife.registry.FishingLifeItemsRegistry;
import com.FishingLife.fishinglife.util.FishingGame.FishingGameFishLogicHandler;
import com.FishingLife.fishinglife.util.ModTags;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.item.FishingRodItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fml.ModList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static com.FishingLife.fishinglife.item.ItemUtil.FishingRodItemTickevent.general_fishing_ending;
import static com.FishingLife.fishinglife.item.ItemUtil.FishingRodItemTickevent.stop;

public class ModFishingRodItem extends FishingRodItem {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final Random random = new Random();
    public ModFishingRodItem(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {

        ItemStack itemstack = pPlayer.getItemInHand(pHand);

        if (pPlayer.fishing != null) {
            if (!pLevel.isClientSide) {
                fishingrodPlayerDataUtil.setplayer(pPlayer) ;
                fishingrodPlayerDataUtil.setlevel(pLevel) ;
                fishingrodPlayerDataUtil.setitemstack(itemstack);
               fishingrodPlayerDataUtil.setHand(pHand);
                int i = 0;
                if (!pPlayer.fishing.level().isClientSide && pPlayer != null && !shouldStopFishing(pPlayer,pPlayer.fishing)) {
                    if(fishingrodPlayerDataUtil.isGameflag()){
                        HUDIntegration.setInvisible();
                        fishingrodPlayerDataUtil.setGameflag(false);
                        pPlayer.fishing.discard();
                        fishingrodPlayerDataUtil.setTickcount(0);
                    }
                    net.minecraftforge.event.entity.player.ItemFishedEvent event = null;
                    if (pPlayer.fishing.getHookedIn() != null) {
                        pullEntity(pPlayer.fishing.getHookedIn(),pPlayer.fishing);
                        CriteriaTriggers.FISHING_ROD_HOOKED.trigger((ServerPlayer)pPlayer, itemstack, pPlayer.fishing, Collections.emptyList());
                        pPlayer.fishing.level().broadcastEntityEvent(pPlayer.fishing, (byte)31);
                        i = pPlayer.fishing.getHookedIn() instanceof ItemEntity ? 3 : 5;
                        pPlayer.fishing.discard();
                    } else if (pPlayer.fishing.nibble > 0) {
                        //Generate the fished item before the game. (It is a little bit unrealistic)
                        LootParams lootparams = (new LootParams.Builder((ServerLevel) pPlayer.fishing.level())).withParameter(LootContextParams.ORIGIN, pPlayer.fishing.position()).withParameter(LootContextParams.TOOL, fishingrodPlayerDataUtil.getitemstack()).withParameter(LootContextParams.THIS_ENTITY, pPlayer.fishing).withParameter(LootContextParams.KILLER_ENTITY, pPlayer.fishing.getOwner()).withParameter(LootContextParams.THIS_ENTITY, pPlayer.fishing).withLuck((float) fishingrodPlayerDataUtil.getluck() + pPlayer.getLuck()).create(LootContextParamSets.FISHING);   //luck should also be localized
                        ResourceLocation loot =null;
                        int number =1; //Fishinglife
                        if(FishingLifeConfig.compat_other_mod_fish.get()) {
                            if (ModList.get().isLoaded("aquaculture")) {
                                number = generateOneOrTwo();
                            }
                        }
                        switch (number) {
                            case 1 -> { //FishingLife
                                if (itemstack.is(FishingLifeItemsRegistry.PROFESSIONAL_FISHING_ROD.get())) {
                                    loot = new ResourceLocation("fishinglife", "gameplay/fishing/professional_fishing_rod/professional_fishingrod_fishing");
                                } else if (itemstack.is(FishingLifeItemsRegistry.ELITE_FISHING_ROD.get())) {
                                    loot = new ResourceLocation("fishinglife", "gameplay/fishing/elite_fishing_rod/elite_fishingrod_fishing");
                                } else if (itemstack.is(FishingLifeItemsRegistry.MASTER_FISHING_ROD.get())) {
                                    loot = new ResourceLocation("fishinglife", "gameplay/fishing/master_fishing_rod/master_fishingrod_fishing");
                                } else {
                                    throw new IllegalStateException("(Fishing loot table) No loot table");
                                }
                            }
                            case 2 ->//If other fishing mod exists
                                    loot = new ResourceLocation("fishinglife", "gameplay/compat_fishing/fishing");
                            default ->
                                    throw new IllegalStateException("(Fishing loot table) Unexpected value: " + number);
                        }

                        LootTable loottable = ((ServerLevel) pPlayer.fishing.level()).getServer().getLootData().getLootTable(loot);
                        List<ItemStack> list = loottable.getRandomItems(lootparams);
                        LOGGER.info("LIST:" + list);
                        fishingrodPlayerDataUtil.setFishedItemList(list);
                        if(list.isEmpty()) {
                            pPlayer.sendSystemMessage(Component.literal("You need a more advanced fishing rod to catch it")); //List maybe empty because the limitation of fishing rod
                            i=4;
                            pPlayer.fishing.discard();
                        }//fishing game
                        else {
                            if(FishingLifeConfig.is_fishinggame.get()) {
                                if (list.get(0).is(ModTags.Items.MODFISH) || list.get(0).is(ModTags.Items.COMPAT_FISH) || list.get(0).is(ItemTags.FISHES)) {
                                    FishingGameFishLogicHandler.tension_init();
                                    fishingrodPlayerDataUtil.setGameflag(true);
                                } else {
                                    general_fishing_ending(pPlayer, 0);
                                    return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
                                }
                            }
                            else{
                                general_fishing_ending(pPlayer, 0);
                                return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
                            }
                        }
                    }
                    if (pPlayer.fishing.onGround()) {
                        i = 2;
                        pPlayer.fishing.discard();
                    }
                    if(pPlayer.fishing.nibble == 0) {
                        pPlayer.fishing.discard();
                    }
                }
                itemstack.hurtAndBreak(i, pPlayer, (p_41288_) -> {
                    p_41288_.broadcastBreakEvent(pHand);
                });
                pLevel.playSound((Player) null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.FISHING_BOBBER_RETRIEVE, SoundSource.NEUTRAL, 1.0F, 0.4F / (pLevel.getRandom().nextFloat() * 0.4F + 0.8F));
                pPlayer.gameEvent(GameEvent.ITEM_INTERACT_FINISH);
            }
                }
        else {
            pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.FISHING_BOBBER_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (pLevel.getRandom().nextFloat() * 0.4F + 0.8F));
            if (!pLevel.isClientSide) {
                int k = EnchantmentHelper.getFishingSpeedBonus(itemstack);
                int j = EnchantmentHelper.getFishingLuckBonus(itemstack);
                reset();
                pPlayer.getCapability(IntegrationProvider.FISHING_INTEGRATION).ifPresent(fishing -> {
                    fishing.resetALL();
                    fishing.generateRandomTension();
                });
                LOGGER.info("Starting trigger from empty");
                FishingHook fishingHook=new FishingHook(pPlayer, pLevel, j, k);
                 pLevel.addFreshEntity(fishingHook);
                 fishingrodPlayerDataUtil.setLuck(Math.max(0, j))  ;
            }

            pPlayer.awardStat(Stats.ITEM_USED.get(this));
            pPlayer.gameEvent(GameEvent.ITEM_INTERACT_START);
        }
        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
    }
    private static boolean shouldStopFishing(Player pPlayer, FishingHook hook) {
        return stop(pPlayer, hook, LOGGER);
    }
    private void pullEntity(Entity pEntity, FishingHook hook) {
        Entity entity = hook.getOwner();
        if (entity != null) {
            Vec3 vec3 = (new Vec3(entity.getX() - hook.getX(), entity.getY() - hook.getY(), entity.getZ() - hook.getZ())).scale(0.1D);
            pEntity.setDeltaMovement(pEntity.getDeltaMovement().add(vec3));
        }
    }
    public static int generateOneOrTwo() {
        return random.nextInt(2) + 1;
    }
    private void reset(){
        fishingrodPlayerDataUtil.setplayer(null) ;
        fishingrodPlayerDataUtil.setlevel(null) ;
        fishingrodPlayerDataUtil.setitemstack(null);
        fishingrodPlayerDataUtil.setHand(null);
        fishingrodPlayerDataUtil.setLuck(0);
        fishingrodPlayerDataUtil.setGameSuccess(false);
        fishingrodPlayerDataUtil.setTick_for_vitality(0);
        fishingrodPlayerDataUtil.setFishedItemList(null);
    }
}


