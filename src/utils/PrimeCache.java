package utils;

import java.util.ArrayList;
import java.util.List;

public class PrimeCache {

	private List<Integer> primes = new ArrayList<Integer>(); // consider internally sorted list/set

	public PrimeCache(int maximumInclusive) {
		int tabsize = maximumInclusive-2+1;
		int[] tab = new int[(int)tabsize];
		for (int i = 2; i <= maximumInclusive; ++i)
			tab[(int)(i-2)] = i;

		int ptr = 0;

		while (ptr < tabsize) {
			if (tab[ptr] == 0) {
				ptr++;
				continue;
			}
			primes.add(tab[ptr]);
			for (int s = (ptr+tab[ptr]); s < tabsize; s += tab[ptr])
				tab[s] = 0;
			ptr++;
		}
//		System.out.println(tab[0]);
	}

	public boolean isPrime(int n) {
		return primes.contains(n);
	}

	List<Integer> toList() {
		return new ArrayList<>(primes);
	}


	public static void main(String[] args) {
		PrimeCache p = new PrimeCache(100);
		System.out.println(p.primes);
		System.out.println();
	}
}
