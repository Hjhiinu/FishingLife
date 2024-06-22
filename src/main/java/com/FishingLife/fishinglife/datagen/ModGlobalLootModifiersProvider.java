package com.FishingLife.fishinglife.datagen;


import com.FishingLife.fishinglife.fishinglife;
import com.FishingLife.fishinglife.loot.AddItemModifier;
import com.FishingLife.fishinglife.registry.FishingLifeItemsRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, fishinglife.MOD_ID);
    }

    @Override
    protected void start() {
        //add("pine_cone_from_creeper", new ItemGlobalLootModifier(new LootItemCondition[] {
          //      new LootTableIdCondition.Builder(new ResourceLocation("entities/creeper")).build() }, Items.BEDROCK));


        add("anchor_pattern_item_from_shipwreck_treasure", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/shipwreck_treasure")).build()}, FishingLifeItemsRegistry.ANCHOR_PATTERN_ITEM.get()));

        add("pirate_pattern_item_from_shipwreck_treasure", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/shipwreck_treasure")).build()}, FishingLifeItemsRegistry.PIRATE_PATTERN_ITEM.get()));

        add("ship_pattern_item_from_shipwreck_treasure", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/shipwreck_treasure")).build()}, FishingLifeItemsRegistry.SHIP_PATTERN_ITEM.get()));

        add("seashell_pattern_item_from_shipwreck_treasure", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/shipwreck_treasure")).build()}, FishingLifeItemsRegistry.SEASHELL_PATTERN_ITEM.get()));


    }
}

