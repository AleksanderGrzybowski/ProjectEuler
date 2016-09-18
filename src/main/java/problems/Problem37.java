package problems;

import annotations.Done;
import utils.Common;
import utils.PrimeCache;

import java.util.ArrayList;
import java.util.List;

@Done
public class Problem37 implements Problem<Integer> {

	static PrimeCache cache = new PrimeCache(1_000_000);

	static List<Integer> slice(int number) {
		ArrayList<Integer> result = new ArrayList<>();
		String numberString = Integer.toString(number);

		StringBuilder sbFromLeft = new StringBuilder(numberString);
		StringBuilder sbFromRight = new StringBuilder(numberString);

		while (sbFromLeft.length() > 0) {
			result.add(Integer.parseInt(sbFromLeft.toString()));
			result.add(Integer.parseInt(sbFromRight.toString()));
			sbFromLeft.deleteCharAt(0);
			sbFromRight.deleteCharAt(sbFromRight.length()-1);
		}

		return result;
	}

	static boolean isTruncatablePrime(int number) {
		return slice(number).stream()
				.allMatch(cache::isPrime);
	}

	@Override
	public Integer getCalculatedSolution() {
		final int FIRST_CONSIDERED_PRIME = 11;
		final int NUMBER_OF_ELEMENTS = 11;

		return Common.naturalNumbers(FIRST_CONSIDERED_PRIME).filter(Problem37::isTruncatablePrime).limit(NUMBER_OF_ELEMENTS).sum();
	}

	@Override
	public Integer getExpectedSolution() {
		return 748317;
	}
}
