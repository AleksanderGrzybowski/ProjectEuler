package problems;

import annotations.Done;
import utils.PrimeCache;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Done
public class Problem37 implements Problem<Integer> {

	public static final int NUMBER_OF_ELEMENTS = 11;
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
		return IntStream.iterate(11, i -> i+1).filter(Problem37::isTruncatablePrime).limit(NUMBER_OF_ELEMENTS).sum();
	}

	@Override
	public Integer getExpectedSolution() {
		return 748317;
	}
}
