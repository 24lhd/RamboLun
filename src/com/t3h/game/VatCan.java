package com.t3h.game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

public class VatCan {
	private int x;
	private int y;
	private Image vatCan;
	public VatCan(Image vatCan,int x, int y) {
		this.x = x;
		this.y = y;
		this.vatCan=vatCan;
	}
	public void drawVatCan(Graphics2D g){
		g.drawImage(vatCan, x, y, null);
	}
	public void diTheoMap(int huong,int time) {
		if (time%5!=0) {
			return;
		}
		if (huong==NhanVatGame.RIGHT) {
			x--;
		}
		if (huong==NhanVatGame.LEFT) {
			x++;
		}
	}
	public void trongLuc(int huong,int time,boolean trongLuc) {
		if (time%5!=0){
			return;
		}
		if (y>0){
			if (trongLuc) {
				return;
			}
			y=y+2;
		}
	}
	public Rectangle getRect() {
		Rectangle rectangle=new Rectangle(x, y, vatCan.getWidth(null),vatCan.getHeight(null));
		return rectangle;
	}
}
