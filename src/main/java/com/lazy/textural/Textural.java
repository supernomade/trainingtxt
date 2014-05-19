package com.lazy.textural;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.lazy.textural.outils.Drawable;
import com.lazy.textural.shapes.Rectangle;

public class Textural {

	private final File file;
	private final String FORMAT_TEXTURAL = "png";
	private final Color color;

	public Textural(String fileName) {
		this(fileName,Color.BLACK /*DEFFULT is BLACK*/);
	}

	public Textural(String fileName, Color color) {
		checkFileName(fileName);
		file = createFile(fileName);
		this.color = color;
	}

	private File createFile(String name) {
		return new File(name + "." + FORMAT_TEXTURAL);
	}

	public void print(final int width, final int height) throws IOException {
		checkIsPositiveValue(width, height);
		BufferedImage imageDrawn = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Drawable textural = new Rectangle(0, 0, width, height, color);
		textural.draw(imageDrawn);
		ImageIO.write(imageDrawn, FORMAT_TEXTURAL, file);

	}

	private void checkIsPositiveValue(Integer... values) {
		for (Integer value : values) {
			if (value < 0) {
				throw new IllegalArgumentException("This value : " + value + " is not autorized");
			}
		}
	}

	private void checkFileName(String fileName) {
		if (fileName==null ||  fileName.isEmpty()) {
			throw new IllegalArgumentException("This value : " + fileName + " is not autorized");
		}
	}
}
