package com.t3h.gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class LosePanel extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btTiepTuc;
	private JButton btThoat;
	private ImageIcon imageTiepTuc=new ImageIcon(getClass().getResource("/image/bt4.png"));
	private ImageIcon imageThoat=new ImageIcon(getClass().getResource("/image/bt2.png"));
	public LosePanel() {
		setLayout(null);
		btTiepTuc=new JButton(imageTiepTuc);
		btTiepTuc.setBounds(MyFrame.NGANG/2-imageTiepTuc.getIconWidth()/2,MyFrame.DOC/2+50-imageTiepTuc.getIconHeight(), imageTiepTuc.getIconWidth(),imageTiepTuc.getIconHeight());
		btTiepTuc.setBorderPainted(false);
		add(btTiepTuc);
		btThoat=new JButton(imageThoat);
		btThoat.setBounds(MyFrame.NGANG/2-imageThoat.getIconWidth()/2,btTiepTuc.getY()+20+btTiepTuc.getHeight(), imageThoat.getIconWidth(),imageThoat.getIconHeight());
		btThoat.setBorderPainted(false);
		add(btThoat);
		
	}
	public JButton getBtTiepTuc() {
		return btTiepTuc;
	}
	public JButton getBtThoat() {
		return btThoat;
	}
	@Override
	protected void paintComponent(Graphics g2) {
		super.paintComponent(g2);
		Graphics2D g=(Graphics2D) g2;
		
		g.drawImage(new ImageIcon(getClass().getResource("/image/xxx.jpg")).getImage(), 0, 0,MyFrame.NGANG,MyFrame.DOC,null);
		g.drawImage(new ImageIcon(getClass().getResource("/image/lose.png")).getImage(), MyFrame.NGANG/2-new ImageIcon(getClass().getResource("/image/lose.png")).getImage().getWidth(null)/2,  MyFrame.DOC/2-new ImageIcon(getClass().getResource("/image/lose.png")).getImage().getHeight(null)/2-150,null);
		g.drawImage(new ImageIcon(getClass().getResource("/image/end.gif")).getImage(),MyFrame.NGANG/3+100,MyFrame.DOC-new ImageIcon(getClass().getResource("/image/end.gif")).getImage().getHeight(null)-50,null);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
}
