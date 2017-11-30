package projecteuler.problems;


public class Problem22 implements Problem<Long> {
    
    private static final String WORDS_FILENAME = "files/22.txt";
    
    @Override
    public Long getCalculatedSolution() {
        int[] index = {0};
        
        return Common.readFile(WORDS_FILENAME)
                .sorted()
                .mapToLong(line -> scoreForWord(++index[0], line))
                .sum();
    }
    
    private static int scoreForWord(int index, String word) {
        return index * word.chars().map(c -> c - 'A' + 1).sum();
    }
    
    @Override
    public Long getExpectedSolution() {
        return 871198282L;
    }
}
