package com.t3h.game;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

public abstract class NhanVatGame {
	public static final int UP=2;
	public static final int DOWN=4;
	public static final int LEFT=1;
	public static final int RIGHT=3;
	protected int x;
	protected int y;
	protected boolean isChuyenDong;
	protected boolean isLeft;
	protected boolean isStand;
	protected boolean isShot;
	protected boolean isJump;
	protected boolean isSit;
	public boolean isDie() {
		return isDie;
	}
	public void setDie(boolean isDie) {
		this.isDie = isDie;
	}
	protected boolean isThrow;
	protected boolean isLookUp;
	protected boolean isDie;
	protected int orient;
	private Image imageRect;

	public NhanVatGame(int x,int y) {
		this.x=x;
		this.y=y;
		isStand=true;
		orient=RIGHT;
	}
	public Image getImageRect() {
		return imageRect;
	}
	public void setImageRect(Image imageRect) {
		this.imageRect = imageRect;
	}
	public void setThrow(boolean isThrow) {
		this.isThrow = isThrow;
	}
	public void setJump(boolean isJump) {
		this.isJump = isJump;
	}
	public void setLookUp(boolean isLookUp) {
		this.isLookUp = isLookUp;
	}
	public void setShot(boolean isShot) {
		this.isShot = isShot;
	}
	public void setSit(boolean isSit) {
		this.isSit = isSit;
	}
	public void setStand(boolean isStand) {
		this.isStand = isStand;
	}
	public void setChuyenDong(boolean isChuyenDong) {
		this.isChuyenDong = isChuyenDong;
	}
	public void setOrient(int orient) {
		this.orient = orient;
	}
	public void setLeft(boolean isLeft) {
		this.isLeft = isLeft;
	}
	public boolean checkVatCan(ArrayList<VatCan> vatCan) {
		for (VatCan vat : vatCan) {
				if (vat.getRect().intersects(getRectDown())) {
					return true;
				}
		}
		return false;
	}
	public boolean checkVatCanLeftRight(ArrayList<VatCan> vatCan,int huong) {
		for (VatCan vat : vatCan) {
				if (vat.getRect().intersects(getRectLeft())&&huong==NhanVatGame.LEFT) {
					return false;
				}
				if (vat.getRect().intersects(getRectRight())&&huong==NhanVatGame.RIGHT) {
					return false;
				}
		}
		return true;
	}
		
	public boolean trongLuc(int huong,int time,boolean trongLuc,ArrayList<VatCan> vatCan){
		if (time%4!=0) {
			return false;
		}
		if (checkVatCan(vatCan)) {
			trongLuc=true;
		}
		if (huong==DOWN) {
			if (trongLuc) {
				return false;
			}else{
				y=y+2;
			}
		}
		
		return false;
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
	public Rectangle getRectLeft() {
		return new Rectangle(x+20,y+10,5,getImageRect().getHeight(null)-20);
	}
	public Rectangle getRectRight() {
		return new Rectangle(x+getImageRect().getWidth(null)-35,y+10,5,getImageRect().getHeight(null)-20);
	}
	public Rectangle getRectDown() {
		if (isLeft) {
			return new Rectangle(x+40,y+getImageRect().getHeight(null)-10,30,5);
		}
		return new Rectangle(x+10,y+getImageRect().getHeight(null)-10,30,5);
	}
	public Rectangle getRect() {
		return new Rectangle(x,y,getImageRect().getWidth(null),getImageRect().getHeight(null));
	}
	
}
