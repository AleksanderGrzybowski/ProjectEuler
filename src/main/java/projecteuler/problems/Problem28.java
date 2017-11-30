package projecteuler.problems;

import java.util.stream.IntStream;

public class Problem28 implements Problem<Integer> {
    
    private static final int SIZE = 1001;
    
    @Override
    public Integer getCalculatedSolution() {
        return new Spiral(SIZE).diagonalSum();
    }
    
    private static class Spiral {
        
        private int[][] spiral;
        
        Spiral(int size) {
            // borders made with '0'-s
            spiral = new int[size + 2][size + 2];
            
            int currentNumber = 1;
            int posX, posY;
            posX = posY = size / 2 + 1;
            
            spiral[posX][posY] = currentNumber++;
            posX++;
            
            for (int i = 0; i < size / 2; ++i) {
                while (spiral[posX - 1][posY] != 0) {
                    spiral[posX][posY] = currentNumber++;
                    posY++;
                }
                
                while (spiral[posX][posY - 1] != 0) {
                    spiral[posX][posY] = currentNumber++;
                    posX--;
                }
                
                while (spiral[posX + 1][posY] != 0) {
                    spiral[posX][posY] = currentNumber++;
                    posY--;
                }
                
                while (spiral[posX][posY + 1] != 0) {
                    spiral[posX][posY] = currentNumber++;
                    posX++;
                }
            }
        }
        
        int diagonalSum() {
            return IntStream.range(0, spiral.length).map(i -> spiral[i][i]).sum()
                    + IntStream.range(0, spiral.length).map(i -> spiral[i][spiral.length - 1 - i]).sum()
                    - spiral[spiral.length / 2][spiral.length / 2];
        }
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 669171001;
    }
}
