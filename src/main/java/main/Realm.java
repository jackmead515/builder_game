package main;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;

import com.google.common.collect.HashMultimap;

import items.Actor;
import items.Item;
import util.BoundingBox;

public class Realm {
	
	public volatile LinkedList<Item> items;
	public volatile LinkedList<Actor> actors;
	public volatile LinkedList<Item> boundaries;
	public volatile HashMap<BoundingBox, Item> hmitems;
	
	public Realm() {
		items = new LinkedList<Item>();
		boundaries = new LinkedList<Item>();
		actors = new LinkedList<Actor>();
		hmitems = new HashMap<BoundingBox, Item>();
	}
	
	public void add(Item i) {
		items.add(i);
		if(i instanceof Actor) actors.add((Actor) i);
		if(i.canCollide) boundaries.add(i);
		hmitems.put(i.bbox, i);
	}
	
	public void remove(Item i) {
		items.remove(i);
		if(i instanceof Actor) actors.remove((Actor) i);
		if(i.canCollide) boundaries.remove(i);
		hmitems.remove(i.bbox, i);
	}
	
	public boolean collides(BoundingBox b) {
		ListIterator<Item> listIterator = boundaries.listIterator();
		while (listIterator.hasNext()) {
			Item i = listIterator.next();
			if(i.bbox.collides(b)) {
				return true;
			}
		}
		return false;
	}

}
