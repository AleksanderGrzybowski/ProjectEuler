package utils;

import java.util.Set;
import java.util.TreeSet;

// This was previously used, elegant, but waaaay to slow to use here...
//public static boolean isPrimeInt(int number) {
//	return (number != 1) && IntStream.range(2, number).parallel().noneMatch(i -> number % i == 0);
//}


public class PrimeCache {

	private TreeSet<Integer> primes = new TreeSet<>();
	private final int max;

	public PrimeCache(int maximumInclusive) {
		this.max = maximumInclusive;

		int size = max - 2 + 1;
		int[] tab = new int[size];

		for (int i = 2; i <= max; ++i)
			tab[(i - 2)] = i;

		for (int ptr = 0; ptr < size; ++ptr) {
			if (tab[ptr] != 0) {
				primes.add(tab[ptr]);
				for (int s = (ptr + tab[ptr]); s < size; s += tab[ptr]) {
					tab[s] = 0;
				}
			}
		}
	}

	public boolean isPrime(int number) {
		if (number > max)
			throw new IllegalArgumentException("Prime check for " + number + " requested, but cache size is only " + max);
		return primes.contains(number);
	}

	public Set<Integer> toSet() {
		return new TreeSet<>(primes);
	}
}
