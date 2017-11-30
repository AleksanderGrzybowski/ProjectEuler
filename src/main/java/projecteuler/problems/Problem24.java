package projecteuler.problems;

import static java.lang.Long.parseLong;

@SuppressWarnings("ConstantConditions")
public class Problem24 implements Problem<Long> {
    
    private static final int TO_SKIP = 999999;
    private static final String GIVEN_DIGITS = "0123456789";
    
    @Override
    public Long getCalculatedSolution() {
        return parseLong(
                Common.permutations(GIVEN_DIGITS).parallelStream()
                        .sorted()
                        .skip(TO_SKIP)
                        .findFirst().get()
        );
    }
    
    @Override
    public Long getExpectedSolution() {
        return 2783915460L;
    }
}
