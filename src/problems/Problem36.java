package problems;

import annotations.Done;

import java.util.stream.IntStream;

@Done
public class Problem36 implements Problem<Integer> {

	static boolean isPalindromicInBothBases(int number) {
		String decimal = Integer.toString(number);
		String binary = Integer.toBinaryString(number);

		return new StringBuilder(decimal).reverse().toString().equals(decimal) &&
				new StringBuilder(binary).reverse().toString().equals(binary);

	}

	@Override
	public Integer getCalculatedSolution() {
		return IntStream.range(1, 1_000_000)
				.filter(Problem36::isPalindromicInBothBases)
				.sum();
	}

	@Override
	public Integer getExpectedSolution() {
		return 872187;
	}
}
