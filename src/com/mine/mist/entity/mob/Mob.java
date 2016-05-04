package com.mine.mist.entity.mob;

import com.mine.mist.entity.Entity;
import com.mine.mist.graphics.Sprite;

public class Mob extends Entity {

	protected int dir;
	protected Sprite sprite;
	public boolean moving = false;

	public void update() {

	}

	public void move(int xa, int ya) {
		if (ya < 0)
			dir = 0;
		if (xa > 0){
			dir = 1;
			if(ya < 0) dir = 0;
			
		}
		if (ya > 0){
			dir = 2;
		}
		if (xa < 0)
			dir = 3;

		if (!collision()) {
			x += xa;
			y += ya;
		}

	}

	public void render() {

	}

	private boolean collision() {
		return false;
	}
}
