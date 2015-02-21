package problems;

import annotations.Done;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

@Done
public class Problem01 implements Problem<Integer> {

	@Override
	public Integer getCalculatedSolution() {
		IntPredicate isDivisibleBy3 = i -> (i % 3 == 0);
		IntPredicate isDivisibleBy5 = i -> (i % 5 == 0);
		IntPredicate criteria = isDivisibleBy3.or(isDivisibleBy5);

		final int START_NUMBER_INCLUSIVE = 0;
		final int END_NUMBER_EXCLUSIVE = 999;

		return IntStream.rangeClosed(START_NUMBER_INCLUSIVE, END_NUMBER_EXCLUSIVE)
				.filter(criteria)
				.sum();
	}

	@Override
	public Integer getExpectedSolution() {
		return 233168;
	}
}
