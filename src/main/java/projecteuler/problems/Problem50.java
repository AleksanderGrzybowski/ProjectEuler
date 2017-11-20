package projecteuler.problems;

import projecteuler.PrimeCache;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SuppressWarnings("ConstantConditions")
public class Problem50 implements Problem<Integer> {
    
    private static final int MAX = 1_000_000;
    
    @Override
    public Integer getCalculatedSolution() {
        List<Integer> primesBelowMillion = IntStream.rangeClosed(2, MAX).boxed()
                .filter(PrimeCache.INSTANCE::isPrime)
                .collect(Collectors.toList());
        
        return primesBelowMillion.parallelStream().map(prime -> {
            int maxCount = IntStream.range(0, primesBelowMillion.size()).boxed().map(left -> {
                int sum = 0, count = 0;
                
                for (int walking = left; walking < primesBelowMillion.size() && sum < prime && sum <= MAX; ++walking) {
                    count++;
                    sum += primesBelowMillion.get(walking);
                }
                
                return sum == prime ? count : Integer.MIN_VALUE;
            }).max(Integer::compareTo).get();
            
            return new Pair(prime, maxCount);
        }).max(Comparator.comparing(pair -> pair.seriesLength)).get().prime;
    }
    
    private static class Pair {
        final int prime;
        final int seriesLength;
        
        private Pair(int prime, int seriesLength) {
            this.prime = prime;
            this.seriesLength = seriesLength;
        }
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 997651;
    }
}
