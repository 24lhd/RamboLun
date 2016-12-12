package com.t3h.gui;

import javax.swing.JFrame;

public class MyFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	public static final int NGANG=900;
	public static final int DOC=620;
	public MyFrame() {
		setTitle("RamBo");
		setSize(NGANG, DOC);
		setLocationRelativeTo(null);
		add(new MainPanel());
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
