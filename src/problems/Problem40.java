package problems;

import annotations.Done;

@Done
public class Problem40 implements Problem<Integer> {

	@Override
	public Integer getCalculatedSolution() {
		StringBuilder sb = new StringBuilder();
		int i = 1;

		while (sb.length() <= 1000000) {
			sb.append(i);
			i++;
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
