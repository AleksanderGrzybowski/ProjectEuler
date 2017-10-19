package projecteuler.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static projecteuler.problems.Common.primes;

@SuppressWarnings("ResultOfMethodCallIgnored")
public class Problem10 implements Problem<Long> {
    
    @Override
    public Long getCalculatedSolution() {
        return takeWhile(primes().boxed(), i -> i < 2_000_000).mapToLong(e -> e).sum();
    }
    
    @Override
    public Long getExpectedSolution() {
        return 142913828922L;
    }
    
    // https://stackoverflow.com/a/26919665
    // Ugly but works
    // Refactor this on Java 9
    private <T> Stream<T> takeWhile(Stream<T> stream, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        
        stream.peek(e -> {
            if (predicate.test(e)) {
                result.add(e);
            }
        }).allMatch(predicate);
        
        return result.stream(); // yea, fake crap
    }
}
