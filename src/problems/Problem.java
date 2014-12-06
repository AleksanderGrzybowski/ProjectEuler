package problems;

public interface Problem<T> {
	T getCalculatedSolution();
	T getExpectedSolution();
}
