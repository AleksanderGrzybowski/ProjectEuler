package projecteuler.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;

public class Problem02 implements Problem<Integer> {
    
    private static final IntPredicate IS_EVEN = i -> i % 2 == 0;
    
    @Override
    public Integer getCalculatedSolution() {
        return fibonacciUpTo(4_000_000).stream()
                .mapToInt(e -> e)
                .filter(IS_EVEN)
                .sum();
    }
    
    private List<Integer> fibonacciUpTo(int limit) {
        List<Integer> elements = new ArrayList<>();
        
        int a = 1;
        int b = 2;
        
        elements.add(a);
        elements.add(b);
        
        while (b <= limit) {
            int temp = b;
            b = a + b;
            a = temp;
            elements.add(b);
        }
        
        return elements;
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 4613732;
    }
}
