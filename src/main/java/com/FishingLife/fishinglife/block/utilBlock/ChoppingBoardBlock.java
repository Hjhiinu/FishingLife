package com.FishingLife.fishinglife.block.utilBlock;

import com.FishingLife.fishinglife.block.ModBlock;
import com.FishingLife.fishinglife.block.entity.ChoppingBoardBlockEntity;
import com.FishingLife.fishinglife.block.entity.ModBlockEntities;
import com.FishingLife.fishinglife.util.ModTags;
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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;

public class ChoppingBoardBlock extends ModBlock implements EntityBlock {

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
                        if(heldItem.is(ModTags.Items.MODFISH)) {
                            if (!choppingBoard.hasItem()) {
                                choppingBoard.setRenderStack(heldItem.split(1));
                                choppingBoard.setItemFacing(player.getDirection().getOpposite());
                                world.setBlock(pos, state, 3); // Update block state
                                return InteractionResult.SUCCESS;
                            }
                        }
                }
            }
        }
        return InteractionResult.PASS;
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
