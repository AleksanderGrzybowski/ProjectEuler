package problems;

import annotations.Done;

import java.util.Set;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Done
public class Problem44 implements Problem<Integer> {

	@Override
	public Integer getCalculatedSolution() {
		IntUnaryOperator pentFormula = n -> (n * (3 * n - 1)) / 2;
		final int LIMIT = 10000;

		Set<Integer> set = IntStream.rangeClosed(1, LIMIT).map(pentFormula).boxed().collect(Collectors.toSet());

		int d = Integer.MAX_VALUE;

		for (int pj : set) {
			for (int pk : set) {
				if (set.contains(pj + pk) && set.contains(Math.abs(pj - pk))) {
					d = Math.min(d, Math.abs(pj - pk));
				}
			}
		}
		return d;
	}

	@Override
	public Integer getExpectedSolution() {
		return 5482660;
	}
}
