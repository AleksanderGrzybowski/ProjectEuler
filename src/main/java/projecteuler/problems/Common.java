package projecteuler.problems;

import java.util.stream.IntStream;

class Common {
    static IntStream primes() {
        return naturalNumbers().filter(Common::isPrime);
    }
    
    /**
     * Handwritten, streams are too slow.
     * return number >= 2 && IntStream.rangeClosed(2, (int) Math.sqrt(number)).allMatch(e -> number % e != 0);
     */
    static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        
        for (int i = 2; i <= (int) Math.sqrt(number); ++i) {
            if (number % i == 0) return false;
        }
        return true;
    }
    
    private static IntStream naturalNumbers() {
        return IntStream.iterate(2, i -> i + 1);
    }
}
