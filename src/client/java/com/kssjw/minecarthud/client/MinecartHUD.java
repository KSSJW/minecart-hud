package com.kssjw.minecarthud.client;

import com.kssjw.minecarthud.client.manager.LoadManager;

import net.fabricmc.api.ClientModInitializer;

public class MinecartHUD implements ClientModInitializer {
    
    @Override
    public void onInitializeClient() {

        LoadManager.registerConfig();
    }
}