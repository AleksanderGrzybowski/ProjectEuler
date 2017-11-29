package projecteuler.problems;

import java.util.Comparator;
import java.util.stream.LongStream;

@SuppressWarnings("ConstantConditions")
public class Problem14 implements Problem<Long> {
    
    @Override
    public Long getCalculatedSolution() {
        return range().boxed().parallel()
                .max(Comparator.comparing(Problem14::collatzLength))
                .get();
    }
    
    private static LongStream range() {
        return LongStream.range(2, 1_000_000);
    }
    
    private static int collatzLength(long start) {
        int length = 1;
        long current = start;
        
        while (current != 1) {
            length++;
            
            current = (current % 2 == 0) ? (current / 2) : (3 * current + 1);
        }
        
        return length;
    }
    
    @Override
    public Long getExpectedSolution() {
        return 837799L;
    }
}
