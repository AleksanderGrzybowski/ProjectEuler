package problems;

import annotations.Done;

import java.util.stream.IntStream;

@Done
public class Problem06 implements Problem<Integer> {

	public IntStream getRange() {
		final int FIRST = 1;
		final int LAST = 100;

		return IntStream.rangeClosed(FIRST, LAST);
	}

	@Override
	public Integer getCalculatedSolution() {
		int sumOfSquares = getRange().map(i -> i * i).sum();
		int sum = getRange().sum();
		int squareOfSum = sum * sum;

		return squareOfSum - sumOfSquares;
	}

	@Override
	public Integer getExpectedSolution() {
		return 25164150;
	}
}
