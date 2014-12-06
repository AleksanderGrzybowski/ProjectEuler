package problems;

import annotations.Done;

import java.math.BigInteger;
import java.util.Arrays;

@Done
public class Problem16 implements Problem<Integer> {

	@Override
	public Integer getCalculatedSolution() {

		return Arrays.stream(
				BigInteger.valueOf(2).pow(1000).toString().split("")
		).mapToInt(Integer::parseInt).sum();
	}

	@Override
	public Integer getExpectedSolution() {
		return 1366;
	}
}
