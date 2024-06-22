package com.FishingLife.fishinglife.block.entity;

import net.minecraft.core.Direction;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;

public class ChoppingBoardBlockEntity extends BlockEntity {
    private Direction itemFacing = Direction.NORTH;
    private ItemStack renderStack = ItemStack.EMPTY;
    private long lastInteractionTime = 0;

    public ChoppingBoardBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CHOPPING_BOARD_PROCESS_BE.get(), pos, state);
    }

    public ItemStack getRenderStack() {
        return renderStack;
    }

    public void setRenderStack(ItemStack stack) {
        this.renderStack = stack;
        setChanged();
        if (!level.isClientSide) {
            level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
        }
    }

    public boolean hasItem() {
        return !renderStack.isEmpty();
    }
    public long getLastInteractionTime() {
        return lastInteractionTime;
    }

    public void setLastInteractionTime(long lastInteractionTime) {
        this.lastInteractionTime = lastInteractionTime;
    }
    public Direction getItemFacing() {
        return itemFacing;
    }

    public void setItemFacing(Direction itemFacing) {
        this.itemFacing = itemFacing;
        setChanged();
        if (!level.isClientSide) {
            level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
        }
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        renderStack = ItemStack.of(tag.getCompound("ChoppingBoardRenderStack"));
        lastInteractionTime = tag.getLong("ChoppingBoardLastInteractionTime");
        itemFacing = Direction.from3DDataValue(tag.getInt("ChoppingBoardItemFacing"));
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.put("ChoppingBoardRenderStack", renderStack.save(new CompoundTag()));
        tag.putLong("ChoppingBoardLastInteractionTime", lastInteractionTime);
        tag.putInt("ChoppingBoardItemFacing", itemFacing.get3DDataValue());
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = super.getUpdateTag();
        saveAdditional(tag);
        return tag;
    }

    @Override
    public void handleUpdateTag(CompoundTag tag) {
        super.handleUpdateTag(tag);
        load(tag);
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }


    public void tick() {
        if (!renderStack.isEmpty() && renderStack.isDamageableItem() && renderStack.getDamageValue() >= renderStack.getMaxDamage()) {
            setRenderStack(ItemStack.EMPTY);
            setChanged();
        }
    }

}

