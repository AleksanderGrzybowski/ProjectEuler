package problems;

import annotations.Done;

import java.util.Arrays;

@Done
public class Problem24 implements Problem<Long> {

	@Override
	public Long getCalculatedSolution() {

		int[] tab = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}; // this is permutation number 1
		for (int i = 0; i < 999_999; ++i) // so we need 999.999 iterations to get the 1.000.000 one
			nextPermutationMutating(tab);

		return Long.parseLong(Arrays.stream(tab)
						.mapToObj(i -> "" + i)
						.reduce((a, b) -> a + b).get());
	}

	@Override
	public Long getExpectedSolution() {
		return 2783915460L;
	}

	// algorithm ripped off from notes from AiSD course
	public static void nextPermutationMutating(int[] tab) {
		int i;
		for (i = tab.length - 2; ; i--) {
			if (tab[i] < tab[i + 1])
				break;
		}
		// i and i+1 are set now!

		int curMinIndex = i + 1;
		for (int j = (i + 1); j < tab.length; ++j) {
			if (tab[j] < tab[curMinIndex] && tab[j] > tab[i])
				curMinIndex = j;
		}

		int tmp = tab[curMinIndex];
		tab[curMinIndex] = tab[i];
		tab[i] = tmp;

		// reverse on the right
		int lenToRev = (tab.length - i - 1);
		for (int offs = 0; offs < lenToRev / 2; ++offs) {
			int tmpa = tab[i + 1 + offs];
			tab[i + 1 + offs] = tab[tab.length - 1 - offs];
			tab[tab.length - 1 - offs] = tmpa;
		}
	}
}
