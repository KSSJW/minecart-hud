package com.kssjw.minecarthud.client.extension.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "minecart-hud")
public class ConfigValue implements ConfigData {
    
    // 启用开关
    @ConfigEntry.Category("general")
    @ConfigEntry.Gui.PrefixText
    public boolean enabled = true;
}