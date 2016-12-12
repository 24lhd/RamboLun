package com.t3h.game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import com.t3h.boom.Boom;
import com.t3h.bullet.Bullet;
import com.t3h.gui.MyFrame;

public class GameManager {
	private Hero hero;
	private MapGame mapGame;
	private ArrayList<Bullet> arrBullet;
	private ArrayList<Bullet> arrBulletBoss;
	private ArrayList<Bullet> arrBulletDanBac;
	private ArrayList<OngGia> arrOngGia;
	private ArrayList<Boom> arrChoBoom;
	private ArrayList<Boom> arrBoomBossNem;
	private ArrayList<Boom> arrBoomBossTha;
	private ArrayList<Boom> arrBoomTaNem;
	private ArrayList<BossNemBom> arrBossNemBom;
	private ArrayList<BossBanSung> arrBossBanSung;
	private ArrayList<BossBanDanBac> arrBossBanDanBac;
	private Image[] dan;
	private ArrayList<VatCan> arrVatCan;
	private int timeBomRoi;
	private int timeRemove;
	
	private Image[] danTenLua={
			new ImageIcon(getClass().getResource("/image/br.gif")).getImage(),
			new ImageIcon(getClass().getResource("/image/bu.gif")).getImage(),
			new ImageIcon(getClass().getResource("/image/bl.gif")).getImage()
	};
	private Image[] danLaze={
			new ImageIcon(getClass().getResource("/image/bullet_laze_left.png")).getImage(),
			new ImageIcon(getClass().getResource("/image/bullet_laze_up.png")).getImage(),
			new ImageIcon(getClass().getResource("/image/bullet_laze_right.png")).getImage()
	};
	
