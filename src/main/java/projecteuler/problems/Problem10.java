package projecteuler.problems;

import projecteuler.PrimeCache;

import static projecteuler.problems.Common.takeWhile;

public class Problem10 implements Problem<Long> {
    
    private static final int LIMIT = 2_000_000;
    
    @Override
    public Long getCalculatedSolution() {
        return takeWhile(PrimeCache.INSTANCE.primes().boxed(), i -> i < LIMIT)
                .mapToLong(e -> e)
                .sum();
    }
    
    @Override
    public Long getExpectedSolution() {
        return 142913828922L;
    }
}
