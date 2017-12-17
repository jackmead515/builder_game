package util;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Collection;
import java.util.Iterator;

import items.Item;
import main.Main;

public class Util {
	
	public static int distanceTo(int x, int y, int x1, int y1) {
		return (int) Math.sqrt(Math.pow(Math.abs(x - x1), 2) + Math.pow(Math.abs(y - y1), 2));
	}
	
	public static int ordinalIndexOf(String str, String substr, int n) {
		int pos = str.indexOf(substr);
		while (--n > 0 && pos != -1)
			pos = str.indexOf(substr, pos + 1);
		return pos;
	}
	
	public static boolean inArea(Rectangle r, Point p) {
		return r.getBounds().contains(p);
	}
	
	public static Point mouseSnap(Point point) {
		
		int x = point.x;
		int y = point.y;
		
		int lowXCount = 0; int lowYCount = 0;
		int highXCount = 0; int highYCount = 0;
		
		for(int i = 0; i < 6; i++){
			if((x+i) % 5 == 0){
				lowXCount = i;
				break;
			}
		}
		for(int i = 0; i < 6; i++){
			if((y+i) % 5 == 0){
				lowYCount = i;
				break;
			}
		}
		for(int i = 0; i < 6; i++){
			if((y-i) % 5 == 0){
				highYCount = i;
				break;
			}
		}
		for(int i = 0; i < 6; i++){
			if((x-i) % 5 == 0){
				highXCount = i;
				break;
			}
		}
		
		if(highXCount < lowXCount || highYCount < lowYCount){
			return new Point(x-highXCount, y-highYCount);
		}else if(lowXCount < highXCount || lowYCount < highYCount){
			return new Point(x+lowXCount, y+lowYCount);
		}
		return point;
	}

}
