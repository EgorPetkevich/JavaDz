package project3;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NginxLogStatsApp {

    public static void main(String[] args) {
        if (args.length < 3) {
            System.err.println("java -jar nginx-log-stats.jar logs/2023* 2023-08-31 markdown");
            System.exit(1);
        }

        String logPath = args[0];
        String fromDate = args[1];
        String outputFormat = args[2];

        Path logFilePath = Paths.get(logPath);

        if (!logFilePath.toFile().exists()) {
            System.err.println("Error: Log file not found at " + logPath);
            System.exit(1);
        }

        try (Stream<LogRecord> logRecords = LogParser.parseLogs(logPath, fromDate)) {
            List<LogRecord> logRecordList = logRecords.collect(Collectors.toList());

            LogReport logReport = LogAnalyzer.analyzeLogs(logRecordList.stream());

            String reportOutput = logReport.generateReport(outputFormat);

            System.out.println(reportOutput);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
