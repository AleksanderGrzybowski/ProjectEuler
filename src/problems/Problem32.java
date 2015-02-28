package problems;

import annotations.Done;
import utils.Common;

import java.util.HashSet;
import java.util.Set;

@Done
public class Problem32 implements Problem<Integer> {

	private static boolean canBeWritten(int i, int j) {

		String numberString = "" + i + j + (i * j);
		long number = Long.parseLong(numberString);
		return numberString.length() == 9 && Common.isPandigital(number);
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
