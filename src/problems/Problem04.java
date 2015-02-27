package problems;

import annotations.Done;

@Done
public class Problem04 implements Problem<Integer> {

	public boolean isPalindrome(int number) {
		String orig = Integer.toString(number);
		String reversed = new StringBuilder(orig).reverse().toString();

		return reversed.equals(orig);
	}

	@Override
	public Integer getCalculatedSolution() {
		int currentBiggestPalindrome = 0;

		final int FIRST = 100;
		final int LAST = 999;

		for (int i = FIRST; i <= LAST; ++i) {
			for (int j = FIRST; j <= LAST; ++j) {
				int product = i * j;
				if (isPalindrome(product) && (product > currentBiggestPalindrome)) {
					currentBiggestPalindrome = product;
				}
			}
		}

		return currentBiggestPalindrome;
	}

	@Override
	public Integer getExpectedSolution() {
		return 906609;
	}
}
