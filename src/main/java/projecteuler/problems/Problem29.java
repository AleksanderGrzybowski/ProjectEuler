package projecteuler.problems;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class Problem29 implements Problem<Long> {
    
    @Override
    public Long getCalculatedSolution() {
        return range().mapToObj(BigInteger::valueOf)
                .flatMap(a -> range().mapToObj(a::pow))
                .distinct()
                .count();
    }
    
    private static IntStream range() {
        return IntStream.rangeClosed(2, 100);
    }
    
    @Override
    public Long getExpectedSolution() {
        return 9183L;
    }
}
