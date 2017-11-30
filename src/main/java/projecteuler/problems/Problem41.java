package projecteuler.problems;

import projecteuler.PrimeCache;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

@SuppressWarnings("ConstantConditions")
public class Problem41 implements Problem<Integer> {
    
    // We must use a trick - we for sure know that 8 and 9 digit pandigitals are not prime,
    // because (1+2+...+7+8) is divisible by 3, the same for (1+...+9)
    private static final int MAX = 10_000_000;
    
    private static List<Set<Integer>> PANDIGITAL_SETS_CACHE = IntStream.rangeClosed(1, 9)
            .mapToObj(i -> IntStream.rangeClosed(1, i).boxed().collect(Collectors.toCollection(HashSet::new)))
            .collect(toList());
    
    @Override
    public Integer getCalculatedSolution() {
        return IntStream.range(1, MAX)
                .parallel()
                .filter(i -> isPandigital(i) && PrimeCache.INSTANCE.isPrime(i))
                .max().getAsInt();
    }
    
    // Also hand coded, stream version is too slow
    private static boolean isPandigital(int number) {
        Set<Integer> digits = new HashSet<>();
        int numberOfDigits = 0;
        
        while (number != 0) {
            int digit = number % 10;
            digits.add(digit);
            number /= 10;
            numberOfDigits++;
        }
        
        return PANDIGITAL_SETS_CACHE.get(numberOfDigits - 1).equals(digits);
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 7652413;
    }
}

