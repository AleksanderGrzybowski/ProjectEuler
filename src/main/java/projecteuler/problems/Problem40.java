package projecteuler.problems;

import java.util.stream.IntStream;

public class Problem40 implements Problem<Integer> {
    
    private static final int MAX_LENGTH = 1_000_000;
    private static final int MAX_POWER_OF_TEN = 6;
    
    @Override
    public Integer getCalculatedSolution() {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; builder.length() <= MAX_LENGTH; i++) {
            builder.append(i);
        }
        
        return powersOfTen(MAX_POWER_OF_TEN)
                .map(i -> Integer.parseInt("" + builder.charAt(i - 1)))
                .reduce(1, (a, b) -> a * b);
    }
    
    private IntStream powersOfTen(int max) {
        return IntStream.rangeClosed(0, max - 1).map(i -> (int) Math.pow(10, i));
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 210;
    }
}
