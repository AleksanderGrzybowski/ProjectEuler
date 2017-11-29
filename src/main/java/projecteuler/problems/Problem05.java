package projecteuler.problems;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

@SuppressWarnings("ConstantConditions")
public class Problem05 implements Problem<Integer> {
    
    @Override
    public Integer getCalculatedSolution() {
        int step = divisors().max().getAsInt();
        
        return IntStream.iterate(step, i -> i + step) // let's go up by the biggest possible divisor
                .parallel()
                .filter(isDivisibleThrough1To20())
                .findFirst().getAsInt();
    }
    
    // functional madness
    private static IntPredicate isDivisibleThrough1To20() {
        return divisors()
                .mapToObj(divisor -> (IntPredicate) candidate -> candidate % divisor == 0)
                .reduce(IntPredicate::and)
                .get();
    }
    
    // smaller ones are all covered by bigger ones
    private static IntStream divisors() {
        return IntStream.rangeClosed(11, 20);
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 232792560;
    }
}
