package com.t3h.boom;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import com.t3h.game.NhanVatGame;
import com.t3h.game.VatCan;

public class Boom {
	private int y;
	private int x;
	private Image imageBoom;
	private Image imageNo;
	private int timeNem;
	private int huong;
	private int doDaiNemBom;
	private AudioClip bomBossNo;
	int timePlay;
	public Boom( int x, int y,int huong,Image imageBoom,Image imageNo) {
		this.y = y;
		this.x = x;
		this.imageBoom=imageBoom;
		this.imageNo=imageNo;
		this.huong=huong;
		timeNem=0;
		timePlay=0;
		doDaiNemBom=100;
		bomBossNo=Applet.newAudioClip(getClass().getResource("/sound/boombossno.wav"));
	}
	public boolean checkVatCan(ArrayList<VatCan> vatCan) {
		for (VatCan vat : vatCan) {
				if (vat.getRect().intersects(getRect())) {
					return true;
				}
		}
		return false;
	}
	public boolean trongLuc(int huong,int time,boolean trongLuc,ArrayList<VatCan> vatCan) {
		
		if (time%5!=0) {
			return false;
		}
		if (checkVatCan(vatCan)) {
			trongLuc=true;
		}
		if (trongLuc) {
			timeNem++;
			if (timeNem==10) {
				bomBossNo.play();
			}
		}else{
			timeNem=0;
			bomBossNo.stop();
		}
		
		if (huong==NhanVatGame.DOWN) {
			if (trongLuc) {
				return false;
			}
				y=y+2;
		}
		return true;
	}
	public void diChuyenTheoMap(int huong,int time) {
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
	public void nem(int time,boolean trongLuc) {
		if (time%5!=0) {
			return;
		}
		if (trongLuc) {
			timePlay++;
			if (timePlay==10) {
				bomBossNo.play();
			}
		}else{
			timePlay=0;
			bomBossNo.stop();
		}
		if (huong==NhanVatGame.RIGHT) {
			if (timeNem>=doDaiNemBom) {
				if (trongLuc) {
					return;
				}
				y=y+3;
				x=x+2;
			}else{
				timeNem=timeNem+2;;
				x=x+2;
				y=y-2;
			}
		}else{
			if (timeNem>=doDaiNemBom) {
				if (trongLuc) {
					return;
				}
				y=y+3;
				x=x-2;
			}else{
				timeNem=timeNem+2;
				x=x-2;
				y=y-2;
			}
		}
	}
	public void drawBoom(Graphics2D g) {
		g.drawImage(imageBoom, x, y,null);
	}
	public void drawBoomNo(Graphics2D g) {
		g.drawImage(imageNo, x, y-imageNo.getHeight(null)+imageBoom.getHeight(null),null);
		
	}
	public Rectangle getRect() {
		return new Rectangle(x, y, imageBoom.getWidth(null), imageBoom.getHeight(null));
	}
	public Rectangle getRectBoomNo() {
		return new Rectangle(x, y, imageNo.getWidth(null), imageNo.getHeight(null));
	}
}
