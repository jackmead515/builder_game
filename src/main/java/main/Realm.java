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
	
	public volatile LinkedList<Item> itemsToAdd;
	public volatile LinkedList<Item> itemsToRemove;
	
	public Realm() {
		itemsToAdd = new LinkedList<Item>();
		itemsToRemove = new LinkedList<Item>();
		items = new LinkedList<Item>();
		boundaries = new LinkedList<Item>();
		actors = new LinkedList<Actor>();
		hmitems = new HashMap<BoundingBox, Item>();
	}
	
	public void add() {
		while(!itemsToAdd.isEmpty()) {
			this.add(itemsToAdd.pop());
		}
	}
	
	public void remove() {
		while(!itemsToRemove.isEmpty()) {
			this.remove(itemsToRemove.pop());
		}
	}
	
	public void register(Item i) {
		itemsToAdd.add(i);
	}
	
	public void deregister(Item i) {
		itemsToRemove.add(i);
	}
	
	private void add(Item i) {
		items.add(i);
		if(i instanceof Actor) actors.add((Actor) i);
		if(i.canCollide) boundaries.add(i);
		hmitems.put(i.bbox, i);
	}
	
	private void remove(Item i) {
		items.remove(i);
		if(i instanceof Actor) actors.remove((Actor) i);
		if(i.canCollide) boundaries.remove(i);
		hmitems.remove(i.bbox, i);
	}
	
	public boolean collides(BoundingBox b) {
		Item i = hmitems.get(b);
		return i != null && i.canCollide;
	}

}






















