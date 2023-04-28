package com.lijihong.online.client.wall;

/**
 * \* Created with IntelliJ IDEA.
 * \* @ProjectName: TankWar
 * \* @FileName: ClientWall
 * \* @author: li-jihong
 * \* Date: 2023-04-25 19:02
 */
public class ClientWall extends Wall {
    public ClientWall(int startX, int startY) {
        super(startX, startY);
    }

    public ClientWall(int startX, int startY, int width, int height) {
        super(startX, startY, width, height);
    }
}