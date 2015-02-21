package utils;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

// This was previously used, elegant, but waaaay to slow to use here...
//public static boolean isPrimeInt(int number) {
//	return (number != 1) && IntStream.range(2, number).parallel().noneMatch(i -> number % i == 0);
//}

public class PrimeCache {

	private SortedSet<Integer> primes;
	private final int max;

	public PrimeCache(int maximumInclusive) {
		this.max = maximumInclusive;

		TreeSet<Integer> primes = new TreeSet<>();

		int size = max - 2 + 1;
		int[] tab = new int[size];

		for (int i = 2; i <= max; ++i) {
			tab[(i - 2)] = i;
		}

		for (int ptr = 0; ptr < size; ++ptr) {
			if (tab[ptr] != 0) {
				primes.add(tab[ptr]);
				for (int s = (ptr + tab[ptr]); s < size; s += tab[ptr]) {
					tab[s] = 0;
				}
			}
		}

		this.primes = Collections.unmodifiableSortedSet(primes);
	}

	public boolean isPrime(int number) {
		if (number > max) {
			throw new IllegalArgumentException("Prime check for " + number + " requested, but cache size is only " + max);
		}
		return primes.contains(number);
	}

	public SortedSet<Integer> asSortedSet() {
		return primes;
	}
}
