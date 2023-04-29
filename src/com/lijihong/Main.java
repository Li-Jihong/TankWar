package com.lijihong;

import com.lijihong.ui.MenuPanel;
import com.lijihong.ui.MyFrame;

import javax.swing.*;
import java.io.IOException;

import static com.lijihong.util.Tools.init;
import static com.lijihong.util.Tools.resizeWindow;

public class Main {  //todo 设置界面
    public static void main(String[] args) throws IOException {
        init();
        MyFrame f = new MyFrame();
        MenuPanel m = new MenuPanel(f);
        f.setResizable(false);
        resizeWindow(f, Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);
        f.setVisible(true);
        System.out.println("启动成功啦！！！");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}