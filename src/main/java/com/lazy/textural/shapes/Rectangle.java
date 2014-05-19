package com.lazy.textural.shapes;

import java.awt.Color;
import java.awt.image.BufferedImage;

import com.lazy.textural.outils.Drawable;

public class Rectangle implements Drawable {

	private final int x;
	private final int y;
	private final int width;
	private final int height;
	private final Color color;

	public Rectangle(int x, int y, int width, int height, Color color) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
	}

	public void draw(BufferedImage imageTextural) {
		for (int i = x; i < (x+width); i++) {
			for (int j = y; j < (y+height); j++) {
				imageTextural.setRGB(i, j, color.getRGB());
			}
		}
	}

}
