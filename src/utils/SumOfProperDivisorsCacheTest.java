package utils;

import org.junit.Assert;
import org.junit.Test;

public class SumOfProperDivisorsCacheTest {
	@Test
	public void test_all() {
		SumOfProperDivisorsCache cache = new SumOfProperDivisorsCache(20);

		Assert.assertEquals(1+2+5, cache.get(10));
		Assert.assertEquals(1+2+3+4+6, cache.get(12));
		Assert.assertEquals(1+3+5, cache.get(15));
		Assert.assertEquals(1+2+3+6+9, cache.get(18));
	}
}