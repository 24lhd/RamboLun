package com.t3h.gui;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.BitSet;

import javax.swing.JPanel;

import com.t3h.game.GameManager;
import com.t3h.game.NhanVatGame;

public class MyPanel extends JPanel implements Runnable,KeyListener,ActionListener{
	/**
	 * 
	 */
	private CardLayout cardLayout;
	private static final long serialVersionUID = 1L;
	private GameManager gameManager;
	private BitSet bitSet;
	private  boolean isRunning=true;
	private CompletePanel completePanel;
	private LosePanel losePanel;
	private AudioClip heroShot;
	public MyPanel() {
		heroShot=Applet.newAudioClip(getClass().getResource("/sound/boombossno.wav"));
		cardLayout=new CardLayout();
		setLayout(cardLayout);
		completePanel=new CompletePanel();
		losePanel=new LosePanel();
		addComponentListener(new ComponentListener() {
			@Override
			public void componentShown(ComponentEvent e) {
				MyPanel.this.requestFocusInWindow();
			}
			@Override
			public void componentResized(ComponentEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void componentHidden(ComponentEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
		
		completePanel.getBtHoanThanh().addActionListener(this);
		losePanel.getBtTiepTuc().addActionListener(this);
		losePanel.getBtThoat().addActionListener(this);
		addKeyListener(null);
		initGame();
		
	}
	public void initGame() {
		bitSet=new BitSet(256);
		setBackground(Color.cyan);
		gameManager=new GameManager();
		Thread thread=new Thread(this);
		thread.start();
		setFocusable(true);
		addKeyListener(this);
	}
	@Override
	protected void paintComponent(Graphics e) {
		super.paintComponent(e);
		Graphics2D g=(Graphics2D) e;
		gameManager.draw(g);
	}
	@Override
	public void keyPressed(KeyEvent e) {
		bitSet.set(e.getKeyCode());
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if (bitSet.get(KeyEvent.VK_W)){
			gameManager.setLeft(false);
			gameManager.orientBullet(NhanVatGame.RIGHT);
			gameManager.setLookUp(false);
		}if (bitSet.get(KeyEvent.VK_S)) {
			gameManager.setSit(false);
		}if (bitSet.get(KeyEvent.VK_A)) {
			gameManager.setChuyenDong(false);
		}if (bitSet.get(KeyEvent.VK_D)) {
			gameManager.setChuyenDong(false);
		}if (bitSet.get(KeyEvent.VK_K)) {
			gameManager.setJump(false);
		}if (bitSet.get(KeyEvent.VK_L)) {
			gameManager.setThrow(false);
		}if (bitSet.get(KeyEvent.VK_J)) {
			heroShot.stop();
			gameManager.setShot(false);
		}
		bitSet.clear(e.getKeyCode());
	}
	@Override
	public void keyTyped(KeyEvent e) {

	}
	@Override
	public void run() {
		int timeMove=199;
		int timeJump=0;
		int time=0;
		int timeNem=199;
		while (isRunning) {
			timeMove++;
			timeJump++;
			time++;
			timeNem++;
			try {
				
				if (gameManager.checkComplete()) {
					if (time%2000==0) {
						add(completePanel, MainPanel.KEY_COMPLETE);
						cardLayout.show(this,MainPanel.KEY_COMPLETE);
					}
						
				}
				if (gameManager.checkLose()) {
						add(losePanel, MainPanel.KEY_LOSE);
						cardLayout.show(this,MainPanel.KEY_LOSE);
				}
				if (bitSet.get(KeyEvent.VK_W)){
					gameManager.orientBullet(NhanVatGame.UP);
					gameManager.setLookUp(true);
				}if (bitSet.get(KeyEvent.VK_S)) {
					gameManager.setSit(true);
				}if (bitSet.get(KeyEvent.VK_A)) {
					gameManager.orientBullet(NhanVatGame.LEFT);
					gameManager.setLeft(true);
					gameManager.setChuyenDong(true);
					gameManager.diChuyenTheoMap(NhanVatGame.LEFT,timeMove);
				}if (bitSet.get(KeyEvent.VK_D)) {
					gameManager.orientBullet(NhanVatGame.RIGHT);
					gameManager.setLeft(false);
					gameManager.setChuyenDong(true);
					gameManager.diChuyenTheoMap(NhanVatGame.RIGHT,timeMove);
				}if (bitSet.get(KeyEvent.VK_K)) {
					gameManager.setJump(true);
					if (timeJump<250) {
						gameManager.diChuyenTheoMap(NhanVatGame.UP,timeJump);
					}else if(timeJump>400){
						gameManager.diChuyenTheoMap(NhanVatGame.DOWN,timeJump);
					}if (timeJump>800) {
						timeJump=0;
					}
				}
				else{
					gameManager.diChuyenTheoMap(NhanVatGame.DOWN,timeMove);
					if (bitSet.get(KeyEvent.VK_L)) {
						if (timeNem==150) {
							gameManager.setThrow(true);
						}if (timeNem>300) {
							timeNem=100;
						}
							
					}else if (bitSet.get(KeyEvent.VK_J)) {
						if (bitSet.get(KeyEvent.VK_W)&&bitSet.get(KeyEvent.VK_D)||bitSet.get(KeyEvent.VK_W)&&bitSet.get(KeyEvent.VK_A)) {
							gameManager.orientBullet(NhanVatGame.UP);
						}if (timeMove%200==0) {
							heroShot.play();
							gameManager.setShot(true);
							gameManager.heroShot();
						}
					}
				}
				gameManager.trongLuc(time);
				gameManager.moveAllBulletTa();
				gameManager.moveAllLuuDan(time);
				gameManager.diChuyen(time);
				gameManager.checkAllBulletBoss();
				gameManager.diChuyen(time);
				gameManager.checkVaCham();
				Thread.sleep(1);
			} catch (Exception e) {
				
			}
			repaint();	
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(completePanel.getBtHoanThanh())) {
			System.exit(0);
		}
		if (e.getSource().equals(losePanel.getBtThoat())) {
			System.exit(0);
		}
		if (e.getSource().equals(losePanel.getBtTiepTuc())) {
			cardLayout.show(getParent(),MainPanel.KEY_PLAY);
		}
	}
}
