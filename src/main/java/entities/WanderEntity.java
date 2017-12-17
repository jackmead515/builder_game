package entities;

import java.awt.Point;

import interfaces.ISimpleAI;
import main.Main;
import util.Randomizer;
import util.Util;

public class WanderEntity extends Entity implements ISimpleAI {
	
	protected long movementTimeSpeed;
	protected long movementStartTime;
	protected int pathLength;

	public WanderEntity() {
		movementStartTime = System.nanoTime();
		movementTimeSpeed = 1L;
		pathLength = 500;
	}

	protected void move(double delta, long time) {
		if(time - movementStartTime >= movementTimeSpeed) {
			movementStartTime = time;
			
			Point p = direction.next((int)delta);
			if(p != null && !Main.window.gamePanel.outOfBounds(p.x, p.y)) {
				this.bbox.set(p);
			} else {
				this.direction.setRandomHeading(this.bbox.center.x, this.bbox.center.y, this.pathLength);
			}
		}
	}
}




























