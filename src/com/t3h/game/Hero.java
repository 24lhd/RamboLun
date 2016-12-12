package com.t3h.game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import com.t3h.boom.Boom;
import com.t3h.bullet.Bullet;
import com.t3h.gui.MyFrame;

public class Hero extends NhanVatGame {
	private Image standLeft = new ImageIcon(getClass().getResource("/image/stand_left.gif")).getImage();
	private Image standRight =new ImageIcon(getClass().getResource("/image/stand_right.gif")).getImage();
	private Image moveRight =new ImageIcon(getClass().getResource("/image/move_right.gif")).getImage();
	private Image moveLeft =  new ImageIcon(getClass().getResource("/image/move_left.gif")).getImage();
	private Image sitLeft =new ImageIcon(getClass().getResource("/image/sit_left.gif")).getImage();
	private Image sitMoveLeft =new ImageIcon(getClass().getResource("/image/sit_move_left.gif")).getImage();
	private Image sitMoveRight =new ImageIcon(getClass().getResource("/image/sit_move_right.gif")).getImage();
	private Image sitRight =new ImageIcon(getClass().getResource("/image/sit_right.gif")).getImage();
	private Image sitShotRight =new ImageIcon(getClass().getResource("/image/sit_shot_right.gif")).getImage();
	private Image sitShotLeft =new ImageIcon(getClass().getResource("/image/sit_shot_left.gif")).getImage();
	private Image standShotLeft =new ImageIcon(getClass().getResource("/image/stand_shot_left.gif")).getImage();
	private Image standShotRight =new ImageIcon(getClass().getResource("/image/stand_shot_right.gif")).getImage();
	private Image moveShotLeft =new ImageIcon(getClass().getResource("/image/move_shot_left.gif")).getImage();
	private Image moveShotRight =new ImageIcon(getClass().getResource("/image/move_shot_right.gif")).getImage();
	private Image jumpLeft =new ImageIcon(getClass().getResource("/image/nhay.gif")).getImage();
	private Image jumpRight =new ImageIcon(getClass().getResource("/image/nhayphai.gif")).getImage();
	private Image lookUpLeft =new ImageIcon(getClass().getResource("/image/look_up_left.gif")).getImage();
	private Image lookUpRight =new ImageIcon(getClass().getResource("/image/look_up_right .gif")).getImage();
	private Image shotLookUpLeft =new ImageIcon(getClass().getResource("/image/shot_up_left.gif")).getImage();
	private Image shotLookUpRight =new ImageIcon(getClass().getResource("/image/shot_up_right.gif")).getImage();
	private Image moveLookUpLeft =new ImageIcon(getClass().getResource("/image/move_look_up_left.gif")).getImage();
	private Image moveLookUpRight =new ImageIcon(getClass().getResource("/image/move_look_up_right.gif")).getImage();
	private Image standThrowLeft =new ImageIcon(getClass().getResource("/image/stand_throw_boom_left.gif")).getImage();
	private Image standThrowRight =new ImageIcon(getClass().getResource("/image/stand_throw_boom_right.gif")).getImage();
	private Image moveThrowLeft =new ImageIcon(getClass().getResource("/image/move_throw_boom_left.gif")).getImage();
	private Image moveThrowRight =new ImageIcon(getClass().getResource("/image/move_throw_boom_right.gif")).getImage();
	private Image sitThrowLeft =new ImageIcon(getClass().getResource("/image/sit_throw_left.gif")).getImage();
	private Image sitThrowRight =new ImageIcon(getClass().getResource("/image/sit_throw_right.gif")).getImage();
	private Image moveShotLookUPLeft =new ImageIcon(getClass().getResource("/image/move_shot_up_left.gif")).getImage();
	private Image moveShotLookUpRight =new ImageIcon(getClass().getResource("/image/move_shot_up_right.gif")).getImage();
	private Image sitMoveShotLeft =new ImageIcon(getClass().getResource("/image/sit_move_shot_left.gif")).getImage();
	private Image sitMoveShotRight =new ImageIcon(getClass().getResource("/image/sit_move_shot_right.gif")).getImage();
	private Image luuDan =new ImageIcon(getClass().getResource("/image/luudan.gif")).getImage();
	private Image luuDanNo =new ImageIcon(getClass().getResource("/image/luudantano.gif")).getImage();
	private Image die =new ImageIcon(getClass().getResource("/image/herodie.png")).getImage();
	private boolean isDap;
	public Hero(int x,int y){
		super(x,y);
	}
	public boolean isDap() {
		return isDap;
	}
	public void setDap(boolean isDap) {
		this.isDap = isDap;
	}
	public void drawHeroLeft(Graphics2D g) {
		setImageRect(standLeft);
		if (isJump) {
			g.drawImage(jumpLeft, x,y,null);
		}else if (isChuyenDong) {
			 if (isLookUp) {
					if (isShot) {
						g.drawImage(moveShotLookUPLeft, x, y, null);
					}else{
						g.drawImage(moveLookUpLeft, x, y, null);
					}
				}else if (isSit) {
					if (isThrow) {
							g.drawImage(sitThrowLeft, x, y, null);
					}else if (isShot) {
							g.drawImage(sitMoveShotLeft, x, y, null);
					}else{
							g.drawImage(sitMoveLeft, x, y, null);
					}
				}else if (isShot) {
						g.drawImage(moveShotLeft, x, y, null);
				}else if (isThrow) {
						g.drawImage(moveThrowLeft, x, y, null);
				}else{
						g.drawImage(moveLeft, x, y, null);
			}
		}else{ // k chuyen dong
				if (isLookUp) {
					if (isShot) {
						g.drawImage(shotLookUpLeft, x, y, null);
					}else{
						g.drawImage(lookUpLeft, x, y, null);
					}
				}else if (isSit) {
						if (isShot) {
							g.drawImage(sitShotLeft, x, y, null);
						}else if (isThrow) {
							g.drawImage(sitThrowLeft, x, y, null);
						}else{
							g.drawImage(sitLeft, x, y, null);
						}
				}else if (isStand) {
					if (isShot) {
						g.drawImage(standShotLeft, x, y, null);
					}else if (isThrow) {
						g.drawImage(standThrowLeft, x, y, null);
					}else{
						g.drawImage(standLeft, x, y, null);
					}
				}
			}
		
	}
	public void drawHeroRight(Graphics2D g) {
			setImageRect(standRight);
			if (isJump) {
				g.drawImage(jumpRight, x,y,null);
			}else if (isChuyenDong) {
					 if (isLookUp) {
							if (isShot) {
								g.drawImage(moveShotLookUpRight, x, y, null);
							}else{
								
								g.drawImage(moveLookUpRight, x, y, null);
							}
						}else if (isSit) {
							if (isThrow) {
									g.drawImage(sitThrowRight, x, y, null);
							}else if (isShot) {
									g.drawImage(sitMoveShotRight, x, y, null);
							}else{
									g.drawImage(sitMoveRight, x, y, null);
							}
						}else if (isShot) {
								g.drawImage(moveShotRight, x, y, null);
						}else if (isThrow) {
								g.drawImage(moveThrowRight, x, y, null);
						}else{
								g.drawImage(moveRight, x, y, null);
					}
				}else{ // k chuyen dong
						if (isLookUp) {
							if (isShot) {
								g.drawImage(shotLookUpRight, x, y, null);
							}else{
								g.drawImage(lookUpRight, x, y, null);
							}
						}else if (isSit) {
								if (isShot) {
									g.drawImage(sitShotRight, x, y, null);
								}else if (isThrow) {
									g.drawImage(sitThrowRight, x, y, null);
								}else{
									g.drawImage(sitRight, x, y, null);
								}
						}else if (isStand) {
							if (isShot) {
								g.drawImage(standShotRight, x, y, null);
							}else if (isThrow) {
								g.drawImage(standThrowRight, x, y, null);
							}else{
								g.drawImage(standRight, x, y, null);
							}
						}
					}
	}
	public void draw(Graphics2D g) {
		if (!isDie) {
			if (isLeft) {
				setImageRect(standLeft);
				drawHeroLeft(g);
			}else{
				setImageRect(standRight);
				drawHeroRight(g);
			}
		}else{
			setImageRect(die);
			g.drawImage(die,x,y,null);
		}
	}
	public boolean diChuyen(int huong,int time,boolean trongLuc,ArrayList<VatCan> vatCans) {
		if (time%4!=0) {
			return false;
		}
		if (x<0&&huong==LEFT) {
			return false;
		}
		int tam=MyFrame.DOC-y;
		if (huong==UP&&y>200-tam) {
				y=y-2;
		}
		super.trongLuc(huong, time, trongLuc,vatCans);
		return true;
	}
	public Bullet fire(Image [] imageBullet){
		if (isDie) {
			return null;
		}
		int x=0;
		int y=0;
		Image image = null;
		if(isSit){
			if (isLeft) {
				x=this.x-sitLeft.getWidth(null)/2;
				y=this.y+sitLeft.getHeight(null)/2+20;
				image=imageBullet[0];
			}else{
				x=this.x+sitLeft.getWidth(null);
				y=this.y+sitLeft.getHeight(null)/2+20;
				image=imageBullet[2];
			}
		}else{
			if (isLeft) {
				if(isLookUp){
					x=this.x+lookUpRight.getWidth(null)/2;
					y=this.y-20;
					image=imageBullet[1];
				}else{
					x=this.x-standLeft.getWidth(null)/2;
					y=this.y+standLeft.getHeight(null)/2-5;
					image=imageBullet[0];
				}
			} else{
				if(isLookUp){
					x=this.x+lookUpRight.getWidth(null)/2;
					y=this.y-20;
					image=imageBullet[1];
				}else{
					x=this.x+standRight.getWidth(null)+standRight.getWidth(null)/2;
					y=this.y+standRight.getHeight(null)/2-5;
					image=imageBullet[2];
				}
			}
		}
		return new Bullet(x, y,orient,image);
	}

	public Boom nemBoom() {
		int x=this.x;
		int y=this.y;
		if (isLeft) {
			return new Boom(x-standLeft.getWidth(null)/2, y,NhanVatGame.LEFT, luuDan,luuDanNo);
		}
		return new Boom(x+60, y,NhanVatGame.RIGHT, luuDan,luuDanNo);
	}
	public Rectangle getRect() {
		if (isSit) {
			return new Rectangle(x+20,y+standRight.getHeight(null)/2+20,30,40);
		}
		return new Rectangle(x+20,y+standRight.getHeight(null)/2-20,30,80);
	}
	
	
	

}