	public GameManager() {
		
		arrVatCan=new ArrayList<>();
		arrVatCan.add(new VatCan(new ImageIcon(getClass().getResource("/image/go.gif")).getImage(),100,400));
		arrVatCan.add(new VatCan(new ImageIcon(getClass().getResource("/image/0006.png")).getImage(),300,400));
		arrVatCan.add(new VatCan(new ImageIcon(getClass().getResource("/image/baocat.png")).getImage(),700,400));
		arrVatCan.add(new VatCan(new ImageIcon(getClass().getResource("/image/toatau3.gif")).getImage(),750,400));
		arrVatCan.add(new VatCan(new ImageIcon(getClass().getResource("/image/thungbia.png")).getImage(),1500,400));
		arrVatCan.add(new VatCan(new ImageIcon(getClass().getResource("/image/toatau1.gif")).getImage(),1550,400));
		arrVatCan.add(new VatCan(new ImageIcon(getClass().getResource("/image/da.gif")).getImage(),3000,400));
		arrVatCan.add(new VatCan(new ImageIcon(getClass().getResource("/image/thungbia.png")).getImage(),3250,400));
		arrVatCan.add(new VatCan(new ImageIcon(getClass().getResource("/image/xetai2.gif")).getImage(),3500,400));
		arrVatCan.add(new VatCan(new ImageIcon(getClass().getResource("/image/car3.gif")).getImage(),4000,400));
		arrVatCan.add(new VatCan(new ImageIcon(getClass().getResource("/image/car8.gif")).getImage(),4500,400));
		arrVatCan.add(new VatCan(new ImageIcon(getClass().getResource("/image/xekeo.gif")).getImage(),4700,400));
		arrVatCan.add(new VatCan(new ImageIcon(getClass().getResource("/image/thungbia.png")).getImage(),5000,400));
		arrVatCan.add(new VatCan(new ImageIcon(getClass().getResource("/image/0003.png")).getImage(),5150,400));
		arrVatCan.add(new VatCan(new ImageIcon(getClass().getResource("/image/0005.png")).getImage(),5250,400));
		arrVatCan.add(new VatCan(new ImageIcon(getClass().getResource("/image/thung.png")).getImage(),6000,400));
		arrVatCan.add(new VatCan(new ImageIcon(getClass().getResource("/image/toatau2.gif")).getImage(),6050,400));
		arrVatCan.add(new VatCan(new ImageIcon(getClass().getResource("/image/toatau3.gif")).getImage(),6300,400));
		arrVatCan.add(new VatCan(new ImageIcon(getClass().getResource("/image/toatau2.gif")).getImage(),6550,400));
		arrVatCan.add(new VatCan(new ImageIcon(getClass().getResource("/image/toatau3.gif")).getImage(),6800,400));
		arrVatCan.add(new VatCan(new ImageIcon(getClass().getResource("/image/thungphi.png")).getImage(),7100,400));
		arrVatCan.add(new VatCan(new ImageIcon(getClass().getResource("/image/toatau2.gif")).getImage(),7150,400));
		arrVatCan.add(new VatCan(new ImageIcon(getClass().getResource("/image/toatau3.gif")).getImage(),7400,400));
		arrVatCan.add(new VatCan(new ImageIcon(getClass().getResource("/image/thung.png")).getImage(),7950,400));
		arrVatCan.add(new VatCan(new ImageIcon(getClass().getResource("/image/018.gif")).getImage(),7700,400));
		arrVatCan.add(new VatCan(new ImageIcon(getClass().getResource("/image/xetai.gif")).getImage(),8000,400));
		arrVatCan.add(new VatCan(new ImageIcon(getClass().getResource("/image/xekhach.gif")).getImage(),9000,100));
		arrBossBanSung=new ArrayList<>();
		arrBossBanSung.add(new BossBanSung(1500, 200));
		arrBossBanSung.add(new BossBanSung(2500, 200));
		arrBossBanSung.add(new BossBanSung(2200, 200));
		arrBossBanSung.add(new BossBanSung(2700, 200));
		arrBossBanSung.add(new BossBanSung(2900, 200));
		arrBossBanSung.add(new BossBanSung(2300, 200));
		arrBossBanSung.add(new BossBanSung(3500, 200));
		arrBossBanSung.add(new BossBanSung(4500, 200));
		arrBossBanSung.add(new BossBanSung(5500, 200));
		arrBossBanSung.add(new BossBanSung(6500, 200));
		arrBossBanSung.add(new BossBanSung(7500, 200));
		arrBossBanDanBac=new ArrayList<>();
		arrBossBanDanBac.add(new BossBanDanBac(2200, 200));
		arrBossBanDanBac.add(new BossBanDanBac(2300, 200));
		arrBossBanDanBac.add(new BossBanDanBac(2400, 200));
		arrBossBanDanBac.add(new BossBanDanBac(2600, 200));
		arrBossBanDanBac.add(new BossBanDanBac(2700, 200));
		arrBossBanDanBac.add(new BossBanDanBac(2800, 200));
		arrBossBanDanBac.add(new BossBanDanBac(3000, 200));
		arrBossBanDanBac.add(new BossBanDanBac(4000, 200));
		arrBossBanDanBac.add(new BossBanDanBac(5000, 200));
		arrBossBanDanBac.add(new BossBanDanBac(6000, 200));
		arrBossBanDanBac.add(new BossBanDanBac(7000, 200));
		arrBossBanDanBac.add(new BossBanDanBac(8000, 200));
		arrBulletDanBac=new ArrayList<>();
		arrBulletBoss=new ArrayList<>();
		arrChoBoom=new ArrayList<>();
		arrBullet=new ArrayList<>();
		hero=new Hero(350,20);
		mapGame=new MapGame(0,0);
		arrOngGia=new ArrayList<>();
		arrOngGia.add(new OngGia(900, 0));
		arrOngGia.add(new OngGia(5000, 0));
		arrOngGia.add(new OngGia(2500, 0));
		arrBoomBossTha=new ArrayList<>();
		arrBoomTaNem=new ArrayList<>();
		arrBossNemBom=new ArrayList<>();
		arrBossNemBom.add(new BossNemBom(900, 2));
		arrBossNemBom.add(new BossNemBom(1200, 2));
		arrBossNemBom.add(new BossNemBom(1400, 2));
		arrBossNemBom.add(new BossNemBom(1600, 2));
		arrBossNemBom.add(new BossNemBom(1800, 2));
		arrBossNemBom.add(new BossNemBom(1200, 2));
		arrBossNemBom.add(new BossNemBom(2200, 2));
		arrBossNemBom.add(new BossNemBom(3400, 2));
		arrBossNemBom.add(new BossNemBom(4500, 2));
		arrBossNemBom.add(new BossNemBom(5600, 2));
		arrBossNemBom.add(new BossNemBom(7600, 2));
		arrBoomBossNem=new ArrayList<>();
		setDan(danLaze);
		timeBomRoi=0;
		timeRemove=0;
		
		
	}
	
