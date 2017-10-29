package projecteuler.problems;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

@SuppressWarnings("ConstantConditions")
public class Problem26 implements Problem<Integer> {
    
    @Override
    public Integer getCalculatedSolution() {
        return IntStream.range(2, 1000).boxed().max(Comparator.comparing(Problem26::lengthOfCycle)).get();
    }
    
    private static int lengthOfCycle(int b) {
        Set<Integer> numbers = new HashSet<>();
        int a = 10;
        
        while (!numbers.contains(a)) {
            numbers.add(a);
            a = (a % b) * 10;
        }
        
        return numbers.size();
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 983;
    }
}
