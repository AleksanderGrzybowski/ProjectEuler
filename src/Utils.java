import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Utils {
	public static boolean isPrimeLong(long number) {
		return (number != 1) && LongStream.range(2, number).parallel().noneMatch(i -> number % i == 0);
	}

	public static boolean isPrimeInt(int number) {
		return (number != 1) && IntStream.range(2, number).parallel().noneMatch(i -> number % i == 0);
	}
}
