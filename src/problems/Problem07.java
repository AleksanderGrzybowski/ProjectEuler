package problems;

import annotations.Done;
import utils.PrimeCache;

import java.util.ArrayList;

@Done
public class Problem07 implements Problem<Integer> {

	@Override
	public Integer getCalculatedSolution() {
		final int LIMIT = 200_000;
		PrimeCache cache = new PrimeCache(LIMIT);
		final int INDEX = 10_001;

		return new ArrayList<>(cache.asSortedSet()).get(INDEX - 1);
	}

	@Override
	public Integer getExpectedSolution() {
		return 104743;
	}
}
