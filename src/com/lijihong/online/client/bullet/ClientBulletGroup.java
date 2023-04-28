package com.lijihong.online.client.bullet;

import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Vector;

/**
 * \* Created with IntelliJ IDEA.
 * \* @ProjectName: TankWar
 * \* @FileName: ClientBulletGroup
 * \* @author: li-jihong
 * \* Date: 2023-04-25 18:59
 */
public class ClientBulletGroup extends BulletGroup {
    /**
     * <h3>更新子弹信息</h3>
     * 同步时可能会出现 this 有而 info 没有的子弹
     */
    public void syncBullets(@NotNull Vector<BulletBase.BulletInfo> bulletInfos) {
        bullets.clear();
        for (BulletBase.BulletInfo info : bulletInfos) {
            // 反射创建不同类型的子弹
            Class<? extends BulletBase> T = info.getBulletType();
            Constructor<? extends BulletBase> constructor = null;
            try {
                constructor = T.getConstructor(int.class, int.class, double.class);
                Rectangle rect = info.getRect();
                BulletBase bullet = constructor.newInstance((int) rect.getCenterX(), (int) rect.getCenterY(), info.getOrientation());
                addBullet(bullet);
            } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                     IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}