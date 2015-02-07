package problems;

import annotations.Done;

import java.util.stream.IntStream;

@Done
public class Problem34 implements Problem<Integer> {

	static int factorial(int n) {
		return (n == 0) ? 1 : IntStream.rangeClosed(2, n).reduce(1, (a, b) -> a * b);
	}

	static boolean isCurious(int number) {
		return Integer.toString(number)
				.chars().map(c -> c - '0')
				.map(Problem34::factorial)
				.sum() == number;
	}

	@Override
	public Integer getCalculatedSolution() {
		return IntStream.range(3, 1_000_000)
				.filter(Problem34::isCurious)
				.sum();
	}

	@Override
	public Integer getExpectedSolution() {
		return 40730;
	}
}
