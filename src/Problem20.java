import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.LongStream;

@Done
public class Problem20 implements Problem<Integer> {
	static BigInteger factorial(int number) {
		return LongStream.rangeClosed(1, number).boxed().map(BigInteger::valueOf)
				.reduce(BigInteger.ONE, (a,b) -> a.multiply(b));
	}

	@Override
	public Integer getCalculatedSolution() {
		return Arrays.stream(factorial(100).toString().split(""))
				.mapToInt(Integer::valueOf)
				.sum();
	}

	@Override
	public Integer getExpectedSolution() {
		return 648;
	}
}
