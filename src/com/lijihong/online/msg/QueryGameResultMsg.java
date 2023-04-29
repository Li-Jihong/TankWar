package com.lijihong.online.msg;

/**
 * \* Created with IntelliJ IDEA.
 * \* @ProjectName: TankWar
 * \* @FileName: QueryGameResultMsg
 * \* @author: li-jihong
 * \* Date: 2023-04-28 22:11
 */

import com.lijihong.game.GameMap;

/**
 * 客户端向服务端查询游戏结果
 */
public class QueryGameResultMsg extends MsgBase {
    public QueryGameResultMsg() {
        super();
    }

    public static final class QueryGameResultResponseMsg extends MsgBase {
        public final GameMap.GameInfo info;

        public QueryGameResultResponseMsg(GameMap.GameInfo info) {
            super();
            this.info = info;
        }
    }
}
