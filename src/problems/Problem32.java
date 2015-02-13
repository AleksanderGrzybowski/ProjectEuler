package problems;

import annotations.Done;

import java.util.*;
import java.util.stream.Collectors;

@Done
public class Problem32 implements Problem<Integer> {

	static List<Integer> expected1to9 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

	static boolean isPandigitalFrom1To9(long number) {
		String numberString = Long.toString(number);
		List<Integer> digits = numberString.chars().map(i -> i - '0').boxed().collect(Collectors.toList());

		Collections.sort(digits);
		return digits.equals(expected1to9);
	}

	private static boolean canBeWritten(int i, int j) {
		return isPandigitalFrom1To9(Long.parseLong("" + i + j + (i * j)));
	}

	@Override
	public Integer getCalculatedSolution() {
		Set<Integer> result = new HashSet<>();

		for (int i = 1; i < 2000; ++i) {
			for (int j = 1; j < 2000; ++j) {
				if (canBeWritten(i, j)) {
					result.add(i * j);
				}
			}
		}
		return result.stream().mapToInt(i -> i).sum();
	}

	@Override
	public Integer getExpectedSolution() {
		return 45228;
	}
}
