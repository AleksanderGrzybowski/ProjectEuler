import java.util.stream.IntStream;

/**
 * Created by kelog on 21.11.14.
 */
public class Problem06 {

	public static IntStream getRange() {
		return IntStream.range(1, 100);
	}

	public static void main(String[] args) {

		int sumOfSquares = getRange().map(i -> i * i).sum();
		int sum = getRange().sum();
		int squareOfSum = sum * sum;

		int result = squareOfSum - sumOfSquares;
		System.out.println(result);
	}
}
