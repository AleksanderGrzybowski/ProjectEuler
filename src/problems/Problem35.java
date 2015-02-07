package problems;

import annotations.Done;
import utils.PrimeCache;

import java.util.HashSet;
import java.util.Set;

@Done
public class Problem35 implements Problem<Integer> {

	static Set<Integer> primes = new PrimeCache(1_000_000).toSet();

	static Set<Integer> getPossibleRotations(int number) {
		HashSet<Integer> resultSet = new HashSet<>();
		String numberString = Integer.toString(number);
		StringBuilder sb = new StringBuilder(numberString);

		for (int i = 0; i < numberString.length(); ++i) {
			char first = sb.charAt(0);
			sb.deleteCharAt(0);
			sb.append(first);
			resultSet.add(Integer.parseInt(sb.toString()));
		}
		return resultSet;
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
