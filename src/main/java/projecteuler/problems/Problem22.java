package projecteuler.problems;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.stream.Stream;

public class Problem22 implements Problem<Long> {
    
    @Override
    public Long getCalculatedSolution() {
        int[] index = {0};
        
        return readFile("files/22.txt")
                .sorted()
                .mapToLong(line -> scoreForWord(++index[0], line))
                .sum();
    }
    
    private static int scoreForWord(int index, String word) {
        return index * Arrays.stream(word.split("")).mapToInt(c -> c.charAt(0) - 'A' + 1).sum();
    }
    
    private static Stream<String> readFile(String filename) {
        try {
            return Files.lines(new File(filename).toPath());
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
    
    @Override
    public Long getExpectedSolution() {
        return 871198282L;
    }
}
