package com.lvshen.teris.ui.window;


import com.lvshen.teris.config.FrameConfig;
import com.lvshen.teris.config.GameConfig;
import com.lvshen.teris.util.FrameUtil;

import javax.swing.*;

public class JFrameGame extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = -4056290386335708982L;

    public JFrameGame(JPanelGame panelGame) {
        //获得游戏配置
        FrameConfig fCfg = GameConfig.getFrameConfig();
        //设置标题
        this.setTitle(fCfg.getTitle());
        //设置默认关闭属性
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口大小
        this.setSize(fCfg.getWidth(), fCfg.getHeight());
        //禁止玩家改变窗体大小
        this.setResizable(false);
        //居中
        FrameUtil.setFrameCenter(this);
        //设置默认Panel
        this.setContentPane(panelGame);
        //默认窗口为显示
        this.setVisible(true);
    }
}
