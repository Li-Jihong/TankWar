package com.lijihong.online.msg;

/**
 * \* Created with IntelliJ IDEA.
 * \* @ProjectName: TankWar
 * \* @FileName: GameOverMsg
 * \* @author: li-jihong
 * \* Date: 2023-04-28 22:08
 */

import com.lijihong.game.GameMap;

/**
 * 服务器广播游戏结束
 */
public class GameOverMsg extends MsgBase {
    public final GameMap.GameInfo info;

    public GameOverMsg(GameMap.GameInfo info) {
        super();
        this.info = info;
    }
}