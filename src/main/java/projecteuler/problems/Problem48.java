package projecteuler.problems;

import java.math.BigInteger;
import java.util.stream.IntStream;

@SuppressWarnings("ConstantConditions")
public class Problem48 implements Problem<String> {
    
    private static final IntStream RANGE = IntStream.range(1, 1000);
    private static final int LAST_DIGITS = 10;
    
    @Override
    public String getCalculatedSolution() {
        String sum = RANGE
                .mapToObj(i -> BigInteger.valueOf(i).pow(i))
                .reduce(BigInteger::add)
                .get()
                .toString();
        
        return sum.substring(sum.length() - LAST_DIGITS);
    }
    
    @Override
    public String getExpectedSolution() {
        return "9110846700";
    }
}
