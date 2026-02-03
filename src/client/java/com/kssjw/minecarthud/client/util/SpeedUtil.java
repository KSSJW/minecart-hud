package com.kssjw.minecarthud.client.util;

import net.minecraft.entity.vehicle.AbstractMinecartEntity;

public class SpeedUtil {

    private SpeedUtil() {}

    private static double MIN_SPEED_THRESHOLD = 0.001; // 最低速度阈值

    public static float getSpeed(AbstractMinecartEntity minecart) {
        double speedSqr = minecart.getVelocity().lengthSquared();

        if (speedSqr < Math.pow(MIN_SPEED_THRESHOLD, 2.0)) return 0;    // 速度阈值判断（使用平方以避免开方）

        float speed = (float)Math.sqrt(speedSqr) * 4;   // 速度转换（每秒）

        if (RailUtil.isCurved(minecart)) {
            return speed *= Math.sqrt(2.0); // 修正为斜角速度
        } else {
            return speed;
        }
    }
}