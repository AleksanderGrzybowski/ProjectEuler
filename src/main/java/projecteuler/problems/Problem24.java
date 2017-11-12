package projecteuler.problems;

import static java.lang.Long.parseLong;

@SuppressWarnings("ConstantConditions")
public class Problem24 implements Problem<Long> {
    
    @Override
    public Long getCalculatedSolution() {
        return parseLong(
                Common.permutations("0123456789").parallelStream()
                        .sorted()
                        .skip(999999)
                        .findFirst().get()
        );
    }
    
    @Override
    public Long getExpectedSolution() {
        return 2783915460L;
    }
}
