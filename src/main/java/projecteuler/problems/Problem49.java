
package projecteuler.problems;

import projecteuler.PrimeCache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Problem49 implements Problem<Long> {
    
    private static final IntStream FOUR_DIGIT_NUMBERS = IntStream.rangeClosed(1000, 9999);
    private static final int NOT_LOOKING_FOR = 1487;
    
    @Override
    public Long getCalculatedSolution() {
        List<Integer> fourDigitPrimes = FOUR_DIGIT_NUMBERS.filter(PrimeCache.INSTANCE::isPrime).boxed().collect(toList());
        
        List<Triple> series = new ArrayList<>();
        for (int i = 0; i < fourDigitPrimes.size(); ++i) {
            for (int j = i + 1; j < fourDigitPrimes.size(); ++j) {
                int difference = fourDigitPrimes.get(j) - fourDigitPrimes.get(i);
                int thirdElement = fourDigitPrimes.get(j) + difference;
                
                if (fourDigitPrimes.contains(thirdElement)) {
                    series.add(new Triple(
                            fourDigitPrimes.get(i),
                            fourDigitPrimes.get(j),
                            thirdElement
                    ));
                }
            }
        }
        
        return series.parallelStream()
                .filter(triple -> meetsProperty(triple.i, triple.j, triple.k))
                .filter(triple -> triple.i != NOT_LOOKING_FOR)
                .findFirst()
                .map(result -> Long.parseLong("" + result.i + result.j + result.k))
                .orElseThrow(AssertionError::new);
    }
    
    private static boolean meetsProperty(int a, int b, int c) {
        return Stream.of(a, b, c).allMatch(PrimeCache.INSTANCE::isPrime)
                &&
                Stream.of(a, b, c).map(i -> Arrays.stream(("" + i).split("")).sorted().collect(joining("")))
                        .collect(toSet())
                        .size() == 1;
    }
    
    private static class Triple {
        final int i, j, k;
        
        Triple(int i, int j, int k) {
            this.i = i;
            this.j = j;
            this.k = k;
        }
    }
    
    @Override
    public Long getExpectedSolution() {
        return 296962999629L;
    }
}
