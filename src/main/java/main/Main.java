package main;

import java.awt.Point;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

import buildings.Market_Stall;
import entities.Deer;
import entities.Merchant;
import entities.Traveler;
import items.Actor;
import items.Item;
import sprites.Explosion;
import util.Randomizer;

public class Main {
	
	public static Realm realm;
	public static Frame window;

	public static void main(String[] args) {
		
		init();
		
		startLoop();
		
	}
	
	private static void init() {
		
		BMPImages.load();
		SoundEffect.load();
		new Randomizer();
		
		realm = new Realm();
		
		Market_Stall mks = new Market_Stall(new Point(1000, 200));
		realm.register(mks);
		Merchant m = new Merchant(new Point(985, 210));
		Main.realm.register(m);
		
		Traveler tr = new Traveler(new Point(1000, 100));
		realm.register(tr);
		
		for(int i = 0; i < 20; i++) {
			Traveler deer = new Traveler(new Point(i*25, i*25));
			realm.register(deer);
		}
		/*for(int i = 0; i < 20; i++) {
			Deer deer = new Deer(new Point(i*25 + 25, i*25));
			realm.register(deer);
		}
		for(int i = 0; i < 20; i++) {
			Deer deer = new Deer(new Point(i*25 + 50, i*25));
			realm.register(deer);
		}*/
		
		/*Deer deer = new Deer(new Point(500, 500));
		realm.register(deer);
		
		Explosion ex = new Explosion(new Point(500, 500));
		realm.register(ex);*/

		Thread t = new Thread(new Runnable() {
			public void run() {
				try {
					window = new Frame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		t.start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void update(double delta, long time) {
		realm.add(); realm.remove();
		ListIterator<Actor> listIterator = realm.actors.listIterator();
		while (listIterator.hasNext()) {
			listIterator.next().act(delta, time);
		}
	}
	
	private static void render() {
		try {
			window.gamePanel.paintImmediately(0,0,window.gamePanel.getWidth(),window.gamePanel.getHeight());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void startLoop() {
		long lastLoopTime = System.nanoTime();
		int lastFpsTime = 0;
		long startTime = lastLoopTime;
		final int TARGET_FPS = 60;
		final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;   
		int fps = 0;

		while (true) {

			long now = System.nanoTime();
			long updateLength = now - lastLoopTime;
			lastLoopTime = now;
			double delta = updateLength / ((double)OPTIMAL_TIME);

			lastFpsTime += updateLength;
			fps++;

			if (lastFpsTime >= 1000000000) {
				lastFpsTime = 0;
				fps = 0;
			} 
			
			update(delta, now);

			render();

			try {
				Thread.sleep( Math.abs((lastLoopTime-System.nanoTime() + OPTIMAL_TIME)/1000000 ));
			} catch(Exception e) {
				e.printStackTrace();
			};
		}
		
	}

}

