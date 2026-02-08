package com.kssjw.minecarthud.client.extension.config;

import net.minecraft.text.Text;

public class ConfigEnum {
    
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

    public static enum displayLocation {
        BottomCenter("option.minecart-hud.bottomcenter"),
        Left("option.minecart-hud.left"),
        TopLeft("option.minecart-hud.topleft"),
        TopCenter("option.minecart-hud.topcenter"),
        TopRight("option.minecart-hud.topright"),
        Right("option.minecart-hud.right");

        private final String key;
        displayLocation(String key) { this.key = key;}

        @Override
        public String toString() {
            return Text.translatable(key).getString();
        }
    }
}