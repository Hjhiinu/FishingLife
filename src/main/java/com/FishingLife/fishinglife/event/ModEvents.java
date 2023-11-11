package com.FishingLife.fishinglife.event;

import com.FishingLife.fishinglife.ModVillager.ModVillagers;
import com.FishingLife.fishinglife.fishinglife;
import com.FishingLife.fishinglife.registry.FishingLifeItemsRegistry;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = fishinglife.MOD_ID)
public class ModEvents {


    public static int randomnum(){
        return (int) (Math.random() * 9);
    }

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if(event.getType() == ModVillagers.JUNGLE_FISHERMAN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

           ItemStack jungle1 =new ItemStack(FishingLifeItemsRegistry.HYDROLYCUS_ARMATUS.get(),2);
           CompoundTag a1=jungle1.getOrCreateTag();
            a1.putString("Quality","Special");

            ItemStack jungle2 =new ItemStack(FishingLifeItemsRegistry.SALMINUS.get(),2);
            CompoundTag a2=jungle2.getOrCreateTag();
            a2.putString("Quality","Special");

            ItemStack jungle3 =new ItemStack(FishingLifeItemsRegistry.PIRANHA.get(),2);
            CompoundTag a3=jungle3.getOrCreateTag();
            a3.putString("Quality","Special");

            ItemStack jungle4 =new ItemStack(FishingLifeItemsRegistry.ACANTHODORAS.get(),2);
            CompoundTag a4=jungle4.getOrCreateTag();
            a4.putString("Quality","Special");

            ItemStack jungle5 =new ItemStack(FishingLifeItemsRegistry.CETOPSIDIUM.get(),2);
            CompoundTag a5=jungle5.getOrCreateTag();
            a5.putString("Quality","Special");

            ItemStack jungle6 =new ItemStack(FishingLifeItemsRegistry.PANCAKE_STINGRAYS.get(),2);
            CompoundTag a6=jungle6.getOrCreateTag();
            a6.putString("Quality","Special");

            ItemStack jungle7 =new ItemStack(FishingLifeItemsRegistry.DISCUS.get(),2);
            CompoundTag a7=jungle7.getOrCreateTag();
            a7.putString("Quality","Special");

            ItemStack jungle8 =new ItemStack(FishingLifeItemsRegistry.RAINBOW_FISH.get(),2);
            CompoundTag a8=jungle8.getOrCreateTag();
            a8.putString("Quality","Special");

            ItemStack jungle9 =new ItemStack(FishingLifeItemsRegistry.PEACOCK_BASS.get(),2);
            CompoundTag a9=jungle9.getOrCreateTag();
            a9.putString("Quality","Special");

            ItemStack[] itemStackArray1 = new ItemStack[] {
                    jungle1,jungle2,jungle3,jungle4,jungle5,jungle6,jungle7,jungle8,jungle9

            };


            // Level 1
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    itemStackArray1[randomnum()],
                    itemStackArray1[randomnum()],
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 12),
                    50, 8,0));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    itemStackArray1[randomnum()],
                    itemStackArray1[randomnum()],
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 12),
                    50, 8,0));

           /* trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    jungle3,
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 6),
                    50, 8,0));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    jungle4,
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 6),
                    50, 8,0));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    jungle5,
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 6),
                    50, 8,0));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    jungle6,
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 6),
                    50, 8,0));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    jungle7,
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 6),
                    50, 8,0));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    jungle8,
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 6),
                    50, 8,0));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    jungle9,
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 6),
                    50, 8,0));

            // Level 2
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    new ItemStack(ModItems.CORN.get(), 6),
                    5, 9, 0.035f));

            // Level 3
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.GOLD_INGOT, 8),
                    new ItemStack(ModItems.CORN_SEEDS.get(), 2),
                    2, 12, 0.075f));

             */
        }

        if(event.getType() == ModVillagers.DESERT_FISHERMAN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            ItemStack commonCarp = new ItemStack(FishingLifeItemsRegistry.COMMON_CARP.get(), 2);
            CompoundTag tagCommonCarp = commonCarp.getOrCreateTag();
            tagCommonCarp.putString("Quality", "Special");

            ItemStack lakeWhitefish = new ItemStack(FishingLifeItemsRegistry.LAKE_WHITEFISH.get(), 2);
            CompoundTag tagLakeWhitefish = lakeWhitefish.getOrCreateTag();
            tagLakeWhitefish.putString("Quality", "Special");

            ItemStack orangespottedSunfish = new ItemStack(FishingLifeItemsRegistry.ORANGESPOTTED_SUNFISH.get(), 2);
            CompoundTag tagOrangespottedSunfish = orangespottedSunfish.getOrCreateTag();
            tagOrangespottedSunfish.putString("Quality", "Special");

            ItemStack americanShad = new ItemStack(FishingLifeItemsRegistry.AMERICAN_SHAD.get(), 2);
            CompoundTag tagAmericanShad = americanShad.getOrCreateTag();
            tagAmericanShad.putString("Quality", "Special");

            ItemStack blackCrappie = new ItemStack(FishingLifeItemsRegistry.BLACK_CRAPPIE.get(), 2);
            CompoundTag tagBlackCrappie = blackCrappie.getOrCreateTag();
            tagBlackCrappie.putString("Quality", "Special");

            ItemStack brookTrout = new ItemStack(FishingLifeItemsRegistry.BROOK_TROUT.get(), 2);
            CompoundTag tagBrookTrout = brookTrout.getOrCreateTag();
            tagBrookTrout.putString("Quality", "Special");

            ItemStack longnoseGar = new ItemStack(FishingLifeItemsRegistry.LONGNOSE_GAR.get(), 2);
            CompoundTag tagLongnoseGar = longnoseGar.getOrCreateTag();
            tagLongnoseGar.putString("Quality", "Special");

            ItemStack shortnoseGar = new ItemStack(FishingLifeItemsRegistry.SHORTNOSE_GAR.get(), 2);
            CompoundTag tagShortnoseGar = shortnoseGar.getOrCreateTag();
            tagShortnoseGar.putString("Quality", "Special");

            ItemStack europeanPerch = new ItemStack(FishingLifeItemsRegistry.EUROPEAN_PERCH.get(), 2);
            CompoundTag tagEuropeanPerch = europeanPerch.getOrCreateTag();
            tagEuropeanPerch.putString("Quality", "Special");

// Array of all the items
            ItemStack[] itemStackArray1 = new ItemStack[] {
                    commonCarp, lakeWhitefish, orangespottedSunfish, americanShad, blackCrappie,
                    brookTrout, longnoseGar, shortnoseGar, europeanPerch
            };


            // Level 1
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    itemStackArray1[randomnum()],
                    itemStackArray1[randomnum()],
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 12),
                    50, 8,0));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    itemStackArray1[randomnum()],
                    itemStackArray1[randomnum()],
                    new ItemStack(FishingLifeItemsRegistry.ARISQUEDO_COIN.get(), 12),
                    50, 8,0));
        }


    }

    /*@SubscribeEvent
    public static void addCustomWanderingTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 12),
                new ItemStack(ModItems.SAPPHIRE_BOOTS.get(), 1),
                3, 2, 0.2f));

        rareTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 24),
                new ItemStack(ModItems.METAL_DETECTOR.get(), 1),
                2, 12, 0.15f));
    }

     */
}


