package projecteuler.problems;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;

@SuppressWarnings("ConstantConditions")
public class Problem39 implements Problem<Integer> {
    
    private static final int MAX_PERIMETER = 1000;
    private static final int MIN_PERIMETER = 3;
    
    @Override
    public Integer getCalculatedSolution() {
        return IntStream.rangeClosed(MIN_PERIMETER, MAX_PERIMETER)
                .parallel().boxed()
                .max(Comparator.comparing(Problem39::numberOfSolutionsForPerimeter))
                .get();
    }
    
    private static int numberOfSolutionsForPerimeter(int perimeter) {
        if (perimeter < 3) return 0;
        
        Set<List<Integer>> triangles = new HashSet<>();
        
        for (int a = 1; a <= perimeter - 2; ++a) {
            for (int b = 1; b <= perimeter - a - 1; ++b) {
                int c = perimeter - a - b;
                List<Integer> triangle = new ArrayList<>(asList(a, b, c));
                triangle.sort(Comparator.naturalOrder());
                
                if (isASquareTriangle(triangle)) {
                    triangles.add(triangle);
                }
            }
        }
        
        return triangles.size();
    }
    
    private static boolean isASquareTriangle(List<Integer> triangle) {
        return triangle.get(0) * triangle.get(0) + triangle.get(1) * triangle.get(1) == triangle.get(2) * triangle.get(2);
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 840;
    }
}
