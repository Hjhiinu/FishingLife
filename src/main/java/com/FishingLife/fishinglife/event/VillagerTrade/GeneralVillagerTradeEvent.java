package com.FishingLife.fishinglife.event.VillagerTrade;

import com.FishingLife.fishinglife.ModVillager.ModVillagers;
import com.FishingLife.fishinglife.fishinglife;
import com.FishingLife.fishinglife.registry.FishingLifeBlocksRegistry;
import com.FishingLife.fishinglife.registry.FishingLifeItemsRegistry;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.function.Supplier;

import static com.FishingLife.fishinglife.ModVillager.ModVillagerTradeProvider.randomfunction;

@Mod.EventBusSubscriber(modid = fishinglife.MOD_ID)
public class GeneralVillagerTradeEvent {
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if (event.getType()== ModVillagers.OCEAN_FISHERMAN.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            // Level 1 trades
            addSimpleTrade(trades, 1, new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 32), new ItemStack(Items.NAUTILUS_SHELL, 2), 15, 4, 0);
            addSimpleTrade(trades, 1, new ItemStack(Items.GLOW_INK_SAC, 8), new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 20), 20, 4, 0);
            addSimpleTrade(trades, 1, new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 30), new ItemStack(Items.PRISMARINE_SHARD, 3), 20, 4, 0);
            addSimpleTrade(trades, 1, new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 64), new ItemStack(Items.COAST_ARMOR_TRIM_SMITHING_TEMPLATE, 1), 5, 4, 0);
            // Level 2 trades
            addTradeWithDurabilityCheck(trades, 2, "Common", 6, 9, 50, 5);
            addTradeWithDurabilityCheck(trades, 2, "Rare", 6, 10, 50, 6);
            addTradeWithDurabilityCheck(trades, 2, "Common", 7, 9, 50, 5);
            addTradeWithDurabilityCheck(trades, 2, "Rare", 7, 10, 50, 6);
            addTradeWithDurabilityCheck(trades, 2, "Common", 8, 9, 50, 5);
            addTradeWithDurabilityCheck(trades, 2, "Rare", 8, 10, 50, 6);
            // Level 3 trades
            addTradeWithDurabilityCheck(trades, 3, "Special", 6, 12, 50, 7);
            addTradeWithDurabilityCheck(trades, 3, "Extraordinary", 6, 13, 50, 8);
            addTradeWithDurabilityCheck(trades, 3, "Special", 7, 12, 50, 7);
            addTradeWithDurabilityCheck(trades, 3, "Extraordinary", 7, 13, 50, 8);
            addTradeWithDurabilityCheck(trades, 3, "Special", 8, 12, 50, 7);
            addTradeWithDurabilityCheck(trades, 3, "Extraordinary", 8, 13, 50, 8);
            // Level 4 trades
            addTradeWithDurabilityCheck(trades, 4, "Special", 6, 15, 50, 7);
            addTradeWithDurabilityCheck(trades, 4, "Extraordinary", 6, 16, 50, 8);
            addTradeWithDurabilityCheck(trades, 4, "Special", 7, 15, 50, 7);
            addTradeWithDurabilityCheck(trades, 4, "Extraordinary", 7, 16, 50, 8);
            addTradeWithDurabilityCheck(trades, 4, "Special", 8, 15, 50, 7);
            addTradeWithDurabilityCheck(trades, 4, "Extraordinary", 8, 16, 50, 8);
            //Level 5
            //TODO Still in Plan
        }
        if (event.getType()== ModVillagers.COLLECTOR.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            // Level 1 trades
            addSimpleTrade(trades, 1, new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 32), new ItemStack(Items.TURTLE_EGG, 2), 10, 4, 0);
            addSimpleTrade(trades, 1, new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 30), new ItemStack(Items.ICE, 5), 20, 5, 0);
            addSimpleTrade(trades, 1, new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_GOLD_COIN.get(), 34), new ItemStack(Items.NETHER_STAR, 1), 5, 20, 0);
            addSimpleTrade(trades, 1, new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_GOLD_COIN.get(), 23), new ItemStack(Items.HEART_OF_THE_SEA, 1), 8, 10, 0);
            addSimpleTrade(trades, 1, new ItemStack(Items.AMETHYST_SHARD, 5), new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 20), 15, 4, 0);
            addSimpleTrade(trades, 1, new ItemStack(Items.CHISELED_BOOKSHELF, 4), new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 15), 15, 4, 0);

            // Level 2 trades
            addSimpleTrade(trades, 2, new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 42), new ItemStack(Items.SNIFFER_EGG, 2), 10, 6, 0);
            addSimpleTrade(trades, 2, new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_GOLD_COIN.get(), 23), new ItemStack(Items.MYCELIUM, 5), 15, 6, 0);

            // Level 3 trades
            addSimpleTrade(trades, 3, new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_GOLD_COIN.get(), 24), new ItemStack(Items.EXPERIENCE_BOTTLE, 10), 15, 10, 0);
            addSimpleTrade(trades, 3, new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_GOLD_COIN.get(), 40), new ItemStack(Items.ELYTRA, 1), 3, 22, 0);

            /*//Level 4
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 640),
                    new ItemStack(Items.ENCHANTED_GOLDEN_APPLE,1),
                    3, 100,0));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 640),
                    new ItemStack(Items.PLAYER_HEAD,1),
                    3, 100,0));

             */
        }
        if(event.getType() == ModVillagers.SEAEFOOD_WHOLESALE_MERCHANT.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            // Level 1 trades
            addTradeWithDurabilityCheck(trades, 1, "Common", 5, 2, 5, 50, 5);
            addTradeWithDurabilityCheck(trades, 1, "Common", 5, 2, 5, 50, 5);
            addTradeWithDurabilityCheck(trades, 1, "Rare", 5, 2, 7, 50, 5);
            addTradeWithDurabilityCheck(trades, 1, "Rare", 5, 2, 7, 50, 5);
            addTradeWithDurabilityCheck(trades, 1, "Special", 5, 2, 9, 50, 7);
            addTradeWithDurabilityCheck(trades, 1, "Extraordinary", 5, 2, 11, 50, 8);

            // Level 2 trades
            addTradeWithDurabilityCheck(trades, 2, "Common", 5, 2, 7, 50, 6);
            addTradeWithDurabilityCheck(trades, 2, "Common", 5, 2, 7, 50, 6);
            addTradeWithDurabilityCheck(trades, 2, "Rare", 5, 2, 9, 50, 6);
            addTradeWithDurabilityCheck(trades, 2, "Rare", 5, 2, 9, 50, 6);
            addTradeWithDurabilityCheck(trades, 2, "Special", 5, 2, 12, 50, 8);
            addTradeWithDurabilityCheck(trades, 2, "Extraordinary", 5, 2, 14, 50, 10);

            // Level 3 trades
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 25),
                    new ItemStack(FishingLifeBlocksRegistry.FISHINGMACHINE.get(), 1),
                    50, 6,0));
            addTradeWithDurabilityCheck(trades, 3, "Rare", 5, 2, 10, 50, 7);
            addTradeWithDurabilityCheck(trades, 3, "Special", 5, 2, 14, 50, 10);
            addTradeWithDurabilityCheck(trades, 3, "Special", 5, 2, 14, 50, 10);
            addTradeWithDurabilityCheck(trades, 3, "Extraordinary", 5, 2, 16, 50, 11);
            addTradeWithDurabilityCheck(trades, 3, "Extraordinary", 5, 2, 16, 50, 11);

            // Level 4 trades
            addTradeWithDurabilityCheck(trades, 4, "Special", 5, 2, 18, 50, 14);
            addTradeWithDurabilityCheck(trades, 4, "Special", 5, 2, 18, 50, 14);
            addTradeWithDurabilityCheck(trades, 4, "Extraordinary", 5, 2, 20, 50, 15);
            addTradeWithDurabilityCheck(trades, 4, "Extraordinary", 5, 2, 20, 50, 15);
            //Level 5
            //TODO Still in Plan

        }

        if(event.getType() == ModVillagers.JUNGLE_FISHERMAN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            // Level 1 trades
            addTradeWithDurabilityCheck(trades, 1, "Common", 3, 4, 50, 4);
            addTradeWithDurabilityCheck(trades, 1, "Common", 3, 4, 50, 4);
            addTradeWithDurabilityCheck(trades, 1, "Rare", 3, 6, 50, 4);
            addTradeWithDurabilityCheck(trades, 1, "Rare", 3, 6, 50, 4);
            addTradeWithDurabilityCheck(trades, 1, "Special", 3, 8, 50, 4);
            addTradeWithDurabilityCheck(trades, 1, "Extraordinary", 3, 10, 50, 4);

            // Level 2 trades
            addTradeWithDurabilityCheck(trades, 2, "Common", 4, 6, 50, 6);
            addTradeWithDurabilityCheck(trades, 2, "Common", 4, 6, 50, 6);
            addTradeWithDurabilityCheck(trades, 2, "Rare", 4, 8, 50, 6);
            addTradeWithDurabilityCheck(trades, 2, "Rare", 4, 8, 50, 6);
            addTradeWithDurabilityCheck(trades, 2, "Special", 4, 10, 50, 6);
            addTradeWithDurabilityCheck(trades, 2, "Extraordinary", 4, 12, 50, 6);

            // Level 3 trades
            addTradeWithDurabilityCheck(trades, 3, "Special", 3, 12, 50, 8);
            addTradeWithDurabilityCheck(trades, 3, "Special", 3, 12, 50, 8);
            addTradeWithDurabilityCheck(trades, 3, "Special", 4, 14, 50, 8);
            addTradeWithDurabilityCheck(trades, 3, "Special", 4, 14, 50, 8);
            addTradeWithDurabilityCheck(trades, 3, "Extraordinary", 3, 16, 50, 8);
            addTradeWithDurabilityCheck(trades, 3, "Extraordinary", 4, 18, 50, 8);

            // Level 4 trades
            addTradeWithDurabilityCheck(trades, 4, "Extraordinary", 3, 18, 50, 8);
            addTradeWithDurabilityCheck(trades, 4, "Extraordinary", 3, 18, 50, 8);
            addTradeWithDurabilityCheck(trades, 4, "Extraordinary", 4, 18, 50, 8);
            addTradeWithDurabilityCheck(trades, 4, "Extraordinary", 4, 18, 50, 8);

            //Level 5
            //TODO     Still in Plan

        }

        if(event.getType() == ModVillagers.GENERAL_FISHERMAN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            // Level 1 trades
            addTradeWithDurabilityCheck(trades, 1, "Common", 1, 4, 50, 4);
            addTradeWithDurabilityCheck(trades, 1, "Common", 1, 4, 50, 4);
            addTradeWithDurabilityCheck(trades, 1, "Rare", 1, 6, 50, 4);
            addTradeWithDurabilityCheck(trades, 1, "Rare", 1, 6, 50, 4);
            addTradeWithDurabilityCheck(trades, 1, "Special", 1, 8, 50, 4);
            addTradeWithDurabilityCheck(trades, 1, "Extraordinary", 1, 10, 50, 4);

            // Level 2 trades
            addTradeWithDurabilityCheck(trades, 2, "Common", 2, 6, 50, 6);
            addTradeWithDurabilityCheck(trades, 2, "Common", 2, 6, 50, 6);
            addTradeWithDurabilityCheck(trades, 2, "Rare", 2, 8, 50, 6);
            addTradeWithDurabilityCheck(trades, 2, "Rare", 2, 8, 50, 6);
            addTradeWithDurabilityCheck(trades, 2, "Special", 2, 10, 50, 6);
            addTradeWithDurabilityCheck(trades, 2, "Extraordinary", 2, 12, 50, 6);

            // Level 3 trades
            addTradeWithDurabilityCheck(trades, 3, "Special", 1, 12, 50, 8);
            addTradeWithDurabilityCheck(trades, 3, "Special", 1, 12, 50, 8);
            addTradeWithDurabilityCheck(trades, 3, "Special", 2, 14, 50, 8);
            addTradeWithDurabilityCheck(trades, 3, "Special", 2, 14, 50, 8);
            addTradeWithDurabilityCheck(trades, 3, "Extraordinary", 1, 16, 50, 8);
            addTradeWithDurabilityCheck(trades, 3, "Extraordinary", 2, 18, 50, 8);

            // Level 4 trades
            addTradeWithDurabilityCheck(trades, 4, "Extraordinary", 1, 18, 50, 8);
            addTradeWithDurabilityCheck(trades, 4, "Extraordinary", 1, 18, 50, 8);
            addTradeWithDurabilityCheck(trades, 4, "Extraordinary", 2, 18, 50, 8);
            addTradeWithDurabilityCheck(trades, 4, "Extraordinary", 2, 18, 50, 8);
            //Level 5
            //TODO     Still in Plan

        }

        if(event.getType() == ModVillagers.DESERT_FISHERMAN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            // Level 1 trades
            addTradeWithDurabilityCheck(trades, 1, "Common", 0, 4, 50, 4);
            addTradeWithDurabilityCheck(trades, 1, "Common", 0, 4, 50, 4);
            addTradeWithDurabilityCheck(trades, 1, "Rare", 0, 6, 50, 4);
            addTradeWithDurabilityCheck(trades, 1, "Rare", 0, 6, 50, 4);
            addTradeWithDurabilityCheck(trades, 1, "Special", 0, 8, 50, 4);
            addTradeWithDurabilityCheck(trades, 1, "Extraordinary", 0, 10, 50, 4);

            // Level 2 trades
            addTradeWithDurabilityCheck(trades, 2, "Special", 0, 12, 50, 8);
            addTradeWithDurabilityCheck(trades, 2, "Special", 0, 12, 50, 8);

            // Level 3 trades
            addTradeWithDurabilityCheck(trades, 3, "Extraordinary", 0, 16, 50, 8);
            addTradeWithDurabilityCheck(trades, 3, "Extraordinary", 0, 18, 50, 8);
            addTradeWithDurabilityCheck(trades, 3, "Extraordinary", 0, 18, 50, 8);
            //TODO     Still in Plan
        }

    }
    private static void addTradeWithDurabilityCheck(Int2ObjectMap<List<VillagerTrades.ItemListing>> trades, int level,
                                                    String quality, int fishgroup, int coinCount, int maxUses, int xpValue) {
        trades.get(level).add((pTrader, pRandom) -> {
            ItemStack itemToBuy = randomfunction(quality, fishgroup);
            ItemStack itemToSell = new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), coinCount);

            // Check if the item to buy is at full durability
            if (itemToBuy.isDamageableItem() && itemToBuy.getDamageValue() != 0) {
                return null;
            }
            return new MerchantOffer(itemToBuy, itemToSell, maxUses, xpValue, 0);
        });
    }

    private static void addTradeWithDurabilityCheck(Int2ObjectMap<List<VillagerTrades.ItemListing>> trades, int level,
                                                    String quality, int fishgroup, int fishcount, int coinCount, int maxUses, int xpValue) {
        trades.get(level).add((pTrader, pRandom) -> {
            ItemStack itemToBuy = randomfunction(quality, fishgroup,fishcount);
            ItemStack itemToSell = new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), coinCount);

            // Check if the item to buy is at full durability
            if (itemToBuy.isDamageableItem() && itemToBuy.getDamageValue() != 0) {
                return null;
            }
            return new MerchantOffer(itemToBuy, itemToSell, maxUses, xpValue, 0);
        });
    }

    private static void addSimpleTrade(Int2ObjectMap<List<VillagerTrades.ItemListing>> trades, int level,
                                       ItemStack itemToBuy, ItemStack itemToSell, int maxUses, int xpValue, float priceMultiplier) {
        trades.get(level).add((pTrader, pRandom) -> new MerchantOffer(itemToBuy, itemToSell, maxUses, xpValue, priceMultiplier));
    }

}
