@Done
public class Problem09 {
	public static boolean isConditionMet(int a, int b, int c) {
		return (a + b + c == 1000) && (a * a + b * b == c * c);
	}

	public static void main(String[] args) {
		outer:
		for (int a = 1; a <= 999; ++a) {
			for (int b = 1; b <= 999; ++b) {
				for (int c = 1; c <= 999; ++c) {
					if (isConditionMet(a, b, c)) {
						System.out.println(a * b * c);
						break outer;
					}
				}
			}
		}
	}
}
