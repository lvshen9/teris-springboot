package com.lvshen.teris.control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * 控制类
 * @author lvshen
 */
public class PlayerControl extends KeyAdapter{
	private GameControl gameControl;

	public PlayerControl(GameControl gameControl){
		this.gameControl=gameControl;
	}


	/**
	 * 键盘按下事件
	 */
	@Override
	public void keyPressed(KeyEvent e) {

		this.gameControl.actionByKeyCode(e.getKeyCode());



	}



}
