package com.kssjw.minecarthud.client.manager;

import com.kssjw.minecarthud.client.extension.config.ConfigValue;
import com.kssjw.minecarthud.client.util.ToastUtil;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class LoadManager {

    public static boolean isAutoConfigLoaded() {
        try {
            Class.forName("me.shedaniel.autoconfig.AutoConfig");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public static void registerConfig() {
        if (isAutoConfigLoaded()) {
            AutoConfig.register(ConfigValue.class, GsonConfigSerializer::new);
        } else {
            return;
        }
    }
    
    public static Screen getConfigScreen(Screen parent) {
        if (LoadManager.isAutoConfigLoaded()) {
            return AutoConfig.getConfigScreen(ConfigValue.class, parent).get();
        } else {
            ToastUtil.toast(
                Text.translatable("toast.minecart-hud.autoconfignotfound.title"),
                Text.translatable("toast.minecart-hud.autoconfignotfound.desc")
            );
            return parent;
        }
    }
}