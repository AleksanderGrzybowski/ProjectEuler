package projecteuler.problems;

@SuppressWarnings("ConstantConditions")
public class Problem07 implements Problem<Integer> {
    
    private static final int TO_SKIP = 10000;
    
    @Override
    public Integer getCalculatedSolution() {
        return Common.primes()
                .skip(TO_SKIP)
                .findFirst().getAsInt();
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 104743;
    }
}
