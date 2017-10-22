package projecteuler.problems;

import java.util.Comparator;
import java.util.stream.LongStream;

@SuppressWarnings("ConstantConditions")
public class Problem14 implements Problem<Long> {
    
    @Override
    public Long getCalculatedSolution() {
        return LongStream.range(2, 1_000_000).boxed().parallel()
                .max(Comparator.comparing(this::collatzLength)).get();
    }
    
    private int collatzLength(long start) {
        int length = 0;
        long current = start;
        
        while (current != 1) {
            length++;
            
            current = (current % 2 == 0) ? (current / 2) : (3 * current + 1);
        }
        
        return length + 1;
    }
    
    @Override
    public Long getExpectedSolution() {
        return 837799L;
    }
}
