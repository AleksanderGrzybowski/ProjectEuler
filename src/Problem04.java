@Done
public class Problem04 implements Problem<Integer> {

	public static boolean isPalindrome(int number) {
		String numberString = Integer.toString(number);
		return new StringBuilder(numberString).reverse().toString().equals(numberString);
	}

	@Override
	public Integer getCalculatedSolution() {
		int currentBiggestPalindrome = 0;

		for (int i = 100; i <= 999; ++i)
			for (int j = 100; j <= 999; ++j)
				if (isPalindrome(i * j) && (i * j > currentBiggestPalindrome))
					currentBiggestPalindrome = i * j;

		return currentBiggestPalindrome;
	}

	@Override
	public Integer getExpectedSolution() {
		return 906609;
	}
}
