package projecteuler.problems;

import java.util.stream.IntStream;

public class Problem36 implements Problem<Integer> {
    
    private static final int MAX = 1_000_000;
    
    @Override
    public Integer getCalculatedSolution() {
        return IntStream.rangeClosed(1, MAX)
                .filter(Problem36::isPalindromicInBase10And2)
                .sum();
    }
    
    private static boolean isPalindromicInBase10And2(int number) {
        return isPalindromic(Integer.toString(number)) && isPalindromic(Integer.toString(number, 2));
    }
    
    private static boolean isPalindromic(String number) {
        return number.equals(new StringBuilder(number).reverse().toString());
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 872187;
    }
}
