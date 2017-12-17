package entities;

import java.awt.Point;
import java.awt.image.BufferedImage;

import interfaces.IAnimate;
import main.BMPImages;
import main.Main;
import util.BoundingBox;

public class Traveler extends WanderEntity implements IAnimate {
	
	public BufferedImage[] animation;
	
	protected long animateStartTime;
	protected long animateTimeSpeed;
	protected int animateIndex;
		
	public Traveler(Point p) {
		image = BMPImages.traveler_1;
		animation = new BufferedImage[] {
				BMPImages.traveler_1,
				BMPImages.traveler_2
		};
		animateStartTime = System.nanoTime();
		animateTimeSpeed = 400000000L;
		bbox = new BoundingBox(16, 32);
		bbox.set(p);
		movementStartTime = System.nanoTime();
		movementTimeSpeed = 30000000L;
	}
		
	@Override
	public void act(double delta, long time) {
		this.move(delta, time);
		this.animate(delta, time);
	}

	public void animate(double delta, long time) {
		if(time - animateStartTime >= animateTimeSpeed) {
			animateStartTime = time;
			
			animateIndex+=1;
			if(animateIndex >= animation.length){
				animateIndex=0;
			}
			image = animation[animateIndex];
		
		}
	}

}
