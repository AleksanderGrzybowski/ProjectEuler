import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;

/**
 * Created by kelog on 21.11.14.
 */




public class Problem02 {
	static class FibbonacciSupplier implements IntSupplier {

		int previous = 0;
		int current = 1;

		@Override
		public int getAsInt() {
			int result = previous + current;
			previous = current;
			current = result;
			return result;
		}
	}

	public static void main(String[] args) {

		IntPredicate maximumValueConstraint = i -> (i < 4_000_000);
		IntPredicate evenValueConstraint = i -> (i % 2 == 0);

		int sum = IntStream.generate(new FibbonacciSupplier())
				.filter(maximumValueConstraint)
				.filter(evenValueConstraint)
				.limit(1000)
				.sum();

		System.out.println(sum);
	}
}
