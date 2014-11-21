import java.util.ArrayList;
import java.util.List;

public class Tests {

	public static List<String> getAllProblemClasses() {
		List<String> list = new ArrayList<>();

		for (int i = 1; i <= 99; ++i) {
			String className = "Problem" + String.format("%02d", i);
			try {
				Class.forName(className).newInstance();
				list.add(className);
			} catch (Exception e) {
				// empty
			}
		}
		return list;
	}

	public static void runAllTests() {
		System.out.println("Starting ALL tests for problems");
		getAllProblemClasses().forEach(Tests::testClass);
	}


	public static void runFastTests() {
		System.out.println("Starting FAST tests for problems");

		for (String s : getAllProblemClasses()) {
			try {
				if (Class.forName(s).isAnnotationPresent(TakesTime.class))
					continue;
			} catch (Exception e) {
				throw new AssertionError();
			}
			testClass(s);
		}
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
}
