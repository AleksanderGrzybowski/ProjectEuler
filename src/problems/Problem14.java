package problems;

import annotations.Done;

import java.util.Comparator;
import java.util.stream.IntStream;

@Done
public class Problem14 implements Problem<Integer> {

	int getCollatzSequenceLength(long number) {
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

	public Integer getCalculatedSolution_faster() {
		int currentMaxLength = 0;
		int numberWeSearchFor = 1;

		for (int i = 1; i < 1_000_000; ++i) {
			int length = getCollatzSequenceLength(i);
			if (length > currentMaxLength) {
				currentMaxLength = length;
				numberWeSearchFor = i;
			}
		}

		return numberWeSearchFor;
	}

	@Override
	public Integer getCalculatedSolution() {
		return IntStream.range(1, 1_000_000).boxed().max(Comparator.comparing(i -> getCollatzSequenceLength(i))).get();
	}

	@Override
	public Integer getExpectedSolution() {
		return 837799;
	}
}
