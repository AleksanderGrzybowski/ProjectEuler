package problems;

import annotations.Done;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

@Done
public class Problem19 implements Problem<Integer> {
	@Override
	public Integer getCalculatedSolution() {
		int count = 0;

		for (Month month : Month.values()) {
			for (int year = 1901; year <= 2000; ++year) {
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
