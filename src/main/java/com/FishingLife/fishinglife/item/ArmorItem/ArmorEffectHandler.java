package com.FishingLife.fishinglife.item.ArmorItem;
import com.FishingLife.fishinglife.item.ModArmorMaterials;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import java.util.Map;

@Mod.EventBusSubscriber(modid = "fishinglife", value = Dist.CLIENT)
public class ArmorEffectHandler {
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            Player player = event.player;
            applyFullArmorSetEffects(player);
            applySingleArmorPieceEffects(player);
        }
    }

    private static void applyFullArmorSetEffects(Player player) {
        for (Map.Entry<ArmorMaterial, MobEffectInstance> entry : FullArmors.MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial material = entry.getKey();
            MobEffectInstance effect = entry.getValue();

            if (hasFullSuitOfArmorOn(player, material)) {
                applyEffect(player, effect);
            }
        }
    }
    private static void applySingleArmorPieceEffects(Player player) {
        ItemStack helmet = player.getItemBySlot(EquipmentSlot.HEAD);
        if (helmet.getItem() instanceof ArmorItem armorItem && armorItem.getMaterial() == ModArmorMaterials.ADVANCED_TURTLE_SHELL) {
            if (player.isInWater()) {
                applyEffect(player, new MobEffectInstance(MobEffects.WATER_BREATHING, 1200, 0, false, false, true));
            }
        }
    }
    private static boolean hasFullSuitOfArmorOn(Player player, ArmorMaterial material) {
        for (EquipmentSlot slot : EquipmentSlot.values()) {
            if (slot.getType() == EquipmentSlot.Type.ARMOR) {
                ItemStack armorStack = player.getItemBySlot(slot);
                if (!(armorStack.getItem() instanceof ArmorItem armorItem) || armorItem.getMaterial() != material) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void applyEffect(Player player, MobEffectInstance effect) {
        if (!player.hasEffect(effect.getEffect())) {
            player.addEffect(new MobEffectInstance(effect));
        }
    }
/*
    private static void removeEffect(Player player, MobEffectInstance effect) {
        if (player.hasEffect(effect.getEffect())) {
            player.removeEffect(effect.getEffect());
        }
    }

 */
}
