package util;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Stack;

public class Vector2D {
	
	private LinkedList<Point> points;
	
	public Vector2D() {
		points = new LinkedList<Point>();
	}
	
	public Vector2D(int bx, int by, int ex, int ey) {
		points = new LinkedList<Point>();
		this.getPoints(bx, by, ex, ey);
	}
	
	public void setHeading(int bx, int by, int ex, int ey) {
		points.clear();
		this.getPoints(bx, by, ex, ey);
	}
	
	public void setRandomHeading(int bx, int by, int pathLength) {
		int degrees = Randomizer.random(0, 360);
		double angle = Math.toRadians(degrees);
		int ex = (int) (Math.cos(angle) * pathLength);
		int ey = (int) (Math.sin(angle) * pathLength);
		points.clear();
		this.setHeading(bx, by, ex, ey);
	}
	
	/**
	 * Gets the next point in the path of this vector.
	 * @return Point object or null if end of vector is reached.
	 */
	public Point next() {
		if(points.size() >= 1) {
			return points.removeLast();
		} else {
			return null;
		}
	}
	
	public Point next(int iterate) {
		if(iterate >= 1) {
			for(int i = 0; i < iterate-1; i++) {
				if(points.size() >= 1) {
					return points.removeLast();
				} else {
					return null;
				}
			}
			if(points.size() >= 1) {
				return points.removeLast();
			} else {
				return null;
			}
		} else {
			if(points.size() >= 1) {
				return points.removeLast();
			} else {
				return null;
			}
		}
	}
	
	private void getPoints(int x, int y, int x2, int y2) {
		int w = x2 - x;
	    int h = y2 - y;
	    int dx1 = 0, dy1 = 0, dx2 = 0, dy2 = 0 ;
	    if (w<0) dx1 = -1; else if (w>0) dx1 = 1;
	    if (h<0) dy1 = -1; else if (h>0) dy1 = 1;
	    if (w<0) dx2 = -1; else if (w>0) dx2 = 1;
	    int longest = Math.abs(w);
	    int shortest = Math.abs(h);
	    if (!(longest>shortest)) {
	        longest = Math.abs(h);
	        shortest = Math.abs(w);
	        if (h<0) dy2 = -1; else if (h>0) dy2 = 1;
	        dx2 = 0;            
	    }
	    int numerator = longest >> 1;
	    for (int i=0;i<=longest;i++) {
	        points.push(new Point(x, y));
	        numerator += shortest;
	        if (!(numerator<longest)) {
	            numerator -= longest;
	            x += dx1;
	            y += dy1;
	        } else {
	            x += dx2;
	            y += dy2;
	        }
	    }
	}

}
