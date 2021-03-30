package com.lvshen.teris.ui;

import java.awt.Graphics;

public class LayAbout extends Lay {

	public LayAbout(int x, int y, int w, int h) {
		super(x, y, w, h);
		
	}
	
	@Override
    public void paint(Graphics g){
		this.createWindow(g);
		this.drawImageAtCenter(Img.SIGN, g);
	}

}
