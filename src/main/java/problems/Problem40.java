package problems;

import annotations.Done;

@Done
public class Problem40 implements Problem<Integer> {

	@Override
	public Integer getCalculatedSolution() {
		StringBuilder sb = new StringBuilder();

		final int MAX_N = 1000000;
		for (int i = 1; sb.length() <= MAX_N; ++i) {
			sb.append(i);
		}

		int[] positions = new int[]{1, 10, 100, 1000, 10000, 100000};
		int product = 1;

		for (int pos : positions)
			product *= Integer.parseInt("" + sb.charAt(pos - 1));

		return product;
	}

	@Override
	public Integer getExpectedSolution() {
		return 210;
	}
}
