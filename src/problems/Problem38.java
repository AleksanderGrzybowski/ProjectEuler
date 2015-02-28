package problems;

import annotations.Done;
import utils.Common;

import java.util.stream.IntStream;

@Done
public class Problem38 implements Problem<Long> {

	static String concat(int number, int maxN) {
		return IntStream.rangeClosed(1, maxN).boxed()
				.map(i -> "" + (number * i))
				.reduce((a, b) -> a + b).get();
	}

	@Override
	public Long getCalculatedSolution() {
		long curmax = 0;
		for (int i = 1; i < 100000; ++i) {
			for (int n = 1; n <= 9; ++n) {

				String s = concat(i, n);
				if (s.length() != 9) // check that first, parseLong blows on too long input
					continue;

				long number = Long.parseLong(s);
				if (Common.isPandigital(number)) {
					if (number > curmax) {
						curmax = number;
					}
				}
			}
		}
		return curmax;
	}

	@Override
	public Long getExpectedSolution() {
		return 932718654L;
	}
}
