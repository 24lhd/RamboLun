package com.t3h.game;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.t3h.boom.Boom;

public class BossFly2 extends BossFly{
	private Image b52= new ImageIcon(getClass().getResource("/image/b52.gif")).getImage();
	private Image b52No= new ImageIcon(getClass().getResource("/image/b52no.gif")).getImage();
	public BossFly2(int x, int y) {
		super(x, y);
		timeFly=0;
		setFlyLeft(new ImageIcon(getClass().getResource("/image/bossfly.png")).getImage());
		setFlyRight(new ImageIcon(getClass().getResource("/image/bossflyrifht.gif")).getImage());
	}
	public void fly(int time) {
		if (!isDie()) {
			timeFly++;
			if (time%2!=0) {
				return;
			}
			if (timeFly<3000) {
				x--;
				setLeft(true);
			}else if (timeFly>3000&&timeFly<6000) {
				x++;
				setLeft(false);
			}else if (timeFly>6000) {
				timeFly=0;
			}
		}
		
	}
	public BossBanDanBac bossBanDanBac() {
		return new BossBanDanBac(x+getFlyLeft().getWidth(null)/2,y+getFlyLeft().getHeight(null)/2);
	}
	public Boom thaBoom() {
		int x=this.x+getFlyLeft().getWidth(null)/2;
		int y=this.y+getFlyLeft().getHeight(null)/2;
		return new Boom(x, y,NhanVatGame.DOWN, b52,b52No);
	}
	public BossBanSung bossBanSung() {
		return new BossBanSung(x+getFlyLeft().getWidth(null)/2,y+getFlyLeft().getHeight(null)/2);
	}
	public BossNemBom bossNemBom() {
		return new BossNemBom(x+getFlyLeft().getWidth(null)/2,y+getFlyLeft().getHeight(null)/2);
	}

}
