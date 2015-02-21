package utilstests;

import org.junit.Test;
import utils.FibonacciNumbers;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FibonacciNumbersTest {

	@Test
	public void test_generateUpTo() throws Exception {
		List<Integer> expected = Arrays.asList(1, 1, 2, 3, 5, 8, 13, 21, 34);
		List<Integer> actual = FibonacciNumbers.generateUpTo(34);

		assertEquals(expected, actual);
	}
}