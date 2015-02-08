package utils;

public class Triple {
	public final int a,b,c;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Triple triple = (Triple) o;

		if (a != triple.a) return false;
		if (b != triple.b) return false;
		if (c != triple.c) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = a;
		result = 31 * result + b;
		result = 31 * result + c;
		return result;
	}

	public Triple(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public String toString() {
		return "Triple{" +
				"a=" + a +
				", b=" + b +
				", c=" + c +
				'}';
	}
}
