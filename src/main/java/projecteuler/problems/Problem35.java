package projecteuler.problems;

import projecteuler.PrimeCache;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

import static projecteuler.problems.Common.memoized;

public class Problem35 implements Problem<Long> {
    
    private static final int LIMIT = 1_000_000;
    private static Function<Integer, Boolean> IS_PRIME = memoized(Common::isPrime);
    
    @Override
    public Long getCalculatedSolution() {
        return IntStream.range(2, LIMIT).boxed()
                .filter(i -> PrimeCache.INSTANCE.isPrime(i) && isCircularPrime(i))
                .count();
    }
    
    private static boolean isCircularPrime(int number) {
        return allRotationsOf(Integer.toString(number))
                .stream()
                .allMatch(PrimeCache.INSTANCE::isPrime);
    }
    
    private static List<Integer> allRotationsOf(String number) {
        List<Integer> rotations = new ArrayList<>();
        
        for (int i = 0; i < number.length(); i++) {
            char first = number.charAt(0);
            number = number.substring(1) + first;
            rotations.add(Integer.parseInt(number));
        }
        
        return rotations;
    }
    
    @Override
    public Long getExpectedSolution() {
        return 55L;
    }
}
