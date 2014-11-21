import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;

@Done
public class Problem02 {

	static List<Integer> getFibbonacciNumbers(int maximumValue) {
		List<Integer> resultList = new ArrayList<>();
		int previous = 0;
		int current = 1;

		while (current < maximumValue) {
			resultList.add(current);
			int tmp = previous + current;
			previous = current;
			current = tmp;
		}

		return resultList;
	}

	public static void main(String[] args) {
		final int MAXIMUM_VALUE = 4_000_000;
		IntPredicate evenValueConstraint = i -> (i % 2 == 0);

		int sum = getFibbonacciNumbers(MAXIMUM_VALUE).stream().mapToInt(i -> i)
				.filter(evenValueConstraint)
				.limit(1000)
				.sum();

		System.out.println(sum);
	}
}
