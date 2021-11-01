package lab14;

import lab14lib.Generator;
import lab14lib.GeneratorAudioVisualizer;
import lab14lib.GeneratorDrawer;
import lab14lib.GeneratorPlayer;

public class Main {
	public static void main(String[] args) {
		/** Your code here. */
//		Generator generator = new SawToothGenerator(512);
//		GeneratorAudioVisualizer gav = new GeneratorAudioVisualizer(generator);
//		gav.drawAndPlay(4096, 1000000);

//		Generator generator = new AcceleratingSawToothGenerator(200, 1.1);
//		GeneratorAudioVisualizer gav = new GeneratorAudioVisualizer(generator);
//		gav.drawAndPlay(4096, 1000000);

		Generator generator = new StrangeBitwiseGenerator(512);
		GeneratorAudioVisualizer gav = new GeneratorAudioVisualizer(generator);
		gav.drawAndPlay(4096, 1000000);
	}
} 