package com.FishingLife.fishinglife.item.ItemUtil;

import com.FishingLife.fishinglife.fishinglife;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = fishinglife.MOD_ID)
public class tooltip {
    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void onTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        if (!stack.isEmpty() && stack != null && stack.hasTag() && stack.getTag() != null) {

            if (stack.getTag().contains("Quality")) {
                String quality = stack.getTag().getString("Quality");
                /*
                double age = stack.getTag().getDouble("Age");
                BigDecimal bd = new BigDecimal(age);
                bd = bd.round(new MathContext(3));
*/


                MutableComponent string = Component.translatable("fishinglife.Quality.quality",quality);
                event.getToolTip().add(string.withStyle(string.getStyle().withItalic(true).withColor(ChatFormatting.DARK_AQUA)));

                // MutableComponent decimalAge = Component.translatable("fishinglife.Age.age",bd);
                //event.getToolTip().add(decimalAge.withStyle(decimalAge.getStyle().withItalic(true).withColor(ChatFormatting.YELLOW)));

            }
        }
    }
}
