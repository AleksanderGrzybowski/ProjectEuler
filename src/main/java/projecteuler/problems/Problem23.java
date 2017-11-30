package projecteuler.problems;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toSet;
import static projecteuler.problems.Common.memoized;

public class Problem23 implements Problem<Integer> {
    
    private static final Function<Integer, Integer> SUM_OF_PROPER_DIVISORS = memoized(Common::sumOfproperDivisors);
    private static final Function<Integer, Boolean> IS_ABUNDANT = memoized(i -> SUM_OF_PROPER_DIVISORS.apply(i) > i);
    private static final int LIMIT = 28123;
    
    private static final Set<Integer> ABUNDANT_NUMBERS = IntStream.range(2, LIMIT)
            .filter(IS_ABUNDANT::apply)
            .boxed()
            .collect(toSet());
    
    @Override
    public Integer getCalculatedSolution() {
        return IntStream.range(1, LIMIT)
                .filter(Problem23::cantBeWrittenAsSumOfTwoAbundantNumbers)
                .sum();
    }
    
    private static boolean cantBeWrittenAsSumOfTwoAbundantNumbers(int number) {
        return ABUNDANT_NUMBERS.stream().noneMatch(component -> ABUNDANT_NUMBERS.contains(number - component));
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 4179871;
    }
}
