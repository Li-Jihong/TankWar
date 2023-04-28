package com.lijihong.online.client;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * \* Created with IntelliJ IDEA.
 * \* @ProjectName: TankWar
 * \* @FileName: ClientGameMap
 * \* @author: li-jihong
 * \* Date: 2023-04-28 22:04
 */
public class ClientGameMap extends GameMap {
    /**
     * 用于标记这些操作是否启用了, 只做储存, 由 {@link com.azazo1.ui.OnlineWaitingRoomPanel} 控制与读取
     */
    public final AtomicBoolean
            left = new AtomicBoolean(false),
            right = new AtomicBoolean(false),
            forward = new AtomicBoolean(false),
            backward = new AtomicBoolean(false);
}
