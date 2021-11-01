package lab14;

import lab14lib.Generator;

public class AcceleratingSawToothGenerator implements Generator {
	private int state;
	private int period;
	private double factor; // the rate of change in each recycle

	public AcceleratingSawToothGenerator(int period, double factor) {
		state = 0;
		this.period = period;
		this.factor = factor;
	}

	@Override
	public double next() {
		state += 1;
		if (state == period) {
			period *= factor;
			state = 0;
		}
		return normalize(state);
	}
	public double normalize(int x) {
		return (double)x * 2 / period - 1;
	}
}
