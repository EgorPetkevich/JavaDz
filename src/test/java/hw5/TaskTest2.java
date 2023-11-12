package hw5;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class TaskTest2 {
    @Test
    void testFindFridaysTheThirteenth() {
        int yearToSearch = 2024;
        List<LocalDate> fridaysTheThirteenth = Task2.findFridaysTheThirteenth(yearToSearch);

        assertEquals(2, fridaysTheThirteenth.size());
        assertEquals(LocalDate.of(2024, 9, 13), fridaysTheThirteenth.get(0));
        assertEquals(LocalDate.of(2024, 12, 13), fridaysTheThirteenth.get(1));
    }

}
