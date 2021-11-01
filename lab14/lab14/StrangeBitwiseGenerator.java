package lab14;

import lab14lib.Generator;

public class StrangeBitwiseGenerator implements Generator {
	private int period;	// recycle routes
	private int state;

	public StrangeBitwiseGenerator(int period) {
		state = 0;
		this.period = period;
	}

	public double next() {
		state = state + 1;
		int weirdState = state & (state >>> 3) % period;
		return normalize(weirdState);
	}

	public double normalize(int x) {
		return (double) x * 2 / period - 1;
	}
}
