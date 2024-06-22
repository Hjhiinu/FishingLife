package com.FishingLife.fishinglife.block.utilBlock;

import com.FishingLife.fishinglife.block.ModBlock;
import com.FishingLife.fishinglife.block.entity.ChoppingBoardBlockEntity;
import com.FishingLife.fishinglife.block.entity.ModBlockEntities;
import com.FishingLife.fishinglife.util.ModTags;
import com.teammetallurgy.aquaculture.item.ItemFilletKnife;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.ModList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;

import static com.FishingLife.fishinglife.item.FishItem.FishItemListProvider.RandomProcess;

public class ChoppingBoardBlock extends ModBlock implements EntityBlock {
    private static final int COOLDOWN_TICKS = 20;

    public ChoppingBoardBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ChoppingBoardBlockEntity(pos, state);
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!world.isClientSide) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof ChoppingBoardBlockEntity) {
                ChoppingBoardBlockEntity choppingBoard = (ChoppingBoardBlockEntity) blockEntity;

                long currentTime = System.currentTimeMillis();
                if (currentTime - choppingBoard.getLastInteractionTime() < 200) {
                    return InteractionResult.PASS;
                }
                choppingBoard.setLastInteractionTime(currentTime);

                ItemStack heldItem = player.getItemInHand(hand);
                if (!player.getCooldowns().isOnCooldown(heldItem.getItem())) {
                    if (heldItem.isEmpty()) {
                        // Picking up the item
                        if (choppingBoard.hasItem()) {
                            player.addItem(choppingBoard.getRenderStack());
                            choppingBoard.setRenderStack(ItemStack.EMPTY);
                            world.setBlock(pos, state, 3); // Update block state
                            return InteractionResult.SUCCESS;
                        }
                    } else {
                        // Placing the item
                        if (heldItem.is(ModTags.Items.MODFISH)) {
                            if (!choppingBoard.hasItem()) {
                                choppingBoard.setRenderStack(heldItem.split(1));
                                choppingBoard.setItemFacing(player.getDirection().getOpposite());
                                world.setBlock(pos, state, 3); // Update block state
                                return InteractionResult.SUCCESS;
                            }
                        } else if (heldItem.is(ModTags.Items.FISH_PROCESSING_KNIFE)) { //Cut the fish item
                            knifeInteraction(hit,  choppingBoard, player, heldItem, world,pos);
                            return InteractionResult.SUCCESS;
                        } else if (ModList.get().isLoaded("aquaculture")) {
                            if (heldItem.getItem() instanceof ItemFilletKnife){
                                knifeInteraction(hit,  choppingBoard, player, heldItem, world,pos);
                            }
                        }
                    }
                }
            }
        }
        return InteractionResult.PASS;
    }
    public void knifeInteraction(BlockHitResult hit,  ChoppingBoardBlockEntity choppingBoard, Player player, ItemStack heldItem, Level world, BlockPos pos){
        Direction facing = hit.getDirection();
        Direction direction = facing.getAxis() == Direction.Axis.Y ? player.getDirection().getOpposite() : facing;
        ItemEntity itemEntity = new ItemEntity(world, (double) pos.getX() + 0.5D + (double) direction.getStepX() * 0.65D, (double) pos.getY() + 0.1D, (double) pos.getZ() + 0.5D + (double) direction.getStepZ() * 0.65D, RandomProcess(player));
        choppingBoard.setRenderStack(ItemStack.EMPTY);
        itemEntity.setDeltaMovement(0.05D * (double) direction.getStepX() + world.random.nextDouble() * 0.02D, 0.05D, 0.05D * (double) direction.getStepZ() + world.random.nextDouble() * 0.02D);
        world.addFreshEntity(itemEntity);
        player.getCooldowns().addCooldown(heldItem.getItem(), COOLDOWN_TICKS);
        heldItem.hurtAndBreak(1, player, (p) -> {
            p.broadcastBreakEvent(InteractionHand.MAIN_HAND);
        });
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        if(pLevel.isClientSide()) {
            return null;
        }

        return createTickerHelper(pBlockEntityType, ModBlockEntities.CHOPPING_BOARD_PROCESS_BE.get(),
                (pLevel1, pPos, pState1, pBlockEntity) -> pBlockEntity.tick());
    }

    @Nullable
    protected static <E extends BlockEntity, A extends BlockEntity> BlockEntityTicker<A> createTickerHelper(BlockEntityType<A> pServerType, BlockEntityType<E> pClientType, BlockEntityTicker<? super E> pTicker) {
        return pClientType == pServerType ? (BlockEntityTicker<A>)pTicker : null;
    }
}
