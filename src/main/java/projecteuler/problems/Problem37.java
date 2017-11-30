package projecteuler.problems;

import projecteuler.PrimeCache;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Problem37 implements Problem<Integer> {
    
    private static final int MIN = 10;
    private static final int TRUNCATABLE_PRIMES_COUNT = 11;
    
    @Override
    public Integer getCalculatedSolution() {
        return IntStream.iterate(MIN, i -> i + 1)
                .filter(Problem37::areAllTruncationsPrimes)
                .limit(TRUNCATABLE_PRIMES_COUNT)
                .sum();
    }
    
    private static boolean areAllTruncationsPrimes(int i) {
        return allTruncations(Integer.toString(i)).allMatch(PrimeCache.INSTANCE::isPrime);
    }
    
    private static Stream<Integer> allTruncations(String number) {
        return Stream.concat(
                IntStream.range(0, number.length()).map(i -> Integer.valueOf(number.substring(i, number.length()))).boxed(),
                IntStream.range(1, number.length()).map(i -> Integer.valueOf(number.substring(0, i))).boxed()
        );
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 748317;
    }
}
