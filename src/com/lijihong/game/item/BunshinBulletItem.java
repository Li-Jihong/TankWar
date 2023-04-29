package com.lijihong.game.item;

import com.lijihong.game.bullet.BunshinBullet;
import com.lijihong.game.tank.TankBase;
import com.lijihong.util.Tools;

public class BunshinBulletItem extends ItemBase {
    public static final String imgFile = "img/BunshinBulletItem.png";

    {
        img = Tools.loadImg(imgFile);
    }

    @Override
    public void finishAndEffect(TankBase tank) {
        super.finishAndEffect(tank);
        tank.fireModule.setNextBullet(BunshinBullet.class);
    }

    public BunshinBulletItem(int centerX, int centerY) {
        super(centerX, centerY);
    }
}
