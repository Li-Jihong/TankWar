package com.lijihong.online.msg;

/**
 * \* Created with IntelliJ IDEA.
 * \* @ProjectName: TankWar
 * \* @FileName: FetchGameIntroMsg
 * \* @author: li-jihong
 * \* Date: 2023-04-28 22:06
 */

import com.lijihong.game.session.ServerGameSessionIntro;

/**
 * 客户端向服务器申请获取单局游戏基本配置 (非 {@link com.lijihong.game.GameMap.GameInfo} (-> 游戏结局信息)) 的消息
 */
public class FetchGameIntroMsg extends MsgBase {
    public FetchGameIntroMsg() {
        super();
    }

    public static final class FetchGameIntroResponseMsg extends MsgBase {
        public final ServerGameSessionIntro intro;

        /**
         * @param intro 单局游戏配置
         */
        public FetchGameIntroResponseMsg(ServerGameSessionIntro intro) {
            super();
            this.intro = intro;
        }
    }
}
