package problems;

import annotations.Done;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import static utils.Common.naturalNumbers;

@Done
public class Problem25 implements Problem<Integer> {

	Map<Integer, BigInteger> cache = new HashMap<>();

	public Problem25() {
		cache.put(1, BigInteger.ONE);
		cache.put(2, BigInteger.ONE);
	}

	public BigInteger fib(int index) {
		if (!cache.containsKey(index))
			cache.put(index, fib(index - 1).add(fib(index - 2)));
		return cache.get(index);
	}

	@Override
	public Integer getCalculatedSolution() {
		return naturalNumbers()
				.filter(i -> fib(i).toString().length() == 1000)
				.findFirst().getAsInt();
	}

	@Override
	public Integer getExpectedSolution() {
		return 4782;
	}
}
