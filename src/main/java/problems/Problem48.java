package problems;

import annotations.Done;

import java.math.BigInteger;
import java.util.stream.IntStream;

@Done
public class Problem48 implements Problem<String> {

	@Override
	public String getCalculatedSolution() {
		final int FIRST = 1;
		final int LAST = 1000;
		String whole = IntStream.rangeClosed(FIRST, LAST).boxed()
				.map(i -> BigInteger.valueOf(i).pow(i))
				.reduce(BigInteger.ZERO, BigInteger::add)
				.toString();

		return whole.substring(whole.length()-10, whole.length());
	}

	@Override
	public String getExpectedSolution() {
		return "9110846700";
	}
}
