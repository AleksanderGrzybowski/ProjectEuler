package problems;

import annotations.Done;
import utils.PrimeCache;

import java.util.stream.IntStream;

@Done

public class Problem07 implements Problem<Integer> {

	PrimeCache pc = new PrimeCache(200_000);

	@Override
	public Integer getCalculatedSolution() {
		IntStream naturalNumbers = IntStream.iterate(1, i -> i + 1);
		int index = 10_001;

		return naturalNumbers.filter(pc::isPrime).skip(index - 1).findFirst().getAsInt();
	}

	@Override
	public Integer getExpectedSolution() {
		return 104743;
	}
}
