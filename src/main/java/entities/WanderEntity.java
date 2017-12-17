package entities;

import java.awt.Point;

import interfaces.ISimpleAI;
import main.Main;
import sprites.Explosion;
import util.Randomizer;
import util.Util;

public class WanderEntity extends Entity implements ISimpleAI {
	
	protected boolean move;
	protected long movementTimeSpeed;
	protected long movementStartTime;
	protected int pathLength;

	public WanderEntity() {
		move = true;
		movementStartTime = System.nanoTime();
		movementTimeSpeed = 500000000L;
		pathLength = 100;
	}

	public void move(double delta, long time) {
		if(time - movementStartTime >= movementTimeSpeed && move) {
			movementStartTime = time;
			
			Point p = direction.next((int)delta);
			if(p != null && !Main.window.gamePanel.outOfBounds(p.x, p.y)) {
				this.bbox.set(p);
			} else {
				this.direction.setRandomHeading(this.bbox.center.x, this.bbox.center.y, this.pathLength);
			}
		}
	}
	
	public void setMove(boolean move) {
		this.move = move;
	}
}




























