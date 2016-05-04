package com.mine.mist.entity.mob;

import com.mine.mist.Keyboard;
import com.mine.mist.Screen;
import com.mine.mist.graphics.Sprite;

public class Player extends Mob {
	private Keyboard input;
	private Sprite sprite;
	private int anim;
	private boolean walking;

	public Player(Keyboard input) {
		this.input = input;
		sprite = Sprite.playerRight_still;
	}

	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
	}

	public void render(Screen screen) {
		if(dir == 0){
			sprite = sprite.playerUp_still;
			if(walking){
				if(anim%20 > 10) sprite = sprite.playerUp_1;
				else sprite = sprite.playerUp_2;
			}	
		}
		if(dir == 1){
			sprite = sprite.playerRight_still;
			if(walking){
				if(anim%20 > 10) sprite = sprite.playerRight_1;
				else sprite = sprite.playerRight_2;
			}
		}
		if(dir == 2){
			sprite = sprite.playerDown_still;
			if(walking){
				if(anim%20 > 10) sprite = sprite.playerDown_1;
				else sprite = sprite.playerDown_2;
			}
		}
		if(dir == 3){
			sprite = sprite.playerLeft_still;
			if(walking){
				if(anim%20 > 10) sprite = sprite.playerLeft_1;
				else sprite = sprite.playerLeft_2;
			}
		}
		
		screen.renderPlayer(x, y, sprite);
	}

	public void update() {
		int xa = 0, ya = 0;
		if (anim < 7000)
			anim++;
		else
			anim = 0;
		if (input.up)
			ya--;
		if (input.down)
			ya++;
		if (input.right)
			xa++;
		if (input.left)
			xa--;
		if (xa != 0 || ya != 0){
			move(xa, ya);
			walking = true;
		}
		else walking = false;
			

	}

}
