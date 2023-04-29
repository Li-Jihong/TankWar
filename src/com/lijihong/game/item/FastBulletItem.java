package com.lijihong.game.item;

import com.lijihong.game.bullet.FastBullet;
import com.lijihong.game.tank.TankBase;
import com.lijihong.util.Tools;

public class FastBulletItem extends ItemBase {
    public FastBulletItem(int centerX, int centerY) {
        super(centerX, centerY);
    }

    public static final String imgFile = "img/FastBulletItem.png";

    {
        img = Tools.loadImg(imgFile);
    }

    @Override
    public void finishAndEffect(TankBase tank) {
        super.finishAndEffect(tank);
        tank.fireModule.setNextBullet(FastBullet.class);
    }
}
