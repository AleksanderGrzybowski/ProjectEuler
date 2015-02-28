package problems;

import annotations.Done;

import java.util.Set;
import java.util.function.LongUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@Done
public class Problem45 implements Problem<Long> {

	@Override
	public Long getCalculatedSolution() {
		LongUnaryOperator triangleFunction = i -> (i * (i + 1)) / 2;
		LongUnaryOperator pentagonalFunction = i -> (i * (3 * i - 1)) / 2;
		LongUnaryOperator hexagonalFunction = i -> (i * (2 * i - 1));

		final int LIMIT = 1000000;
		Set<Long> triangle = LongStream.rangeClosed(1, LIMIT).map(triangleFunction).boxed().collect(Collectors.toSet());
		Set<Long> pentagonal = LongStream.rangeClosed(1, LIMIT).map(pentagonalFunction).boxed().collect(Collectors.toSet());
		Set<Long> hexagonal = LongStream.rangeClosed(1, LIMIT).map(hexagonalFunction).boxed().collect(Collectors.toSet());

		triangle.retainAll(pentagonal);
		triangle.retainAll(hexagonal);

		return triangle.stream().skip(2).findFirst().get();
	}

	@Override
	public Long getExpectedSolution() {
		return 1533776805L;
	}
}
