package com.FishingLife.fishinglife.item;
import com.FishingLife.fishinglife.client.fishingHUD.HUDIntegration;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.item.FishingRodItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.ItemFishedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Collections;
import java.util.List;

@Mod.EventBusSubscriber
public class ModFishingRodItem extends FishingRodItem {
    protected static final RandomSource random = RandomSource.create();
    private static final Logger LOGGER = LogManager.getLogger();
    private static Player player;

    private static Level level;

    private static ItemStack Itemstack;

    private static InteractionHand hand;

    private static boolean gameflag=false;

    private static boolean checkitem=false;

    private static boolean is_fishing=false;

    private static int tickcount=0;

    private final int totalcount=600;

    private static int luck;

    private static int damage;

    public ModFishingRodItem(Properties pProperties) {
        super(pProperties);
        gameflag=false;
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {

        ItemStack itemstack = pPlayer.getItemInHand(pHand);

        //LOGGER.info(pPlayer);

        if (pPlayer.fishing != null) {
            if (!pLevel.isClientSide) {
                player = pPlayer;
                level = pLevel;
                Itemstack = itemstack;
                hand = pHand;

                if (!player.fishing.level().isClientSide && player != null && !shouldStopFishing(player,player.fishing)) {
                    LOGGER.info("Nibble "+player.fishing.nibble);
                    int i = 0;
                    net.minecraftforge.event.entity.player.ItemFishedEvent event = null;
                    if (player.fishing.getHookedIn() != null) {
                        pullEntity(player.fishing.getHookedIn(),player.fishing);
                        CriteriaTriggers.FISHING_ROD_HOOKED.trigger((ServerPlayer)player, itemstack, player.fishing, Collections.emptyList());
                        player.fishing.level().broadcastEntityEvent(player.fishing, (byte)31);
                        i = player.fishing.getHookedIn() instanceof ItemEntity ? 3 : 5;
                        player.fishing.discard();
                    } else if (player.fishing.nibble > 0) {
                        gameflag = true;
                    }
                    if (player.fishing.onGround()) {
                        i = 2;
                        player.fishing.discard();
                    }
                    if(player.fishing.nibble == 0) {
                        player.fishing.discard();
                    }
                    damage=i;
                } else {
                    damage=0;
                }
                itemstack.hurtAndBreak(damage, pPlayer, (p_41288_) -> {
                    p_41288_.broadcastBreakEvent(pHand);
                });
                level.playSound((Player) null, player.getX(), player.getY(), player.getZ(), SoundEvents.FISHING_BOBBER_RETRIEVE, SoundSource.NEUTRAL, 1.0F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
                player.gameEvent(GameEvent.ITEM_INTERACT_FINISH);
            }
                }
        else {
            pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.FISHING_BOBBER_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (pLevel.getRandom().nextFloat() * 0.4F + 0.8F));
            if (!pLevel.isClientSide) {
                int k = EnchantmentHelper.getFishingSpeedBonus(itemstack);
                int j = EnchantmentHelper.getFishingLuckBonus(itemstack);
                is_fishing=false;
                damage=0;
                LOGGER.info("Starting trigger from empty");
                FishingHook fishingHook=new FishingHook(pPlayer, pLevel, j, k);
                 pLevel.addFreshEntity(fishingHook);

                 luck = Math.max(0, j);
            }

            pPlayer.awardStat(Stats.ITEM_USED.get(this));
            pPlayer.gameEvent(GameEvent.ITEM_INTERACT_START);
        }

        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
    }
 /*   @SubscribeEvent
    public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
        if(gameflag){
            if(is_fishing){
                gameflag=
            }
        }else{
            LOGGER.info("NO FISHINGROD interaction");
        }
    }




    public void setFlag(boolean a){
        gameflag=a;
    }
    public void resetCount(){
        tickcount=0;
    }

    @SubscribeEvent
    public static void onPlayerHurt(LivingHurtEvent event) {
        if (event.getEntity().level().isClientSide) {
            if (gameflag) {          //If player gets hurt, game ends
                gameflag = false;
            }
        }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            if (event.player.level().isClientSide) {
                if (checkitem) {          //Check if player is still using the fishing rod (if game starts)
                    Player player1 = event.player;
                    if (shouldStopFishing(player1, player1.fishing)) {
                        gameflag = false;
                        checkitem = false;
                    }

                }
            }
        }
    }
}*/

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            if (gameflag) {
                HUDIntegration.allinit();
                tickcount++;
                if (player.fishing == null) {
                    gameflag = false;
                    LOGGER.info("Cancel the fishing");
                } else {
                    if (tickcount == 60) {
                        LOGGER.info("This is an TICK log message for end of fishing");
                        gameflag = false;
                        tickcount = 0;
                        HUDIntegration.setInvisible();
                        if (!level.isClientSide) {
                            //LOGGER.info("???????? " + player.fishing.level());
                            //LOGGER.info("Determine ????? " + !player.fishing.level().isClientSide);

                            FishingHook temp = player.fishing;
                            Player temp_player = player;

                                //TEST:
                                //TEST hookedIn
                                LOGGER.info("HOOKED IN -------"+temp.getHookedIn());

                                LOGGER.info("I IS 0, IS FISHING");
                                is_fishing=true;

                                if (!temp.level().isClientSide && temp_player != null && !shouldStopFishing(temp_player, temp)) {
                                    LOGGER.info("PROCEED TO CUSTOM FISHING");
                                    LootParams lootparams = (new LootParams.Builder((ServerLevel) temp.level())).withParameter(LootContextParams.ORIGIN, temp.position()).withParameter(LootContextParams.TOOL, Itemstack).withParameter(LootContextParams.THIS_ENTITY, temp).withParameter(LootContextParams.KILLER_ENTITY, temp.getOwner()).withParameter(LootContextParams.THIS_ENTITY, temp).withLuck((float) luck + temp_player.getLuck()).create(LootContextParamSets.FISHING);   //luck should also be localized
                                    LootTable loottable = temp.level().getServer().getLootData().getLootTable(BuiltInLootTables.FISHING);
                                    List<ItemStack> list = loottable.getRandomItems(lootparams);
                                    net.minecraftforge.event.entity.player.ItemFishedEvent new_event = new ItemFishedEvent(list, temp.onGround() ? 2 : 1, temp);
                                    net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new_event);
                                    if (new_event.isCanceled()) {
                                        temp.discard();
                                        damage = new_event.getRodDamage();
                                    }
                                    CriteriaTriggers.FISHING_ROD_HOOKED.trigger((ServerPlayer) temp_player, Itemstack, temp, list);

                                    for (ItemStack itemstack : list) {
                                        ItemEntity itementity = new ItemEntity(temp.level(), temp.getX(), temp.getY(), temp.getZ(), itemstack);
                                        double d0 = temp_player.getX() - temp.getX();
                                        double d1 = temp_player.getY() - temp.getY();
                                        double d2 = temp_player.getZ() - temp.getZ();
                                        double d3 = 0.1D;
                                        itementity.setDeltaMovement(d0 * 0.1D, d1 * 0.1D + Math.sqrt(Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2)) * 0.08D, d2 * 0.1D);
                                        temp.level().addFreshEntity(itementity);
                                        temp_player.level().addFreshEntity(new ExperienceOrb(temp_player.level(), temp_player.getX(), temp_player.getY() + 0.5D, temp_player.getZ() + 0.5D, random.nextInt(6) + 1));   //same random
                                        if (itemstack.is(ItemTags.FISHES)) {
                                            temp_player.awardStat(Stats.FISH_CAUGHT, 1);
                                        }
                                    }

                                    damage = 1;
                                }
                            }

                            LOGGER.info("THE DAMAGE IS " + damage);

                            player.fishing.discard();
                            Itemstack.hurtAndBreak(damage, player, (p_41288_) -> {
                                p_41288_.broadcastBreakEvent(hand);
                            });
                        }

                        level.playSound((Player) null, player.getX(), player.getY(), player.getZ(), SoundEvents.FISHING_BOBBER_RETRIEVE, SoundSource.NEUTRAL, 1.0F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
                        player.gameEvent(GameEvent.ITEM_INTERACT_FINISH);

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
    private void pullEntity(Entity pEntity, FishingHook hook) {
        Entity entity = hook.getOwner();
        if (entity != null) {
            Vec3 vec3 = (new Vec3(entity.getX() - hook.getX(), entity.getY() - hook.getY(), entity.getZ() - hook.getZ())).scale(0.1D);
            pEntity.setDeltaMovement(pEntity.getDeltaMovement().add(vec3));
        }
    }
}


