package problems;

import annotations.Done;

@Done
public class Problem05 implements Problem<Integer> {

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
		final int FIRST_DIVISOR = 1;
		final int LAST_DIVISOR = 20;

		outer:
		for (int number = 2; true; number += 2) { // small optimize - only even numbers considered
			for (int divisor = FIRST_DIVISOR; divisor <= LAST_DIVISOR; ++divisor) {
				if (number % divisor != 0) {
					continue outer;
				}
			}
			return number;
		}
	}

	@Override
	public Integer getExpectedSolution() {
		return 232792560;
	}
}
