package com.kssjw.minecarthud.client.manager;

import com.kssjw.minecarthud.client.extension.config.ConfigValue;

import me.shedaniel.autoconfig.AutoConfig;

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

    public static String getSelectedDisplayMode() {
        if (LoadManager.isAutoConfigLoaded()) {
            switch (getConfig().selectedDisplayMode) {
                case ConfigValue.displayMode.Detailed:
                    return "Detailed";

                case ConfigValue.displayMode.Simple:
                    return "Simple";
            
                default:
                    return "Detailed";
            }
        } else{
            return "Detailed";
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