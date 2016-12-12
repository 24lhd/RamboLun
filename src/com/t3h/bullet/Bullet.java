package com.t3h.bullet;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import com.t3h.game.NhanVatGame;

public class Bullet {
	private int y;
	private int x;
	private Image image;
	private int huong;
	public Bullet( int x, int y, int huong,Image image) {
		super();
		this.y = y;
		this.x = x;
		this.huong = huong;
		this.image=image;
	}
	public boolean moveBullet(int w,int h) {
		if (x<=0||x>=(w-image.getWidth(null)-20)) {
			return false;
		}
		if (y<=0||y>=(h-image.getHeight(null)-30)) {
			return false;
		}
		switch (huong) {
		case NhanVatGame.LEFT:
			x--;
			break;
		case NhanVatGame.RIGHT:
			x++;
			break;
		case NhanVatGame.UP:
			y--;
			break;
		}
		return true;
	}
	public void draw(Graphics2D g) {
		g.drawImage(image, x, y,null);
	}
	public Rectangle getRect() {
		return new Rectangle(x, y, image.getWidth(null), image.getHeight(null));
	}
	
}
