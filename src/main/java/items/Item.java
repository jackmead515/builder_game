package items;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Vector;

import javax.swing.JPanel;

import util.BoundingBox;
public class Item {
	
	public BoundingBox bbox;
	public BufferedImage image;
	public boolean canCollide;
	
	public Item() {}
	
	public void draw(Graphics2D g2, JPanel panel) {
		g2.drawImage(image, bbox.x, bbox.y, panel);
	}
	
	public String description() {
		return this.getClass().getSimpleName();
	}

}
