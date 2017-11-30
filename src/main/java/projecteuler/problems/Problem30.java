package projecteuler.problems;

import java.util.stream.IntStream;

public class Problem30 implements Problem<Integer> {
    
    private static final int LIMIT = 1000000;
    
    @Override
    public Integer getCalculatedSolution() {
        return IntStream.range(2, LIMIT).parallel()
                .filter(Problem30::canBeWrittenAsSumOfFifthPowers)
                .sum();
    }
    
    private static boolean canBeWrittenAsSumOfFifthPowers(int number) {
        return number == Integer.toString(number).chars()
                .map(i -> (int) Math.pow(i - '0', 5))
                .sum();
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 443839;
    }
}
