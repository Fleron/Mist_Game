package com.mine.mist;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.mine.mist.entity.mob.Player;
import com.mine.mist.level.Level;
import com.mine.mist.level.RandomLevel;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;

	public static int width = 300;
	public static int height = width / 16 * 9;
	public static int scale = 3;
	public static String title = "Mist";

	private Thread thread;
	private JFrame frame;
	private boolean running = false;

	private Screen screen;
	private Keyboard keyboard;
	private Level level;
	private Player player;

	private BufferedImage image = new BufferedImage(width, height,
			BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer())
			.getData();

	public Game() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);

		frame = new JFrame();
		screen = new Screen(width, height);
		keyboard = new Keyboard();
		level = new RandomLevel(64, 64);
		player = new Player(keyboard);
		addKeyListener(keyboard);
	}

	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Game");
		thread.start();
	}

	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		int frames = 0;
		int updates = 0;
		long previousTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		double delta = 0;
		final double ns = 1000000000.0 / 60.0;

		while (running) {
			long currentTime = System.nanoTime();
			delta += (currentTime - previousTime) / ns;
			previousTime = currentTime;
			requestFocus();

			while (delta >= 1) {
				update();
				updates++;
				delta--;
			}
			render();
			frames++;
			
			if(System.currentTimeMillis()-timer > 1000){
				timer += 1000;
				System.out.println(updates + "ups " + frames + "fps");
				frame.setTitle(title + "  | "+ updates + "ups " +" | "+ frames + "fps");
				frames = 0;
				updates = 0;
			}
		}
		stop();
	}

	public void update() {
		keyboard.update();
		player.update();
		
	}
	
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		screen.clear();
		int xScroll = player.x - screen.width/2;
		int yScroll  = player.y - screen.height/2;
		level.render(xScroll, yScroll, screen);
		player.render(screen);
		

		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}

		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		bs.show();

	}

	public static void main(String[] args) {
		Game game = new Game();

		game.frame.setResizable(false);
		game.frame.setTitle("Mist");
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);

		game.start();
	}
}
