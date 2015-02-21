package problems;

import annotations.Done;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Done
public class Problem38 implements Problem<Long> {

	static boolean isPandigitalFrom1To9(long number) {
		String numberString = Long.toString(number);
		List<Integer> digits = numberString.chars().map(i -> i - '0').boxed().collect(Collectors.toList());

		Collections.sort(digits);
		return digits.equals(expected1to9);
	}

	static List<Integer> expected1to9 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

	static String concat(int number, int maxN) {
		return IntStream.rangeClosed(1, maxN).boxed()
				.map(i -> "" + (number * i))
				.reduce((a, b) -> a + b).get();
	}

	@Override
	public Long getCalculatedSolution() {
		long curmax = 0;
		for (int i = 1; i < 100000; ++i) {
			for (int n = 1; n <= 9; ++n) {

				String s = concat(i, n);
				if (s.length() != 9) // check that first, parseLong blows on too long input
					continue;

				long number = Long.parseLong(s);
				if (isPandigitalFrom1To9(number)) {
					if (number > curmax) {
						curmax = number;
					}
				}
			}
		}
		return curmax;
	}

	@Override
	public Long getExpectedSolution() {
		return 932718654L;
	}
}
