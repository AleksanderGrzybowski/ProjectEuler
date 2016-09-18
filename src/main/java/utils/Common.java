package utils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Common {

	// algorithm ripped off from notes from AiSD course
	public static void nextPermutationMutating(int[] tab) {
		int i;
		for (i = tab.length - 2; ; i--) {
			if (tab[i] < tab[i + 1])
				break;
		}
		// i and i+1 are set now!

		int curMinIndex = i + 1;
		for (int j = (i + 1); j < tab.length; ++j) {
			if (tab[j] < tab[curMinIndex] && tab[j] > tab[i])
				curMinIndex = j;
		}

		int tmp = tab[curMinIndex];
		tab[curMinIndex] = tab[i];
		tab[i] = tmp;

		// reverse on the right
		int lenToRev = (tab.length - i - 1);
		for (int offs = 0; offs < lenToRev / 2; ++offs) {
			int tmpa = tab[i + 1 + offs];
			tab[i + 1 + offs] = tab[tab.length - 1 - offs];
			tab[tab.length - 1 - offs] = tmpa;
		}
	}

	public static IntStream naturalNumbers(int start) {
		return IntStream.iterate(start, i -> i+1);
	}

	public static IntStream naturalNumbers() {
		return naturalNumbers(1);
	}

	public static boolean isPandigital(long number) {
		String numberString = Long.toString(number);
		List<Integer> digits = numberString.chars().map(i -> i - '0').boxed().collect(Collectors.toList());

		if (digits.contains(0)) { // rule says: from 1 up to n, zero is banned
			return false;
		}

		Collections.sort(digits);

		List<Integer> expected1toN = IntStream.rangeClosed(1, numberString.length()).boxed().collect(Collectors.toList());
		return digits.equals(expected1toN);
	}
}
