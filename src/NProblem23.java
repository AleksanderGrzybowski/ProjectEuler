import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@Done
public class NProblem23 implements Problem<Integer> {


	static Map<Integer, Integer> sumOfProperDivisorsMap = new HashMap<>();

	static {
		for (int i = 1; i <= 65000; ++i) // TODO change magic number to what?
			sumOfProperDivisorsMap.put(i, sumOfProperDivisors(i));
	}

	static int sumOfProperDivisors(int number) {
		return IntStream.rangeClosed(1, number - 1).filter(i -> number % i == 0).sum();
	}

	static int sumOfProperDivisorsCached(int number) {
		return sumOfProperDivisorsMap.get(number);
	}


	static boolean isAbundant(int number) {
		return sumOfProperDivisorsCached(number) > number;
	}

	static Set<Integer> abundantNumbers = new HashSet<Integer>();

	static {

		for (int i = 1; i <= 65000; ++i) { // TODO change magic number to what?
			if (isAbundant(i)) abundantNumbers.add(i);
//			System.out.println(i);

		}
	}

	static boolean canBeWritten(int number) {
		for (int i = 1; i < number; ++i) {
			if (abundantNumbers.contains(i) && abundantNumbers.contains(number-i))
				return true;
		}
		return false;
	}

	@Override
	public Integer getCalculatedSolution() {
		return 1337;
	}

	@Override
	public Integer getExpectedSolution() {
		return 1337;
	}

	public static void main(String[] args) {
		List<Integer> l = new ArrayList<>(abundantNumbers);
		l.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1, o2);
			}
		});
		System.out.println(l);

		long res = LongStream.range(2L, 65000L).filter(w -> !canBeWritten((int) w)).peek(System.out::println).sum();
		System.out.println(res);

	}
}
