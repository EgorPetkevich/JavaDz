package hw1;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
public class Task3Test {
    @Test
    public void testIsNestableTrue() {
        assertTrue(Task3.isNestable(new int[]{1, 2, 3, 4}, new int[]{0, 6}));
        assertTrue(Task3.isNestable(new int[]{3, 1}, new int[]{4, 0}));
    }

    @Test
    public void testIsNestableFalse() {
        assertFalse(Task3.isNestable(new int[]{9, 9, 8}, new int[]{8, 9}));
        assertFalse(Task3.isNestable(new int[]{1, 2, 3, 4}, new int[]{2, 3}));
    }

    @Test
    public void testIsNestableWithEqualMinMax() {
        // Проверка случая, когда min(a1) равно min(a2) или max(a1) равно max(a2)
        assertFalse(Task3.isNestable(new int[]{1, 2, 3, 4}, new int[]{1, 6}));
        assertFalse(Task3.isNestable(new int[]{1, 2, 3, 4}, new int[]{0, 4}));
    }

    @Test
    public void testIsNestableEmptyArrays() {
        // Проверка случая с пустыми массивами
        assertTrue(Task3.isNestable(new int[]{}, new int[]{}));
    }
}
