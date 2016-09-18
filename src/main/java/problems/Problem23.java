package problems;

import annotations.Done;
import utils.SumOfProperDivisorsCache;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Done
public class Problem23 implements Problem<Integer> {

	SumOfProperDivisorsCache cache = new SumOfProperDivisorsCache(65_000);

	boolean isAbundant(int number) {
		return cache.get(number) > number;
	}

	Set<Integer> abundantNumbers;
	final int MAX = 65_000;

	public Problem23() {
		abundantNumbers = IntStream.rangeClosed(1, MAX)
				.filter(this::isAbundant)
				.boxed().collect(Collectors.toSet());
	}

	boolean canBeWritten(int number) {
		for (int i = 1; i < number; ++i) {
			if (abundantNumbers.contains(i) && abundantNumbers.contains(number - i))
				return true;
		}
		return false;
	}

	@Override
	public Integer getCalculatedSolution() {
		return IntStream.range(1, MAX)
				.filter(w -> !canBeWritten(w))
				.sum();
	}

	@Override
	public Integer getExpectedSolution() {
		return 4179871;
	}
}
