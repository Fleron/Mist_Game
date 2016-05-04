package com.mine.mist.graphics;

import java.awt.Color;

public class Sprite {
	public final int SIZE, WIDTH, HEIGHT;
	private int x, y;
	public int[] pixels;
	private Spritesheet sheet;
	
	public static Sprite grass = new Sprite(16,16, 5, 0, Spritesheet.tiles);
	public static Sprite grass2 = new Sprite(16,16, 5, 1, Spritesheet.tiles);
	public static Sprite water = new Sprite(16,16, 0, 0, Spritesheet.tiles);
	public static Sprite water2 = new Sprite(16,16, 1, 0, Spritesheet.tiles);
	public static Sprite brick = new Sprite(16,16, 5, 2, Spritesheet.tiles);
	public static Sprite bush = new Sprite(16,16, 14, 9, Spritesheet.tilesTransparent);
	public static Sprite forest1 = new Sprite(16,16, 13, 10, Spritesheet.tilesTransparent);
	public static Sprite forest2 = new Sprite(16,16, 13, 11, Spritesheet.tilesTransparent);
	
	public static Sprite playerRight_still = new Sprite(16,18,1,1, Spritesheet.character);
	public static Sprite playerRight_1 = new Sprite(16,18,0,1, Spritesheet.character);
	public static Sprite playerRight_2 = new Sprite(16,18,2,1, Spritesheet.character);
	public static Sprite playerUp_still = new Sprite(16,18,1,0, Spritesheet.character);
	public static Sprite playerUp_1 = new Sprite(16,18,0,0, Spritesheet.character);
	public static Sprite playerUp_2 = new Sprite(16,18,2,0, Spritesheet.character);
	public static Sprite playerDown_still = new Sprite(16,18,1,2, Spritesheet.character);
	public static Sprite playerDown_1 = new Sprite(16,18,0,2, Spritesheet.character);
	public static Sprite playerDown_2 = new Sprite(16,18,2,2, Spritesheet.character);
	public static Sprite playerLeft_still = new Sprite(16,18,1,3, Spritesheet.character);
	public static Sprite playerLeft_1 = new Sprite(16,18,0,3, Spritesheet.character);
	public static Sprite playerLeft_2 = new Sprite(16,18,2,3, Spritesheet.character);

	public static Sprite voidsprite = new Sprite(16,16, 0xFFFFFF);


	public Sprite(int width,int height, int x, int y, Spritesheet sheet) {
		WIDTH = width;
		HEIGHT = height;
		SIZE = width*height;
		pixels = new int[SIZE];
		this.x = x * width +x;
		this.y = y * height +y;
		this.sheet = sheet;
		load();
	}
	public Sprite (int width,int height, int color){
		WIDTH = width;
		HEIGHT = height; 
		SIZE = width*height;
		pixels = new int[SIZE];
		setColor(color);
	}

	private void setColor(int color) {
		for( int i = 0; i < WIDTH*HEIGHT; i++){
			pixels[i] = color;
		}
		
	}
	private void load() {
		for (int y = 0; y < HEIGHT; y++) {
			for (int x = 0; x < WIDTH; x++) {
				pixels[x + y * WIDTH] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.WIDTH];
			}
		}
	}
}
