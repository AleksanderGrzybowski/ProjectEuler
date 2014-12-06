package problems;

import annotations.Done;

@Done
public class Problem15 implements Problem<Long> {

	static final int SIZE = 20;
	static long[][] tab = new long[SIZE + 1][SIZE + 1];

	@Override
	public Long getCalculatedSolution() {
		for (int i = 0; i <= SIZE; ++i) {
			tab[SIZE][i] = 1;
			tab[i][SIZE] = 1;
		}

		for (int row = SIZE -1; row >= 0; --row) {
			for (int col = SIZE -1; col >= 0; --col) {
				tab[row][col] = tab[row+1][col] + tab[row][col+1];
			}
		}

		return tab[0][0];
	}

	@Override
	public Long getExpectedSolution() {
		return 137846528820L;
	}
}

