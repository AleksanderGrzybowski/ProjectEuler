package projecteuler.problems;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Problem02 implements Problem<Integer> {
    
    private static final int LIMIT = 4_000_000;
    
    @Override
    public Integer getCalculatedSolution() {
        return fibonacciUpTo(LIMIT).stream()
                .mapToInt(e -> e)
                .filter(Problem02::isEven)
                .sum();
    }
    
    private static List<Integer> fibonacciUpTo(int limit) {
        List<Integer> fibonacciElements = new ArrayList<>();
        
        int a = 1;
        int b = 2;
        
        fibonacciElements.addAll(asList(a, b));
        
        while (b <= limit) {
            int previous = b;
            b = a + b;
            a = previous;
            fibonacciElements.add(b);
        }
        
        return fibonacciElements;
    }
    
    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 4613732;
    }
}
