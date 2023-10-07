package hw1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
public class Task1Test {
    @Test
    public void testConvertToSecondsValidInput() {
        assertEquals(764, Task1.convertToSeconds("12:44"));
        assertEquals(3599, Task1.convertToSeconds("59:59"));
        assertEquals(600, Task1.convertToSeconds("10:00"));

    }

    @Test
    public void testConvertToSecondsInvalidInput() {
        // Некорректный формат времени (больше двух компонентов)
        assertEquals(-1, Task1.convertToSeconds("10:20:30"));

        // Некорректное количество секунд
        assertEquals(-1, Task1.convertToSeconds("05:60"));

        // Некорректное значение минут
//        assertEquals(-1, Task1.convertToSeconds("999:59"));

        // Некорректный формат времени (меньше двух компонентов)
        assertEquals(-1, Task1.convertToSeconds("10"));
    }

    @Test
    public void testConvertToSecondsInvalidInputNumberFormatException() {
        // Некорректный формат числа (не целое число)
        assertEquals(-1, Task1.convertToSeconds("abc:def"));
    }
}
