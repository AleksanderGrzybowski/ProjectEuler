package problems;

import annotations.Done;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

@Done
public class Problem01 implements Problem<Integer> {

	@Override
	public Integer getCalculatedSolution() {
		IntPredicate isAMultipleOf3 = i -> (i % 3 == 0);
		IntPredicate isAMultipleOf5 = i -> (i % 5 == 0);
		IntPredicate criteria = isAMultipleOf3.or(isAMultipleOf5);

		final int START = 0;
		final int END = 999;

		return IntStream.rangeClosed(START, END)
				.filter(criteria)
				.sum();
	}

	@Override
	public Integer getExpectedSolution() {
		return 233168;
	}
}
