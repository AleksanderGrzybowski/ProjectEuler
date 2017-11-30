package projecteuler.problems;

import projecteuler.PrimeCache;

import java.util.Comparator;
import java.util.stream.IntStream;

@SuppressWarnings("ConstantConditions")
public class Problem27 implements Problem<Integer> {
    
    @Override
    public Integer getCalculatedSolution() {
        return range().boxed()
                .flatMap(a -> range().mapToObj(b -> new Pair(a, b)))
                .parallel()
                .max(Comparator.comparing(Problem27::maxNumberOfPrimes))
                .map(pair -> pair.a * pair.b)
                .get();
    }
    
    private static IntStream range() {
        return IntStream.rangeClosed(-999, 999);
    }
    
    @SuppressWarnings("ResultOfMethodCallIgnored")
    private static int maxNumberOfPrimes(Pair pair) {
        int[] primesCount = new int[1];
        
        IntStream.iterate(0, i -> i + 1)
                .map(n -> n * n + pair.a * n + pair.b)
                .peek(i -> primesCount[0]++)
                .anyMatch(i -> !PrimeCache.INSTANCE.isPrime(i));
        
        return primesCount[0];
    }
    
    
    private static class Pair {
        final int a, b;
        
        private Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    
    @Override
    public Integer getExpectedSolution() {
        return -59231;
    }
}
