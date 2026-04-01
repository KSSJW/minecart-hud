package com.kssjw.minecarthud.client.manager;

import com.kssjw.minecarthud.client.extension.config.ConfigEnum;
import com.kssjw.minecarthud.client.util.DirectionUtil;
import com.kssjw.minecarthud.client.util.SpeedUtil;
import com.kssjw.minecarthud.client.util.TextUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.world.entity.vehicle.minecart.AbstractMinecart;

public class RenderManager {

    private static void drawSpeed(AbstractMinecart minecart, GuiGraphicsExtractor graphics) {
        if (Minecraft.getInstance().player.getVehicle() == null || Minecraft.getInstance().player.getVehicle() != minecart) return;

        Component text = Component.translatable("hud.minecart-hud.speed.head")
            .append(String.format("%.2f", (double)SpeedUtil.getSpeed(minecart)))
            .append(Component.translatable("hud.minecart-hud.speed.tail"));
        TextUtil.draw(
            graphics,
            text,
            ConfigManager.getSelectedDisplayLocationX(text),
            ConfigManager.getSelectedDisplayLocationY(text),
            ConfigManager.getColorOfSpeed()
        );
    }

    private static void drawDirection(AbstractMinecart minecart, GuiGraphicsExtractor graphics) {
        if (Minecraft.getInstance().player.getVehicle() == null || Minecraft.getInstance().player.getVehicle() != minecart) return;

        Component text = Component.translatable("hud.minecart-hud.speed.direction")
            .append(String.valueOf(DirectionUtil.getDirectionOfCart(minecart)));
        TextUtil.draw(
            graphics,
            text,
            ConfigManager.getSelectedDisplayLocationX(text),
            ConfigManager.getSelectedDisplayLocationY(text) + TextUtil.getHeightOfText(text),
            ConfigManager.getColorOfDirection()
        );
    }

    private static void drawAllOnSameLine(AbstractMinecart minecart, GuiGraphicsExtractor graphics) {
        if (Minecraft.getInstance().player.getVehicle() == null || Minecraft.getInstance().player.getVehicle() != minecart) return;
        
        MutableComponent text = Component.empty();
        if (ConfigManager.isEnabledSpeed()) {
            text.append(
                Component.literal(String.format("%.2f", (double)SpeedUtil.getSpeed(minecart)))
                    .setStyle(Style.EMPTY.withColor(ConfigManager.getColorOfSpeed()))
            );
        }
        if (ConfigManager.isEnabledDirection()) {
            text.append(
                Component.literal(String.valueOf(" " + DirectionUtil.getDirectionOfCart(minecart)))
                    .setStyle(Style.EMPTY.withColor(ConfigManager.getColorOfDirection()))
            );
        }

        TextUtil.draw(
            graphics,
            text,
            ConfigManager.getSelectedDisplayLocationX(text),
            ConfigManager.getSelectedDisplayLocationY(text),
            ConfigManager.getColorOfDirection()
        );
    }

    public static void draw(GuiGraphicsExtractor graphics) {
        if (ConfigManager.isEnabled() && Minecraft.getInstance().player.getVehicle() instanceof AbstractMinecart minecart) {
            switch (ConfigManager.getSelectedDisplayMode()) {
                case ConfigEnum.displayMode.Detailed:
                    if (ConfigManager.isEnabledSpeed()) drawSpeed(minecart, graphics);
                    if (ConfigManager.isEnabledDirection()) drawDirection(minecart, graphics);
                    break;

                case ConfigEnum.displayMode.Simple:
                    drawAllOnSameLine(minecart, graphics);
                    break;

                default:
                    break;
            }
        }
    }
}