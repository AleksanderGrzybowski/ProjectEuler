package projecteuler.problems;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Problem01 implements Problem<Integer> {
    
    @Override
    public Integer getCalculatedSolution() {
        return IntStream.range(1, 1000)
                .filter(isMultipleOf(3).or(isMultipleOf(5)))
                .sum();
    }
    
    private IntPredicate isMultipleOf(int factor) {
        return number -> number % factor == 0;
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 233168;
    }
}
