package com.mine.mist;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

	public boolean[] key = new boolean[120];
	public boolean up, down, left, right;

	public void update (){
		up = key[KeyEvent.VK_W];
		down = key[KeyEvent.VK_S];
		left = key[KeyEvent.VK_A];
		right = key[KeyEvent.VK_D];
		
	}

	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode > 0 && keyCode < key.length) {
			key[keyCode] = true;
		}
	}

	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode > 0 && keyCode < key.length) {
			key[keyCode] = false;
		}

	}

	public void keyTyped(KeyEvent e) {

	}

}
