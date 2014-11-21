import java.util.function.IntPredicate;
import java.util.stream.IntStream;

@Done
public class Problem01 implements Problem<Integer> {

	@Override
	public Integer getCalculatedSolution() {
		IntPredicate isDivisibleBy3 = (i) -> (i % 3 == 0);
		IntPredicate isDivisibleBy5 = (i) -> (i % 5 == 0);
		IntPredicate criteria = isDivisibleBy3.or(isDivisibleBy5);

		int startNumberInclusive = 0;
		int endNumberInclusive = 999;

		return IntStream.rangeClosed(startNumberInclusive, endNumberInclusive)
				.filter(criteria)
				.sum();
	}

	@Override
	public Integer getExpectedSolution() {
		return 233168;
	}

	public static void main(String[] args) {
		Tests.testClass(Thread.currentThread().getStackTrace()[1].getClassName());
	}
}
