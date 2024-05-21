package com.FishingLife.fishinglife.event;

import com.FishingLife.fishinglife.ModVillager.ModVillagers;
import com.FishingLife.fishinglife.capability.fishingMechanism.Integration;
import com.FishingLife.fishinglife.capability.fishingMechanism.IntegrationProvider;
import com.FishingLife.fishinglife.capability.fishingexperience.fishingexperience;
import com.FishingLife.fishinglife.capability.fishingexperience.fishingexperienceProvider;
import com.FishingLife.fishinglife.fishinglife;
import com.FishingLife.fishinglife.registry.FishingLifeBlocksRegistry;
import com.FishingLife.fishinglife.registry.FishingLifeItemsRegistry;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import java.util.List;

import static com.FishingLife.fishinglife.ModVillager.ModVillagerTradeProvider.randomfunction;

@Mod.EventBusSubscriber(modid = fishinglife.MOD_ID)
public class ModEvents {
   /* public static String getRandomRarity() {
        Random random = new Random();
        int rarityValue = random.nextInt(4); // Generates a number from 0 to 3

        switch (rarityValue) {
            case 0:
                return "Common";
            case 1:
                return "Rare";
            case 2:
                return "Special";
            case 3:
                return "Extraordinary";
            default:
                return "Unknown"; // Fallback, should never occur
        }
    }

    */
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if (event.getType()== ModVillagers.OCEAN_FISHERMAN.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //Level 1
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 32),
                    new ItemStack(Items.NAUTILUS_SHELL,2),
                    15, 4,0));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.GLOW_INK_SAC,8),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 20),
                    20, 4,0));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 30),
                    new ItemStack(Items.PRISMARINE_SHARD,3),
                    20, 4,0));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 64),
                    new ItemStack(Items.COAST_ARMOR_TRIM_SMITHING_TEMPLATE,1),
                    5, 4,0));
            //Level 2
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Common",6),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 9),
                    50, 5,0));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Rare",6),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 10),
                    50, 6,0));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Common",7),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 9),
                    50, 5,0));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Rare",7),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 10),
                    50, 6,0));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Common",8),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 9),
                    50, 5,0));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Rare",8),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 10),
                    50, 6,0));
            //Level 3
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Special",6),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 12),
                    50, 7,0));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Extraordinary",6),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 13),
                    50, 8,0));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Special",7),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 12),
                    50, 7,0));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Extraordinary",7),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 13),
                    50, 8,0));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Special",8),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 12),
                    50, 7,0));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Extraordinary",8),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 13),
                    50, 8,0));
            //Level 4
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Special",6),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 15),
                    50, 7,0));
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Extraordinary",6),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 16),
                    50, 8,0));
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Special",7),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 15),
                    50, 7,0));
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Extraordinary",7),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 16),
                    50, 8,0));
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Special",8),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 15),
                    50, 7,0));
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Extraordinary",8),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 16),
                    50, 8,0));
            //Level 5
            //TODO Still in Plan
        }
        if (event.getType()== ModVillagers.COLLECTOR.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //Level 1
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 32),
                    new ItemStack(Items.TURTLE_EGG,2),
                    10, 4,0));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 30),
                    new ItemStack(Items.ICE,5),
                    20, 5,0));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_GOLD_COIN.get(), 34),
                    new ItemStack(Items.NETHER_STAR,1),
                    5, 20,0));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_GOLD_COIN.get(), 23),
                    new ItemStack(Items.HEART_OF_THE_SEA,1),
                    8, 10,0));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.AMETHYST_SHARD,5),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 20),
                    15, 4,0));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.CHISELED_BOOKSHELF,4),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 15),
                    15, 4,0));
            //Level 2
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 42),
                    new ItemStack(Items.SNIFFER_EGG,2),
                    10, 6,0));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_GOLD_COIN.get(), 23),
                    new ItemStack(Items.MYCELIUM,5),
                    15, 6,0));
            //Level 3
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_GOLD_COIN.get(), 24),
                    new ItemStack(Items.EXPERIENCE_BOTTLE,10),
                    15, 10,0));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_GOLD_COIN.get(), 40),
                    new ItemStack(Items.ELYTRA,1),
                    3, 22,0));

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
            // Level 1
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Common",5,2),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 5),
                    50, 5,0));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Common",5,2),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 5),
                    50, 5,0));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Rare",5,2),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 7),
                    50, 5,0));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Rare",5,2),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 7),
                    50, 5,0));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Special",5,2),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 9),
                    50, 7,0));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Extraordinary",5,2),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 11),
                    50, 8,0));

            //Level 2
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Common",5,2),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 7),
                    50, 6,0));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Common",5,2),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 7),
                    50, 6,0));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Rare",5,2),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 9),
                    50, 6,0));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Rare",5,2),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 9),
                    50, 6,0));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Special",5,2),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 12),
                    50, 8,0));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Extraordinary",5,2),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 14),
                    50, 10,0));

            //Level 3
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 25),
                    new ItemStack(FishingLifeBlocksRegistry.FISHINGMACHINE.get(), 1),
                    50, 6,0));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Rare",5,2),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 10),
                    50, 7,0));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Special",5,2),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 14),
                    50, 10,0));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Special",5,2),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 14),
                    50, 10,0));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Extraordinary",5,2),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 16),
                    50, 11,0));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Extraordinary",5,2),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 16),
                    50, 11,0));
            //Level 4
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Special",5,2),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 18),
                    50, 14,0));
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Special",5,2),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 18),
                    50, 14,0));
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Extraordinary",5,2),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 20),
                    50, 15,0));
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Extraordinary",5,2),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 20),
                    50, 15,0));
            //Level 5
            //TODO Still in Plan

        }

        if(event.getType() == ModVillagers.JUNGLE_FISHERMAN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            // Level 1
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Common",3),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 4),
                    50, 4,0));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Common",3),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 4),
                    50, 4,0));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Rare",3),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 6),
                    50, 4,0));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Rare",3),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 6),
                    50, 4,0));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Special",3),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 8),
                    50, 4,0));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Extraordinary",3),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 10),
                    50, 4,0));

            //Level 2
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Common",4),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 6),
                    50, 6,0));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Common",4),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 6),
                    50, 6,0));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Rare",4),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 8),
                    50, 6,0));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Rare",4),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 8),
                    50, 6,0));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Special",4),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 10),
                    50, 6,0));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Extraordinary",4),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 12),
                    50, 6,0));

            //Level 3
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Special",3),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 12),
                    50, 8,0));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Special",3),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 12),
                    50, 8,0));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Special",4),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 14),
                    50, 8,0));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Special",4),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 14),
                    50, 8,0));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Extraordinary",3),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 16),
                    50, 8,0));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Extraordinary",4),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 18),
                    50, 8,0));
            //Level 4
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Extraordinary",3),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 18),
                    50, 8,0));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Extraordinary",3),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 18),
                    50, 8,0));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Extraordinary",4),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 18),
                    50, 8,0));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Extraordinary",4),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 18),
                    50, 8,0));

            //Level 5
            //TODO     Still in Plan

        }

        if(event.getType() == ModVillagers.GENERAL_FISHERMAN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            // Level 1
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Common",1),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 4),
                    50, 4,0));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Common",1),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 4),
                    50, 4,0));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Rare",1),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 6),
                    50, 4,0));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Rare",1),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 6),
                    50, 4,0));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Special",1),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 8),
                    50, 4,0));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Extraordinary",1),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 10),
                    50, 4,0));

            //Level 2
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Common",2),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 6),
                    50, 6,0));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Common",2),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 6),
                    50, 6,0));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Rare",2),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 8),
                    50, 6,0));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Rare",2),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 8),
                    50, 6,0));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Special",2),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 10),
                    50, 6,0));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Extraordinary",2),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 12),
                    50, 6,0));

            //Level 3
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Special",1),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 12),
                    50, 8,0));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Special",1),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 12),
                    50, 8,0));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Special",2),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 14),
                    50, 8,0));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Special",2),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 14),
                    50, 8,0));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Extraordinary",1),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 16),
                    50, 8,0));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Extraordinary",2),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 18),
                    50, 8,0));
            //Level 4
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Extraordinary",1),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 18),
                    50, 8,0));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Extraordinary",1),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 18),
                    50, 8,0));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Extraordinary",2),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 18),
                    50, 8,0));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Extraordinary",2),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 18),
                    50, 8,0));
            //Level 5
            //TODO     Still in Plan

        }

        if(event.getType() == ModVillagers.DESERT_FISHERMAN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            // Level 1
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Common",0),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 4),
                    50, 4,0));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Common",0),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 4),
                    50, 4,0));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Rare",0),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 6),
                    50, 4,0));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Rare",0),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 6),
                    50, 4,0));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Special",0),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 8),
                    50, 4,0));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Extraordinary",0),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 10),
                    50, 4,0));
            //Level 2
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Special",0),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 12),
                    50, 8,0));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                   randomfunction("Special",0),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 12),
                    50, 8,0));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Extraordinary",0),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 16),
                    50, 8,0));
            //Level 3
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    randomfunction("Extraordinary",0),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 18),
                    50, 8,0));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                   randomfunction("Extraordinary",0),
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 18),
                    50, 8,0));
                //TODO     Still in Plan




        }

    }



    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof Player) {
            if (!event.getObject().getCapability(fishingexperienceProvider.PLAYER_FISHING_EXPERIENCE).isPresent()) {
                event.addCapability(new ResourceLocation(fishinglife.MOD_ID, "fishing_experience_properties"), new fishingexperienceProvider());
            }
            if (!event.getObject().getCapability(IntegrationProvider.FISHING_INTEGRATION).isPresent()) {
                event.addCapability(new ResourceLocation(fishinglife.MOD_ID, "fishing_mechanisms_properties"), new IntegrationProvider());
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        if(event.isWasDeath()) {
            event.getOriginal().getCapability(fishingexperienceProvider.PLAYER_FISHING_EXPERIENCE).ifPresent(oldStore -> {
                event.getOriginal().getCapability(fishingexperienceProvider.PLAYER_FISHING_EXPERIENCE).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });
            event.getOriginal().getCapability(IntegrationProvider.FISHING_INTEGRATION).ifPresent(oldStore -> {
                event.getOriginal().getCapability(IntegrationProvider.FISHING_INTEGRATION).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });
        }
    }

    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.register(fishingexperience.class);
        event.register(Integration.class);
    }


    @SubscribeEvent
    public static void addCustomWanderingTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        //List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();   TODO STILL IN PLAN

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 2),
                new ItemStack(FishingLifeItemsRegistry.BOK_CHOY_SEEDS.get(), 10),
                3, 3, 0.2f));

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 2),
                new ItemStack(FishingLifeItemsRegistry.SCALLION_SEEDS.get(), 10),
                3, 3, 0.2f));

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 2),
                new ItemStack(FishingLifeItemsRegistry.SOYBEAN_SEEDS.get(), 10),
                3, 3, 0.2f));

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 2),
                new ItemStack(FishingLifeItemsRegistry.GREEN_PEPPER_SEEDS.get(), 10),
                3, 3, 0.2f));

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 2),
                new ItemStack(FishingLifeItemsRegistry.PADDY_SEEDS.get(), 10),
                3, 3, 0.2f));

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 2),
                new ItemStack(FishingLifeItemsRegistry.CHILI_PEPPER_SEEDS.get(), 10),
                3, 3, 0.2f));
    }
}



