import java.util.stream.IntStream;

/**
 * Created by kelog on 21.11.14.
 */
public class Problem07 {
	public static boolean isPrime(int number) {
		if (number == 1) return false;

		for (int i = 2; i < number; ++i)
			if (number % i == 0)
				return false;
		return true;
	}

	public static void main(String[] args) {
		IntStream naturalNumbers = IntStream.iterate(1, i -> i + 1);
		int index = 10_001;

		int result = naturalNumbers.filter(Problem07::isPrime).skip(index - 1).findFirst().getAsInt();

		System.out.println(result);

	}
}
