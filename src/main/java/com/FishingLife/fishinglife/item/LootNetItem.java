package com.FishingLife.fishinglife.item;

import com.FishingLife.fishinglife.registry.FishingLifeItemsRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import javax.annotation.Nonnull;
import java.util.List;

import static com.FishingLife.fishinglife.util.FishQualityEventHandler.assignCertainQuality;
import static com.FishingLife.fishinglife.util.FishingNetFunctionHandler.*;

public class LootNetItem extends Item {
    private final ResourceLocation lootTable;

    private final ResourceLocation fish_machine_trash;



    public LootNetItem(ResourceLocation lootTable,ResourceLocation fish_machine_trash) {
        super(new Item.Properties());
        this.lootTable = lootTable;
        this.fish_machine_trash=fish_machine_trash;
    }

    @Override
    @Nonnull
    public InteractionResultHolder<ItemStack> use(Level world, Player player, @Nonnull InteractionHand hand) {
        ItemStack heldStack = player.getItemInHand(hand);
        int iter_time;
        int ind;
        int quality;

        if (world.isClientSide || this.lootTable == null) return new InteractionResultHolder<>(InteractionResult.FAIL, heldStack);
        Item s_1 = FishingLifeItemsRegistry.SMALL_NET_WITH_BASIC_BAITS.get();
         Item s_2 = FishingLifeItemsRegistry.SMALL_NET_WITH_ADVANCED_BAITS.get();
        Item s_3 = FishingLifeItemsRegistry.SMALL_NET_WITH_PREMIUM_BAITS.get();
        Item s_4 = FishingLifeItemsRegistry.SMALL_NET_WITH_ULTIMATE_BAITS.get();

         Item m_1 = FishingLifeItemsRegistry.MEDIUM_NET_WITH_BASIC_BAITS.get();
         Item m_2 = FishingLifeItemsRegistry.MEDIUM_NET_WITH_ADVANCED_BAITS.get();
         Item m_3 = FishingLifeItemsRegistry.MEDIUM_NET_WITH_PREMIUM_BAITS.get();
          Item m_4 = FishingLifeItemsRegistry.MEDIUM_NET_WITH_ULTIMATE_BAITS.get();

        Item l_1 = FishingLifeItemsRegistry.LARGE_NET_WITH_BASIC_BAITS.get();
        Item l_2 = FishingLifeItemsRegistry.LARGE_NET_WITH_ADVANCED_BAITS.get();
        Item l_3 = FishingLifeItemsRegistry.LARGE_NET_WITH_PREMIUM_BAITS.get();
        Item l_4 = FishingLifeItemsRegistry.LARGE_NET_WITH_ULTIMATE_BAITS.get();



//Net size check
        if(heldStack.is(s_1) || heldStack.is(s_2) || heldStack.is(s_3) || heldStack.is(s_4)){
            iter_time=netrandomNUm(1);
            ind=1;
        }
        else if(heldStack.is(m_1) || heldStack.is(m_2) || heldStack.is(m_3) || heldStack.is(m_4)){
            iter_time=netrandomNUm(2);
            ind=2;
        }
        else{
            iter_time=netrandomNUm(3);
            ind=3;
        }
        //Bait check
        if(heldStack.is(s_1) || heldStack.is(m_1) || heldStack.is(l_1)){
            quality=1;
        }
        else if(heldStack.is(s_2) || heldStack.is(m_2) || heldStack.is(l_2)){
            quality=2;
        }
        else if(heldStack.is(s_3) || heldStack.is(m_3) || heldStack.is(l_3)){
            quality=3;
        }
        else{
            quality=4;
        }



        if (world instanceof ServerLevel serverLevel) {

            for (int i = 0; i < iter_time; i++) {
            LootParams.Builder builder = new LootParams.Builder(serverLevel);
            int assign =qualityWithDifferentBait(quality);
            List<ItemStack> loot = serverLevel.getServer().getLootData().getLootTable(this.lootTable).getRandomItems(builder.create(LootContextParamSets.EMPTY));
            List<ItemStack> trash = serverLevel.getServer().getLootData().getLootTable(this.fish_machine_trash).getRandomItems(builder.create(LootContextParamSets.EMPTY));

            if (!loot.isEmpty()) {

                    if (assign==0){
                        ItemStack trashStack = trash.get(0);
                        this.giveItem(player, trashStack);
                    }
                    else{
                        ItemStack lootStack = loot.get(0);
                        assignCertainQuality(lootStack, assign);
                        this.giveItem(player, lootStack);
                    }


                heldStack.shrink(1);


                //player.displayClientMessage(Component.translatable("aquaculture.loot.open", lootStack.getHoverName()).withStyle(ChatFormatting.YELLOW), true);



                }
            }
            if(netKeepOrNot(ind)){
                this.giveItem(player, netReturn(ind));
            }
            return new InteractionResultHolder<>(InteractionResult.SUCCESS, heldStack);
        }

        return super.use(world, player, hand);
    }

    private void giveItem(Player player, @Nonnull ItemStack stack) {
        if (!player.getInventory().add(stack)) {
            player.drop(stack, false);
        } else if (player instanceof ServerPlayer) {
            player.inventoryMenu.sendAllDataToRemote();
        }
    }
}