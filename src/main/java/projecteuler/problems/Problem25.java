package projecteuler.problems;

import java.math.BigInteger;
import java.util.function.Supplier;
import java.util.stream.Stream;

@SuppressWarnings("ConstantConditions")
public class Problem25 implements Problem<Integer> {
    
    @Override
    public Integer getCalculatedSolution() {
        return fibbonacci().filter(f -> f.value.toString().length() == 1000).findFirst().get().index;
    }
    
    private Stream<WithIndex> fibbonacci() {
        return Stream.generate(new Supplier<WithIndex>() {
            
            private BigInteger a = BigInteger.ONE;
            private BigInteger b = BigInteger.ONE;
            private int currentIndex = 0;
            
            @Override
            public WithIndex get() {
                currentIndex++;
                
                if (currentIndex == 1 || currentIndex == 2) {
                    return new WithIndex(currentIndex, BigInteger.ONE);
                } else {
                    BigInteger result = a.add(b);
                    a = b;
                    b = result;
                    return new WithIndex(currentIndex, result);
                }
            }
        });
    }
    
    private static class WithIndex {
        final int index;
        final BigInteger value;
        
        WithIndex(int index, BigInteger value) {
            this.index = index;
            this.value = value;
        }
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 4782;
    }
}
