package project3;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class LogAnalyzer {



    public static LogReport analyzeLogs(Stream<LogRecord> logRecords) {
        // Инициализация переменных для подсчета метрик
        int totalRequests = 0;
        long totalResponseSize = 0;
        LocalDate startDate = null;
        LocalDate endDate = null;

        // Структуры данных для хранения информации о ресурсах и кодах ответа
        Map<String, Integer> resourceCounts = new HashMap<>();
        Map<Integer, Integer> responseCodeCounts = new HashMap<>();

        // Анализ логов
        for (LogRecord logRecord : logRecords.collect(Collectors.toList())) {
            // Обновление общего количества запросов
            totalRequests++;

            // Обновление общего размера ответов сервера
            totalResponseSize += logRecord.getResponseSize();

            // Обновление начальной даты
            if (startDate == null || logRecord.getTimestamp().toLocalDate().isBefore(startDate)) {
                startDate = logRecord.getTimestamp().toLocalDate();
            }

            // Обновление конечной даты
            if (endDate == null || logRecord.getTimestamp().toLocalDate().isAfter(endDate)) {
                endDate = logRecord.getTimestamp().toLocalDate();
            }

            // Подсчет запрашиваемых ресурсов
            resourceCounts.merge(logRecord.getResource(), 1, Integer::sum);

            // Подсчет кодов ответа
            responseCodeCounts.merge(logRecord.getResponseCode(), 1, Integer::sum);
        }

        // Рассчет среднего размера ответа сервера
        long averageResponseSize = totalRequests > 0 ? totalResponseSize / totalRequests : 0;

        // Создание объекта LogReport
        LogReport logReport = new LogReport(startDate, endDate, totalRequests, averageResponseSize);
        logReport.setResourceCounts(resourceCounts);
        logReport.setResponseCodeCounts(responseCodeCounts);

        return logReport;
    }
}
