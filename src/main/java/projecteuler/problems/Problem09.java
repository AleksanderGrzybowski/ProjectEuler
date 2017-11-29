package projecteuler.problems;

public class Problem09 implements Problem<Integer> {
    
    private static final int SUM = 1000;
    
    @Override
    public Integer getCalculatedSolution() {
        for (int a = 1; a <= SUM; ++a) {
            for (int b = a; b <= SUM; ++b) {
                int c = SUM - b - a;
                
                if (isPythagoreanTriplet(a, b, c)) {
                    return a * b * c;
                }
            }
        }
        
        throw new AssertionError();
    }
    
    private static boolean isPythagoreanTriplet(int a, int b, int c) {
        return a * a + b * b == c * c;
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 31875000;
    }
}
