package projecteuler.problems;

import java.util.List;
import java.util.stream.IntStream;

import static java.lang.Long.parseLong;
import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.toList;

@SuppressWarnings("ConstantConditions")
public class Problem24 implements Problem<Long> {
    
    @Override
    public Long getCalculatedSolution() {
        return parseLong(
                permutations("0123456789").parallelStream()
                        .sorted()
                        .skip(999999)
                        .findFirst().get()
        );
    }
    
    private static List<String> permutations(String number) {
        return number.length() == 1 ? (
                singletonList(number)
        ) : (
                permutations(number.substring(1))
                        .stream()
                        .flatMap(tailPerm ->
                                IntStream.rangeClosed(0, tailPerm.length()).mapToObj(i ->
                                        new StringBuilder(tailPerm).insert(i, number.charAt(0)).toString()
                                )
                        ).collect(toList())
        );
    }
    
    @Override
    public Long getExpectedSolution() {
        return 2783915460L;
    }
}
