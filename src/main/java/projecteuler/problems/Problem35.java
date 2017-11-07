package projecteuler.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

import static projecteuler.problems.Problem21.memoized;

public class Problem35 implements Problem<Integer> {
    
    private static final int LIMIT = 1_000_000;
    private static Function<Integer, Boolean> IS_PRIME = memoized(Common::isPrime);
    
    @Override
    public Integer getCalculatedSolution() {
        return (int) IntStream.range(2, LIMIT).boxed()
                .filter(i -> IS_PRIME.apply(i) && isCircularPrime(i))
                .count();
    }
    
    private boolean isCircularPrime(int i) {
        return allRotationsOf(Integer.toString(i)).stream().allMatch(j -> IS_PRIME.apply(j));
    }
    
    private List<Integer> allRotationsOf(String number) {
        List<Integer> rotations = new ArrayList<>();
        
        for (int i = 0; i < number.length(); i++) {
            char first = number.charAt(0);
            number = number.substring(1) + first;
            rotations.add(Integer.parseInt(number));
        }
        
        return rotations;
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 55;
    }
}
