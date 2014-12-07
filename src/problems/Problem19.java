package problems;

import annotations.Done;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

@Done
public class Problem19 implements Problem<Integer> {

	static final int START_YEAR = 1901;
	static final int END_YEAR = 2000;

	@Override
	public Integer getCalculatedSolution() {
		int count = 0;

		for (Month month : Month.values()) {
			for (int year = START_YEAR; year <= END_YEAR; ++year) {
				LocalDate date = LocalDate.of(year, month, 1);
				if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
					count++;
				}
			}
		}
		return count;
	}

	@Override
	public Integer getExpectedSolution() {
		return 171;
	}
}
