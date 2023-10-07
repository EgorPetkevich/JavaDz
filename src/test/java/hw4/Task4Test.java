package hw4;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
public class Task4Test {
    @Test
    public void testFixStringEvenLength() {
        assertEquals("214365", Task4.fixString("123456"));
        assertEquals("This is a mixed up string.", Task4.fixString("hTsii  s aimex dpus rtni.g"));
        assertEquals("abcde", Task4.fixString("badce"));
    }


    @Test
    public void testFixStringNullInput() {
        // Проверка на случай с null входными данными
        assertEquals("Некорректная строка", Task4.fixString(null));
    }

    @Test
    public void testFixStringEmptyInput() {
        // Проверка на случай с пустой строкой
        assertEquals("", Task4.fixString(""));
    }

}
