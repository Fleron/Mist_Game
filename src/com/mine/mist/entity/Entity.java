package com.mine.mist.entity;

import java.util.Random;
import com.mine.mist.Screen;
import com.mine.mist.level.Level;

public abstract class Entity {
	public int x,y;
	private boolean removed = false;
	private Level level;
	protected final Random random = new Random();


	public void update(){
		
	}
	
	public void render(Screen screen){
		
	}
	
	public void remove(){
		removed = true;
	}
	
	public boolean isRemoved(){
		return removed;
	}
}
