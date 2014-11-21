import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/**
 * Created by kelog on 21.11.14.
 */
public class Problem05 {

	static final int FIRST_DIVISOR = 1;
	static final int LAST_DIVISOR = 10;

	public static IntPredicate getModPredicate(int number) {
		return x -> (x % number == 0);
	}

	public static IntStream getFilteredStream(IntStream stream) {
		for (int i = FIRST_DIVISOR; i <= LAST_DIVISOR; ++i)
			stream = stream.filter(getModPredicate(i));
		return stream;
	}

	public static void main(String[] args) {
		IntStream naturalNumbers = IntStream.iterate(1, i -> i + 1);
		int result = getFilteredStream(naturalNumbers).findFirst().getAsInt();
		System.out.println(result);
	}
}
