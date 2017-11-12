package projecteuler.problems;

import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

@SuppressWarnings("ConstantConditions")
public class Problem42 implements Problem<Integer> {
    
    private static Set<Integer> TRIANGLE_NUMBERS;
    
    @Override
    public Integer getCalculatedSolution() {
        List<String> words = Common.readFile("files/42.txt").collect(toList());
        int maxWordValue = words.stream().map(Problem42::wordValue).max(Integer::compareTo).get();
        
        TRIANGLE_NUMBERS = Common.takeWhile(
                IntStream.iterate(1, i -> i + 1).map(i -> i * (i + 1) / 2).boxed(),
                i -> i <= maxWordValue
        ).collect(toSet());
        
        return (int) words.stream().filter(Problem42::isATriangleWord).count();
    }
    
    private static boolean isATriangleWord(String word) {
        return TRIANGLE_NUMBERS.contains(wordValue(word));
    }
    
    private static int wordValue(String word) {
        return word.chars().map(c -> c - 'A' + 1).sum();
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 162;
    }
}
