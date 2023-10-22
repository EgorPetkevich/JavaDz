package hw1;

import hw0.Task7;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class Task7Test {
    @Test
    public void testRotateRight() {
        // Проверяем сдвиг вправо
        int[] result = Task7.rotateRight(8, 1);
        assertArrayEquals(new int[]{4, 8, 4}, result);
    }

    @Test
    public void testRotateLeft() {
        // Проверяем сдвиг влево
        int[] result = Task7.rotateLeft(16, 1);
        assertArrayEquals(new int[]{1, 16, 1}, result);
    }

    @Test
    public void testRotateRightWithZeroShift() {
        // Проверяем сдвиг вправо с нулевым сдвигом
        int[] result = Task7.rotateRight(5, 0);
        assertArrayEquals(new int[]{5, 5, 5}, result);
    }

    @Test
    public void testRotateLeftWithZeroShift() {
        // Проверяем сдвиг влево с нулевым сдвигом
        int[] result = Task7.rotateLeft(10, 0);
        assertArrayEquals(new int[]{10, 10, 10}, result);
    }
}
