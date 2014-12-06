package utilstests;

import org.junit.Assert;
import org.junit.Test;
import utils.PrimeCache;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PrimeCacheTest {
	@Test
	public void test_all() {
		PrimeCache primeCache = new PrimeCache(30);

		Set<Integer> expected = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29));
		Set<Integer> actual = primeCache.toSet();

		Assert.assertEquals(expected, actual);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_cant_request_prime_larger_than_cache_size() throws Exception {
		PrimeCache primeCache = new PrimeCache(30);

		primeCache.isPrime(100000);

	}
}