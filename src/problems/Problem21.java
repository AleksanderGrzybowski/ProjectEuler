package problems;

import annotations.Done;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

@Done
public class Problem21 implements Problem<Integer> {

	static Map<Integer, Integer> sumOfProperDivisorsMap = new HashMap<>();

	static {
		for (int i = 1; i <= 9999; ++i)
			sumOfProperDivisorsMap.put(i, sumOfProperDivisors(i));
	}

	static int sumOfProperDivisors(int number) {
		return IntStream.rangeClosed(1, number - 1).filter(i -> number % i == 0).sum();
	}

	static int sumOfProperDivisorsCached(int number) {
		return sumOfProperDivisorsMap.get(number);
	}

	static boolean isAmicablePair(int a, int b) {
		return (a != b && sumOfProperDivisorsCached(a) == b && sumOfProperDivisorsCached(b) == a);
	}

	@Override
	public Integer getCalculatedSolution() {
		Set<Integer> resultSet = new HashSet<>();

		for (int i = 1; i < 10_000; i++) {
			for (int j = 1; j < 10_000; j++) {
				if (isAmicablePair(i, j)) {
					resultSet.add(i);
					resultSet.add(j);
				}
			}
		}
		return resultSet.stream().mapToInt(i -> i).sum();
	}

	@Override
	public Integer getExpectedSolution() {
		return 31626;
	}
}
