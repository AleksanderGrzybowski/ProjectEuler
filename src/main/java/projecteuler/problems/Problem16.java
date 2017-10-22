package projecteuler.problems;

import java.math.BigDecimal;
import java.util.Arrays;

public class Problem16 implements Problem<Integer> {
    
    @Override
    public Integer getCalculatedSolution() {
        return Arrays.stream(BigDecimal.valueOf(2).pow(1000).toString().split(""))
                .mapToInt(Integer::valueOf)
                .sum();
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 1366;
    }
}
