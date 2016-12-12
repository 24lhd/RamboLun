package com.t3h.game;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import com.t3h.boom.Boom;

public class OngGia extends NhanVatGame{
	private boolean isThoat;
	private boolean isCho;
	private AudioClip thanks;
	private Image biTroi = new ImageIcon(getClass().getResource("/image/bitroi.gif")).getImage();
	private Image thoat =new ImageIcon(getClass().getResource("/image/thoat.gif")).getImage();
	private Image chay =new ImageIcon(getClass().getResource("/image/chay.gif")).getImage();
	private Image choBom =  new ImageIcon(getClass().getResource("/image/cho.gif")).getImage();
	private Image run =new ImageIcon(getClass().getResource("/image/run.gif")).getImage();
	private Image danLaze =new ImageIcon(getClass().getResource("/image/danlaze.png")).getImage();
	private int time;
	public OngGia(int x, int y) {
		super(x, y);
		time=0;
		setImageRect(chay);
		thanks=Applet.newAudioClip(getClass().getResource("/sound/Thanks.wav"));
	}
	public void draw(Graphics2D g) {
		setCho(false);
		if (isCho) {
			thanks.stop();
		}
		if (isThoat) {
			time++;
			if (time>600) {
				g.drawImage(run, x, y, null);
				if (time%2==0) {
					x=x-2;
				}
			}else if (time>400) {
				if (time==500) {
					setCho(true);
					if (isCho) {
						thanks.play();
					}
				}
				g.drawImage(choBom, x, y, null);
				
			}else if (time>200) {
				
				g.drawImage(chay, x, y, null);
			}else if (time<200) {
					g.drawImage(thoat, x, y, null);
			}
		}else if (isStand) {
			g.drawImage(biTroi, x, y, null);
		}
		
	}
	public boolean isCho() {
		return isCho;
	}
	public void setCho(boolean isCho) {
		this.isCho = isCho;
	}
	public boolean isThoat() {
		return isThoat;
	}
	public void setThoat(boolean isThoat) {
		this.isThoat = isThoat;
	}
	public Rectangle getRectOngGia() {
		return new Rectangle(x, y, getImageRect().getWidth(null), getImageRect().getHeight(null));
	}
	public Boom choBoom() {
		int x=this.x;
		int y=this.y;
		return new Boom(x, y,NhanVatGame.DOWN, danLaze,danLaze);
	}
	
}
