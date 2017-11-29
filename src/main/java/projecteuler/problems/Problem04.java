package projecteuler.problems;

import java.util.stream.IntStream;

@SuppressWarnings("ConstantConditions")
public class Problem04 implements Problem<Integer> {
    
    private static final int THREE_DIGIT_MIN = 100;
    private static final int THREE_DIGIT_MAX = 999;
    
    @Override
    public Integer getCalculatedSolution() {
        return productsOf3DigitNumbers()
                .filter(Problem04::isPalindromic)
                .max().getAsInt();
    }
    
    private static IntStream productsOf3DigitNumbers() {
        return threeDigitNumbers().flatMap(
                first -> threeDigitNumbers().map(second -> first * second)
        );
    }
    
    private static IntStream threeDigitNumbers() {
        return IntStream.rangeClosed(THREE_DIGIT_MIN, THREE_DIGIT_MAX);
    }
    
    private static boolean isPalindromic(int number) {
        return Integer.parseInt(new StringBuilder("" + number).reverse().toString()) == number;
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 906609;
    }
}
