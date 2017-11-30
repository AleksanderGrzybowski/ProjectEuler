package projecteuler.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

@SuppressWarnings("ConstantConditions")
public class Problem45 implements Problem<Long> {
    
    private static final Function<Long, Long> TRIANGULAR = n -> n * (n + 1) / 2;
    private static final Function<Long, Long> PENTAGONAL = n -> n * (3 * n - 1) / 2;
    private static final Function<Long, Long> HEXAGONAL = n -> n * (2 * n - 1);
    private static final int EXPECTED_COMMON_ELEMENTS_SIZE = 3;
    
    @Override
    public Long getCalculatedSolution() {
        return LongStream.iterate(10, max -> max * 10).boxed().flatMap(max -> {
            Set<Long> commonElements = intersection(
                    generateUpTo(TRIANGULAR, max),
                    generateUpTo(PENTAGONAL, max),
                    generateUpTo(HEXAGONAL, max)
            );
            
            if (commonElements.size() == EXPECTED_COMMON_ELEMENTS_SIZE) {
                return Stream.of(commonElements.stream().max(Long::compareTo).get());
            } else {
                return Stream.empty();
            }
        }).findFirst().get();
    }
    
    @SafeVarargs
    private static Set<Long> intersection(Set<Long> first, Set<Long>... others) {
        Set<Long> intersection = new HashSet<>(first);
    
        Arrays.stream(others).forEach(intersection::retainAll);
        
        return intersection;
    }
    
    private static Set<Long> generateUpTo(Function<Long, Long> generator, long max) {
        Set<Long> elements = new HashSet<>();
        
        for (long currentIndex = 1, currentElement = Long.MIN_VALUE; currentElement <= max; currentIndex++) {
            currentElement = generator.apply(currentIndex);
            elements.add(currentElement);
        }
        
        return elements;
    }
    
    @Override
    public Long getExpectedSolution() {
        return 1533776805L;
    }
}
