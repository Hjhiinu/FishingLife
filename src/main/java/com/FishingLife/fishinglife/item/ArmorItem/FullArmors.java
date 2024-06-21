package com.FishingLife.fishinglife.item.ArmorItem;

import com.FishingLife.fishinglife.item.ModArmorMaterials;
import net.minecraft.world.item.ArmorItem;
import com.google.common.collect.ImmutableMap;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ArmorMaterial;

import java.util.Map;

public class FullArmors extends ArmorItem {
    public static final Map<ArmorMaterial, MobEffectInstance> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, MobEffectInstance>())
                    .put(ModArmorMaterials.FISH_SCALE, new MobEffectInstance(MobEffects.NIGHT_VISION, Integer.MAX_VALUE, 1,
                            false, false, true))
                    .build();

    public FullArmors(ArmorMaterial pMaterial, ArmorItem.Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

}
