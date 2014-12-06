package problems;

import annotations.Done;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;

@Done
public class Problem12 implements Problem<Integer> {

	static class TriangleNumberSupplier implements IntSupplier {

		int sum = 0;
		int current = 1;

		@Override
		public int getAsInt() {
			sum += current;
			current++;
			return sum;
		}
	}

	int getNumberOfDivisors(int number) {
		int sqrt = (int) Math.sqrt(number);
		int correctionIfPerfectSquare = (sqrt * sqrt == number) ? -1 : 0;

		return  (int) IntStream.rangeClosed(1, sqrt)
				.filter(i -> number % i == 0)
				.count() * 2
				+ correctionIfPerfectSquare;
	}

	@Override
	public Integer getCalculatedSolution() {
		return IntStream.generate(new TriangleNumberSupplier())
				.filter(i -> getNumberOfDivisors(i) > 500)
				.findFirst().getAsInt();
	}

	@Override
	public Integer getExpectedSolution() {
		return 76576500;
	}
}
