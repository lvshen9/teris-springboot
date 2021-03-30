package com.lvshen.teris.ui.window;


import com.lvshen.teris.control.GameControl;
import com.lvshen.teris.util.FrameUtil;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.*;

public class JFrameSavePoint extends JFrame {
    private JButton btnOk = null;
    private JLabel lbPoint = null;
    private JTextField txName = null;
    private JLabel errMsg = null;
    private GameControl gameControl = null;

    private static final int NAME_LENGTH = 16;


    public JFrameSavePoint(GameControl gameControl) {
        this.gameControl = gameControl;
        this.setTitle("保存记录");
        this.setSize(256, 128);
        FrameUtil.setFrameCenter(this, -380);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.createCom();
        this.createAction();

/*		//TODO 测试用
		this.setDefaultCloseOperation(3);
		this.setVisible(true);*/
    }

    /**
     * 显示窗口口
     */
    public void show(int point) {
        this.lbPoint.setText("您的得分:" + point);
        this.setVisible(true);
    }

    /**
     * 创建事件监听
     */
    private void createAction() {
        this.btnOk.addActionListener(e -> {
            String name = txName.getText();
            if (name.length() > NAME_LENGTH || StringUtils.isBlank(name)) {
                errMsg.setText("名字输入不合法");
            } else {
                setVisible(false);
                gameControl.savePoint(name);
            }
        });
    }

    /**
     * 初始化控件
     */
    private void createCom() {
        //创建北部面板
        JPanel north = new JPanel(new FlowLayout(FlowLayout.LEFT));
        //创建分数文字
        this.lbPoint = new JLabel();
        //添加分数到北部面板
        north.add(lbPoint);
        //创建错误信息控件
        this.errMsg = new JLabel();
        this.errMsg.setForeground(Color.RED);
        //添加错误信息到北部面板
        north.add(this.errMsg);
        //北部面板添加到主面板
        this.add(north, BorderLayout.NORTH);
        //创建中部面板，流式布局
        JPanel center = new JPanel(new FlowLayout(FlowLayout.LEFT));
        //创建文本框
        this.txName = new JTextField(10);
        //设置文字
        center.add(new JLabel("您的名字"));
        //文本框添加到中部面板
        center.add(this.txName);
        //中部面板添加到主面板
        this.add(center, BorderLayout.CENTER);

        //创建南部面板(流式布局)
        JPanel south = new JPanel(new FlowLayout(FlowLayout.CENTER));
        //创建确定按钮
        this.btnOk = new JButton("确定");
        //按钮添加到南部面板
        south.add(btnOk);
        //南部面板添加到主面板
        this.add(south, BorderLayout.SOUTH);

    }
}
