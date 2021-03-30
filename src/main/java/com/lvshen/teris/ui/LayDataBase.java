package com.lvshen.teris.ui;

import java.awt.Graphics;

/**
 * @author lvshen
 */
public class LayDataBase extends LayData {
	public LayDataBase(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	@Override
    public void paint(Graphics g){
		
		this.createWindow(g);
		this.showData(Img.DB, this.dto.getDbRecode(), g);
	}

}
