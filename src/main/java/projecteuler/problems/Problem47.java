package projecteuler.problems;

import projecteuler.PrimeCache;

import java.util.HashSet;
import java.util.stream.Stream;

@SuppressWarnings("ConstantConditions")
public class Problem47 implements Problem<Integer> {

    @Override
    public Integer getCalculatedSolution() {
        return Common.naturalNumbers()
                .filter(j ->
                        Stream.of(j, j + 1, j + 2, j + 3).allMatch(this::has4DistinctPrimeFactors)
                ).findFirst().getAsInt();
    }
    
    private boolean has4DistinctPrimeFactors(Integer i) {
        return new HashSet<>(PrimeCache.INSTANCE.factorize(i)).size() == 4;
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 134043;
    }
}
