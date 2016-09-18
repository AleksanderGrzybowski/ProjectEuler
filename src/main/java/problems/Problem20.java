package problems;

import annotations.Done;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.LongStream;

@Done
public class Problem20 implements Problem<Integer> {
	BigInteger factorial(int number) {
		return LongStream.rangeClosed(1, number).boxed()
				.map(BigInteger::valueOf)
				.reduce(BigInteger.ONE, BigInteger::multiply);
	}

	@Override
	public Integer getCalculatedSolution() {
		final int NUMBER = 100;
		return Arrays.stream(factorial(NUMBER).toString().split(""))
				.mapToInt(Integer::valueOf)
				.sum();
	}

	@Override
	public Integer getExpectedSolution() {
		return 648;
	}
}
