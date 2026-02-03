package com.kssjw.minecarthud.client.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.kssjw.minecarthud.client.manager.RenderManager;

import org.spongepowered.asm.mixin.injection.At;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.render.RenderTickCounter;

@Mixin(InGameHud.class)
public class InGameHudMixin {

    @Inject(method = "render", at = @At("TAIL"))
    private void injectRender(DrawContext context, RenderTickCounter tickCounter, CallbackInfo ci) {
        RenderManager.draw(context);
    }
}