package problems;

import annotations.Done;
import utils.PrimeCache;

@Done
public class Problem27 implements Problem<Integer> {

	static PrimeCache cache = new PrimeCache(1_000_000);

	public static int getNumberOfPrimesForPolynomial(int a, int b) {
		for (int n = 0; true; n++) {
			int probablePrime = (n * n) + (a * n) + b;
			if (!cache.isPrime(probablePrime)) {
				return n;
			}
		}
	}

	@Override
	public Integer getCalculatedSolution() {
		int product = 0;
		int currentMaximumNumPrimes = 0;

		for (int a = -999; a <= 999; ++a) {
			for (int b = -999; b <= 999; ++b) {
				int primesNum = getNumberOfPrimesForPolynomial(a, b);
				if (primesNum > currentMaximumNumPrimes) {
					currentMaximumNumPrimes = primesNum;
					product = a * b;
				}
			}
		}
		return product;
	}

	@Override
	public Integer getExpectedSolution() {
		return -59231;
	}
}
