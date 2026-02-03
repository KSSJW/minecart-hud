package com.kssjw.minecarthud.client.util;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;

public class TextUtil {

    private TextUtil() {}

    public static int getWidthOfText(Text text) {
        return MinecraftClient.getInstance().textRenderer.getWidth(text);
    }

    public static int getHeightOfText(Text text) {
        return MinecraftClient.getInstance().textRenderer.fontHeight;
    }

    public static void draw(DrawContext context, Text text, int x, int y, int color) {
        context.drawText(MinecraftClient.getInstance().textRenderer, text, x, y, color, true);
    }
}