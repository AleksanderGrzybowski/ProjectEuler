package projecteuler.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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
        return primes().filter(i -> value % i == 0).findFirst().getAsInt();
    }
    
    private static IntStream primes() {
        return naturalNumbers().filter(i -> IntStream.range(2, i).allMatch(e -> i % e != 0));
    }
    
    private static IntStream naturalNumbers() {
        return IntStream.iterate(2, i -> i + 1);
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 6857;
    }
}
