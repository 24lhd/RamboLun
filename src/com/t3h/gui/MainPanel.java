package com.t3h.gui;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class MainPanel extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CardLayout cardLayout;
	public static final String KEY_PLAY = "key play";
	public static final String KEY_HOWTO = "key howto";
	public static final String KEY_LOSE = "key lose";
	public static final String KEY_COMPLETE = "key complete";
	public static final String KEY_START = "key start";
	private StartPanel startPanel;
	private HowToPanel howToPanel;
	private MyPanel myPanel;
	private AudioClip ms_BG;
	private AudioClip ms_BG1;
	public MainPanel() {
		ms_BG=Applet.newAudioClip(getClass().getResource("/sound/menu.mid"));
		ms_BG1=Applet.newAudioClip(getClass().getResource("/sound/level5.mid"));
		ms_BG.loop();
		ms_BG.play();
		cardLayout=new CardLayout();
		setLayout(cardLayout);
		myPanel=new MyPanel();
		startPanel=new StartPanel();
		howToPanel=new HowToPanel();
		add(startPanel,KEY_START);
		add(howToPanel,KEY_HOWTO);
		add(myPanel, KEY_PLAY);
		cardLayout.show(this, KEY_START);
		startPanel.getBtStart().addActionListener(this);
		howToPanel.getBtTiep().addActionListener(this);
		addKeyListener(null);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(startPanel.getBtStart())) {
			ms_BG.stop();
			ms_BG1.loop();
			ms_BG1.play();
			cardLayout.show(this, KEY_HOWTO);
		}
		if (e.getSource().equals(howToPanel.getBtTiep())) {
			cardLayout.show(this, KEY_PLAY);
		}
	}

}
