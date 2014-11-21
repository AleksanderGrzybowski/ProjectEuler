import java.util.stream.LongStream;

@Done
public class Problem10 implements Problem<Long> {

	public static boolean isPrime(long number) {
		return (number != 1) && LongStream.rangeClosed(2, (long)(Math.sqrt(number))).parallel().noneMatch(i -> number % i == 0);
	}

	@Override
	public Long getCalculatedSolution() {
		long sum = LongStream.range(1, 2_000_000)
				.filter(Problem10::isPrime)
				.sum();

		return sum;
	}

	@Override
	public Long getExpectedSolution() {
		return 142913828922L;
	}
}
