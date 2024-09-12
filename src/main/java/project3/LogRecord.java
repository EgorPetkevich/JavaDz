package project3;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class LogRecord {
    private OffsetDateTime timestamp;
    private String ipAddress;
    private String method;
    private String resource;
    private String protocol;
    private int responseCode;
    private long responseSize;
    private String userAgent;

    // Конструктор
    public LogRecord(OffsetDateTime timestamp, String ipAddress, String method, String resource,
        String protocol, int responseCode, long responseSize, String userAgent) {
        this.timestamp = timestamp;
        this.ipAddress = ipAddress;
        this.method = method;
        this.resource = resource;
        this.protocol = protocol;
        this.responseCode = responseCode;
        this.responseSize = responseSize;
        this.userAgent = userAgent;
    }

    // Геттеры
    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getMethod() {
        return method;
    }

    public String getResource() {
        return resource;
    }

    public String getProtocol() {
        return protocol;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public long getResponseSize() {
        return responseSize;
    }

    public String getUserAgent() {
        return userAgent;
    }
    public static LogRecord parseLogRecord(String logLine) {
        String[] parts = logLine.split(" ");

        // Пример: 93.180.71.3 - - [17/May/2015:08:05:32 +0000] "GET /downloads/product_1 HTTP/1.1" 304 0 "-" "Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.21)"

        // Получение времени из строки лога
        String timestampString = parts[3].substring(1) + " " + parts[4];
        OffsetDateTime timestamp = OffsetDateTime.parse(timestampString, DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z"));

        // Получение других значений из строки лога
        String ipAddress = parts[0];
        String method = parts[5].substring(1);
        String resource = parts[6];
        String protocol = parts[7].substring(0, parts[7].length() - 1);
        int responseCode = Integer.parseInt(parts[8]);
        long responseSize = Long.parseLong(parts[9]);
        String userAgent = parts[11].substring(1, parts[11].length() - 1);

        return new LogRecord(timestamp, ipAddress, method, resource, protocol, responseCode, responseSize, userAgent);
    }



}
