import java.util.stream.IntStream;

@Done
@TakesTime
public class Problem07 implements Problem<Integer> {


	@Override
	public Integer getCalculatedSolution() {
		IntStream naturalNumbers = IntStream.iterate(1, i -> i + 1);
		int index = 10_001;

		return naturalNumbers.filter(Utils::isPrimeLong).skip(index - 1).findFirst().getAsInt();
	}

	@Override
	public Integer getExpectedSolution() {
		return 104743;
	}
}
