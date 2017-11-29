package projecteuler.problems;

import java.util.HashMap;
import java.util.Map;

public class Problem17 implements Problem<Integer> {
    
    @Override
    public Integer getCalculatedSolution() {
        Map<Integer, String> words = new HashMap<>();
        
        words.put(1, "one");
        words.put(2, "two");
        words.put(3, "three");
        words.put(4, "four");
        words.put(5, "five");
        words.put(6, "six");
        words.put(7, "seven");
        words.put(8, "eight");
        words.put(9, "nine");
        words.put(10, "ten");
        words.put(11, "eleven");
        words.put(12, "twelve");
        words.put(13, "thirteen");
        words.put(14, "fourteen");
        words.put(15, "fifteen");
        words.put(16, "sixteen");
        words.put(17, "seventeen");
        words.put(18, "eighteen");
        words.put(19, "nineteen");
        words.put(20, "twenty");
        words.put(30, "thirty");
        words.put(40, "forty");
        words.put(50, "fifty");
        words.put(60, "sixty");
        words.put(70, "seventy");
        words.put(80, "eighty");
        words.put(90, "ninety");
        words.put(1000, "one thousand");
        
        for (int tensDigit = 2; tensDigit <= 9; ++tensDigit) {
            for (int onesDigit = 1; onesDigit <= 9; ++onesDigit) {
                words.put(10 * tensDigit + onesDigit, words.get(tensDigit * 10) + "-" + words.get(onesDigit));
            }
        }
        
        for (int hundredsDigit = 1; hundredsDigit <= 9; ++hundredsDigit) {
            words.put(100 * hundredsDigit, words.get(hundredsDigit) + " hundred");
            
            for (int tensPart = 1; tensPart <= 99; ++tensPart) {
                words.put(100 * hundredsDigit + tensPart, words.get(100 * hundredsDigit) + " and " + words.get(tensPart));
            }
        }
        
        return words.values().stream()
                .mapToInt(Problem17::wordLength)
                .sum();
    }
    
    private static int wordLength(String word) {
        return withRemovedSpacesAndHypens(word).length();
    }
    
    private static String withRemovedSpacesAndHypens(String word) {
        return word.replace(" ", "").replace("-", "");
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 21124;
    }
}

