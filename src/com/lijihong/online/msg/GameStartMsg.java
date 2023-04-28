package com.lijihong.online.msg;

/**
 * \* Created with IntelliJ IDEA.
 * \* @ProjectName: TankWar
 * \* @FileName: GameStartMsg
 * \* @author: li-jihong
 * \* Date: 2023-04-28 22:09
 */
/**
 * 服务器通知各个玩家（包括房主）游戏开始
 */
public class GameStartMsg extends MsgBase {
    /**
     * 当局游戏配置
     */
    public final ServerGameSessionIntro intro;

    public GameStartMsg(ServerGameSessionIntro intro) {
        super();
        this.intro = intro;
    }
}