package project3_1;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
public class NginxLogAnalyzer {
    public static void main(String[] args) {
        if (args.length != 2 || !args[0].equals("--path")) {
            System.out.println("Usage: java -jar nginx-log-analyzer.jar --path <logFilePath>");
            System.exit(1);
        }

        String logFilePath = args[1];
        LogReport logReport = analyzeLogs(logFilePath);

        // Генерация текстового отчета в формате Markdown
        String markdownReport = logReport.toMarkdown();
        System.out.println(markdownReport);
    }



    private static TypedLogRecord parseLogLine(String logLine) {
        // Простой способ разделения по пробелам
        String[] logParts = logLine.split("\\s+");
        return new TypedLogRecord(
            logParts[0],  // $remote_addr
            logParts[1],  // $remote_user
            OffsetDateTime.parse(logParts[3].substring(1, logParts[3].length() - 1)),  // [$time_local]
            logParts[5].substring(1),  // "$request"
            Integer.parseInt(logParts[6]),  // $status
            Long.parseLong(logParts[7]),  // $body_bytes_sent
            logParts[9].equals("\"-\"") ? null : logParts[9].substring(1, logParts[9].length() - 1),  // "$http_referer"
            logParts[11].substring(1, logParts[11].length() - 1)  // "$http_user_agent"
        );
    }
    private static LogReport analyzeLogs(String logFilePath) {
        try (Stream<String> lines = Files.lines(Paths.get(logFilePath))) {
            return lines.map(NginxLogAnalyzer::parseLogLine)
                .collect(() -> new LogReport(logFilePath), LogReport::accumulate, LogReport::combine);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

class TypedLogRecord {
    private String remoteAddr;
    private String remoteUser;
    private OffsetDateTime timestamp;
    private String request;
    private int status;
    private long bodyBytesSent;
    private String referer;
    private String userAgent;

    public TypedLogRecord(String remoteAddr, String remoteUser, OffsetDateTime timestamp,
        String request, int status, long bodyBytesSent, String referer, String userAgent) {
        this.remoteAddr = remoteAddr;
        this.remoteUser = remoteUser;
        this.timestamp = timestamp;
        this.request = request;
        this.status = status;
        this.bodyBytesSent = bodyBytesSent;
        this.referer = referer;
        this.userAgent = userAgent;
    }

    // Геттеры
    public String getRequest() {
        return request;
    }

    public int getStatus() {
        return status;
    }

    public long getBodyBytesSent() {
        return bodyBytesSent;
    }

    // ... (existing code)
}

class LogReport {
    private String logFilePath;
    private int totalRequests;
    private Map<String, Integer> resourceFrequency;
    private Map<Integer, Integer> responseCodeFrequency;
    private long totalResponseSize;

    public LogReport(String logFilePath) {
        this.logFilePath = logFilePath;
        this.totalRequests = 0;
        this.resourceFrequency = new HashMap<>();
        this.responseCodeFrequency = new HashMap<>();
        this.totalResponseSize = 0;
    }


    public LogReport() {
        this.totalRequests = 0;
        this.resourceFrequency = new HashMap<>();
        this.responseCodeFrequency = new HashMap<>();
        this.totalResponseSize = 0;
    }

    public void accumulate(TypedLogRecord logRecord) {
        totalRequests++;
        resourceFrequency.merge(logRecord.getRequest(), 1, Integer::sum);
        responseCodeFrequency.merge(logRecord.getStatus(), 1, Integer::sum);
        totalResponseSize += logRecord.getBodyBytesSent();
    }

    public void combine(LogReport other) {
        totalRequests += other.totalRequests;
        other.resourceFrequency.forEach((resource, count) ->
            resourceFrequency.merge(resource, count, Integer::sum));
        other.responseCodeFrequency.forEach((code, count) ->
            responseCodeFrequency.merge(code, count, Integer::sum));
        totalResponseSize += other.totalResponseSize;
    }

    public String toMarkdown() {
        StringBuilder markdownReport = new StringBuilder();
        markdownReport.append("#### Общая информация\n\n");
        markdownReport.append("|        Метрика        |     Значение |\n");
        markdownReport.append("|:---------------------:|-------------:|\n");
        markdownReport.append("|       Файл(-ы)        | `" + logFilePath + "` |\n");
        // Добавьте остальные метрики...

        markdownReport.append("\n#### Запрашиваемые ресурсы\n\n");
        markdownReport.append("|     Ресурс      | Количество |\n");
        markdownReport.append("|:---------------:|-----------:|\n");
        resourceFrequency.forEach((resource, count) ->
            markdownReport.append("|  `" + resource + "`  |      " + count + " |\n"));

        markdownReport.append("\n#### Коды ответа\n\n");
        markdownReport.append("| Код |          Имя          | Количество |\n");
        markdownReport.append("|:---:|:---------------------:|-----------:|\n");
        responseCodeFrequency.forEach((code, count) ->
            markdownReport.append("| " + code + " |          " + getResponseName(code) + "           |       " + count + " |\n"));

        return markdownReport.toString();
    }

    private String getResponseName(int responseCode) {
        // Здесь вы можете реализовать логику присвоения имени коду ответа
        // В данном примере возвращается сам код ответа
        return String.valueOf(responseCode);
    }
}
