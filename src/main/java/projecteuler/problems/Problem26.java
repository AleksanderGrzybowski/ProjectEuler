package projecteuler.problems;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

@SuppressWarnings("ConstantConditions")
public class Problem26 implements Problem<Integer> {
    
    private static final int MAX_D = 1000;
    
    @Override
    public Integer getCalculatedSolution() {
        return IntStream.range(2, MAX_D).boxed()
                .max(Comparator.comparing(Problem26::lengthOfCycle))
                .get();
    }
    
    private static int lengthOfCycle(int divisor) {
        Set<Integer> digitsInFractionalRepresentation = new HashSet<>();
        int dividend = 10;
        
        while (!digitsInFractionalRepresentation.contains(dividend)) {
            digitsInFractionalRepresentation.add(dividend);
            dividend = (dividend % divisor) * 10;
        }
        
        return digitsInFractionalRepresentation.size();
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 983;
    }
}
