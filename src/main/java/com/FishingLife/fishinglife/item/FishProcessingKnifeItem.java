package com.FishingLife.fishinglife.item;

import com.FishingLife.fishinglife.block.entity.ChoppingBoardBlockEntity;
import com.FishingLife.fishinglife.util.ModTags;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nonnull;

import static com.FishingLife.fishinglife.item.FishItem.FishItemListProvider.RandomProcess;

public class FishProcessingKnifeItem extends TieredItem implements Vanishable {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final int COOLDOWN_TICKS = 20;
    private final float attackDamageBaseline;

    private final Multimap<Attribute, AttributeModifier> defaultModifiers;

    // private int Roughness;
    public FishProcessingKnifeItem(Tier pTier, float pAttackDamageModifier, float pAttackSpeedModifier, Item.Properties pProperties) {
        super(pTier, pProperties);
        this.attackDamageBaseline = pAttackDamageModifier + pTier.getAttackDamageBonus();
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", (double)this.attackDamageBaseline, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", (double)pAttackSpeedModifier, AttributeModifier.Operation.ADDITION));
        this.defaultModifiers = builder.build();
        //   this.Roughness=0;
    }
    public float getAttackDamage() {
        return this.attackDamageBaseline;
    }

    public boolean canAttackBlock(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer) {
        return !pPlayer.isCreative();
    }
    public float getDestroySpeed(ItemStack pStack, BlockState pState) {
        if (pState.is(Blocks.COBWEB)) {
            return 8.0F;
        }
        else if(pState.is(BlockTags.CORALS)){
            return 8.0F;
        }
        else {
            return pState.is(BlockTags.SWORD_EFFICIENT) ? 1.5F : 1.0F;
        }
    }
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pStack.hurtAndBreak(4, pAttacker, (p_43296_) -> {
            p_43296_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
        });
        return true;
    }
    public boolean mineBlock(ItemStack pStack, Level pLevel, BlockState pState, BlockPos pPos, LivingEntity pEntityLiving) {
        if (pState.getDestroySpeed(pLevel, pPos) != 0.0F) {
            pStack.hurtAndBreak(8, pEntityLiving, (p_43276_) -> {
                p_43276_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
            });
        }
        return true;
    }

    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pEquipmentSlot) {
        return pEquipmentSlot == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(pEquipmentSlot);
    }

    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer,InteractionHand pHand) {
        ItemStack itemStack = pPlayer.getItemInHand(InteractionHand.MAIN_HAND);
        ItemStack offhandItem = pPlayer.getItemInHand(InteractionHand.OFF_HAND);
        if (!pLevel.isClientSide&&!pPlayer.getCooldowns().isOnCooldown(this)) {


            if (offhandItem.is(ModTags.Items.MODFISH)) {
                giveItem(pPlayer,RandomProcess(offhandItem,pPlayer));
                itemStack.hurtAndBreak(2, pPlayer, (p) -> {
                    p.broadcastBreakEvent(InteractionHand.MAIN_HAND);
                });
                offhandItem.hurtAndBreak(60, pPlayer, (p) -> {
                    p.broadcastBreakEvent(InteractionHand.OFF_HAND);
                });
               // LOGGER.info("Use");
                pPlayer.getCooldowns().addCooldown(this, COOLDOWN_TICKS);
                return InteractionResultHolder.success(itemStack);
            }


        }
        return InteractionResultHolder.pass(itemStack);
    }

    private void giveItem(Player player, @Nonnull ItemStack stack) {
        if (!player.getInventory().add(stack)) {
            player.drop(stack, false);
        } else if (player instanceof ServerPlayer) {
            player.inventoryMenu.sendAllDataToRemote();
        }
    }

    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();
        ItemStack itemStack = context.getItemInHand();
        Direction facing = context.getClickedFace();

        if (!level.isClientSide && player!=null&&!player.getCooldowns().isOnCooldown(this)) {
            if (level.getBlockEntity(pos) instanceof ChoppingBoardBlockEntity blockEntity) {
                Direction direction = facing.getAxis() == Direction.Axis.Y ? player.getDirection().getOpposite() : facing;
                ItemEntity itemEntity = new ItemEntity(level, (double) pos.getX() + 0.5D + (double) direction.getStepX() * 0.65D, (double) pos.getY() + 0.1D, (double) pos.getZ() + 0.5D + (double) direction.getStepZ() * 0.65D, RandomProcess(blockEntity.getRenderStack(),player));
                itemEntity.setDeltaMovement(0.05D * (double) direction.getStepX() + level.random.nextDouble() * 0.02D, 0.05D, 0.05D * (double) direction.getStepZ() + level.random.nextDouble() * 0.02D);
                level.addFreshEntity(itemEntity);
                player.getCooldowns().addCooldown(this, COOLDOWN_TICKS);
                if(player.isCreative()){
                    return InteractionResult.SUCCESS;
                }
                blockEntity.decreaseStoredItemDurability(20);
                itemStack.hurtAndBreak(2, player, (p) -> {
                    p.broadcastBreakEvent(InteractionHand.MAIN_HAND);
                });

                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }

    private static void pushTagCopleteness(ItemStack stack){
        if (!stack.hasTag()) {
            stack.setTag(new CompoundTag());
            LOGGER.info("Unusual method to obtain the fish");
        }
        CompoundTag tag = stack.getTag();
        if(tag != null) {
            tag.putString("Completeness", "Some parts are missing");
        }
    }
}




/*
    public int getRoughness() {
        return this.Roughness;
    }

    public void setRoughness(int roughness) {
        this.Roughness = roughness;
    }
    public void IncreaseRoughness() {
        this.Roughness++;
    }

     */

