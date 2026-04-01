package com.kssjw.minecarthud.client.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.network.chat.Component;

public class TextUtil {

    private TextUtil() {}

    public static int getWidthOfText(Component text) {
        return Minecraft.getInstance().font.width(text);
    }

    public static int getHeightOfText(Component text) {
        return Minecraft.getInstance().font.lineHeight;
    }

    public static void draw(GuiGraphicsExtractor graphics, Component text, int x, int y, int color) {
        graphics.text(
            Minecraft.getInstance().font,
            text,
            x,
            y,
            color,
            true
        );
    }
}