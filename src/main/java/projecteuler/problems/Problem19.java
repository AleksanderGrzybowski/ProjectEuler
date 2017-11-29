package projecteuler.problems;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Problem19 implements Problem<Long> {
    
    private static final LocalDate DATE_FROM = LocalDate.of(1901, Month.JANUARY, 1);
    private static final LocalDate DATE_TO = LocalDate.of(2000, Month.DECEMBER, 31);
    private static final int DAYS_IN_WEEK = 7;
    
    @Override
    public Long getCalculatedSolution() {
        return dateRangeClosed(
                DATE_FROM.with(TemporalAdjusters.next(DayOfWeek.SUNDAY)),
                DATE_TO,
                DAYS_IN_WEEK
        )
                .filter(Problem19::isSundayAndFirstDayOfMonth)
                .count();
    }
    
    private static Stream<LocalDate> dateRangeClosed(LocalDate from, LocalDate to, int step) {
        List<LocalDate> dates = new ArrayList<>();
        
        for (; from.isBefore(to) || from.equals(to); from = from.plusDays(step)) {
            dates.add(from);
        }
        
        return dates.stream();
    }
    
    private static boolean isSundayAndFirstDayOfMonth(LocalDate date) {
        return date.getDayOfMonth() == 1 && date.getDayOfWeek() == DayOfWeek.SUNDAY;
    }
    
    @Override
    public Long getExpectedSolution() {
        return 171L;
    }
}
