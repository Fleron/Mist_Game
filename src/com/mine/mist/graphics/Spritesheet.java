package com.mine.mist.graphics;

import java.awt.image.BufferedImage;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Spritesheet {
	public final int SIZE;
	public final int WIDTH;
	private String path;
	public int[] pixels;
	public static Spritesheet tiles = new Spritesheet("/textures/spritesheet.png",968,526);
	public static Spritesheet tilesTransparent = new Spritesheet("/textures/roguelikeSheet_transparent.png",968,526); 
	public static Spritesheet character = new Spritesheet("/textures/charset.png",50,75); 
	
	public Spritesheet(String path, int width, int height){
		this.path = path;
		WIDTH = width;
		SIZE = width*height;
		this.pixels = new int[SIZE];
		load();
	}
	public void load(){
		try {
			BufferedImage image = ImageIO.read(Spritesheet.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
