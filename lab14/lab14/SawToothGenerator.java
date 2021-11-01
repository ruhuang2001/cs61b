package lab14;

import lab14lib.Generator;

public class SawToothGenerator implements Generator {
	private int period;	// recycle routes
	private int state;

	public SawToothGenerator(int period) {
		state = 0;
		this.period = period;
	}

	@Override
	public double next() {
		state = state + 1;
		return normalize(state % period);
	}

	public double normalize(int x) {
		return (double) x * 2 / period - 1;
	}
}
