package projecteuler.problems;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Problem20 implements Problem<Integer> {
    
    @Override
    public Integer getCalculatedSolution() {
        return Arrays.stream(
                IntStream.rangeClosed(1, 100)
                        .mapToObj(BigInteger::valueOf)
                        .reduce(BigInteger.ONE, BigInteger::multiply)
                        .toString().split("")
        )
                .mapToInt(Integer::parseInt)
                .sum();
        
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 648;
    }
}
