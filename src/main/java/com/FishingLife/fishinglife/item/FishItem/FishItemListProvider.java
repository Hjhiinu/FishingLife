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
    private static final String COMPONENTS_TAG = "RemainingComponents";
    private static final Logger LOGGER = LogManager.getLogger();
    private static final Random random = new Random();
    static Item fish_fin = FishingLifeItemsRegistry.FISH_FIN.get();

    static Item fish_gill= FishingLifeItemsRegistry.FISH_GILL.get();

    static Item fish_scale = FishingLifeItemsRegistry.FISH_SCALE.get();

    static Item fish_roe = FishingLifeItemsRegistry.FISH_ROE.get();

    static Item fish_meat = FishingLifeItemsRegistry.FISH_MEAT.get();

    static Item[] default_itemArray = new Item[] {
            fish_fin,fish_gill,fish_roe,fish_scale,fish_meat
    };

    public static ItemStack RandomProcess(ItemStack itemstack, Player player){
        if(player.isCreative()){
            return new ItemStack(default_itemArray[getRandom(default_itemArray)]);
        }
        int[] remaining_list= getRemainingComponents(itemstack);
       // LOGGER.info("Remaining_list for fishitem"+ Arrays.toString(remaining_list));
        List<ItemStack> itemStackList = new ArrayList<>();
        List<Integer> itemStackIndicator = new ArrayList<>();
        for(int i=0;i<remaining_list.length;i++){
            if(remaining_list[i]!=0){
                itemStackList.add(new ItemStack(default_itemArray[i]));
                itemStackIndicator.add(i);
            }
        }
        int selected_index=getRandom(itemStackIndicator);
        int itemstack_indicator_index=itemStackIndicator.get(selected_index);

        decreaseComponent(itemstack, itemstack_indicator_index);

       // LOGGER.info("Remaining_list for fishitem after decrease"+ Arrays.toString(getRemainingComponents(itemstack)));
       // LOGGER.info("Selected "+ itemStackList.get(selected_index));
        return itemStackList.get(selected_index);
    }
    private static int getRandom(List<Integer> temp){
        return random.nextInt(temp.size());
    }
    private static int getRandom(Item[] temp){
        return random.nextInt(temp.length);
    }

    public static void setRemainingComponents(ItemStack stack, int[] components) {
        CompoundTag tag = stack.getOrCreateTag();
        tag.put(COMPONENTS_TAG, new IntArrayTag(components));
    }

    public static int[] getRemainingComponents(ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTag();
        if (!tag.contains(COMPONENTS_TAG)) {
            int num_meat=getMeatNum(stack);
            int[] defaultComponents = new int[]{1, 1, 1, 1, num_meat}; // Default values
            setRemainingComponents(stack, defaultComponents);

            return defaultComponents;
        }
        return tag.getIntArray(COMPONENTS_TAG);
    }
    public static void decreaseComponent(ItemStack stack, int index) {
        int[] components = getRemainingComponents(stack);
        if (index >= 0 && index < components.length) {
            components[index] = Math.max(0, components[index] - 1); // Ensure value doesn't go below 0
            setRemainingComponents(stack, components);
        }
    }

    private static int getMeatNum(ItemStack stack){
        if(stack.is(ModTags.Items.SMALL_FISHES)){
            return 1;
        }
        else if(stack.is(ModTags.Items.MEDIUM_FISHES)){
            return 2;
        }
        else{
            return 3;
        }
    }

}
