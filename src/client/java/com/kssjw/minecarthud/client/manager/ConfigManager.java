package com.kssjw.minecarthud.client.manager;

import com.kssjw.minecarthud.client.extension.config.ConfigValue;

import me.shedaniel.autoconfig.AutoConfig;

public class ConfigManager {
    
    private static ConfigValue getConfig() {
        return AutoConfig.getConfigHolder(ConfigValue.class).getConfig();
    }

    public static boolean isEnabled() {
        if (LoadManager.isAutoConfigLoaded() && !getConfig().enabled) {
            return false;
        } else {
            return true;
        }
    }
}