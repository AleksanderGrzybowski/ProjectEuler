package problems;

import annotations.Done;
import utils.Pair;

import java.util.HashSet;
import java.util.Set;

@Done
public class Problem33 implements Problem<Integer> {

	public static final double DELTA = 0.001;

	static int gcd(int a, int b) {
		if (a > b) {
			return gcd(a - b, b);
		} else if (a < b) {
			return gcd(a, b - a);
		} else
			return a;
	}

	static boolean isCuriousFraction(int num, int den) {
		double beforeValue = (double) num / den;

		// fraction is in form (ab)/(cd)
		int a = num / 10;
		int b = num % 10;

		int c = den / 10;
		int d = den % 10;

		double afterValue;

		if (a == c) {
			afterValue = (double) b / d;
		} else if (a == d) {
			afterValue = (double) b / c;
		} else if (b == c) {
			afterValue = (double) a / d;
		} else if (b == d) {
			afterValue = (double) a / c;
		} else {
			return false;
		}

		return Math.abs(afterValue - beforeValue) < DELTA;
	}

	@Override
	public Integer getCalculatedSolution() {
		Set<Pair> resultSet = new HashSet<>();

		for (int den = 1; den <= 99; ++den) {
			for (int num = 1; num < den; ++num) {

				// it's unclear what "trivial case" means, this shows to be it!
				if (num % 10 == 0 || den % 10 == 0 || num <= 9 || den <= 9) {
					continue;
				}

				if (isCuriousFraction(num, den)) {
					resultSet.add(new Pair(num, den));
				}
			}
		}

		int productNum = resultSet.stream().mapToInt(p -> p.a).reduce(1, (t, u) -> t * u);
		int productDen = resultSet.stream().mapToInt(p -> p.b).reduce(1, (t, u) -> t * u);

		return productDen / gcd(productDen, productNum);
	}

	@Override
	public Integer getExpectedSolution() {
		return 100;
	}
}
