package hw5;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
public class Task3 {
    public static Optional<LocalDate> parseDate(String dateString) {
        try {
            // Попробуйте распарсить дату в различных форматах
            DateTimeFormatter[] formatters = {
                DateTimeFormatter.ofPattern("yyyy-MM-dd"),
                DateTimeFormatter.ofPattern("yyyy-M-d"),
                DateTimeFormatter.ofPattern("M/d/yyyy"),
                DateTimeFormatter.ofPattern("M/d/yy"),
                DateTimeFormatter.ofPattern("MMMM d, yyyy"),
                DateTimeFormatter.ofPattern("MMMM d, yy"),
                DateTimeFormatter.ofPattern("MMM d, yyyy"),
                DateTimeFormatter.ofPattern("MMM d, yy"),
                DateTimeFormatter.ofPattern("EEEE"),
                DateTimeFormatter.ofPattern("MMMMM d"),
                DateTimeFormatter.ofPattern("d MMMM"),
                DateTimeFormatter.ofPattern("d"),
                DateTimeFormatter.ofPattern("yyyy"),
            };

            for (DateTimeFormatter formatter : formatters) {
                try {
                    LocalDate parsedDate = LocalDate.parse(dateString, formatter);
                    return Optional.of(parsedDate);
                } catch (Exception ignored) {
                    // Пропускаем форматы, которые не соответствуют
                }
            }

            // Обработка относительных дат
            if (dateString.equals("tomorrow")) {
                return Optional.of(LocalDate.now().plus(1, ChronoUnit.DAYS));
            } else if (dateString.equals("today")) {
                return Optional.of(LocalDate.now());
            } else if (dateString.equals("yesterday")) {
                return Optional.of(LocalDate.now().minus(1, ChronoUnit.DAYS));
            } else if (dateString.matches("\\d+ days ago")) {
                int daysAgo = Integer.parseInt(dateString.split(" ")[0]);
                return Optional.of(LocalDate.now().minus(daysAgo, ChronoUnit.DAYS));
            }

        } catch (Exception e) {
            // Если не удалось распарсить в одном из форматов, вернуть Optional.empty()
        }

        return Optional.empty();
    }

    public static void main(String[] args) {
        // Пример использования
        String dateString = "2020-10-10";
        Optional<LocalDate> result = parseDate(dateString);

        if (result.isPresent()) {
            System.out.println("Дата: " + result.get());
        } else {
            System.out.println("Строка не соответствует ни одному из форматов.");
        }
    }
}
