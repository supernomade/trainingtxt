package com.lazy.textural;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

public class TexturalBehavior {

	@Test
	public void printsBlackTexture() throws IOException {
		Textural textural = new Textural("black");
		textural.print(100, 100);
		BufferedImage texture = ImageIO.read(new File("black.png"));
		assertEquals(Color.BLACK.getRGB(), texture.getRGB(0, 0));
		assertEquals(Color.BLACK.getRGB(), texture.getRGB(99, 0));
		assertEquals(Color.BLACK.getRGB(), texture.getRGB(0, 99));
		assertEquals(Color.BLACK.getRGB(), texture.getRGB(99, 99));
	}

	@Test
	public void printsREDTexture() throws IOException {
		Textural textural = new Textural("red", Color.RED);
		textural.print(100, 100);
		BufferedImage texture = ImageIO.read(new File("red.png"));
		assertEquals(Color.RED.getRGB(), texture.getRGB(0, 0));
		assertEquals(Color.RED.getRGB(), texture.getRGB(99, 0));
		assertEquals(Color.RED.getRGB(), texture.getRGB(0, 99));
		assertEquals(Color.RED.getRGB(), texture.getRGB(99, 99));
	}

	@Test(expected = IllegalArgumentException.class)
	public void printsInvalideTexture() throws IOException {
		Textural textural = new Textural("black");
		textural.print(100, -100);
	}

	@Test(expected = IllegalArgumentException.class)
	public void invalideTextureName() throws IOException {
		new Textural("");
	}

}
