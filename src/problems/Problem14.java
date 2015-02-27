package problems;

import annotations.Done;

import java.util.Comparator;
import java.util.stream.IntStream;

@Done
public class Problem14 implements Problem<Integer> {

	static int collatzSequenceLength(long number) {
		int length = 0;

		while (number != 1) {
			length++;
			if (number % 2 == 0)
				number /= 2;
			else
				number = 3 * number + 1;
		}

		length++;
		return length;
	}

	// there used to be a faster solution here, but was removed, because
	// the following one is fast enough.

	@Override
	public Integer getCalculatedSolution() {
		final int MAX = 1_000_000;
		return IntStream.range(1, MAX).boxed()
				.max(Comparator.comparing(i -> collatzSequenceLength(i)))
				.get();
	}

	@Override
	public Integer getExpectedSolution() {
		return 837799;
	}
}
