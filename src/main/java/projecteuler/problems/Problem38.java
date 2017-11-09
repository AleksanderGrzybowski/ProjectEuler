package projecteuler.problems;

import java.util.stream.LongStream;

import static projecteuler.problems.Problem32.isPandigital;

@SuppressWarnings("ConstantConditions")
public class Problem38 implements Problem<Long> {
    
    private static final int TOP_5_DIGIT_NUMBER = 10000;
    private static final int PANDIGITAL_MAX_LENGTH = 9;
    
    @Override
    public Long getCalculatedSolution() {
        return LongStream.rangeClosed(1, TOP_5_DIGIT_NUMBER)
                .flatMap(Problem38::findPandigitalsIfPresent)
                .max().getAsLong();
    }
    
    private static LongStream findPandigitalsIfPresent(long base) {
        String number = "";
        
        for (int n = 1; number.length() < PANDIGITAL_MAX_LENGTH; n++) {
            number += Long.toString(base * n);
        }
        
        return isPandigital(number) ? LongStream.of(Long.parseLong(number)) : LongStream.empty();
    }
    
    @Override
    public Long getExpectedSolution() {
        return 932718654L;
    }
}
