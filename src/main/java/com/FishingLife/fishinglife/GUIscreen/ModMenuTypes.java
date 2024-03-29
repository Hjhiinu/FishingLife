package com.FishingLife.fishinglife.GUIscreen;

import com.FishingLife.fishinglife.fishinglife;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, fishinglife.MOD_ID);

    public static final RegistryObject<MenuType<FermenterMenu>> FERMENTER_MENU =
            registerMenuType("fermenter_menu", FermenterMenu::new);

    public static final RegistryObject<MenuType<FishingMachineMenu>> FISHING_MACHINE_MENU =
            registerMenuType("fishingmachine_menu", FishingMachineMenu::new);




    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuType(String name, IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
