package com.lazy.textural;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

import com.lazy.textural.shapes.Rectangle;

public class TexturalDrowRectangleBehavior {

	@Test
	public void drawRectangleInTexture() throws IOException {
		Textural textural = new Textural("textureWithRectangleShape");
		textural.print(100, 50);

		File filetextural = new File("textureWithRectangleShape.png");
		BufferedImage texture = ImageIO.read(filetextural);
		Rectangle rectangle = new Rectangle(0, 0, 50, 25, Color.BLUE);
		rectangle.draw(texture);
		Rectangle rectangle1 = new Rectangle(50,25, 50, 25, Color.BLUE);
		rectangle1.draw(texture);
		ImageIO.write(texture, "png", filetextural);
		assertEquals(Color.BLUE.getRGB(), texture.getRGB(0, 0));
		assertEquals(Color.BLUE.getRGB(), texture.getRGB(49, 0));
		assertEquals(Color.BLUE.getRGB(), texture.getRGB(0, 24));
		assertEquals(Color.BLUE.getRGB(), texture.getRGB(49, 24));
		assertEquals(Color.BLUE.getRGB(), texture.getRGB(50, 25));
		assertEquals(Color.BLUE.getRGB(), texture.getRGB(99, 25));
		assertEquals(Color.BLUE.getRGB(), texture.getRGB(50, 49));
		assertEquals(Color.BLUE.getRGB(), texture.getRGB(99, 49));
	}
}
