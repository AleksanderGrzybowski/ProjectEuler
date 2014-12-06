package problems;

import annotations.Done;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

@Done

public class Problem05 implements Problem<Integer> {

	static final int FIRST_DIVISOR = 1;
	static final int LAST_DIVISOR = 20;

	public IntPredicate getModPredicate(int number) {
		return x -> (x % number == 0);
	}

	public IntStream getFilteredStream(IntStream stream) {
		for (int i = FIRST_DIVISOR; i <= LAST_DIVISOR; ++i)
			stream = stream.filter(getModPredicate(i));
		return stream;
	}

	@Override
	public Integer getCalculatedSolution() {
		IntStream naturalNumbers = IntStream.iterate(1, i -> i + 1);

		return getFilteredStream(naturalNumbers).findFirst().getAsInt();
	}

	@Override
	public Integer getExpectedSolution() {
		return 232792560;
	}
}
