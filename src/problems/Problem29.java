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

		for (int a = 2; a <= 100; a++) {
			for (int b = 2; b <= 100; b++) {
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
