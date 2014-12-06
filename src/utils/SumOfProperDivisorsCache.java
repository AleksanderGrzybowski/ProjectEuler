package utils;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class SumOfProperDivisorsCache {

	private Map<Integer, Integer> sumOfProperDivisors = new HashMap<>();

	int sumOfProperDivisors(int number) {
		return IntStream.rangeClosed(1, number - 1).filter(i -> number % i == 0).sum();
	}

	public SumOfProperDivisorsCache(int max) {
		for (int i = 1; i <= max; ++i) // TODO change magic number to what?
			sumOfProperDivisors.put(i, sumOfProperDivisors(i));
	}

	public int get(int number) {
		return sumOfProperDivisors.get(number); // NPE possible
	}
}
