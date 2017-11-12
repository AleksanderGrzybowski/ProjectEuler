package projecteuler.problems;

import java.util.function.Function;
import java.util.stream.IntStream;

public class Problem21 implements Problem<Integer> {
    
    private static final Function<Integer, Integer> D = Common.memoized(Problem21::sumOfproperDivisors);
    
    @Override
    public Integer getCalculatedSolution() {
        int sum = 0;
        
        for (int a = 0; a < 10000; a++) {
            for (int b = 0; b < 10000; b++) {
                if (a == b) break;
                if (D.apply(a) == b && D.apply(b) == a) {
                    sum += a + b;
                }
            }
        }
        
        return sum;
    }
    
    static int sumOfproperDivisors(int number) {
        return IntStream.range(1, number).filter(i -> number % i == 0).sum();
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 31626;
    }
}
