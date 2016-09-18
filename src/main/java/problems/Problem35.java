package problems;

import annotations.Done;
import utils.PrimeCache;

import java.util.HashSet;
import java.util.Set;

@Done
public class Problem35 implements Problem<Integer> {

	static Set<Integer> primes = new PrimeCache(1_000_000).asSortedSet();

	static Set<Integer> getPossibleRotations(int number) {
		HashSet<Integer> rotations = new HashSet<>();
		StringBuilder sb = new StringBuilder(Integer.toString(number));
		int length = sb.length();

		for (int i = 0; i < length; ++i) {
			char first = sb.charAt(0);
			sb.deleteCharAt(0);
			sb.append(first);
			rotations.add(Integer.parseInt(sb.toString()));
		}
		return rotations;
	}

	static boolean isCircularPrime(int number) {
		return getPossibleRotations(number).stream().allMatch(primes::contains);
	}

	@Override
	public Integer getCalculatedSolution() {
		return (int) primes.stream().filter(Problem35::isCircularPrime).count();
	}

	@Override
	public Integer getExpectedSolution() {
		return 55;
	}
}
