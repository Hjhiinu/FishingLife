package com.FishingLife.fishinglife.util.Keybinding;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {
    public static final String KEY_CATEGORY_FISHINGLIFE = "key.category.fishinglife.fishing";
    public static final String KEY_FISHING_LEFT = "key.fishinglife.fishing_left";

    public static final String KEY_FISHING_RIGHT = "key.fishinglife.fishing_right";

    public static final KeyMapping LEFT_KEY = new KeyMapping(KEY_FISHING_LEFT, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_LEFT_BRACKET, KEY_CATEGORY_FISHINGLIFE);

    public static final KeyMapping RIGHT_KEY = new KeyMapping(KEY_FISHING_RIGHT, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_RIGHT_BRACKET, KEY_CATEGORY_FISHINGLIFE);
}
