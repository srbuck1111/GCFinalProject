package co.grandcircus.GCFinalProject.dndpojos;

import java.io.Serializable;

public class Dice implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static int roll(int d) {
		return (int) (Math.random() * d) + 1;
	}

	public static int roll(int d, int num) {
		int total = 0;
		for (int i = 0; i < num; i++) {
			total += (int) (Math.random() * d) + 1;
		}
		return total;
	}
	
}
