package utils;

public class Pair {
	public final int a, b;

	public Pair(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Pair pair = (Pair) o;

		if (a != pair.a) return false;
		if (b != pair.b) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = a;
		result = 31 * result + b;
		return result;
	}
}
