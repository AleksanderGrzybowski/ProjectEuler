package problems;

import annotations.Done;

@Done

public class Problem05 implements Problem<Integer> {

	static final int FIRST_DIVISOR = 1;
	static final int LAST_DIVISOR = 20;

	// the following solution is way more Java-8-ish, but slow...
//	public IntPredicate getModPredicate(int number) {
//		return x -> (x % number == 0);
//	}
//
//	public IntStream getFilteredStream(IntStream stream) {
//		for (int i = FIRST_DIVISOR; i <= LAST_DIVISOR; ++i)
//			stream = stream.filter(getModPredicate(i));
//		return stream;
//	}
//
//		@Override
//	public Integer getCalculatedSolution() {
//		IntStream naturalNumbers = IntStream.iterate(1, i -> i + 1);
//
//		return getFilteredStream(naturalNumbers).findFirst().getAsInt();
//	}

	@Override
	public Integer getCalculatedSolution() {
		outer:
		for (int number = 1; true; number++) {
			for (int divisor = FIRST_DIVISOR; divisor <= LAST_DIVISOR; ++divisor)
				if (number % divisor != 0)
					continue outer;
			return number;
		}
	}

	@Override
	public Integer getExpectedSolution() {
		return 232792560;
	}
}
