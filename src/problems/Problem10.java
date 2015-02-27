package problems;

import annotations.Done;
import utils.PrimeCache;

import java.util.stream.IntStream;

@Done
public class Problem10 implements Problem<Long> {

	public static final int MAX = 2_000_000;
	PrimeCache cache = new PrimeCache(MAX);

	@Override
	public Long getCalculatedSolution() {
		return IntStream.range(1, MAX)
				.filter(cache::isPrime)
				.mapToLong(i -> i)
				.sum();
	}

	@Override
	public Long getExpectedSolution() {
		return 142913828922L;
	}
}
