package projecteuler.problems;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toSet;
import static projecteuler.problems.Problem21.memoized;

public class Problem23 implements Problem<Integer> {
    
    private static final Function<Integer, Integer> sumOfProperDivisors = memoized(Problem21::sumOfproperDivisors);
    private static final Function<Integer, Boolean> isAbundant = memoized(i -> sumOfProperDivisors.apply(i) > i);
    private static final int LIMIT = 28123;
    
    private static final Set<Integer> ABUNDANT_NUMBERS = IntStream.range(2, LIMIT).filter(isAbundant::apply).boxed().collect(toSet());
    
    @Override
    public Integer getCalculatedSolution() {
        return IntStream.range(1, LIMIT).filter(Problem23::cantBeWrittenAsSumOfTwoAbundantNumbers).sum();
    }
    
    private static boolean cantBeWrittenAsSumOfTwoAbundantNumbers(int number) {
        return ABUNDANT_NUMBERS.stream().noneMatch(component -> ABUNDANT_NUMBERS.contains(number - component));
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 4179871;
    }
}
