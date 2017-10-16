package projecteuler.problems;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ConstantConditions")
public class Problem03 implements Problem<Integer> {
    
    @Override
    public Integer getCalculatedSolution() {
        return factorize(600851475143L).stream()
                .max(Integer::compareTo)
                .get();
    }
    
    private List<Integer> factorize(long number) {
        List<Integer> factors = new ArrayList<>();
        
        while (number != 1) {
            int factor = smallestPrimeFactorOf(number);
            factors.add(factor);
            number /= factor;
        }
        
        return factors;
    }
    
    private static int smallestPrimeFactorOf(long value) {
        return Common.primes().filter(i -> value % i == 0).findFirst().getAsInt();
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 6857;
    }
}
