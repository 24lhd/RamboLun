package com.t3h.game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import com.t3h.gui.MyFrame;

public class BossFly {
	private Image flyLeft;
	private Image flyRight;
	private Image imDie=new ImageIcon(getClass().getResource("/image/bossflyno.gif")).getImage();
	protected int timeBom;
	protected int x;
	protected int y;
	protected boolean isLeft;
	protected int timeFly;
	private int hp;
	private boolean isDie;
	public BossFly(int x, int y) {
		this.x=x;
		this.y=y;
		timeBom=0;
		hp=100;
		isDie=false;
	}
	public Image getFlyLeft() {
		return flyLeft;
	}
	public void setFlyLeft(Image flyLeft) {
		this.flyLeft = flyLeft;
	}
	public Image getFlyRight() {
		return flyRight;
	}
	public void setFlyRight(Image flyRight) {
		this.flyRight = flyRight;
	}
	public boolean isLeft() {
		return isLeft;
	}
	public void setLeft(boolean isLeft) {
		this.isLeft = isLeft;
	}
	public boolean isDie() {
		return isDie;
	}
	public void setDie(boolean isDie) {
		this.isDie = isDie;
	}
	public void draw(Graphics2D g) {
		 if (isLeft) {
			g.drawImage(flyLeft, x, y, null);
		}else{
			g.drawImage(flyRight, x, y, null);
		}
	}
	public void drawDie(Graphics2D g) {
			g.drawImage(imDie, x+50, y-50, null);
	}
	public Rectangle getRectBossFly() {
		return new Rectangle(x, y, flyLeft.getWidth(null), MyFrame.DOC);
	}
	public Rectangle getRectBossFlyVaCham() {
		return new Rectangle(x, y, flyLeft.getWidth(null),flyLeft.getHeight(null));
	}
	public boolean checkTrungDan(Rectangle r) {
		if (r.intersects(getRectBossFlyVaCham())) {
			hp--;
			if (hp<=0) {
				 isDie=true;
				 return true;
			}
		}
		return false;
	}
	public boolean diChuyenTheoMap(int huong,boolean trongLuc){
		if (huong==NhanVatGame.RIGHT){
			x--;
		}
		if (huong==NhanVatGame.LEFT){
			x++;
		}
		if (huong==NhanVatGame.DOWN&&isDie==true) {
			if (trongLuc) {
				return true;
			}
			y=y+5;
		}
		return false;
	}
	public boolean checkVaCham(Rectangle r) {
		if(getRectBossFly().intersects(r)){
			timeBom++;
			if (timeBom==300&&isDie==false) {
				timeBom=0;
				return true;
			}else{
				return false;
			}
		}
		return false;
	}
}
