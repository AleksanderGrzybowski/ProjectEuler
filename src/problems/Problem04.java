package problems;

import annotations.Done;

@Done
public class Problem04 implements Problem<Integer> {

	public boolean isPalindrome(int number) {
		String numberString = Integer.toString(number);
		return new StringBuilder(numberString).reverse().toString().equals(numberString);
	}

	@Override
	public Integer getCalculatedSolution() {
		int currentBiggestPalindrome = 0;

		// 3-digit numbers
		for (int i = 100; i <= 999; ++i) {
			for (int j = 100; j <= 999; ++j) {
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
