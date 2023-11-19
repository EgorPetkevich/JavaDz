package hw6;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class TaskTest2 {
    @TempDir
    Path tempDir;

    @Test
    void testCloneFile() throws IOException {
        // Создаем временный файл для теста
        Path originalFilePath = createTempFile("originalFile.txt");

        // Клонируем файл
        Task2.cloneFile(originalFilePath);

        // Проверяем, что копия была создана
        Path copiedFilePath = Paths.get(tempDir.toString(), "originalFile — копия.txt");
        assertTrue(Files.exists(copiedFilePath), "Копия файла не была создана");
    }

    // Вспомогательный метод для создания временного файла
    private Path createTempFile(String fileName) throws IOException {
        return Files.createFile(tempDir.resolve(fileName));
    }
}
