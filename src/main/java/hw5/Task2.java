package hw5;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
public class Task2 {
    public static List<LocalDate> findFridaysTheThirteenth(int year) {
        List<LocalDate> fridaysTheThirteenth = new ArrayList<>();

        for (int month = 1; month <= 12; month++) {
            LocalDate date = LocalDate.of(year, month, 13);
            if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                fridaysTheThirteenth.add(date);
            }
        }

        return fridaysTheThirteenth;
    }

    public static LocalDate findNextFridayTheThirteenth(LocalDate date) {
        return date.withDayOfMonth(13).with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
    }

    public static void main(String[] args) {
        int yearToSearch = 1925;
        List<LocalDate> fridaysTheThirteenth = findFridaysTheThirteenth(yearToSearch);
        System.out.println("Fridays the 13th in " + yearToSearch + ": " + fridaysTheThirteenth);

        LocalDate currentDate = LocalDate.now();
        LocalDate nextFridayTheThirteenth = findNextFridayTheThirteenth(currentDate);
        System.out.println("Next Friday the 13th from " + currentDate + ": " + nextFridayTheThirteenth);
    }

}
