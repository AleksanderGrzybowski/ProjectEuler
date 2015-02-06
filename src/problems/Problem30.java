package problems;

import annotations.Done;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

@Done
public class Problem30 implements Problem<Integer> {

	@Override
	public Integer getCalculatedSolution() {
		IntPredicate canBeWritten = n -> Integer.toString(n).chars()
				.map(c -> c - '0')
				.map(i -> i * i * i * i * i)
				.sum() == n;

		return IntStream.rangeClosed(2, 1_000_000).filter(canBeWritten).sum();
	}

	@Override
	public Integer getExpectedSolution() {
		return 443839;
	}
}
