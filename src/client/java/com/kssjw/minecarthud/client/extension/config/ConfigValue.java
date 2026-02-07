package com.kssjw.minecarthud.client.extension.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

import net.minecraft.text.Text;

@Config(name = "minecart-hud")
public class ConfigValue implements ConfigData {

    public static enum displayMode {
        Detailed("option.minecart-hud.detailed"),
        Simple("option.minecart-hud.simple");

        private final String key;
        displayMode(String key) { this.key = key;}

        @Override
        public String toString() {
            return Text.translatable(key).getString();
        }
    }
    
    /* */

    // 启用开关
    @ConfigEntry.Category("general")
    @ConfigEntry.Gui.PrefixText
    public boolean enabled = true;

    /* */

    // 显示模式
    @ConfigEntry.Category("general")
    @ConfigEntry.Gui.PrefixText
    @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
    public displayMode selectedDisplayMode = displayMode.Detailed;

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