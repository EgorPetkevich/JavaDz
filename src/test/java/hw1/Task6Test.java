package hw1;
import static org.junit.jupiter.api.Assertions.*;

import hw0.Task6;
import org.junit.jupiter.api.Test;
public class Task6Test {
    @Test
    public void testCountK() {
        assertEquals(3, Task6.countK(3524));
        assertEquals(5, Task6.countK(6621));
        assertEquals(4, Task6.countK(6554));
        assertEquals(3, Task6.countK(1234));

        // Проверка для чисел с одинаковыми цифрами
        assertEquals(-1, Task6.countK(1111));

        // Проверка для числа меньше 1000
        assertEquals(-1, Task6.countK(999));

        // Проверка для числа 6174
        assertEquals(0, Task6.countK(6174));
    }

    @Test
    public void testCountKWithInvalidInput() {
        // Проверка для числа меньше 1000
        assertEquals(-1, Task6.countK(999));

        // Проверка для числа с одинаковыми цифрами
        assertEquals(-1, Task6.countK(1111));
    }
}
