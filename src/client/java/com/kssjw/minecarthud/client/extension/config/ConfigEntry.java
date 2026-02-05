package com.kssjw.minecarthud.client.extension.config;

import com.kssjw.minecarthud.client.manager.LoadManager;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;

public class ConfigEntry implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> LoadManager.getConfigScreen(parent);
    }
}