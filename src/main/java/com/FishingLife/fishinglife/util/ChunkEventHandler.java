/*package com.FishingLife.fishinglife.util;

import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.event.level.ChunkDataEvent;
import net.minecraftforge.event.level.ChunkEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ChunkEventHandler {


    @SubscribeEvent
    public static void onChunkDataLoad(ChunkDataEvent.Load event) {
        CompoundTag nbt = event.getData();

        if (!nbt.contains("Pollution Level")) {

            nbt.putString("Pollution Level","Test");
        }
    }

    @SubscribeEvent
    public static void onChunkSave(ChunkDataEvent.Save event) {

    }
}

 */


