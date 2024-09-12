package project3_1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class LogAnalyzerTest {

    @Test
    @DisplayName("Check if the expected log entry is present in the log file")
    public void testLogContent() throws Exception {
        String logFilePath = "/Users/georgepopkich/IdeaProjects/JavaDz/java-course-2023/project-template/src/main/java/project3_1/nginx-access.log";
        String expectedLogEntry = "Expected log entry content";

        assertTrue(Files.lines(Paths.get(logFilePath)).anyMatch(line -> line.contains(expectedLogEntry)));
    }
}
}
