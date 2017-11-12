package projecteuler.problems;


public class Problem22 implements Problem<Long> {
    
    @Override
    public Long getCalculatedSolution() {
        int[] index = {0};
        
        return Common.readFile("files/22.txt")
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
