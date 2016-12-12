package com.t3h.game;

import java.applet.Applet;
import java.applet.AudioClip;

import javax.swing.ImageIcon;

import com.t3h.bullet.Bullet;

public class BossBanDanBac extends Boss{
	private AudioClip bossShot;
	public BossBanDanBac(int x, int y) {
		
		super(x, y);
		setStand(new ImageIcon(getClass().getResource("/image/standboss.gif")).getImage());
		setWalkLeft(new ImageIcon(getClass().getResource("/image/boss_ban_walk_trai.gif")).getImage());
		setWalkRight(new ImageIcon(getClass().getResource("/image/boss_ban_walk_phai.gif")).getImage());
		setNemBanTrai(new ImageIcon(getClass().getResource("/image/dan_bac_trai.gif")).getImage());
		setNemBanPhai(new ImageIcon(getClass().getResource("/image/dan_bac_phai.gif")).getImage());
		setBossDie( new ImageIcon(getClass().getResource("/image/die2.png")).getImage());
		setStart(new ImageIcon(getClass().getResource("/image/startboss.gif")).getImage());
		bossShot=Applet.newAudioClip(getClass().getResource("/sound/boombossno.wav"));
	}
	public Bullet banSung() {
		bossShot.play();
	int x=this.x;
	int y=this.y;
	if (isLeft) {
		return new Bullet(x, y+getImageRect().getHeight(null)/2, NhanVatGame.LEFT, new ImageIcon(getClass().getResource("/image/danbac.gif")).getImage());
	}
	return new Bullet(x+getImageRect().getWidth(null), y+getImageRect().getHeight(null)/2,NhanVatGame.RIGHT,new ImageIcon(getClass().getResource("/image/danbac.gif")).getImage());
	}
}
