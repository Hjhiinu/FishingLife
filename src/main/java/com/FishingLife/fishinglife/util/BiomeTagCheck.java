package com.FishingLife.fishinglife.util;

import com.FishingLife.fishinglife.fishinglife;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.Serializer;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = fishinglife.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BiomeTagCheck implements LootItemCondition {//Thanks to Team Metallurgy and their public minecraft mod repository

    private final BiomeTagPredicate predicate;            //These codes were copied from Aquaculture2 repository

    private BiomeTagCheck(BiomeTagPredicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public boolean test(LootContext context) {
        Vec3 pos = context.getParamOrNull(LootContextParams.ORIGIN);
        return pos != null && this.predicate.test(context.getLevel(), (float) pos.x(), (float) pos.y(), (float) pos.z());
    }

    @Override
    @Nonnull
    public LootItemConditionType getType() {
        return fishinglife.BIOME_TAG_CHECK;
    }

    public static class BiomeTagCheckSerializer implements Serializer<BiomeTagCheck> {

        @Override
        public void serialize(JsonObject json, BiomeTagCheck tagCheck, @Nonnull JsonSerializationContext context) {
            json.add("predicate", tagCheck.predicate.serialize());
        }

        @Override
        @Nonnull
        public BiomeTagCheck deserialize(JsonObject json, @Nonnull JsonDeserializationContext context) {
            return new BiomeTagCheck(BiomeTagPredicate.deserialize(json.get("predicate")));
        }
    }
}
