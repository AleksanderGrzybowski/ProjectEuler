import java.util.stream.IntStream;

@Done
public class Problem07 implements Problem<Integer> {

	public static boolean isPrime(int number) {
		return (number != 1) && IntStream.range(2, number).parallel().noneMatch(i -> number % i == 0);
	}

	@Override
	public Integer getCalculatedSolution() {
		IntStream naturalNumbers = IntStream.iterate(1, i -> i + 1);
		int index = 10_001;

		return naturalNumbers.filter(Problem07::isPrime).skip(index - 1).findFirst().getAsInt();
	}

	@Override
	public Integer getExpectedSolution() {
		return 104743;
	}
}
