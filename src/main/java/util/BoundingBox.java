package util;

import java.awt.Point;
import java.awt.Rectangle;

public class BoundingBox extends Rectangle {
	
	public Point center;
	
	public BoundingBox(int width, int height) {
		this.width = width; this.height = height;
		center = new Point();
	}
	
	public BoundingBox(int x, int y, int height, int width) {
		super(x, y, height, width);
		center = new Point(x+(height/2), y+(width/2));
	}
	
	/**
	 * Set's the next center of the bounding box.
	 * @param p - Point past will become the center of the bounding box.
	 */
	public void set(Point p) {
		center.move(p.x, p.y);
		this.setBounds(p.x-(this.width/2), p.y-(this.height/2), this.width, this.height);
	}
	
	public boolean collides(Point p) {
		return this.getBounds().contains(p);
	}
	
	public boolean collides(Rectangle rect) {
		return this.intersects(rect);
	}
	
	@Override
	public String toString() {
		return "x:"+this.x+"y:"+this.y+"h:"+this.height+"w:"+this.width;
	}
	
	@Override
	public int hashCode() {
		return this.toString().hashCode();
	}
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        BoundingBox o = (BoundingBox) obj;
        
        return o.x == this.x && o.y == this.y && 
        	o.width == this.width && o.height == this.height;
    }

}
