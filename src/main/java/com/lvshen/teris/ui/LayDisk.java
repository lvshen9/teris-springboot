package com.lvshen.teris.ui;


import java.awt.Graphics;

public class LayDisk extends LayData {
	
	

	public LayDisk(int x, int y, int w, int h) {
		super(x, y, w, h);
		
	}
	@Override
    public void paint(Graphics g){
		this.createWindow(g);//Img.DISK
		//g.drawImage(Img.DISK, this.x+PADDING, this.y+PADDING, null);
		this.showData(Img.DISK, this.dto.getDiskRecode(), g);
	}

}
