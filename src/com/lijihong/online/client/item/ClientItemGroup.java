package com.lijihong.online.client.item;

import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Vector;

/**
 * \* Created with IntelliJ IDEA.
 * \* @ProjectName: TankWar
 * \* @FileName: ClientItemGroup
 * \* @author: li-jihong
 * \* Date: 2023-04-25 19:00
 */
public class ClientItemGroup extends ItemGroup {
    /**
     * <h3>更新子弹信息</h3>
     * 同步时可能会出现 this 有而 info 没有的子弹
     */
    public void syncItems(@NotNull Vector<ItemBase.ItemInfo> bulletInfos) {
        synchronized (items) {
            items.clear();
            for (ItemBase.ItemInfo info : bulletInfos) {
                // 反射创建不同类型的物品
                Class<? extends ItemBase> T = info.getItemType();
                Constructor<? extends ItemBase> constructor = null;
                try {
                    constructor = T.getConstructor(int.class, int.class);
                    Rectangle rect = info.getRect();
                    ItemBase item = constructor.newInstance((int) rect.getCenterX(), (int) rect.getCenterY());
                    addItem(item);
                } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                         IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}