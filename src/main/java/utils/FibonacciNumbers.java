package utils;

import java.util.ArrayList;
import java.util.List;

public class FibonacciNumbers {

	public static List<Integer> generateUpTo(int maximumValue) {
		List<Integer> fibs = new ArrayList<>();
		int previous = 0;
		int current = 1;

		while (current <= maximumValue) {
			fibs.add(current);
			int tmp = previous + current;
			previous = current;
			current = tmp;
		}

		return fibs;
	}
}
