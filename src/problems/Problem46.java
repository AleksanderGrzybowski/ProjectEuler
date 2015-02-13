package problems;

import annotations.Done;
import utils.PrimeCache;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

@Done
public class Problem46 implements Problem<Integer> {

	static PrimeCache cache = new PrimeCache(1_000_000);

	static boolean canBeWritten(int number) {
		for (int i : cache.toTreeSet().headSet(number, true)) {
			for (int j = 1; j <= number; ++j) {
				if (number == i + 2 * j * j) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Integer getCalculatedSolution() {
		IntPredicate isNotPrime = i -> !cache.isPrime(i);
		IntPredicate cantBeWritten = i -> !canBeWritten(i);

		IntStream oddNumbers = IntStream.iterate(3, i -> i + 2);

		return oddNumbers
				.filter(isNotPrime)
				.filter(cantBeWritten)
				.findFirst().getAsInt();
	}

	@Override
	public Integer getExpectedSolution() {
		return 5777;
	}
}
