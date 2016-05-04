package com.mine.mist;

import java.util.Random;

import com.mine.mist.graphics.Sprite;
import com.mine.mist.graphics.Spritesheet;
import com.mine.mist.level.tile.Tile;

public class Screen {
	private Spritesheet sheet;
	public int width, height;
	private final int MAP_SIZE = 64;
	private final int MAP_SIZE_MASK = MAP_SIZE - 1;
	public int[] pixels;
	public int xOffs, yOffs;
	private int[] tiles = new int[MAP_SIZE * MAP_SIZE];

	private Random random = new Random();

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];

		for (int i = 0; i < MAP_SIZE * MAP_SIZE; i++) {
			tiles[i] = random.nextInt(0xFFFFFF);
		}
	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	public void renderTile(int xp, int yp, Tile tile) {
		xp -= xOffs;
		yp -= yOffs;

		for (int y = 0; y < tile.sprite.HEIGHT; y++) {
			int ya = y + yp;
			for (int x = 0; x < tile.sprite.WIDTH; x++) {
				int xa = x + xp;
				if (ya < 0 - tile.sprite.HEIGHT || ya >= height || xa < 0 - tile.sprite.WIDTH || xa >= width)
					break;
				if (ya < 0)
					ya = 0;
				if (xa < 0)
					xa = 0;
				pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.WIDTH];

			}

		}
	}
	
	public void renderPlayer(int xp, int yp, Sprite sprite ) {
		xp -= xOffs;
		yp -= yOffs;

		for (int y = 0; y < sprite.HEIGHT; y++) {
			int ya = y + yp;
			for (int x = 0; x < sprite.WIDTH; x++) {
				int xa = x + xp;
				if (ya < 0 - sprite.HEIGHT || ya >= height || xa < 0 - sprite.WIDTH || xa >= width)
					break;
				if (ya < 0)
					ya = 0;
				if (xa < 0)
					xa = 0;
				int col = sprite.pixels[x + y * sprite.WIDTH];
				if(col != 0xFF7BD5FE) pixels[xa + ya * width] = col;
			}

		}
	}

	public void setOffset(int xoffs, int yoffs) {
		this.xOffs = xoffs;
		this.yOffs = yoffs;
	}
}
