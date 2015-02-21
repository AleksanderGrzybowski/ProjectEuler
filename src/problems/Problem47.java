package problems;

import annotations.Done;
import utils.PrimeCache;

import java.util.HashSet;
import java.util.SortedSet;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

@Done
public class Problem47 implements Problem<Integer> {

	static SortedSet<Integer> primes = new PrimeCache(1_000_000).asSortedSet();

	static int numberOfPrimeFactors(int number) {
		HashSet<Integer> factors = new HashSet<>();
		SortedSet<Integer> primesSlice = primes.headSet(number + 1);

		outer:
		while (number != 1) {
			for (int divisor : primesSlice) {
				if (number % divisor == 0) {
					factors.add(divisor);
					number /= divisor;
					continue outer;
				}
			}
		}
		return factors.size();
	}


	@Override
	public Integer getCalculatedSolution() {

		IntPredicate predicate = i ->
				numberOfPrimeFactors(i) == 4
						&& numberOfPrimeFactors(i + 1) == 4
						&& numberOfPrimeFactors(i + 2) == 4
						&& numberOfPrimeFactors(i + 3) == 4;

		return IntStream.rangeClosed(1, 100000000).filter(predicate).findFirst().getAsInt();
	}

	@Override
	public Integer getExpectedSolution() {
		return 134043;
	}
}
