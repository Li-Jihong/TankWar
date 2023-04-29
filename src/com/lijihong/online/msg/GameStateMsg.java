package com.lijihong.online.msg;

/**
 * \* Created with IntelliJ IDEA.
 * \* @ProjectName: TankWar
 * \* @FileName: GameStateMsg
 * \* @author: li-jihong
 * \* Date: 2023-04-28 22:09
 */

import com.lijihong.online.server.GameState;
import com.lijihong.online.server.toclient.Server;

/**
 * 服务器在 {@link Server#GAMING} 时不断广播游戏状态的消息
 */
public class GameStateMsg extends MsgBase {
    public final GameState state;

    public GameStateMsg(GameState state) {
        super();
        this.state = state;
    }
}
