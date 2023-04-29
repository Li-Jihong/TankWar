package com.lijihong.game.item;

import com.lijihong.game.bullet.TeleportBullet;
import com.lijihong.game.tank.TankBase;
import com.lijihong.util.Tools;

public class TeleportBulletItem extends ItemBase{
    public static final String imgFile = "img/TeleportBulletItem.png";

    {
        img = Tools.loadImg(imgFile);
    }

    public TeleportBulletItem(int centerX, int centerY) {
        super(centerX, centerY);
    }

    @Override
    public void finishAndEffect(TankBase tank) {
        super.finishAndEffect(tank);
        tank.fireModule.setNextBullet(TeleportBullet.class);
    }
}
