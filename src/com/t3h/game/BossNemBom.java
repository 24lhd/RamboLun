package com.t3h.game;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.t3h.boom.Boom;

public class BossNemBom extends Boss{
	private Image luuDanNo =new ImageIcon(getClass().getResource("/image/luudanbossno.gif")).getImage();
	private Image luuDan =new ImageIcon(getClass().getResource("/image/luudanboss.gif")).getImage();
	public BossNemBom(int x, int y) {
		super(x, y);
		setStand(new ImageIcon(getClass().getResource("/image/standboss.gif")).getImage());
		setWalkLeft(new ImageIcon(getClass().getResource("/image/boss_walk_left.gif")).getImage());
		setWalkRight(new ImageIcon(getClass().getResource("/image/boss_walk_right.gif")).getImage());
		setNemBanTrai(new ImageIcon(getClass().getResource("/image/bossnembomtrai.gif")).getImage());
		setNemBanPhai(new ImageIcon(getClass().getResource("/image/bossnembomphai.gif")).getImage());
		setBossDie( new ImageIcon(getClass().getResource("/image/bossdie.png")).getImage());
		setStart(new ImageIcon(getClass().getResource("/image/startboss.gif")).getImage());
	}
	public Boom nemBoom() {
		int x=this.x;
		int y=this.y;
		if (isLeft) {
			return new Boom(x+getImageRect().getWidth(null), y,NhanVatGame.LEFT, luuDan,luuDanNo);
		}
		return new Boom(x+60, y,NhanVatGame.RIGHT, luuDan,luuDanNo);
	}
	
}
