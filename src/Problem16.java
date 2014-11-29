import java.math.BigInteger;
import java.util.Arrays;

@Done
public class Problem16 implements Problem<Integer> {

	@Override
	public Integer getCalculatedSolution() {
		int sum = Arrays.stream(
				BigInteger.valueOf(2).pow(1000).toString().split("")
		).mapToInt(Integer::parseInt).sum();

		return sum;
	}

	@Override
	public Integer getExpectedSolution() {
		return 1366;
	}
}
