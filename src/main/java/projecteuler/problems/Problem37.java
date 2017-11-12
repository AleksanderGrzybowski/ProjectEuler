package projecteuler.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

import static projecteuler.problems.Common.memoized;

public class Problem37 implements Problem<Integer> {
    
    private static final int MIN = 10;
    private static final int COUNT = 11;
    private static Function<Integer, Boolean> IS_PRIME = memoized(Common::isPrime);
    
    @Override
    public Integer getCalculatedSolution() {
        return IntStream.iterate(MIN, i -> i + 1)
                .filter(Problem37::areAllTruncationsPrimes)
                .limit(COUNT)
                .sum();
    }
    
    private static boolean areAllTruncationsPrimes(int i) {
        return allTruncations(Integer.toString(i)).stream().allMatch(k -> IS_PRIME.apply(k));
    }
    
    private static List<Integer> allTruncations(String number) {
        List<Integer> truncated = new ArrayList<>();
        
        for (int i = 0; i < number.length(); ++i) {
            truncated.add(Integer.valueOf(number.substring(i, number.length())));
        }
        
        for (int i = number.length() - 1; i > 0; --i) {
            truncated.add(Integer.valueOf(number.substring(0, i)));
        }
        
        return truncated;
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 748317;
    }
}
