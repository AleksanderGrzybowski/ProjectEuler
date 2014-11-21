import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kelog on 21.11.14.
 */
public class Problem03 {

	public static List<BigInteger> factorize(BigInteger number) {
		List<BigInteger> factors = new ArrayList<>();
		
		outer:
		while (!number.equals(BigInteger.ONE)) {
			for (BigInteger pf = BigInteger.valueOf(2); pf.compareTo(number) <= 0; pf = pf.add(BigInteger.ONE)) {
				if (number.mod(pf).equals(BigInteger.ZERO)) {
					factors.add(pf);
					number = number.divide(pf);
					continue outer;
				}
			}
		}
		return factors;
	}

	public static void main(String[] args) {
		BigInteger number = new BigInteger("600851475143");
		List<BigInteger> factors = factorize(number);

		BigInteger largestPrimeFactor = factors.stream().sorted().reduce((a,b) -> (a.compareTo(b) >= 0 ? a : b)).get();

		System.out.println(largestPrimeFactor);
	}
}
