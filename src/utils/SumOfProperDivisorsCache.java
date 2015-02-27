package utils;

import java.util.HashMap;
import java.util.Map;

public class SumOfProperDivisorsCache {

	private Map<Integer, Integer> sumsOfProperDivisors = new HashMap<>();
	private int max;

	public static int sumOfProperDivisors(int number) {
		// this is too slow, TODO: replace with better method
//		return IntStream.rangeClosed(1, number - 1).filter(i -> number % i == 0).sum();
		int sum = 0;
		for (int i = 1; i < number; ++i) {
			if (number % i == 0)
				sum += i;
		}
		return sum;
	}

	public SumOfProperDivisorsCache(int max) {
		this.max = max;
		for (int i = 1; i <= max; ++i) {
			sumsOfProperDivisors.put(i, sumOfProperDivisors(i));
		}
	}

	public int get(int number) {
		if (number > max) {
			throw new IllegalArgumentException("Number " + number + " outside cache");
		}

		return sumsOfProperDivisors.get(number);
	}
}
