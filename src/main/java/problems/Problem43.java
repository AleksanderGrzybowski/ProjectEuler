package problems;

import annotations.Done;
import utils.Common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Done
public class Problem43 implements Problem<Long> {

	static List<String> permutations() {
		int[] current = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9, 8};
		int[] last = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
		ArrayList<String> perms = new ArrayList<>();

		perms.add(arrayToString(current));

		while (!Arrays.equals(current, last)) {
			Common.nextPermutationMutating(current);
			perms.add(arrayToString(current));
		}

		return perms;
	}

	static String arrayToString(int[] tab) {
		return Arrays.stream(tab)
				.mapToObj(Integer::toString)
				.reduce((a, b) -> a + b).get();
	}

	@Override
	public Long getCalculatedSolution() {
		Predicate<String> predicate = s ->
				Integer.parseInt(s.substring(1, 4)) % 2 == 0 &&
						Integer.parseInt(s.substring(2, 5)) % 3 == 0 &&
						Integer.parseInt(s.substring(3, 6)) % 5 == 0 &&
						Integer.parseInt(s.substring(4, 7)) % 7 == 0 &&
						Integer.parseInt(s.substring(5, 8)) % 11 == 0 &&
						Integer.parseInt(s.substring(6, 9)) % 13 == 0 &&
						Integer.parseInt(s.substring(7, 10)) % 17 == 0;

		return permutations().stream()
				.filter(predicate)
				.mapToLong(Long::parseLong)
				.sum();
	}

	@Override
	public Long getExpectedSolution() {
		return 16695334890L;
	}
}
