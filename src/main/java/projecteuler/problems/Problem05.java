package projecteuler.problems;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

@SuppressWarnings("ConstantConditions")
public class Problem05 implements Problem<Integer> {
    
    // functional madness
    private static final IntPredicate IS_DIVISIBLE_1_THROUGH_20 = IntStream
            .of(11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
            .mapToObj(divisor -> (IntPredicate) candidate -> candidate % divisor == 0)
            .reduce(IntPredicate::and)
            .get();
    
    @Override
    public Integer getCalculatedSolution() {
        return IntStream.iterate(20, i -> i + 20) // divisible by 20, so let's go up by 20
                .parallel()
                .filter(IS_DIVISIBLE_1_THROUGH_20)
                .findFirst().getAsInt();
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 232792560;
    }
}
