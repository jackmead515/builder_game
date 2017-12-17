package sprites;

import java.awt.Point;
import java.awt.image.BufferedImage;

import interfaces.IMove;
import main.BMPImages;
import util.BoundingBox;

public class Coins extends Sprite implements IMove {
	
	protected long moveStartTime;
	protected long moveTimeSpeed;
	
	public Coins(Point p) {
		image = BMPImages.coins_1;
		animation = new BufferedImage[] {
			BMPImages.coins_1,
			BMPImages.coins_2,
			BMPImages.coins_3,
			BMPImages.coins_2,
			BMPImages.coins_1,
			BMPImages.coins_3,
		};
		animateStartTime = System.nanoTime();
		animateTimeSpeed = 90000000L;
		moveStartTime = System.nanoTime();
		moveTimeSpeed = 90000000L;
		
		bbox = new BoundingBox(15, 15);
		bbox.set(p);
	}
	
	@Override
	public void act(double delta, long time) {
		this.animate(delta, time);
		this.move(delta, time);
	}
	
	public void move(double delta, long time) {
		if(time - moveStartTime >= moveTimeSpeed) {
			moveStartTime = time;
			
			bbox.set(new Point(bbox.center.x, bbox.center.y-5));
		
		}
	}

}