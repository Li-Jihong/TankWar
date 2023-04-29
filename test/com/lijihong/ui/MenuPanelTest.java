package com.lijihong.ui;

import com.lijihong.Config;

import javax.swing.*;
import java.io.IOException;

import static com.lijihong.util.Tools.resizeWindow;

class MenuPanelTest {
    
    public static void main(String[] args) throws IOException {
        MyFrame f = new MyFrame();
        MenuPanel m = new MenuPanel(f);
        f.setResizable(false);
        resizeWindow(f, Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}