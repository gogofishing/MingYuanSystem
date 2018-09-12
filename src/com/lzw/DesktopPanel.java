package com.lzw;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

public class DesktopPanel extends JDesktopPane {
	private final Image backImage;
	
	public DesktopPanel() {
		super();
		URL url = DesktopPanel.class.getResource("/res/back.jpg");
		backImage = new ImageIcon(url).getImage();
	}

	protected void paintComponent(Graphics g) {
		int width = getWidth();
		int height = this.getHeight();
		g.drawImage(backImage, 0, 0, width, height, this);
	}
}

