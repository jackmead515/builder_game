package util;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import items.Item;
import main.Main;

public class Randomizer {
	
	public Randomizer() {}
	
	public static int random(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}

}
