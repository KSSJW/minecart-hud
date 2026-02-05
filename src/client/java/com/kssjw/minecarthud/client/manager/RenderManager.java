package com.kssjw.minecarthud.client.manager;

import com.kssjw.minecarthud.client.util.DirectionUtil;
import com.kssjw.minecarthud.client.util.SpeedUtil;
import com.kssjw.minecarthud.client.util.TextUtil;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.vehicle.AbstractMinecartEntity;
import net.minecraft.text.Text;

public class RenderManager {

    private static void drawSpeed(AbstractMinecartEntity minecart, DrawContext context) {
        if (MinecraftClient.getInstance().player.getVehicle() == null || MinecraftClient.getInstance().player.getVehicle() != minecart) return;

        Text text = Text.translatable("hud.minecart-hud.speed.head")
                .append(String.format("%.2f", (double)SpeedUtil.getSpeed(minecart)))
                .append(Text.translatable("hud.minecart-hud.speed.tail"));
        TextUtil.draw(
            context,
            text,
            MinecraftClient.getInstance().getWindow().getScaledWidth() / 2 - TextUtil.getWidthOfText(text) / 2,
            MinecraftClient.getInstance().getWindow().getScaledHeight() / 3 * 2,
            0xFFFFFFFF
        );
    }

    private static void drawDirection(AbstractMinecartEntity minecart, DrawContext context) {
        if (MinecraftClient.getInstance().player.getVehicle() == null || MinecraftClient.getInstance().player.getVehicle() != minecart) return;

        Text text = Text.translatable("hud.minecart-hud.speed.direction")
                .append(String.valueOf(DirectionUtil.getDirectionOfCart(minecart)));
        TextUtil.draw(
            context,
            text,
            MinecraftClient.getInstance().getWindow().getScaledWidth() / 2 - TextUtil.getWidthOfText(text) / 2,
            MinecraftClient.getInstance().getWindow().getScaledHeight() / 3 * 2 + TextUtil.getHeightOfText(text),
            0xFFFFFFFF
        );
    }

    public static void draw(DrawContext context) {
        if (ConfigManager.isEnabled() && MinecraftClient.getInstance().player.getVehicle() instanceof AbstractMinecartEntity minecart) {
            drawSpeed(minecart, context);
            drawDirection(minecart, context);
        }
    }
}