package projecteuler.problems;

import java.util.stream.IntStream;

public class Problem34 implements Problem<Integer> {
    
    private static final int MAX = 50000;
    private static final int MIN = 3;
    
    @Override
    public Integer getCalculatedSolution() {
        return IntStream.rangeClosed(MIN, MAX)
                .filter(Problem34::isCurious)
                .sum();
    }
    
    private static boolean isCurious(int number) {
        return number == Integer.toString(number).chars()
                .map(i -> i - '0')
                .map(Problem34::factorial)
                .sum();
    }
    
    private static int factorial(int number) {
        return IntStream.rangeClosed(1, number).reduce(1, (a, b) -> a * b);
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 40730;
    }
}
