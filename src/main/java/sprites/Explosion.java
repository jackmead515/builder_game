package sprites;

import java.awt.Point;
import java.awt.image.BufferedImage;

import main.BMPImages;
import util.BoundingBox;

public class Explosion extends Sprite {
	
	public Explosion(Point p) {
		image = BMPImages.explosion_1_1;
		animation = new BufferedImage[] {
			BMPImages.explosion_1_1,
			BMPImages.explosion_1_2,
			BMPImages.explosion_1_3,
			BMPImages.explosion_1_4,
			BMPImages.explosion_1_5,
			BMPImages.explosion_1_6,
			BMPImages.explosion_1_7
		};
		animateStartTime = System.nanoTime();
		animateTimeSpeed = 30000000L;
		
		bbox = new BoundingBox(32, 32);
		bbox.set(p);
	}
	
	@Override
	public void act(double delta, long time) {
		this.animate(delta, time);
	}

}
