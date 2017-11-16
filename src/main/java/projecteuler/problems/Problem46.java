package projecteuler.problems;

import java.util.function.Function;
import java.util.stream.IntStream;

import static projecteuler.problems.Common.memoized;

@SuppressWarnings("ConstantConditions")
public class Problem46 implements Problem<Integer> {
    
    private static final Function<Integer, Boolean> IS_PRIME = memoized(Common::isPrime);
    
    @Override
    public Integer getCalculatedSolution() {
        return Common.naturalNumbers()
                .filter(i -> i % 2 == 1 && !IS_PRIME.apply(i) && !canBeWrittenGoldbachsWay(i))
                .findFirst()
                .getAsInt();
    }
    
    private boolean canBeWrittenGoldbachsWay(int n) {
        return IntStream.range(2, n).filter(IS_PRIME::apply).anyMatch(prime -> isAPerfectSquare((n - prime) / 2));
    }
    
    private boolean isAPerfectSquare(int number) {
        return Math.pow((int) Math.sqrt(number), 2) == number;
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 5777;
    }
}
