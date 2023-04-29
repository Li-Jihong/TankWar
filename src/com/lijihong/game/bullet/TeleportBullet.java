package com.lijihong.game.bullet;

import com.lijihong.game.tank.TankBase;
import com.lijihong.util.Tools;

/**
 * 将击中的坦克随机传送到一个地方
 */
public class TeleportBullet extends BulletBase {
    public static final String imgFile = "img/TeleportBullet.png";

    {
        rawImg = Tools.loadImg(imgFile);
        damage.set(0);
    }

    public TeleportBullet(int centerX, int centerY, double orientation) {
        super(centerX, centerY, orientation);
    }

    @Override
    public void finish(TankBase tank) {
        super.finish(tank);
        tank.randomlyTeleport();
    }
}
