package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ListIterator;

import javax.swing.JPanel;

import items.Actor;
import items.Item;
import util.Util;

public class GamePanel extends JPanel {
	
	public GamePanel() {}

	public boolean outOfBounds(int x, int y) {
		int width = this.getWidth();
		int height = this.getHeight();
		
		Rectangle rect = new Rectangle(0, 0, width, height);
		
		return !Util.inArea(rect, new Point(x, y));
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setFont(new Font("Minion Pro", Font.PLAIN, 15));
		
		drawBackground(g2);
		
		drawGrid(g2);
		
		drawItems(g2);
		
	}
	
	private void drawItems(Graphics2D g2) {
		ListIterator<Item> listIterator = Main.realm.items.listIterator();
		while (listIterator.hasNext()) {
			Item i = listIterator.next();
			i.draw(g2, this);
			g2.setColor(new Color(0, 255, 0));
			g2.drawRect(i.bbox.x, i.bbox.y, i.bbox.width, i.bbox.height);
			g2.setColor(new Color(255, 0, 0));
			g2.drawRect(i.bbox.center.x, i.bbox.center.y, 2, 2);
		}
	}
	
	private void drawBackground(Graphics2D g2) {
		g2.drawImage(BMPImages.background, 0, 0, this);
	}
	
	private void drawGrid(Graphics2D g2) {
		g2.setColor(new Color(0,0,0,20));
		
		for(int i = 0; i < getWidth(); i+=5) {
			g2.drawLine(i, 0, i, getHeight());
		}
		
		for(int i = 0; i < getHeight(); i+=5) {
			g2.drawLine(0, i, getWidth(), i);
		}
	}
}
