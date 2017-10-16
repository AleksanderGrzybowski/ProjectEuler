package projecteuler.runner;

import projecteuler.problems.Problem;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Runner {
    
    private static final int MAX_NUMBER_OF_PROBLEMS = 99;
    
    public static void main(String[] args) {
        getAllProblems().forEach(Runner::run);
    }
    
    private static List<Problem> getAllProblems() {
        List<Problem> problems = new ArrayList<>();
        
        for (int i = 1; i <= MAX_NUMBER_OF_PROBLEMS; ++i) {
            String className = "projecteuler.problems.Problem" + String.format("%02d", i);
            try {
                problems.add((Problem) Class.forName(className).newInstance());
            } catch (Exception ignored) {
            }
        }
        return problems;
    }
    
    private static void run(Problem problem) {
        System.out.print(problem.getClass().getSimpleName());
        Object expected = problem.getExpectedSolution();
    
        TimedResult result = time(problem::getCalculatedSolution);
        Object actual = result.value;
        
        if (actual == null) {
            System.out.println("  IGNORED");
        } else if (expected.equals(actual)) {
            System.out.printf("  PASS  %4d ms\n", result.timeMS);
        } else {
            System.out.println("  FAIL: expected = " + expected + ", actual = " + actual);
            System.exit(1);
        }
    }
    
    private static TimedResult time(Supplier<Object> function) {
        long start = System.currentTimeMillis();
        Object result = function.get();
        long end = System.currentTimeMillis();
        
        return new TimedResult(result, end - start);
    }
    
    private static class TimedResult {
        public final Object value;
        public final long timeMS;
        
        private TimedResult(Object value, long timeMS) {
            this.value = value;
            this.timeMS = timeMS;
        }
    }
}
