package projecteuler.problems;

import java.util.stream.IntStream;

public class Problem32 implements Problem<Integer> {
    
    private static final int LIMIT = 2000;
    
    @Override
    public Integer getCalculatedSolution() {
        return IntStream.rangeClosed(1, LIMIT).flatMap(i ->
                IntStream.rangeClosed(1, LIMIT)
                        .filter(j -> Common.isPandigital1To9("" + i + j + (i * j)))
                        .map(j -> i * j)
        )
                .distinct()
                .sum();
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 45228;
    }
}
