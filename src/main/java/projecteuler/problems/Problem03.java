package projecteuler.problems;

@SuppressWarnings("ConstantConditions")
public class Problem03 implements Problem<Integer> {
    
    @Override
    public Integer getCalculatedSolution() {
        return Common.factorize(600851475143L).stream()
                .max(Integer::compareTo)
                .get();
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 6857;
    }
}
