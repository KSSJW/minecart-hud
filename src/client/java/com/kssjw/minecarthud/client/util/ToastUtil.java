package com.kssjw.minecarthud.client.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.toasts.SystemToast;
import net.minecraft.client.gui.components.toasts.ToastManager;
import net.minecraft.network.chat.Component;

public class ToastUtil {

    private ToastUtil() {}

    public static void toast(Component title, Component description) {
        ToastManager toastManager = Minecraft.getInstance().getToastManager();
        SystemToast.addOrUpdate(
            toastManager,
            SystemToast.SystemToastId.NARRATOR_TOGGLE,
            title,
            description
        );
    }
}