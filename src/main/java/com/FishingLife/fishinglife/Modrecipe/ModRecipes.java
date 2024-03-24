package com.FishingLife.fishinglife.Modrecipe;

import com.FishingLife.fishinglife.fishinglife;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class  ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, fishinglife.MOD_ID);

    public static final RegistryObject<RecipeSerializer<FermenterRecipe>> FERMENTER_SERIALIZER =
                SERIALIZERS.register("fermenting", () ->FermenterRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<FishingMachineRecipe>> FISHINGMACHINE_SERIALIZER =
            SERIALIZERS.register("machine_fishing", () ->FishingMachineRecipe.Serializer.INSTANCE);



    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
