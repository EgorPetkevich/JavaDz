package hw6;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;
public class Task4 {
    public static void main(String[] args) {
        // Путь к файлу
        Path filePath = Path.of("output.txt");

        try (
            // Создаем файл и получаем OutputStream
            OutputStream fileOutputStream = Files.newOutputStream(filePath);

            // Добавляем CheckedOutputStream для проверки записи при помощи контрольной суммы
            CheckedOutputStream checkedOutputStream = new CheckedOutputStream(fileOutputStream, new Adler32());

            // Добавляем BufferedOutputStream для буферизации данных
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(checkedOutputStream);

            // Добавляем OutputStreamWriter и включаем поддержку UTF-8
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(bufferedOutputStream, "UTF-8");

            // Добавляем PrintWriter для удобной записи текста
            PrintWriter printWriter = new PrintWriter(outputStreamWriter)
        ) {
            // Записываем текст в файл
            printWriter.println("Programming is learned by writing programs. ― Brian Kernighan");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
