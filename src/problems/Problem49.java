package problems;

import annotations.Done;
import utils.PrimeCache;
import utils.Triple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Done
public class Problem49 implements Problem<Long> {

	static PrimeCache cache = new PrimeCache(9999);

	static List<Triple> getPossible4DigitSequences() {
		List<Triple> result = new ArrayList<>();
		List<Integer> startingPoints = cache.toSet().stream()
				.filter(n -> (n >= 1000 && n <= 9999))
				.collect(Collectors.toList());

		for (int start : startingPoints) {
			for (int increment = 1; increment <= (9999 - 1000 + 1) / 2; ++increment) { // must be increasing, so 1 as first
				int a = start;
				int b = start + increment;
				int c = start + increment + increment;

				if (b <= 9999 && c <= 9999) {
					result.add(new Triple(a, b, c));
				}
			}
		}
		return result;
	}

	static boolean arePermutations(int a, int b) {
		List<Integer> listA = Integer.toString(a).chars().boxed().collect(Collectors.toList());
		List<Integer> listB = Integer.toString(b).chars().boxed().collect(Collectors.toList());
		listA.sort(Comparator.naturalOrder());
		listB.sort(Comparator.naturalOrder());
		return listA.equals(listB);

	}

	static boolean areElementsOfTriplePrime(Triple t) {
		return cache.isPrime(t.a) && cache.isPrime(t.b) && cache.isPrime(t.c);
	}

	static boolean areElementsPermutationsOfEachOther(Triple t) {
		return arePermutations(t.a, t.b) && arePermutations(t.b, t.c);
	}


	@Override
	public Long getCalculatedSolution() {
		Triple result = getPossible4DigitSequences().stream()
				.filter(Problem49::areElementsOfTriplePrime)
				.filter(Problem49::areElementsPermutationsOfEachOther)
				.skip(1).findFirst().get();

		return Long.parseLong("" + result.a + result.b + result.c);
	}

	@Override
	public Long getExpectedSolution() {
		return 296962999629L;
	}
}
