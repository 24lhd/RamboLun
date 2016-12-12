package com.t3h.gui;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class HowToPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btTiep;
	private ImageIcon imageIcon=new ImageIcon(getClass().getResource("/image/bt8.png"));
	public HowToPanel() {
		setLayout(null);
		btTiep=new JButton(imageIcon);
		btTiep.setBounds(MyFrame.NGANG-imageIcon.getIconWidth()-10,MyFrame.DOC-imageIcon.getIconHeight()-30, imageIcon.getIconWidth(),imageIcon.getIconHeight());
		add(btTiep);
	}
	
	public JButton getBtTiep() {
		return btTiep;
	}

	@Override
	protected void paintComponent(Graphics g2) {
		super.paintComponent(g2);
		Graphics2D g=(Graphics2D) g2;
		g.drawImage(new ImageIcon(getClass().getResource("/image/xxx.jpg")).getImage(), 0, 0,MyFrame.NGANG,MyFrame.DOC,null);
		g.drawImage(new ImageIcon(getClass().getResource("/image/hd.png")).getImage(), MyFrame.NGANG/2-new ImageIcon(getClass().getResource("/image/hd.png")).getImage().getWidth(null)/2,  MyFrame.DOC/2-new ImageIcon(getClass().getResource("/image/hd.png")).getImage().getHeight(null)/2,null);
	}
}
