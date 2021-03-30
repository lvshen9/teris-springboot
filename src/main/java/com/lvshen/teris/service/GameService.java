package com.lvshen.teris.service;

/**
 * 游戏服务接口
 * @author lvshen
 */
public interface GameService {
	/**
	 * 方向键上
	 */
	boolean keyUp();
	/**
	 * 方向键下
	 */
	boolean keyDown();
	/**
	 * 方向键左
	 */
	boolean keyLeft();
	/**
	 * 方向键右
	 */
	boolean keyRight();
	/**
	 * Y
	 */
	boolean keyFunUp();
	/**
	 * A
	 */
	boolean keyFunDown();
	/**
	 * X
	 */
	boolean keyFunLeft();
	/**
	 * B
	 */
	boolean keyFunRight();

	/**
	 * 启动主线程开始游戏
	 */
	void startGame();
	/**
	 * 游戏主要行为
	 */
	void mainAction();
}
