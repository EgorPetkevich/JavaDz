package project3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;
public class LogParser {

    private static final DateTimeFormatter LOG_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z");

    public static Stream<LogRecord> parseLogs(String logPath, String fromDate) {
        try {
            return Files.lines(Path.of(logPath))
                .filter(line -> line.contains(fromDate))
                .map(LogRecord::parseLogRecord);
        } catch (IOException e) {
            throw new RuntimeException("Error reading log file", e);
        }
    }

    public static DateTimeFormatter getLogDateTimeFormatter() {
        return LOG_DATE_TIME_FORMATTER;
    }
}
