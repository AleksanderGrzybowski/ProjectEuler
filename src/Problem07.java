import java.util.stream.IntStream;

@Done
public class Problem07 {

	public static boolean isPrime(int number) {
		return (number != 1) && IntStream.range(2, number).parallel().noneMatch(i -> number % i == 0);
	}

	public static void main(String[] args) {
		IntStream naturalNumbers = IntStream.iterate(1, i -> i + 1);
		int index = 10_001;

		int result = naturalNumbers.filter(Problem07::isPrime).skip(index - 1).findFirst().getAsInt();

		System.out.println(result);
	}
}
