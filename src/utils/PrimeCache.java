package utils;

import java.util.TreeSet;

public class PrimeCache {

	private TreeSet<Integer> primes = new TreeSet<Integer>(); // consider internally sorted list/set

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

//	List<Integer> toList() {
//		return new ArrayList<>(primes);
//	}


	public static void main(String[] args) {

		System.out.println("Start");
		PrimeCache p = new PrimeCache(10_000_000);
//		System.out.println(p.toList());
		System.out.println("Juz");
	}
}
