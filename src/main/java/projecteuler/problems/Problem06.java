package projecteuler.problems;

import java.util.stream.IntStream;

public class Problem06 implements Problem<Integer> {
    
    @Override
    public Integer getCalculatedSolution() {
        return square(range().sum()) - range().map(Problem06::square).sum();
    }
    
    private static IntStream range() {
        return IntStream.rangeClosed(1, 100);
    }
    
    private static int square(int number) {
        return number * number;
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 25164150;
    }
}
