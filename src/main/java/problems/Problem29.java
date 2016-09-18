package problems;

import annotations.Done;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

@Done
public class Problem29 implements Problem<Integer> {

	@Override
	public Integer getCalculatedSolution() {
		Set<BigInteger> set = new HashSet<>();

		final int MIN = 2;
		final int MAX = 100;

		for (int a = MIN; a <= MAX; a++) {
			for (int b = MIN; b <= MAX; b++) {
				set.add(BigInteger.valueOf(a).pow(b));
			}
		}

		return set.size();
	}

	@Override
	public Integer getExpectedSolution() {
		return 9183;
	}
}
