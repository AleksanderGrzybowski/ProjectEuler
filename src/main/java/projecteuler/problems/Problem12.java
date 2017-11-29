package projecteuler.problems;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;

@SuppressWarnings("ConstantConditions")
public class Problem12 implements Problem<Integer> {
    
    private static final int DESIRED_DIVISORS_THRESHOLD = 500;
    
    @Override
    public Integer getCalculatedSolution() {
        return triangleNumbers()
                .filter(Problem12::hasEnoughDivisors)
                .findFirst().getAsInt();
    }
    
    private static boolean hasEnoughDivisors(int i) {
        return countDivisors(i) > DESIRED_DIVISORS_THRESHOLD;
    }
    
    private static long countDivisors(int number) {
        int sqrt = (int) Math.sqrt(number);
        int correction = (sqrt * sqrt == number) ? -1 : 0;
        
        return 2 * IntStream.rangeClosed(1, sqrt).filter(i -> number % i == 0).count() + correction;
    }
    
    private static IntStream triangleNumbers() {
        return IntStream.generate(new IntSupplier() {
            int next = 1;
            int sum = 0;
            
            @Override
            public int getAsInt() {
                sum += next;
                next++;
                return sum;
            }
        });
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 76576500;
    }
}
