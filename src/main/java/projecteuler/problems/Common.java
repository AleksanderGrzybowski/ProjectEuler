package projecteuler.problems;

import java.util.stream.IntStream;

public class Common {
    public static IntStream primes() {
        return naturalNumbers().filter(i -> IntStream.range(2, i).allMatch(e -> i % e != 0));
    }
    
    private static IntStream naturalNumbers() {
        return IntStream.iterate(2, i -> i + 1);
    }
}
