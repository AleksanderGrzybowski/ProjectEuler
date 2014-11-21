import java.util.stream.LongStream;

@Done
public class Problem10 {

	public static boolean isPrime(long number) {
		return (number != 1) && LongStream.rangeClosed(2, (long)(Math.sqrt(number))).parallel().noneMatch(i -> number % i == 0);
	}

	public static void main(String[] args) {
		long sum = LongStream.range(1, 2_000_000)
				.filter(Problem10::isPrime)
				.sum();

		System.out.println(sum);

	}
}
