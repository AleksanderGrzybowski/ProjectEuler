package projecteuler.problems;

import java.util.stream.IntStream;

public class Problem34 implements Problem<Integer> {
    
    @Override
    public Integer getCalculatedSolution() {
        return range()
                .filter(Problem34::isCurious)
                .sum();
    }
    
    private static IntStream range() {
        return IntStream.rangeClosed(3, 50000);
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
