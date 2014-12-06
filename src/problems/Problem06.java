package problems;

import annotations.Done;

import java.util.stream.IntStream;

@Done
public class Problem06 implements Problem<Integer> {

	public IntStream getRange() {
		return IntStream.rangeClosed(1, 100);
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
