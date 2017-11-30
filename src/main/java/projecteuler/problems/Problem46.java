package projecteuler.problems;

import projecteuler.PrimeCache;

import java.util.stream.IntStream;

@SuppressWarnings("ConstantConditions")
public class Problem46 implements Problem<Integer> {
    
    @Override
    public Integer getCalculatedSolution() {
        return Common.naturalNumbers()
                .filter(i -> isOdd(i) && !PrimeCache.INSTANCE.isPrime(i) && !canBeWrittenGoldbachsWay(i))
                .findFirst()
                .getAsInt();
    }
    
    private static boolean isOdd(int i) {
        return i % 2 == 1;
    }
    
    private static boolean canBeWrittenGoldbachsWay(int n) {
        return IntStream.range(2, n)
                .filter(PrimeCache.INSTANCE::isPrime)
                .anyMatch(prime -> isAPerfectSquare((n - prime) / 2));
    }
    
    private static boolean isAPerfectSquare(int number) {
        return Math.pow((int) Math.sqrt(number), 2) == number;
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 5777;
    }
}
