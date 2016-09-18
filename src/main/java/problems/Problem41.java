package problems;

import annotations.Done;
import utils.Common;

import java.util.stream.IntStream;

@Done
public class Problem41 implements Problem<Integer> {

	// again, stream solution is too slow on my laptop, even .parallel()
	public static boolean isPrime(int number) {
		for (int k = 2; k < number; ++k) {
			if (number % k == 0) return false;
		}
		return true;
	}

	@Override
	public Integer getCalculatedSolution() {

		// here we have 10M as the limit. It's set to 10M because
		// it would take too long to compute all possibilities up to 1G.
		final int LIMIT = 10_000_000;

		return IntStream.rangeClosed(0, LIMIT).parallel()
				.filter(n -> Common.isPandigital(n) && isPrime(n))
				.max().getAsInt();
	}

	@Override
	public Integer getExpectedSolution() {
		return 7652413;
	}
}

