package com.t3h.gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class StartPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Image imageBG= new ImageIcon(getClass().getResource("/image/bg_panel.jpg")).getImage();
	private Image imLogo= new ImageIcon(getClass().getResource("/image/logo.gif")).getImage();
	private ImageIcon imStart= new ImageIcon(getClass().getResource("/image/bt1.png"));
	private JButton btStart;
	
	public StartPanel() {
		setLayout(null);
		btStart=new JButton();
		btStart.setIcon(imStart);
		btStart.setBounds(95, 300, imStart.getIconWidth(),imStart.getIconHeight());
		btStart.setBorderPainted(false);
		add(btStart);
	}
	public JButton getBtStart() {
		return btStart;
	}
	@Override
	public void paintComponent(Graphics g2) {
		super.paintComponent(g2);
		Graphics2D g=(Graphics2D) g2;
		g.drawImage(imageBG, 0, 0,MyFrame.NGANG,MyFrame.DOC,null);
		g.drawImage(imLogo, 120, 30,null);
		
	}
}
