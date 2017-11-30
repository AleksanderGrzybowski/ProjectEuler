package projecteuler.problems;

import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;

public class Problem31 implements Problem<Integer> {
    
    private static final int TARGET_SUM = 200;
    
    @Override
    public Integer getCalculatedSolution() {
        Set<List<CoinCount>> possibilities = new HashSet<>();
        
        for (int a = TARGET_SUM; a >= 0; a -= 200) {
            for (int b = a; b >= 0; b -= 100) {
                for (int c = b; c >= 0; c -= 50) {
                    for (int d = c; d >= 0; d -= 20) {
                        for (int e = d; e >= 0; e -= 10) {
                            for (int f = e; f >= 0; f -= 5) {
                                for (int g = f; g >= 0; g -= 2) {
                                    possibilities.add(asList(
                                            new CoinCount(200, a),
                                            new CoinCount(100, b),
                                            new CoinCount(50, c),
                                            new CoinCount(20, d),
                                            new CoinCount(10, e),
                                            new CoinCount(5, f),
                                            new CoinCount(2, g),
                                            new CoinCount(1, 200 - a - b - c - d - e - f - g)
                                    ));
                                }
                            }
                        }
                    }
                }
            }
        }
        
        return possibilities.size();
    }
    
    @Data
    private static class CoinCount {
        final int coin, count;
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 73682;
    }
}
