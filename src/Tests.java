public class Tests {
	public static void main(String[] args) {
		System.out.println("Starting tests for problems");

		for (int i = 1; i <= 99; ++i) {
			String className = "Problem" + String.format("%02d", i);
			Problem problem;
			try {
				problem = (Problem)Class.forName(className).newInstance();
			} catch (Exception e) {
				continue;
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
}
