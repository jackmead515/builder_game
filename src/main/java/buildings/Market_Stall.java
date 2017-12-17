package buildings;

import java.awt.Point;
import java.awt.image.BufferedImage;

import entities.Merchant;
import main.BMPImages;
import main.Main;
import sprites.Coins;
import sprites.Explosion;
import util.BoundingBox;

public class Market_Stall extends Generator {
	
	public Market_Stall(Point p) {
		image = BMPImages.market_stall;
		bbox = new BoundingBox(45, 45);
		bbox.set(p);
	}
	
	@Override
	public void act(double delta, long time) {
		this.generate(delta, time);
	}
	
	@Override
	public void generate(double delta, long time) {
		if(time - generateStartTime >= generateTimeSpeed && generate) {
			generateStartTime = time;
			
			Point p = bbox.center;
			Coins s = new Coins(new Point(p.x-10, p.y-20));
			Main.realm.register(s);
		
			
		}
	}


}
