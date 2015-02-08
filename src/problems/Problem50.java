package problems;

import annotations.Done;
import utils.PrimeCache;

import java.util.ArrayList;
import java.util.List;

@Done
public class Problem50 implements Problem<Integer> {

	public static final int LIMIT = 1_000_000;

	@Override
	public Integer getCalculatedSolution() {
		PrimeCache cache = new PrimeCache(LIMIT);
		List<Integer> primes = new ArrayList<>(cache.toSet());

		int currentResult = 0;
		int currentLength = 0;

		outer:
		for (int left = 0; left < primes.size(); ++left) {
			for (int right = left; right < primes.size(); ++right) {

				// too slow to use List#subList and IntStream#sum here
				int sum = 0;
				for (int i = left; i < right; ++i) {
					sum += primes.get(i);
					if (sum > LIMIT) continue outer;
				}

				if (cache.isPrime(sum) && ((right - left) > currentLength)) {
					currentResult = sum;
					currentLength = right - left;
				}
			}
		}

		return currentResult;
	}

	@Override
	public Integer getExpectedSolution() {
		return 997651;
	}
}
