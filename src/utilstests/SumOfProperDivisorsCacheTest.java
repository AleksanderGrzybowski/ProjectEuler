package utilstests;

import org.junit.Test;
import utils.SumOfProperDivisorsCache;

import static org.junit.Assert.assertEquals;

public class SumOfProperDivisorsCacheTest {
	@Test
	public void test_all() {
		SumOfProperDivisorsCache cache = new SumOfProperDivisorsCache(20);

		assertEquals(1 + 2 + 5, cache.get(10));
		assertEquals(1 + 2 + 3 + 4 + 6, cache.get(12));
		assertEquals(1 + 3 + 5, cache.get(15));
		assertEquals(1 + 2 + 3 + 6 + 9, cache.get(18));
		assertEquals(1, cache.get(17)); // prime
	}

	@Test(expected = IllegalArgumentException.class)
	public void cant_request_number_outside_the_cache() {
		SumOfProperDivisorsCache cache = new SumOfProperDivisorsCache(20);

		cache.get(100000);
	}
}