package problems;

import annotations.Done;
import utils.FibonacciNumbers;

import java.util.function.IntPredicate;

@Done
public class Problem02 implements Problem<Integer> {

	@Override
	public Integer getCalculatedSolution() {
		final int MAXIMUM_VALUE = 4_000_000;
		IntPredicate evenValueConstraint = i -> (i % 2 == 0);

		return FibonacciNumbers.generateUpTo(MAXIMUM_VALUE).stream().mapToInt(i -> i)
				.filter(evenValueConstraint)
				.sum();
	}

	@Override
	public Integer getExpectedSolution() {
		return 4613732;
	}
}
