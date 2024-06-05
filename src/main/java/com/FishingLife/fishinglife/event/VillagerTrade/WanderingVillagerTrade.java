package com.FishingLife.fishinglife.event.VillagerTrade;

import com.FishingLife.fishinglife.fishinglife;
import com.FishingLife.fishinglife.registry.FishingLifeItemsRegistry;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
@Mod.EventBusSubscriber(modid = fishinglife.MOD_ID)
public class WanderingVillagerTrade {
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
