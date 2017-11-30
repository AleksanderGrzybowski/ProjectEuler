package projecteuler.problems;

import java.util.function.Function;

public class Problem21 implements Problem<Integer> {
    
    private static final Function<Integer, Integer> D = Common.memoized(Common::sumOfproperDivisors);
    private static final int MAX = 10000;
    
    @Override
    public Integer getCalculatedSolution() {
        int sum = 0;
        
        for (int a = 0; a < MAX; a++) {
            for (int b = 0; b < MAX; b++) {
                if (a == b) break;
                if (D.apply(a) == b && D.apply(b) == a) {
                    sum += a + b;
                }
            }
        }
        
        return sum;
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 31626;
    }
}
