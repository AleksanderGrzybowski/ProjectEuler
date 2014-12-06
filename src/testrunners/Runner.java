package testrunners;

import annotations.Done;
import problems.Problem;

import java.util.ArrayList;
import java.util.List;

public class Runner {

	public static List<String> getAllProblemClasses() {
		List<String> list = new ArrayList<>();

		for (int i = 1; i <= 99; ++i) {
			String className = "problems.Problem" + String.format("%02d", i);
			try {
				Class.forName(className).newInstance();
				list.add(className);
			} catch (Exception ignored) {
			}
		}
		return list;
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
		if (!expected.equals(actual))
			System.out.println("  FAIL: expected = " + expected + ", actual = " + actual);
		else {
			System.out.println("  PASS");
		}
	}

	public static void runTestsGroup(TestGroup testGroup) {
		System.out.println("Starting group " + testGroup);
		List<String> classes = getAllProblemClasses();

		for (String c : classes) {

			try {

				if (testGroup == TestGroup.ALL) {
					testClass(c);
				} else if (testGroup == TestGroup.DONE && Class.forName(c).isAnnotationPresent(Done.class)) {
					testClass(c);
				} else if (testGroup == TestGroup.NOTDONE && !Class.forName(c).isAnnotationPresent(Done.class))
					testClass(c);
				else {
//					throw new AssertionError();
				}

			} catch (ClassNotFoundException ignored) {
				throw new AssertionError();
			}

		}

	}

	public enum TestGroup {
		DONE, NOTDONE, ALL
	}
}
