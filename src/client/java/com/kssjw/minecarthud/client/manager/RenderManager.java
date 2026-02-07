package com.kssjw.minecarthud.client.manager;

import com.kssjw.minecarthud.client.util.DirectionUtil;
import com.kssjw.minecarthud.client.util.SpeedUtil;
import com.kssjw.minecarthud.client.util.TextUtil;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.vehicle.AbstractMinecartEntity;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
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
            ConfigManager.getColorOfSpeed()
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
            ConfigManager.getColorOfDirection()
        );
    }

    private static void drawAllOnSameLine(AbstractMinecartEntity minecart, DrawContext context) {
        if (MinecraftClient.getInstance().player.getVehicle() == null || MinecraftClient.getInstance().player.getVehicle() != minecart) return;
        
        MutableText text = Text.empty();
        if (ConfigManager.isEnabledSpeed()) {
            text.append(
                Text.literal(String.format("%.2f", (double)SpeedUtil.getSpeed(minecart)))
                    .setStyle(Style.EMPTY.withColor(ConfigManager.getColorOfSpeed()))
            );
        }
        if (ConfigManager.isEnabledDirection()) {
            text.append(
                Text.literal(String.valueOf(" " + DirectionUtil.getDirectionOfCart(minecart)))
                    .setStyle(Style.EMPTY.withColor(ConfigManager.getColorOfDirection()))
            );
        }

        TextUtil.draw(
            context,
            text,
            MinecraftClient.getInstance().getWindow().getScaledWidth() / 2 - TextUtil.getWidthOfText(text) / 2,
            MinecraftClient.getInstance().getWindow().getScaledHeight() / 3 * 2,
            ConfigManager.getColorOfDirection()
        );
    }

    public static void draw(DrawContext context) {
        if (ConfigManager.isEnabled() && MinecraftClient.getInstance().player.getVehicle() instanceof AbstractMinecartEntity minecart) {
            switch (ConfigManager.getSelectedDisplayMode()) {
                case "Detailed":
                    if (ConfigManager.isEnabledSpeed()) drawSpeed(minecart, context);
                    if (ConfigManager.isEnabledDirection()) drawDirection(minecart, context);
                    break;

                case "Simple":
                    drawAllOnSameLine(minecart, context);
                    break;

                default:
                    break;
            }
        }
    }
}