package com.FishingLife.fishinglife.fishingexperience;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class fishingexperienceProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<fishingexperience> PLAYER_FISHING_EXPERIENCE = CapabilityManager.get(new CapabilityToken<fishingexperience>() { });

    private fishingexperience experience = null;
    private final LazyOptional<fishingexperience> optional = LazyOptional.of(this::createPlayerfishingexperience);

    private fishingexperience createPlayerfishingexperience() {
        if(this.experience == null) {
            this.experience = new fishingexperience();
        }

        return this.experience;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == PLAYER_FISHING_EXPERIENCE) {
            return optional.cast();
        }

        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createPlayerfishingexperience().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createPlayerfishingexperience().loadNBTData(nbt);
    }
}