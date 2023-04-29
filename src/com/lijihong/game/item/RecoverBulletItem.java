package com.lijihong.game.item;

import com.lijihong.game.bullet.RecoverBullet;
import com.lijihong.game.tank.TankBase;
import com.lijihong.util.Tools;

/**
 * 加血子弹的物品
 */
public class RecoverBulletItem extends ItemBase {
    public static final String imgFile = "img/RecoverBulletItem.png";

    {
        img = Tools.loadImg(imgFile);
    }

    public RecoverBulletItem(int centerX, int centerY) {
        super(centerX, centerY);
    }

    @Override
    public void finishAndEffect(TankBase tank) {
        super.finishAndEffect(tank);
        tank.fireModule.setNextBullet(RecoverBullet.class);
    }
}
