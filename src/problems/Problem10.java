package problems;

import annotations.Done;
import utils.PrimeCache;

import java.util.stream.IntStream;

@Done
public class Problem10 implements Problem<Long> {

	PrimeCache primeCache = new PrimeCache(2_000_000);

	@Override
	public Long getCalculatedSolution() {
		return IntStream.range(1, 2_000_000)
				.filter(primeCache::isPrime)
				.mapToLong(i -> i)
				.sum();
	}

	@Override
	public Long getExpectedSolution() {
		return 142913828922L;
	}
}
