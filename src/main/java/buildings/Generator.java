package buildings;

import interfaces.IGenerate;

public class Generator extends Building implements IGenerate {
	
	protected boolean generate;
	protected long generateTimeSpeed;
	protected long generateStartTime;

	public Generator() {
		generate = true;
		generateStartTime = System.nanoTime();
		generateTimeSpeed = 1000000000L;
	}

	public void generate(double delta, long time) {}

	
	public void setGenerate(boolean generate) {
		this.generate = generate;
	}
}
