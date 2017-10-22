package projecteuler.problems;

public class Problem15 implements Problem<Long> {
    
    private static final int SIZE = 20;
    private static final long[][] matrix = new long[SIZE + 1][SIZE + 1];
    
    @Override
    public Long getCalculatedSolution() {
        for (int i = 0; i <= SIZE; ++i) {
            matrix[0][i] = 1;
            matrix[i][0] = 1;
        }
        
        for (int row = 1; row <= SIZE; ++row) {
            for (int col = 1; col <= SIZE; ++col) {
                matrix[row][col] = matrix[row - 1][col] + matrix[row][col - 1];
            }
        }
        
        return matrix[SIZE][SIZE];
    }
    
    @Override
    public Long getExpectedSolution() {
        return 137846528820L;
    }
}

