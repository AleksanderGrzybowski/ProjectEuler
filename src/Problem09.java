@Done
public class Problem09 implements Problem<Integer> {
	public static boolean isConditionMet(int a, int b, int c) {
		return (a + b + c == 1000) && (a * a + b * b == c * c);
	}

	@Override
	public Integer getCalculatedSolution() {
		for (int a = 1; a <= 999; ++a) {
			for (int b = 1; b <= 999; ++b) {
				for (int c = 1; c <= 999; ++c) {
					if (isConditionMet(a, b, c)) {
						return a * b * c;
					}
				}
			}
		}
		throw new AssertionError();
	}

	@Override
	public Integer getExpectedSolution() {
		return 31875000;
	}
}
