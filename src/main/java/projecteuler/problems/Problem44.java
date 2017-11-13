package projecteuler.problems;

import java.util.Comparator;
import java.util.Objects;
import java.util.Set;
import java.util.stream.LongStream;

import static java.lang.Math.abs;
import static java.util.stream.Collectors.toSet;

@SuppressWarnings("ConstantConditions")
public class Problem44 implements Problem<Long> {
    
    private static final int MAX = 10000;
    
    @Override
    public Long getCalculatedSolution() {
        Set<Long> pentagonalNumbers = LongStream.rangeClosed(1, MAX)
                .map(n -> n * (3 * n - 1) / 2)
                .boxed()
                .collect(toSet());
        
        return pentagonalNumbers.stream().flatMap(j ->
                // since they are unique, we can check the actual values, not indexes
                pentagonalNumbers.stream().filter(k -> !Objects.equals(j, k)).map(k -> new Pair(j, k))
        )
                .parallel()
                .filter(pair -> pentagonalNumbers.contains(pair.j + pair.k) && pentagonalNumbers.contains(abs(pair.j - pair.k)))
                .min(Comparator.comparing(Problem44::criteriaForD))
                .map(Problem44::criteriaForD)
                .orElseThrow(AssertionError::new);
    }
    
    private static long criteriaForD(Pair pair) {
        return abs(pair.j - pair.k);
    }
    
    @Override
    public Long getExpectedSolution() {
        return 5482660L;
    }
    
    private static class Pair {
        final long j, k;
        
        private Pair(long j, long k) {
            this.j = j;
            this.k = k;
        }
    }
}
