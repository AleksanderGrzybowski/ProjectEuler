package problems;

import annotations.Done;
import utils.Common;

import java.util.Arrays;

@Done
public class Problem24 implements Problem<Long> {

	@Override
	public Long getCalculatedSolution() {
		// this is permutation number 1
		int[] tab = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

		// so we need 999.999 iterations to get the 1.000.000 one
		for (int i = 0; i < 999_999; ++i) {
			Common.nextPermutationMutating(tab);
		}

		return Long.parseLong(Arrays.stream(tab)
				.mapToObj(Integer::toString)
				.reduce((a, b) -> a + b).get());
	}

	@Override
	public Long getExpectedSolution() {
		return 2783915460L;
	}
}
