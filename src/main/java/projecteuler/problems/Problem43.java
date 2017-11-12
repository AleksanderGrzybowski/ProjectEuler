package projecteuler.problems;

public class Problem43 implements Problem<Long> {
    
    @Override
    public Long getCalculatedSolution() {
        return Problem24.permutations("0123456789")
                .stream()
                .filter(i -> matches(i, 1, 4, 2) &&
                        matches(i, 2, 5, 3) &&
                        matches(i, 3, 6, 5) &&
                        matches(i, 4, 7, 7) &&
                        matches(i, 5, 8, 11) &&
                        matches(i, 6, 9, 13) &&
                        matches(i, 7, 10, 17)
                )
                .mapToLong(Long::parseLong)
                .sum();
    }
    
    private static boolean matches(String number, int fromIndex, int toIndex, int divisor) {
        return Integer.parseInt(number.substring(fromIndex, toIndex)) % divisor == 0;
    }
    
    @Override
    public Long getExpectedSolution() {
        return 16695334890L;
    }
}
