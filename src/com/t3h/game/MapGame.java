package com.t3h.game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import com.t3h.gui.MyFrame;

public class MapGame {
	public static final int WAY=250;
	private int x;
	private BossFly2 diaBay;
	private Image imageBackGround=new ImageIcon(getClass().getResource("/image/xxx.jpg")).getImage();
	private Image imageMatDat=new ImageIcon(getClass().getResource("/image/nendat.png")).getImage();
	public MapGame(int x, int y) {
		super();
		this.x = x;
		diaBay=new BossFly2(9000,20);
	}
	
	public boolean diChuyen(int huong, int time) {
		if (time%5!=0) {
			return false;
		}
		
		if (x==0&&huong==NhanVatGame.LEFT) {
			return true;
		}
		if (x==-9000&&huong==NhanVatGame.RIGHT) {
			return true;
		}
		diaBay.diChuyenTheoMap(huong,diaBay.getRectBossFlyVaCham().intersects(getRect()));
		if (huong==NhanVatGame.RIGHT){
			x--;
		}
		if (huong==NhanVatGame.LEFT){
			x++;
		}
		return false;
	}
	public void draw(Graphics2D g) {
		g.drawImage(imageMatDat, x, MyFrame.DOC-77,null);
		for (int i = 0; i <7; i++) {
			g.drawImage(imageBackGround, x+(imageBackGround.getWidth(null)*i), 0, null);
		}
		if (diaBay.getRectBossFlyVaCham().intersects(getRect())) {
			diaBay.drawDie(g);
		}else{
			diaBay.draw(g);
		}
		
	}
	public BossFly2 getDiaBay() {
		return diaBay;
	}
	public void fly(int time) {
		diaBay.fly(time);
	}
	public Rectangle getRect() {
		return new Rectangle(x,MyFrame.DOC-77, imageMatDat.getWidth(null),imageMatDat.getHeight(null));
	}
	public Rectangle getRectRemoveOngGia() {
		return new Rectangle(0-100, 0,2,MyFrame.DOC);
	}
}
