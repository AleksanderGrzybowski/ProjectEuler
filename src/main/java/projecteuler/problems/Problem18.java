package projecteuler.problems;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.singletonList;

@SuppressWarnings("ConstantConditions")
public class Problem18 implements Problem<Integer> {
    
    private static final int[][] TRIANGLE = new int[][]{
            {75},
            {95, 64},
            {17, 47, 82},
            {18, 35, 87, 10},
            {20, 4, 82, 47, 65},
            {19, 1, 23, 75, 3, 34},
            {88, 2, 77, 73, 7, 63, 67},
            {99, 65, 4, 28, 6, 16, 70, 92},
            {41, 41, 26, 56, 83, 40, 80, 70, 33},
            {41, 48, 72, 33, 47, 32, 37, 16, 94, 29},
            {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14},
            {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57},
            {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48},
            {63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31},
            {4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23},
    };
    
    private List<Integer> traverse(int i, int j, int walkingSum) {
        return i == (TRIANGLE.length - 1) ? (
                singletonList(TRIANGLE[i][j] + walkingSum)
        ) : combine(
                traverse(i + 1, j, TRIANGLE[i][j] + walkingSum),
                traverse(i + 1, j + 1, TRIANGLE[i][j] + walkingSum)
        );
    }
    
    private List<Integer> combine(List<Integer> first, List<Integer> second) {
        List<Integer> combined = new ArrayList<>();
        combined.addAll(first);
        combined.addAll(second);
        return combined;
    }
    
    @Override
    public Integer getCalculatedSolution() {
        return traverse(0, 0, 0).stream().mapToInt(i -> i).max().getAsInt();
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 1074;
    }
}
