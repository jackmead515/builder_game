package sprites;

import java.awt.image.BufferedImage;

import interfaces.IAnimate;
import items.Actor;
import main.Main;
import util.Vector2D;

public class Sprite extends Actor implements IAnimate {

	public Vector2D direction;
	public BufferedImage[] animation;
	
	protected long animateStartTime;
	protected long animateTimeSpeed;
	protected int animateIndex;
		
	public Sprite() {
		animateIndex = 0;
		animateStartTime = System.nanoTime();
		animateTimeSpeed = 100000L;
		direction = new Vector2D();
		canCollide = false;
	}

	public void animate(double delta, long time) {
		if(time - animateStartTime >= animateTimeSpeed) {
			animateStartTime = time;
			
			animateIndex+=1;
			if(animateIndex >= animation.length){
				animateIndex=0;
				Main.realm.deregister(this);
			}
			image = animation[animateIndex];
		
		}
	}
	
}
