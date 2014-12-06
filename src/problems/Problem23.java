package problems;

import annotations.Done;
import utils.SumOfProperDivisorsCache;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

@Done
public class Problem23 implements Problem<Integer> {

	SumOfProperDivisorsCache cache = new SumOfProperDivisorsCache(65_000);

	boolean isAbundant(int number) {
		return cache.get(number) > number;
	}

	Set<Integer> abundantNumbers = new HashSet<>();

	{
		for (int i = 1; i <= 65_000; ++i) { // TODO change magic number to what?
			if (isAbundant(i)) abundantNumbers.add(i);
		}
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
		List<Integer> l = new ArrayList<>(abundantNumbers);
		l.sort(Integer::compare);

		return IntStream.range(1, 65000).filter(w -> !canBeWritten(w)).sum();
	}

	@Override
	public Integer getExpectedSolution() {
		return 4179871;
	}
}
