package com.kssjw.minecarthud.client.manager;

import com.kssjw.minecarthud.client.extension.config.ConfigEnum;
import com.kssjw.minecarthud.client.extension.config.ConfigValue;
import com.kssjw.minecarthud.client.util.TextUtil;

import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class ConfigManager {
    
    private static ConfigValue getConfig() {
        return AutoConfig.getConfigHolder(ConfigValue.class).getConfig();
    }

    /* */

    public static boolean isEnabled() {
        if (LoadManager.isAutoConfigLoaded() && !getConfig().enabled) {
            return false;
        } else {
            return true;
        }
    }

    /* */

    public static ConfigEnum.displayMode getSelectedDisplayMode() {
        if (LoadManager.isAutoConfigLoaded()) {
            return getConfig().selectedDisplayMode;
        } else {
            return ConfigEnum.displayMode.Detailed;
        }
    }

    public static int getSelectedDisplayLocationX(Text text) {
        if (LoadManager.isAutoConfigLoaded()) {
            switch (getConfig().selectedDisplayLocation) {
                case ConfigEnum.displayLocation.BottomCenter:
                    return MinecraftClient.getInstance().getWindow().getScaledWidth() / 2 - TextUtil.getWidthOfText(text) / 2;

                case ConfigEnum.displayLocation.Left:
                    return 0;

                case ConfigEnum.displayLocation.TopLeft:
                    return 0;

                case ConfigEnum.displayLocation.TopCenter:
                    return MinecraftClient.getInstance().getWindow().getScaledWidth() / 2 - TextUtil.getWidthOfText(text) / 2;

                case ConfigEnum.displayLocation.TopRight:
                    return MinecraftClient.getInstance().getWindow().getScaledWidth() - TextUtil.getWidthOfText(text);

                case ConfigEnum.displayLocation.Right:
                    return MinecraftClient.getInstance().getWindow().getScaledWidth() - TextUtil.getWidthOfText(text);
            
                default:
                    return MinecraftClient.getInstance().getWindow().getScaledWidth() / 2 - TextUtil.getWidthOfText(text) / 2;
            }
        } else {
            return MinecraftClient.getInstance().getWindow().getScaledWidth() / 2 - TextUtil.getWidthOfText(text) / 2;
        }
    }

    public static int getSelectedDisplayLocationY(Text text) {
        if (LoadManager.isAutoConfigLoaded()) {
            switch (getConfig().selectedDisplayLocation) {
                case ConfigEnum.displayLocation.BottomCenter:
                    return MinecraftClient.getInstance().getWindow().getScaledHeight() / 3 * 2;

                case ConfigEnum.displayLocation.Left:
                    return MinecraftClient.getInstance().getWindow().getScaledHeight() / 2;

                case ConfigEnum.displayLocation.TopLeft:
                    return 0;

                case ConfigEnum.displayLocation.TopCenter:
                    return 0;

                case ConfigEnum.displayLocation.TopRight:
                    return 0;

                case ConfigEnum.displayLocation.Right:
                    return MinecraftClient.getInstance().getWindow().getScaledHeight() / 2;
            
                default:
                    return MinecraftClient.getInstance().getWindow().getScaledHeight() / 3 * 2;
            }
        } else {
            return MinecraftClient.getInstance().getWindow().getScaledHeight() / 3 * 2;
        }
    }

    /* */

    public static boolean isEnabledSpeed() {
        if (LoadManager.isAutoConfigLoaded() && !getConfig().enabledSpeed) {
            return false;
        } else {
            return true;
        }
    }

    public static int getColorOfSpeed() {
        if (LoadManager.isAutoConfigLoaded()) {
            return getConfig().colorOfSpeed;
        } else {
            return 0xFFFFFFFF;
        }
    }

    /* */

    public static boolean isEnabledDirection() {
        if (LoadManager.isAutoConfigLoaded() && !getConfig().enabledDirection) {
            return false;
        } else {
            return true;
        }
    }

    public static int getColorOfDirection() {
        if (LoadManager.isAutoConfigLoaded()) {
            return getConfig().colorOfDirection;
        } else {
            return 0xFFFFFFFF;
        }
    }
}