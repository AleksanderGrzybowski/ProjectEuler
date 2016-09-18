package problems;

import annotations.Done;

import java.util.stream.IntStream;

@Done
public class Problem28 implements Problem<Integer> {

	public static final int SIZE = 1001;

	static int[][] tab = new int[SIZE][SIZE];
	static int value = 1;
	static int a = SIZE / 2;
	static int b = SIZE / 2;

	public static void iteration(int n) {
		for (int i = 0; i < (2 * n - 1); ++i) {
			tab[a][b] = value++;
			a++;
		}
		tab[a][b] = value++;

		for (int i = 0; i < 2 * n; ++i) {
			b--;
			tab[a][b] = value++;
		}

		for (int i = 0; i < 2 * n; ++i) {
			a--;
			tab[a][b] = value++;
		}

		for (int i = 0; i < 2 * n; ++i) {
			b++;
			tab[a][b] = value++;
		}

		b++;
	}

	static int sumOnDiagonals() {
		return IntStream.range(0, SIZE).map(i -> tab[i][i] + tab[SIZE - i - 1][i]).sum()
				- tab[SIZE / 2][SIZE / 2];
	}

	@Override
	public Integer getCalculatedSolution() {
		for (int i = 0; i < SIZE / 2 + 1; ++i) {
			iteration(i);
		}

		return sumOnDiagonals();
	}

	@Override
	public Integer getExpectedSolution() {
		return 669171001;
	}
}
