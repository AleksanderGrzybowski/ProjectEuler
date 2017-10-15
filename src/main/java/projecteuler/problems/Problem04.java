package projecteuler.problems;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

@SuppressWarnings("ConstantConditions")
public class Problem04 implements Problem<Integer> {
    
    private static final IntPredicate IS_PALINDROMIC = i -> {
        String numberString = "" + i;
        return numberString.equals(new StringBuilder(numberString).reverse().toString());
    };
    
    @Override
    public Integer getCalculatedSolution() {
        return products()
                .filter(IS_PALINDROMIC)
                .max().getAsInt();
    }
    
    private IntStream products() {
        return IntStream.rangeClosed(100, 999).flatMap(
                first -> IntStream.rangeClosed(100, 999).map(second -> first * second)
        );
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 906609;
    }
}
