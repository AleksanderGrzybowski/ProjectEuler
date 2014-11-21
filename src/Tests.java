public class Tests {



	public static void runAllTests() {
		System.out.println("Starting all tests for problems");

		for (int i = 1; i <= 99; ++i) {
			String className = "Problem" + String.format("%02d", i);
			testClass(className);
		}
	}

	public static void runFastTests() {
		System.out.println("Starting FAST tests for problems");

		for (int i = 1; i <= 99; ++i) {
			String className = "Problem" + String.format("%02d", i);
			try {
				if (Class.forName(className).isAnnotationPresent(TakesTime.class))
					continue;
			} catch (Exception e) {
				continue;
			}
			testClass(className);
		}
	}

	public static void testClass(String problemClassName) {

		Problem problem;
		try {
			problem = (Problem)Class.forName(problemClassName).newInstance();
		} catch (Exception e) {
			return;
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
