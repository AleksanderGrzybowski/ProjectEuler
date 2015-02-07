package problems;

import annotations.Done;

import java.util.Set;
import java.util.stream.Collectors;
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

	static boolean isPandigital(long number) {
		String numberString = Long.toString(number);
		Set<Integer> digits = numberString.chars().map(i -> i - '0').boxed().collect(Collectors.toSet());

		if (digits.contains(0)) { // rule says: from 1 up to n, zero is banned
			return false;
		}

		Set<Integer> expected1toN = IntStream.rangeClosed(1, numberString.length()).boxed().collect(Collectors.toSet());
		return digits.equals(expected1toN);
	}

	@Override
	public Integer getCalculatedSolution() {

		// here we have 10M as the limit. It's set to 10M because
		// it would take too long to compute all possibilities up to 1G.
		return IntStream.rangeClosed(0, 10_000_000).parallel()
				.filter(n -> isPandigital(n) && isPrime(n))
				.max().getAsInt();
	}

	@Override
	public Integer getExpectedSolution() {
		return 7652413;
	}
}

