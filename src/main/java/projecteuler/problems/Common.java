package projecteuler.problems;

import projecteuler.PrimeCache;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

class Common {
    private static final Set<String> PANDIGITAL_SET = Arrays.stream("123456789".split("")).collect(toSet());
    
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
    
    static IntStream naturalNumbers() {
        return IntStream.iterate(2, i -> i + 1);
    }
    
    static List<String> permutations(String number) {
        return number.length() == 1 ? (
                singletonList(number)
        ) : (
                permutations(number.substring(1))
                        .stream()
                        .flatMap(tailPerm ->
                                IntStream.rangeClosed(0, tailPerm.length()).mapToObj(i ->
                                        new StringBuilder(tailPerm).insert(i, number.charAt(0)).toString()
                                )
                        ).collect(toList())
        );
    }
    
    // Beautiful, even if Java. 
    static <K, V> Function<K, V> memoized(Function<K, V> function) {
        Map<K, V> cache = new HashMap<>();
        
        return argument -> cache.computeIfAbsent(argument, function);
    }
    
    static boolean isPandigital1To9(String number) {
        return number.length() == 9 && Arrays.stream(number.split("")).collect(toSet()).equals(PANDIGITAL_SET);
    }
    
    @SuppressWarnings("ConstantConditions")
    private static int smallestPrimeFactorOf(long value) {
        return PrimeCache.INSTANCE.primes().filter(i -> value % i == 0).findFirst().getAsInt();
    }
    
    static List<Integer> factorize(long number) {
        List<Integer> factors = new ArrayList<>();
        
        while (number != 1) {
            int factor = smallestPrimeFactorOf(number);
            factors.add(factor);
            number /= factor;
        }
        
        return factors;
    }
    
    static Stream<String> readFile(String filename) {
        try {
            return Files.lines(new File(filename).toPath());
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
    
    // https://stackoverflow.com/a/26919665
    // Ugly but works
    // Refactor this on Java 9
    static <T> Stream<T> takeWhile(Stream<T> stream, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
    
        //noinspection ResultOfMethodCallIgnored
        stream.peek(e -> {
            if (predicate.test(e)) {
                result.add(e);
            }
        }).allMatch(predicate);
        
        return result.stream(); // yea, fake crap
    }
    
    static int sumOfproperDivisors(int number) {
        return IntStream.range(1, number).filter(maybeDivisor -> number % maybeDivisor == 0).sum();
    }
}
