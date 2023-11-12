package hw5;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
public class TaskTest3 {
    @Test
    void testParseDate() {
        // Проверка успешного распознавания даты в различных форматах
        assertParsedDate("2020-10-10");
        assertParsedDate("2020-12-2");
        assertParsedDate("1/3/1976");
        assertParsedDate("1/3/20");
        assertParsedDate("tomorrow");
        assertParsedDate("today");
        assertParsedDate("yesterday");
        assertParsedDate("2234 days ago");

        // Проверка, что возвращает Optional.empty() при некорректных данных
        assertNotParsedDate("invalidDate");
        assertNotParsedDate("notADate");
    }

    private void assertParsedDate(String dateString) {
        Optional<LocalDate> result = Task3.parseDate(dateString);
        assertTrue(result.isPresent(), "Expected a parsed date for input: " + dateString);
    }

    private void assertNotParsedDate(String dateString) {
        Optional<LocalDate> result = Task3.parseDate(dateString);
        assertTrue(result.isEmpty(), "Expected no parsed date for input: " + dateString);
    }

}
