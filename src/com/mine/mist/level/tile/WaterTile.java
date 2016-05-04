package com.mine.mist.level.tile;

import com.mine.mist.Screen;
import com.mine.mist.graphics.Sprite;

public class WaterTile extends Tile{

	public WaterTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen){
		screen.renderTile(x<<4, y<<4, this);
	}
	public boolean solid(){
		return true;
	}

}
