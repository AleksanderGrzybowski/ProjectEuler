package projecteuler.problems;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;

@SuppressWarnings("ConstantConditions")
public class Problem12 implements Problem<Integer> {
    
    @Override
    public Integer getCalculatedSolution() {
        return triangleNumbers().filter(i -> countDivisors(i) > 500).findFirst().getAsInt();
    }
    
    private long countDivisors(int number) {
        int sqrt = (int) Math.sqrt(number);
        int correction = (sqrt * sqrt == number) ? -1 : 0;
        
        return 2 * IntStream.rangeClosed(1, sqrt).filter(i -> number % i == 0).count() + correction;
    }
    
    private IntStream triangleNumbers() {
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
