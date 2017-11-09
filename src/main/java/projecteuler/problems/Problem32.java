package projecteuler.problems;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toSet;

public class Problem32 implements Problem<Integer> {
    
    private static final Set<String> PANDIGITAL_SET = Arrays.stream("123456789".split("")).collect(toSet());
    private static final int LIMIT = 2000;
    
    @Override
    public Integer getCalculatedSolution() {
        return IntStream.rangeClosed(1, LIMIT).flatMap(i ->
                IntStream.rangeClosed(1, LIMIT)
                        .filter(j -> isPandigital("" + i + j + (i * j)))
                        .map(j -> i * j)
        )
                .distinct()
                .sum();
    }
    
    static boolean isPandigital(String number) {
        return number.length() == 9 && Arrays.stream(number.split("")).collect(toSet()).equals(PANDIGITAL_SET);
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 45228;
    }
}
