package projecteuler.problems;

import static projecteuler.problems.Common.primes;

@SuppressWarnings("ResultOfMethodCallIgnored")
public class Problem10 implements Problem<Long> {
    
    @Override
    public Long getCalculatedSolution() {
        return Common.takeWhile(primes().boxed(), i -> i < 2_000_000).mapToLong(e -> e).sum();
    }
    
    @Override
    public Long getExpectedSolution() {
        return 142913828922L;
    }
    
}
