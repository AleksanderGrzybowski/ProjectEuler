package projecteuler.problems;

import java.util.stream.IntStream;

public class Problem06 implements Problem<Integer> {
    
    @Override
    public Integer getCalculatedSolution() {
        return square(range().sum()) - range().map(this::square).sum();
    }
    
    private IntStream range() {
        return IntStream.rangeClosed(1, 100);
    }
    
    private int square(int number) {
        return number * number;
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 25164150;
    }
}
