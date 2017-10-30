package projecteuler.problems;

import java.util.stream.IntStream;

public class Common {
    public static IntStream primes() {
        return naturalNumbers().filter(Common::isPrime);
    }
    
    public static boolean isPrime(int i) {
        return i >= 2 && IntStream.rangeClosed(2, (int) Math.sqrt(i)).allMatch(e -> i % e != 0);
    }
    
    private static IntStream naturalNumbers() {
        return IntStream.iterate(2, i -> i + 1);
    }
}
