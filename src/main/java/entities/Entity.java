package entities;

import interfaces.IAlive;
import items.Actor;
import items.Item;
import util.Vector2D;

public class Entity extends Actor {
	
	public Vector2D direction;
	
	public Entity() {
		direction = new Vector2D();
		canCollide = true;
	}

}
