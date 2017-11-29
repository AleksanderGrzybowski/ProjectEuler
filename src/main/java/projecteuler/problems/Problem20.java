package projecteuler.problems;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Problem20 implements Problem<Integer> {
    
    @Override
    public Integer getCalculatedSolution() {
        return Arrays.stream(
                range()
                        .mapToObj(BigInteger::valueOf)
                        .reduce(BigInteger.ONE, BigInteger::multiply)
                        .toString().split("")
        )
                .mapToInt(Integer::parseInt)
                .sum();
    }
    
    private static IntStream range() {
        return IntStream.rangeClosed(1, 100);
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 648;
    }
}
