package projecteuler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

public class PrimeCache {
    
    public static final PrimeCache INSTANCE = new PrimeCache();
    
    private int size = 100;
    private final ConcurrentHashMap<Integer, Boolean> PRIMES = new ConcurrentHashMap<>();
    
    private int[] sieve;
    
    private PrimeCache() {
        size = 100;
        initialize();
    }
    
    private void initialize() {
        sieve = new int[size];
        
        for (int i = 2; i < sieve.length; ++i) {
            sieve[i] = i;
        }
        
        for (int i = 2; i < sieve.length; ++i) {
            if (sieve[i] != 0) {
                for (int j = i * 2; j < sieve.length; j += i) {
                    sieve[j] = 0;
                }
            }
        }
    }
    
    public boolean isPrime(int number) {
        ensureCapacity(number);
        
        return sieve[number] != 0;
    }
    
    private void ensureCapacity(long number) {
        if (number >= size) {
            while (number >= size) {
                size *= 10;
            }
            initialize();
        }
    }
    
    public IntStream primes() {
        return IntStream.iterate(2, i -> i + 1).filter(this::isPrime);
    }
    
    public List<Integer> factorize(long number) {
        List<Integer> factors = new ArrayList<>();
        
        while (number != 1) {
            int factor = smallestPrimeFactorOf(number);
            factors.add(factor);
            number /= factor;
        }
        
        return factors;
    }
    
    private int smallestPrimeFactorOf(long number) {
        ensureCapacity(number);
        
        for (int i = 2; i <= number; ++i) {
            if (sieve[i] != 0 && number % i == 0) {
                return i;
            }
        }
        
        throw new AssertionError();
    }
}
