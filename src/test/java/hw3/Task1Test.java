package hw3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class Task1Test {
    @Test
    public void testEncrypt() {
        // Тестирование на обычной строке
        String input = "Hello, World!";
        String expected = "Svool, Dliow!";
        String encrypted = Task1.encrypt(input);
        assertEquals(expected, encrypted);

        // Тестирование на пустой строке
        input = "";
        expected = "";
        encrypted = Task1.encrypt(input);
        assertEquals(expected, encrypted);

        // Тестирование на строке с пробелами
        input = "This is a test";
        expected = "Gsrh rh z gvhg";
        encrypted = Task1.encrypt(input);
        assertEquals(expected, encrypted);

        // Тестирование на строке с числами и специальными символами
        input = "123!@#";
        expected = "123!@#";
        encrypted = Task1.encrypt(input);
        assertEquals(expected, encrypted);
    }
}
