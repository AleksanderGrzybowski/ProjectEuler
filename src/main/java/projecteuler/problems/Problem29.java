package projecteuler.problems;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class Problem29 implements Problem<Integer> {
    
    @Override
    public Integer getCalculatedSolution() {
        return (int) range().mapToObj(BigInteger::valueOf)
                .flatMap(a -> range().mapToObj(a::pow))
                .distinct()
                .count();
    }
    
    private IntStream range() {
        return IntStream.rangeClosed(2, 100);
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 9183;
    }
}
