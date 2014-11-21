import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Done
public class Problem03 implements Problem<BigInteger> {
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


	@Override
	public BigInteger getCalculatedSolution() {
		BigInteger number = new BigInteger("600851475143");
		List<BigInteger> factors = factorize(number);

		BigInteger largestPrimeFactor = factors.stream().max((o1, o2) -> o1.compareTo(o2)).get();

		return largestPrimeFactor;
	}

	@Override
	public BigInteger getExpectedSolution() {
		return BigInteger.valueOf(6857);
	}
}
