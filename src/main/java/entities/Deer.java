package entities;

import java.awt.Point;
import java.awt.image.BufferedImage;

import main.BMPImages;
import util.BoundingBox;

public class Deer extends WanderEntity {
	
	public Deer(Point p) {
		image = BMPImages.deer;
		bbox = new BoundingBox(p.x, p.y, 20, 20);
	}
	
	@Override
	public void act(double delta, long time) {
		this.move(delta, time);
	}

}
