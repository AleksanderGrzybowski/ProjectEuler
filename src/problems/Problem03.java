package problems;

import annotations.Done;

import java.util.ArrayList;
import java.util.List;

@Done
public class Problem03 implements Problem<Long> {

	public List<Long> factorize(long number) {
		List<Long> factors = new ArrayList<>();
		
		outer:
		while (number != 1) {
			for (long pf = 2; pf <= number; pf++) {
				if (number % pf == 0) {
					factors.add(pf);
					number /= pf;
					continue outer;
				}
			}
		}
		return factors;
	}

	@Override
	public Long getCalculatedSolution() {
		final long NUMBER = 600851475143L;
		List<Long> factors = factorize(NUMBER);

		return factors.stream().max(Long::compareTo).get();
	}

	@Override
	public Long getExpectedSolution() {
		return 6857L;
	}
}
