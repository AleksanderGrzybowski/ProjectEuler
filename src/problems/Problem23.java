package problems;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Problem23 implements Problem<Integer> {


	Map<Integer, Integer> sumOfProperDivisorsMap = new HashMap<>();

	{
		for (int i = 1; i <= 65000; ++i) // TODO change magic number to what?
			sumOfProperDivisorsMap.put(i, sumOfProperDivisors(i));
	}

	int sumOfProperDivisors(int number) {
		return IntStream.rangeClosed(1, number - 1).filter(i -> number % i == 0).sum();
	}

	int sumOfProperDivisorsCached(int number) {
		return sumOfProperDivisorsMap.get(number);
	}


	boolean isAbundant(int number) {
		return sumOfProperDivisorsCached(number) > number;
	}

	Set<Integer> abundantNumbers = new HashSet<Integer>();

	{

		for (int i = 1; i <= 65000; ++i) { // TODO change magic number to what?
			if (isAbundant(i)) abundantNumbers.add(i);
//			System.out.println(i);

		}
	}

	boolean canBeWritten(int number) {
		for (int i = 1; i < number; ++i) {
			if (abundantNumbers.contains(i) && abundantNumbers.contains(number - i))
				return true;
		}
		return false;
	}

	@Override
	public Integer getCalculatedSolution() {
		List<Integer> l = new ArrayList<>(abundantNumbers);
		l.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1, o2);
			}
		});

		long res = LongStream.range(1L, 65000L).filter(w -> !canBeWritten((int) w)).peek(System.out::println).sum();
		return (int) (res );
	}

	@Override
	public Integer getExpectedSolution() {
		return 4179871;
	}

	public static void main(String[] args) {


	}
}
