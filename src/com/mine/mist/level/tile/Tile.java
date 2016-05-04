package com.mine.mist.level.tile;

import com.mine.mist.Screen;
import com.mine.mist.graphics.Sprite;

public class Tile {
	public int x,y;
	public Sprite sprite;
	
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile grass2 = new GrassTile(Sprite.grass2);
	public static Tile voidTile = new VoidTile(Sprite.voidsprite);
	public static Tile water = new WaterTile(Sprite.water);
	public static Tile forestTop = new ForestTile(Sprite.forest1);
	public static Tile forestBottom = new ForestTile(Sprite.forest2);
	
	
	public Tile(Sprite sprite){
		this.sprite = sprite;
	}
	public void render(int x, int y, Screen screen){
		
	}
	public boolean solid(){
		return false;
	}

}
