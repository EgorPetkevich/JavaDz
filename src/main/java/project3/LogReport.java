package project3;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
public class LogReport {

    private LocalDate startDate;
    private LocalDate endDate;
    private int totalRequests;
    private long averageResponseSize;
    private Map<String, Integer> resourceCounts;
    private Map<Integer, Integer> responseCodeCounts;

    public LogReport(LocalDate startDate, LocalDate endDate, int totalRequests, long averageResponseSize) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalRequests = totalRequests;
        this.averageResponseSize = averageResponseSize;
        this.resourceCounts = new HashMap<>();
        this.responseCodeCounts = new HashMap<>();
    }

    // Геттеры и другие методы...

    public void setResourceCounts(Map<String, Integer> resourceCounts) {
        this.resourceCounts = new HashMap<>(resourceCounts);
    }

    public void setResponseCodeCounts(Map<Integer, Integer> responseCodeCounts) {
        this.responseCodeCounts = new HashMap<>(responseCodeCounts);
    }

    // Конструктор и геттеры/сеттеры

    public String generateReport(String outputFormat) {
        StringBuilder report = new StringBuilder();

        // Общая информация
        report.append("#### Общая информация\n\n");
        report.append("|        Метрика        |     Значение |\n");
        report.append("|:---------------------:|-------------:|\n");
        report.append("|       Файл(-ы)        | `access.log` |\n");
        report.append("|    Начальная дата     |   ").append(startDate).append(" |\n");
        report.append("|     Конечная дата     |            - |\n");
        report.append("|  Количество запросов  |       ").append(String.format("%,d", totalRequests)).append(" |\n");
        report.append("| Средний размер ответа |         ").append(averageResponseSize).append("b |\n\n");

        // Запрашиваемые ресурсы
        report.append("#### Запрашиваемые ресурсы\n\n");
        report.append("|     Ресурс      | Количество |\n");
        report.append("|:---------------:|-----------:|\n");
        for (Map.Entry<String, Integer> entry : resourceCounts.entrySet()) {
            report.append("|  ").append(entry.getKey()).append("  |      ").append(String.format("%,d", entry.getValue())).append(" |\n");
        }
        report.append("\n");

        // Коды ответа
        report.append("#### Коды ответа\n\n");
        report.append("| Код |          Имя          | Количество |\n");
        report.append("|:---:|:---------------------:|-----------:|\n");
        for (Map.Entry<Integer, Integer> entry : responseCodeCounts.entrySet()) {
            report.append("| ").append(entry.getKey()).append(" | ");
            switch (entry.getKey()) {
                case 200:
                    report.append("OK");
                    break;
                case 404:
                    report.append("Not Found");
                    break;
                case 500:
                    report.append("Internal Server Error");
                    break;
                default:
                    report.append("Unknown");
            }
            report.append(" |       ").append(String.format("%,d", entry.getValue())).append(" |\n");
        }

        return report.toString();
    }
}
