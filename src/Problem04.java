public class Problem04 {

	public static boolean isPalindrome(int number) {
		String numberString = "" + number;
		return new StringBuilder(numberString).reverse().toString().equals(numberString);
	}

	public static void main(String[] args) {
		int currentBiggestPalindrome = 0;

		for (int i = 100; i <= 999; ++i)
			for (int j = 100; j <= 999; ++j)
				if (isPalindrome(i * j))
					currentBiggestPalindrome = i * j;

		System.out.println(currentBiggestPalindrome);
	}
}
