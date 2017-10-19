package projecteuler.problems;

public class Problem09 implements Problem<Integer> {
    
    private static final int SUM = 1000;
    
    @Override
    public Integer getCalculatedSolution() {
        for (int i = 1; i <= SUM; ++i) {
            for (int j = i; j <= SUM; ++j) {
                int k = SUM - j - i;
                
                if (i * i + j * j == k * k) {
                    return i * j * k;
                }
            }
        }
        
        throw new AssertionError();
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 31875000;
    }
}
