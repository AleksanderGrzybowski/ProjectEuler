package projecteuler.runner;

import projecteuler.problems.Problem;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    
    private static final int MAX_NUMBER_OF_PROBLEMS = 99;
    
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
        
        System.out.print("" + problem.getClass());
        Object expected = problem.getExpectedSolution();
        Object actual = problem.getCalculatedSolution();
        
        if (actual == null) {
            System.out.println("  IGNORED");
        } else if (expected.equals(actual)) {
            System.out.println("  PASS");
        } else {
            System.out.println("  FAIL: expected = " + expected + ", actual = " + actual);
            System.exit(1);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Starting...");
        
        getAllProblems().forEach(Runner::run);
    }
}
