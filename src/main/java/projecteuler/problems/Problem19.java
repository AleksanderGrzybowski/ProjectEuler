package projecteuler.problems;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Problem19 implements Problem<Integer> {
    
    @Override
    public Integer getCalculatedSolution() {
        return (int) rangeClosed(
                LocalDate.of(1901, Month.JANUARY, 1).with(TemporalAdjusters.next(DayOfWeek.SUNDAY)),
                LocalDate.of(2000, Month.DECEMBER, 31),
                7
        )
                .filter(date -> date.getDayOfMonth() == 1 && date.getDayOfWeek() == DayOfWeek.SUNDAY)
                .count();
    }
    
    private static Stream<LocalDate> rangeClosed(LocalDate from, LocalDate to, int step) {
        List<LocalDate> dates = new ArrayList<>();
        
        for (; from.isBefore(to) || from.equals(to); from = from.plusDays(step)) {
            dates.add(from);
        }
        
        return dates.stream();
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 171;
    }
}
