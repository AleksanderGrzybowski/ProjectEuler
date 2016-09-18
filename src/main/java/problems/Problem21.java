package problems;

import annotations.Done;
import utils.SumOfProperDivisorsCache;

import java.util.HashSet;
import java.util.Set;

@Done
public class Problem21 implements Problem<Integer> {

	SumOfProperDivisorsCache cache = new SumOfProperDivisorsCache(10_000);

	boolean isAmicablePair(int a, int b) {
		return (a != b && cache.get(a) == b && cache.get(b) == a);
	}

	@Override
	public Integer getCalculatedSolution() {
		Set<Integer> result = new HashSet<>();

		for (int i = 1; i < 10_000; i++) {
			for (int j = 1; j < 10_000; j++) {
				if (isAmicablePair(i, j)) {
					result.add(i);
					result.add(j);
				}
			}
		}
		return result.stream().mapToInt(i -> i).sum();
	}

	@Override
	public Integer getExpectedSolution() {
		return 31626;
	}
}
