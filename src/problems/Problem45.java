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
		LongUnaryOperator triangleMapper = i -> (i * (i + 1)) / 2;
		LongUnaryOperator pentagonalMapper = i -> (i * (3 * i - 1)) / 2;
		LongUnaryOperator hexagonalMapper = i -> (i * (2 * i - 1));

		Set<Long> triangle = LongStream.rangeClosed(1, 1000000).map(triangleMapper).boxed().collect(Collectors.toSet());
		Set<Long> pentagonal = LongStream.rangeClosed(1, 1000000).map(pentagonalMapper).boxed().collect(Collectors.toSet());
		Set<Long> hexagonal = LongStream.rangeClosed(1, 1000000).map(hexagonalMapper).boxed().collect(Collectors.toSet());

		triangle.retainAll(pentagonal);
		triangle.retainAll(hexagonal);

		return triangle.stream().skip(2).findFirst().get();
	}

	@Override
	public Long getExpectedSolution() {
		return 1533776805L;
	}
}
