package com.kssjw.minecarthud.client.extension.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "minecart-hud")
public class ConfigValue implements ConfigData {
    
    /* */

    // 启用模组
    @ConfigEntry.Category("general")
    @ConfigEntry.Gui.PrefixText
    public boolean enabled = true;

    /* */

    // 显示的模式
    @ConfigEntry.Category("general")
    @ConfigEntry.Gui.PrefixText
    @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
    public ConfigEnum.displayMode selectedDisplayMode = ConfigEnum.displayMode.Detailed;

    // 显示的位置
    @ConfigEntry.Category("general")
    @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
    public ConfigEnum.displayLocation selectedDisplayLocation = ConfigEnum.displayLocation.BottomCenter;

    /* */

    // 显示速度
    @ConfigEntry.Category("general")
    @ConfigEntry.Gui.PrefixText
    public boolean enabledSpeed = true;

    // 速度颜色
    @ConfigEntry.Category("general")
    @ConfigEntry.ColorPicker(allowAlpha = true)
    public int colorOfSpeed = 0xFFFFFFFF;

    /* */

    // 显示方向
    @ConfigEntry.Category("general")
    @ConfigEntry.Gui.PrefixText
    public boolean enabledDirection = true;

    // 方向颜色
    @ConfigEntry.Category("general")
    @ConfigEntry.ColorPicker(allowAlpha = true)
    public int colorOfDirection = 0xFFFFFFFF;
}