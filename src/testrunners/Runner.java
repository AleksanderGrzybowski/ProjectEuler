package testrunners;

import annotations.Done;
import problems.Problem;

import java.util.ArrayList;
import java.util.List;

public class Runner {

	public static final int MAX_NUMBER_OF_PROBLEMS = 99;

	public static List<String> getAllProblemClasses() {
		List<String> classes = new ArrayList<>();

		for (int i = 1; i <= MAX_NUMBER_OF_PROBLEMS; ++i) {
			String className = "problems.Problem" + String.format("%02d", i);
			try {
				Class.forName(className);
				classes.add(className);
			} catch (Exception ignored) {
			}
		}
		return classes;
	}

	public static void testClass(String problemClassName) {
		Problem problem;

		try {
			problem = (Problem) Class.forName(problemClassName).newInstance();
		} catch (Exception e) {
			throw new AssertionError();
		}

		System.out.print("" + problem.getClass());
		Object expected = problem.getExpectedSolution();
		Object actual = problem.getCalculatedSolution();

		if (expected.equals(actual)) {
			System.out.println("  PASS");
		} else {
			System.out.println("  FAIL: expected = " + expected + ", actual = " + actual);
			System.exit(1);
		}
	}

	public static void runTestsGroup(TestGroup testGroup) {
		System.out.println("Starting group " + testGroup);
		List<String> classes = getAllProblemClasses();

		for (String c : classes) {
			try {
				boolean shouldRunTest = (testGroup == TestGroup.ALL)
						|| (testGroup == TestGroup.NOTDONE && !Class.forName(c).isAnnotationPresent(Done.class));

				if (shouldRunTest) {
					testClass(c);
				}
			} catch (ClassNotFoundException ignored) {
				throw new AssertionError();
			}
		}
	}

	public enum TestGroup {
		NOTDONE, ALL
	}
}