	public Image[] getDan() {
		return dan;
	}
	public void setDan(Image[] dan) {
		this.dan = dan;
	}

	public void setJump(boolean isJump) {
		hero.setJump(isJump);
	}
	public void setShot(boolean isShot) {
		hero.setShot(isShot);
	}
	public void setSit(boolean isSit) {
		hero.setSit(isSit);
	}
	public void setChuyenDong(boolean isChuyenDong) {
		hero.setChuyenDong(isChuyenDong);
	}
	public void setLeft(boolean isLeft) { 
		hero.setLeft(isLeft);
	}
	public void setStand(boolean isStand) {
		hero.setStand(isStand);
	}
	public void setLookUp(boolean isLookUp) {
		hero.setLookUp(isLookUp);
	}
	public void setThrow(boolean isThrow) {
		if (isThrow) {
			Boom boom=hero.nemBoom();
			arrBoomTaNem.add(boom);
		}
		hero.setThrow(isThrow);
	}
	public void draw(Graphics2D g) {
		timeRemove++;
			mapGame.draw(g);
			for (VatCan vatCan : arrVatCan) {
				vatCan.drawVatCan(g);
			}
			for (BossBanSung banSung : arrBossBanSung) {
				banSung.draw(g,arrVatCan);
			}
			for (Bullet bullet : arrBulletBoss) {
				bullet.draw(g);
			}
			for (int i = arrBoomTaNem.size()-1; i>=0; i--) {
				if (arrBoomTaNem.get(i).getRect().intersects(mapGame.getRect())) {
					arrBoomTaNem.get(i).drawBoomNo(g);
					if (timeRemove%500==0) { timeRemove=0;
					arrBoomTaNem.remove(i);
					}
				}else{
					arrBoomTaNem.get(i).drawBoom(g);
					
				}
				
			}
			for (int i=arrBoomBossTha.size()-1;i>=0;i--) {
				if (arrBoomBossTha.get(i).getRect().intersects(mapGame.getRect())) {
					arrBoomBossTha.get(i).drawBoomNo(g);
					if (timeRemove%500==0) { timeRemove=0;
						arrBoomBossTha.remove(i);
					}
				}else if(arrBoomBossTha.get(i).getRect().intersects(hero.getRect())){
					arrBoomBossTha.get(i).drawBoomNo(g);
					if (timeRemove%500==0) { timeRemove=0;
						arrBoomBossTha.remove(i);
					}
				}else{
					arrBoomBossTha.get(i).drawBoom(g);
				}
			}
			for (int i=arrBoomBossNem.size()-1;i>=0;i--) {
				if (arrBoomBossNem.get(i).getRect().intersects(hero.getRect())) {
					arrBoomBossNem.get(i).drawBoomNo(g);
					if (timeRemove%500==0) { timeRemove=0;
					arrBoomBossNem.remove(i);
				}
				}else if(arrBoomBossNem.get(i).getRect().intersects(mapGame.getRect())){
					arrBoomBossNem.get(i).drawBoomNo(g);
					if (timeRemove%500==0) { timeRemove=0;
					arrBoomBossNem.remove(i);
				}
				}else {
					arrBoomBossNem.get(i).drawBoom(g);
				}
			}
			for (int i=arrBossNemBom.size()-1;i>=0;i--) {
				arrBossNemBom.get(i).draw(g,arrVatCan);
			}
			for (int i = arrBullet.size()-1;i>=0; i--) {
				arrBullet.get(i).draw(g);
			}
			for (OngGia ongGia : arrOngGia) {
				ongGia.draw(g);
			}
			for (Boom boom : arrChoBoom) {
				boom.drawBoom(g);
			}
			for (BossBanDanBac bossBanDanBac : arrBossBanDanBac) {
				bossBanDanBac.draw(g,arrVatCan);
			}
			for (Bullet bullet : arrBulletDanBac) {
				bullet.draw(g);
			}
			hero.draw(g);
	}
	public void diChuyenTheoMap(int huong,int time) {
		for (VatCan vatCan : arrVatCan) {
			if (hero.getRectLeft().intersects(vatCan.getRect())&&huong==NhanVatGame.LEFT||hero.getRectRight().intersects(vatCan.getRect())&&huong==NhanVatGame.RIGHT) {
				return;
			}
		}
		hero.diChuyen(huong, time, hero.getRectDown().intersects(mapGame.getRect()),arrVatCan);
			if (!mapGame.diChuyen(huong, time)&&hero.isDie()==false) {
				for (OngGia ongGia : arrOngGia) {
					ongGia.diTheoMap(huong,time);
				}
				for (Boom boom : arrChoBoom) {
					boolean trongLuc=boom.getRect().intersects(mapGame.getRect());
					boom.trongLuc(huong,time, trongLuc,arrVatCan);
					boom.diChuyenTheoMap(huong, time);
				}
				for (Boom boom : arrBoomBossTha) {
					boom.diChuyenTheoMap(huong, time);
				}
				for (Boom boom : arrBoomTaNem) {
					boom.diChuyenTheoMap(huong, time);
				}
				for (BossNemBom bossNemBom : arrBossNemBom) {
					bossNemBom.diTheoMap(huong, time);
				}
				for (Boom boom : arrBoomBossNem) {
					boom.diChuyenTheoMap(huong, time);
				}
				for (VatCan vatCan1 : arrVatCan) {
					vatCan1.diTheoMap(huong, time);
				}
				for (BossBanSung bossBanSung : arrBossBanSung) {
					bossBanSung.diTheoMap(huong, time);
				}
				for (BossBanDanBac bossBanDanBac : arrBossBanDanBac) {
					bossBanDanBac.diTheoMap(huong, time);
				}
			}
	}
	public void trongLuc(int time) {
		for (VatCan vatCan : arrVatCan) {
			vatCan.trongLuc(NhanVatGame.DOWN,time, vatCan.getRect().intersects(mapGame.getRect()));
		}
		for (Boom boom : arrChoBoom) {
			boolean trongLuc=boom.getRect().intersects(mapGame.getRect());
			boom.trongLuc(NhanVatGame.DOWN,time, trongLuc,arrVatCan);
		}
		for (OngGia ongGia : arrOngGia) {
			ongGia.trongLuc(NhanVatGame.DOWN, time,ongGia.getRectOngGia().intersects(mapGame.getRect()),arrVatCan);
		}
		for (Boom boom : arrBoomBossTha) {
			boolean trongLuc=false;;
			if (boom.getRect().intersects(mapGame.getRect())) {
				trongLuc=true;
			}else if(boom.getRect().intersects(hero.getRect())){
				trongLuc=true;
			}
			boom.trongLuc(NhanVatGame.DOWN, time, trongLuc,arrVatCan);
		}
		for (BossNemBom bossNemBom : arrBossNemBom) {
			bossNemBom.trongLuc(NhanVatGame.DOWN, time, bossNemBom.getRect().intersects(mapGame.getRect()),arrVatCan);
		}
		for (Boom boom : arrBoomBossNem) {
			boolean trongLuc=false;
			if (boom.getRect().intersects(mapGame.getRect())) {
				trongLuc=true;
			}else if(boom.getRect().intersects(hero.getRect())){
				trongLuc=true;
			}
			boom.nem(time, trongLuc);
		}
		for (BossBanSung bossBanSung : arrBossBanSung) {
			bossBanSung.trongLuc(NhanVatGame.DOWN, time, bossBanSung.getRect().intersects(mapGame.getRect()),arrVatCan);
		}
		for (BossBanDanBac bossBanDanBac : arrBossBanDanBac) {
			bossBanDanBac.trongLuc(NhanVatGame.DOWN, time, bossBanDanBac.getRect().intersects(mapGame.getRect()),arrVatCan);
		}
	}
	public void diChuyen(int time) {
		mapGame.fly(time);
	}
	public void checkAllBulletBoss() {
		for (BossBanSung bossBanSung : arrBossBanSung) {
			if(bossBanSung.checkVaCham(hero.getRect())&&bossBanSung.getDie()==false){
				arrBulletBoss.add(bossBanSung.banSung());
			}
		}
		for (int i = arrBulletBoss.size()-1; i>=0; i--) {
			for (VatCan vatCan : arrVatCan) {
				if (arrBulletBoss.get(i).getRect().intersects(vatCan.getRect())) {
					arrBulletBoss.remove(i);
				}
			}
			if (arrBulletBoss.get(i).moveBullet(MyFrame.NGANG,MyFrame.DOC)==false) {
				arrBulletBoss.remove(i);
			}
		}
		for (BossBanDanBac bossBanDanBac : arrBossBanDanBac) {
			if (bossBanDanBac.checkVaCham(hero.getRect())&&bossBanDanBac.getDie()==false) {
				arrBulletDanBac.add(bossBanDanBac.banSung());
			}
		}
		for (int i = arrBulletDanBac.size()-1; i>=0; i--) {
			for (VatCan vatCan : arrVatCan) {
				if (arrBulletDanBac.get(i).getRect().intersects(vatCan.getRect())) {
					arrBulletDanBac.remove(i);
				}
			}
			if (arrBulletDanBac.get(i).moveBullet(MyFrame.NGANG,MyFrame.DOC)==false) {
				arrBulletDanBac.remove(i);
			}
		}
		
	}
	public void moveAllBulletTa() {
		for (int i = arrBullet.size()-1; i>=0; i--) {
			if (arrBullet.get(i).moveBullet(MyFrame.NGANG,MyFrame.DOC)==false) {
				arrBullet.remove(i);
			}
			for (VatCan vatCan : arrVatCan) {
				if (arrBullet.get(i).getRect().intersects(vatCan.getRect())) {
					arrBullet.remove(i);
				}
			}
			for (OngGia ongGia : arrOngGia) {
				if (ongGia.getRectOngGia().intersects(arrBullet.get(i).getRect())) {
					ongGia.setThoat(true);
				}
			}
			for (BossNemBom bossNemBom : arrBossNemBom) {
				if (bossNemBom.checkTrungDan(arrBullet.get(i).getRect())) {
					arrBullet.remove(i);
				}
			}
			for (BossBanSung bossBanSung : arrBossBanSung) {
				if (bossBanSung.checkTrungDan(arrBullet.get(i).getRect())) {
					arrBullet.remove(i);
				}
			}
			for (BossBanDanBac bossBanDanBac : arrBossBanDanBac) {
				if (bossBanDanBac.checkTrungDan(arrBullet.get(i).getRect())) {
					arrBullet.remove(i);
				}
			}
			if (arrBullet.get(i).getRect().intersects(mapGame.getDiaBay().getRectBossFlyVaCham())) {
				mapGame.getDiaBay().checkTrungDan(arrBullet.get(i).getRect());
				arrBullet.remove(i);
			}
		}
	}
	public void moveAllLuuDan(int time) {
		for (Boom boom : arrBoomTaNem) {
			boom.nem(time, boom.getRect().intersects(mapGame.getRect()));
			for (OngGia ongGia : arrOngGia) {
				if (ongGia.getRectOngGia().intersects(boom.getRect())) {
					ongGia.setThoat(true);
				}
			}
			for (BossNemBom bossNemBom : arrBossNemBom) {
				bossNemBom.checkTrungDan(boom.getRect());
			}
			for (BossBanSung bossBanSung : arrBossBanSung) {
				bossBanSung.checkTrungDan(boom.getRect());
			}
			for (BossBanDanBac bossBanDanBac : arrBossBanDanBac) {
				bossBanDanBac.checkTrungDan(boom.getRect());
			}
		}
		for (BossNemBom bossNemBom : arrBossNemBom) {
			if (bossNemBom.checkVaCham(hero.getRect())&&bossNemBom.getDie()==false) {
				Boom boom=bossNemBom.nemBoom();
				arrBoomBossNem.add(boom);
			}
		}
	}
	public boolean checkLose() {
		for (Bullet bullet : arrBulletDanBac) {
			if (bullet.getRect().intersects(hero.getRectLeft())) {
				hero.setDie(true);
				return true;
			}
		}
		for (int i = arrBulletBoss.size()-1; i>=0; i--) {
			if (arrBulletBoss.get(i).getRect().intersects(hero.getRectLeft())) {
				hero.setDie(true);
				return true;
			}
		}
		for (Boom boom : arrBoomBossTha) {
			if(boom.getRectBoomNo().intersects(hero.getRectLeft())){
				hero.setDie(true);
				return true;
			}
		}
		for (Boom boom : arrBoomBossNem) {
			if (boom.getRectBoomNo().intersects(hero.getRectLeft())) {
				hero.setDie(true);
				return true;
			}
		}
		return false;
	}
	public boolean checkComplete() {
		return mapGame.getDiaBay().getRectBossFlyVaCham().intersects(mapGame.getRect());
	}
	public void checkVaCham() {
		timeBomRoi++;
		
		if (mapGame.getDiaBay().checkVaCham(hero.getRectDown())) {
			if (timeBomRoi<2000) {
				arrBossBanDanBac.add(mapGame.getDiaBay().bossBanDanBac());
			}else if(timeBomRoi>2000&&timeBomRoi<4000){
				arrBoomBossTha.add(mapGame.getDiaBay().thaBoom());
			}
			else if(timeBomRoi>4000&&timeBomRoi<6000){
				arrBossNemBom.add(mapGame.getDiaBay().bossNemBom());
			}else if(timeBomRoi>6000){
				timeBomRoi=new Random().nextInt(6000)+1;
			}
			
		}
		for (OngGia ongGia : arrOngGia) {
			if (ongGia.isCho()) {
				arrChoBoom.add(ongGia.choBoom());
			}
		}
		
		for (OngGia ongGia : arrOngGia) {
			if (ongGia.getRectOngGia().intersects(mapGame.getRectRemoveOngGia())) {
				arrOngGia.remove(ongGia);
			}
		}
		for (Boom boom : arrChoBoom) {
			if (boom.getRect().intersects(hero.getRectDown())) {
				setDan(danTenLua);
				arrChoBoom.remove(boom);
			}
		}
	}
	public void orientBullet(int orient) {
		hero.setOrient(orient);
	}
	public void heroShot() {
		Bullet bullet=hero.fire(getDan());
		arrBullet.add(bullet);
	}
	public void heroThrow() {
		for (OngGia ongGia : arrOngGia) {
			Boom boom=ongGia.choBoom();
			arrChoBoom.add(boom);
		}
	}
}
