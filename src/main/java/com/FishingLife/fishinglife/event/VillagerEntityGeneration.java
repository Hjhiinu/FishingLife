package com.FishingLife.fishinglife.event;

import com.FishingLife.fishinglife.entity.ModEntity;
import com.FishingLife.fishinglife.entity.NewVillager;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureStart;
import net.minecraftforge.event.level.ChunkEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod.EventBusSubscriber
public class VillagerEntityGeneration {
    private static final Logger LOGGER = LogManager.getLogger();
    @SubscribeEvent
    public static void onChunkLoad(ChunkEvent.Load event) {
        if (!(event.getLevel() instanceof ServerLevel)) {
            return;
        }
        ServerLevel world = (ServerLevel) event.getLevel();
        LevelChunk chunk = (LevelChunk) event.getChunk();
        if (event.isNewChunk()) {
            for (StructureStart structureStart : chunk.getAllStarts().values()) {
                Structure structure = structureStart.getStructure();
                if (structureStart != StructureStart.INVALID_START) {
                    ResourceLocation structureLoc = world.registryAccess().registryOrThrow(Registries.STRUCTURE).getKey(structure);
                    BlockPos structurePos = structureStart.getPieces().get(0).getBoundingBox().getCenter();
                    LOGGER.info("structurePos "+structurePos+" structure "+structureLoc);
                    if (new ResourceLocation("fishinglife:fishing_village").equals(structureLoc)) {
                        LOGGER.info("structure is matched");
                        int spawnnum=0;
                        while(spawnnum<6) {
                            spawn(world, structurePos.getX(), structurePos.getY() - 3, structurePos.getZ());
                            spawnnum++;
                        }
                    }
                }
            }
        }
    }

    private static void spawn(ServerLevel world, int X, int Y, int Z) {
        NewVillager villager = ModEntity.NEWVILLAGER.get().create(world);
        LOGGER.info("Mob is created");
        if(villager==null){
            LOGGER.info("Mob is null");
        }
        else {
            villager.moveTo(X, Y, Z);
            LOGGER.info("Mob is moved to right place");
            world.addFreshEntity(villager);
            LOGGER.info("Mob is add");
        }
    }
}
