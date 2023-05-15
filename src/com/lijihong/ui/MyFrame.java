package com.lijihong.ui;

import com.lijihong.Config;
import com.lijihong.base.SingleInstance;
import com.lijihong.util.Tools;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;

import static com.lijihong.util.Tools.resizeWindow;

public class MyFrame extends JFrame implements SingleInstance {
    protected static MyFrame instance;

    public MyFrame() throws IOException { // 这个构造函数只会被调用一次
        super();
        checkInstance();
        instance = this;
        setTitle(Config.translation.frameTitle);
        setIconImage(ImageIO.read(Tools.getFileURL("img/FrameIcon.png").url()));
        setContentPane(new MyPanel() { // 显示加载中画面
            @Override
            public void setupUI() {
                setLayout(new BorderLayout()); // 设置Swing组件布局
                add(new JLabel(Config.translation.loading, SwingConstants.CENTER), BorderLayout.CENTER);
            }
        }); //匿名内部类
        resizeWindow(this, Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT); // 设置面板大小
        consumeFontLoadingTime(); // 消耗字体加载时间，防止在游戏启动时出现卡顿。
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // 在窗口大小改变时重新调整内部Panel的大小和位置
                resizePanel();
            }
        });

    }

    private void resizePanel() {
        // 获取窗口当前大小
        Dimension size = getContentPane().getSize();
        // 计算内部Panel应该占据的大小
        int width = (int) (size.width * Config.PANEL_WIDTH_RATIO);
        int height = (int) (size.height * Config.PANEL_HEIGHT_RATIO);
        // 计算内部Panel应该位于窗口的位置
        int x = (size.width - width) / 2;
        int y = (size.height - height) / 2;
        // 设置内部Panel的大小和位置
        getMyPanel().setBounds(x, y, width, height);
    }

    private MyPanel getMyPanel() {
        return (MyPanel) getContentPane();
    }



    public static MyFrame getInstance() {
        return instance;
    }

    @Override
    public void checkInstance() {
        if (instance != null) {
            throw new IllegalStateException("MyFrame can be created only once.");
        }
        //检查是否已经有了MyFrame实例。如果已经存在实例，则抛出IllegalStateException异常。
    }

    /**
     * 先尝试加载字体, 防止游戏启动时卡顿
     */
    public void consumeFontLoadingTime() {
        Timer timer = new Timer((int) (1000.0 / Config.FPS), null);
        timer.setRepeats(true);
        timer.addActionListener((e) -> {
            Graphics g = getContentPane().getGraphics();
            if (g != null) {
                Graphics2D g2d = ((Graphics2D) g);
                g2d.setFont(Config.TANK_CLIP_FONT);
                g2d.drawString("", 0, 0);
                g2d.dispose();
                timer.stop();
            }
        });
        timer.start();
    }

    @Override
    public Component add(Component comp) {
        throw new IllegalCallerException("This frame supports content panel only.");
    }

    @Override
    public void setContentPane(Container contentPane) {
        if (!(contentPane instanceof MyPanel)) {
            throw new IllegalArgumentException("MyFrame supports MyPanel only");
        }
        setContentPane((MyPanel) contentPane);
        // 该方法的实现可以确保只有MyPanel类的实例可以作为MyFrame的内容面板，
        // 避免了由于其他类型的容器被设置为内容面板而引起的问题。
    }

    public void setContentPane(MyPanel panel) {
        super.setContentPane(panel);
        panel.setupUI();
    }
    
}
