@Done
public class Problem04 {

	public static boolean isPalindrome(int number) {
		String numberString = Integer.toString(number);
		return new StringBuilder(numberString).reverse().toString().equals(numberString);
	}

	public static void main(String[] args) {
		int currentBiggestPalindrome = 0;

		for (int i = 100; i <= 999; ++i)
			for (int j = 100; j <= 999; ++j)
				if (isPalindrome(i * j) && (i * j > currentBiggestPalindrome))
					currentBiggestPalindrome = i * j;

		System.out.println(currentBiggestPalindrome);
	}
}
