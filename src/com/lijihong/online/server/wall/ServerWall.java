package com.lijihong.online.server.wall;

import com.lijihong.game.wall.Wall;

import java.awt.*;

public class ServerWall extends Wall {
    {
        doPaint.set(false);
    }

    @Override
    public void update(Graphics graphics) {
    }

    public ServerWall(int startX, int startY) {
        super(startX, startY);
    }
    
    public ServerWall(int startX, int startY, int width, int height) {
        super(startX, startY, width, height);
    }
}
