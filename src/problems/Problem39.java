package problems;

import annotations.Done;
import utils.Triple;

import java.util.Arrays;
import java.util.HashSet;

@Done
public class Problem39 implements Problem<Integer> {

	public static int numberOfSolutionsFor(int p) {
		HashSet<Triple> triangles = new HashSet<>();

		for (int a = 1; a <= (p - 2); ++a) {
			for (int b = 1; b <= (p - 2); ++b) {

				int c = p - b - a;
				// naive, but works
				if ((a + b + c != p) || c <= 0) {
					continue;
				}

				if (a * a + b * b == c * c) {
					int[] sides = new int[]{a, b, c};
					Arrays.sort(sides);
					triangles.add(new Triple(sides[0], sides[1], sides[2]));
				}
			}
		}
		return triangles.size();
	}

	@Override
	public Integer getCalculatedSolution() {
		int currentMaxP = 0;
		int currentMaxSols = 0;

		final int MIN_P = 3;
		final int MAX_P = 1000;

		for (int p = MIN_P; p <= MAX_P; ++p) {
			int nSols = numberOfSolutionsFor(p);

			if (currentMaxSols < nSols) {
				currentMaxP = p;
				currentMaxSols = nSols;
			}
		}
		return currentMaxP;
	}

	@Override
	public Integer getExpectedSolution() {
		return 840;
	}
}
