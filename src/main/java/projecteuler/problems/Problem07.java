package projecteuler.problems;

@SuppressWarnings("ConstantConditions")
public class Problem07 implements Problem<Integer> {
    
    @Override
    public Integer getCalculatedSolution() {
        return Common.primes().skip(10000).findFirst().getAsInt();
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 104743;
    }
}
