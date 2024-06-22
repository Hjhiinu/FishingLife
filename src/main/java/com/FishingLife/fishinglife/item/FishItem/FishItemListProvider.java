package com.FishingLife.fishinglife.item.FishItem;

import com.FishingLife.fishinglife.registry.FishingLifeItemsRegistry;
import com.FishingLife.fishinglife.util.ModTags;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.IntArrayTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class FishItemListProvider {
    private static final Random random = new Random();
    static Item fish_fin = FishingLifeItemsRegistry.FISH_FIN.get();

    static Item fish_gill= FishingLifeItemsRegistry.FISH_GILL.get();

    static Item fish_scale = FishingLifeItemsRegistry.FISH_SCALE.get();

    static Item fish_roe = FishingLifeItemsRegistry.FISH_ROE.get();

    static Item fish_meat = FishingLifeItemsRegistry.FISH_MEAT.get();

    static Item[] default_itemArray = new Item[] {
            fish_fin,fish_gill,fish_roe,fish_scale,fish_meat
    };

    public static ItemStack RandomProcess(Player player) {
        return new ItemStack(default_itemArray[random.nextInt(default_itemArray.length)]);
    }

}
