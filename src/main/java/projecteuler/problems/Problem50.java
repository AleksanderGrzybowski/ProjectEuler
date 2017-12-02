package projecteuler.problems;

import lombok.Data;
import projecteuler.PrimeCache;

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
        
        int currentResult = 0;
        int currentLength = 0;
        
        outer:
        for (int left = 0; left < primesBelowMillion.size(); ++left) {
            for (int right = left; right < primesBelowMillion.size(); ++right) {
                
                int sum = 0;
                for (int i = left; i < right; ++i) {
                    sum += primesBelowMillion.get(i);
                    if (sum > MAX) continue outer;
                }
                
                if (PrimeCache.INSTANCE.isPrime(sum) && ((right - left) > currentLength)) {
                    currentResult = sum;
                    currentLength = right - left;
                }
            }
        }
        
        return currentResult;
    }
    
    @Data
    private static class Pair {
        final int prime;
        final int seriesLength;
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 997651;
    }
}
