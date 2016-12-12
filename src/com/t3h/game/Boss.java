package com.t3h.game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Boss extends NhanVatGame{
	private boolean isStart;
	private int timeNemBom;
	private int time;
	private int timeMove;
	private boolean isDie;
	private Image stand;
	private Image walkLeft;
	private Image walkRight;
	private Image nemBanTrai;
	private Image nemBanPhai;
	private Image bossDie;
	private Image start;
	
	public Boss(int x, int y) {
		super(x, y);
		
		timeNemBom=0;
		time=0;
		timeMove=0;
		isDie=false;
		setImageRect(stand);
	}
	
	public void setBossDie(Image bossDie) {
		this.bossDie = bossDie;
	}

	public void setTimeNemBom(int timeNemBom) {
		this.timeNemBom = timeNemBom;
	}
	public void setStand(Image stand) {
		this.stand = stand;
	}

	public void setWalkLeft(Image walkLeft) {
		this.walkLeft = walkLeft;
	}

	public void setWalkRight(Image walkRight) {
		this.walkRight = walkRight;
	}

	public void setNemBanTrai(Image nemBanTrai) {
		this.nemBanTrai = nemBanTrai;
	}

	public void setNemBanPhai(Image nemBanPhai) {
		this.nemBanPhai = nemBanPhai;
	}

	public void setStart(Image start) {
		this.start = start;
	}
	public void draw(Graphics2D g,ArrayList<VatCan> vatCan) {
		timeNemBom++;
		timeMove++;
		if(isDie){
			setImageRect(bossDie);
			g.drawImage(bossDie, x, y,null);
		}else{
			
			if (isStand) {
				setImageRect(stand);
				if (timeMove<1000) {
					g.drawImage(stand, x, y,null);
				} else if (timeMove>1000&&timeMove<2000) {
					setImageRect(walkLeft);
					if (timeMove%5==0&&checkVatCanLeftRight(vatCan,NhanVatGame.RIGHT)) {
						x++;
					}
					g.drawImage(walkRight, x, y,null);
				} else if(timeMove>2000&&timeMove<3000){
					if (timeMove%5==0&&checkVatCanLeftRight(vatCan,NhanVatGame.LEFT)) {
						x--;
					}
					g.drawImage(walkLeft, x, y,null);
				}else if(timeMove>3000){
					timeMove=0;
				}
			}else if(isStart){
				timeMove=0;
				if (timeNemBom<800) {
					g.drawImage(start, x, y,null);
				}else if (timeNemBom>800) {
					setImageRect(nemBanTrai);
					if (isLeft) {
						g.drawImage(nemBanTrai, x, y,null);
					} else {
						g.drawImage(nemBanPhai, x, y,null);
					}
				}else if (timeNemBom>2000) {
					timeNemBom=0;
				}
			}
		}
	}
	public boolean checkTrungDan(Rectangle r) {
		if(r.intersects(getRect())){
			isDie=true;
			return true;
		}
		return false;
	}
	public Rectangle getRectLeftShot() {
		return new Rectangle(x-300, y,500,getImageRect().getHeight(null));
	}
	public Rectangle getRectRightShot() {
		return new Rectangle(x+getImageRect().getWidth(null), y,500,getImageRect().getHeight(null));
	}
	public Rectangle getRect() {
		return new Rectangle(x, y,getImageRect().getWidth(null),getImageRect().getHeight(null));
	}
	public boolean checkVaCham(Rectangle r) {
		time++;
		if(getRectLeftShot().intersects(r)){
			isLeft=true;
			isStand=false;
			isStart=true;
			if (time%1300==0) {
				time=0;
				return true;
			}
		}else if(getRectRightShot().intersects(r)){
			isLeft=false;
			isStand=false;
			isStart=true;
			if (time%1300==0) {
				time=0;
				return true;
			}
		}else{
			isStand=true;
			isStart=false;
			return false;
		}
		return false;
	}
	
	public boolean getDie() {
		return isDie;
	}
}
