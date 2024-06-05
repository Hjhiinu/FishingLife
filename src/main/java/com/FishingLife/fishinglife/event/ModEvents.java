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

}



