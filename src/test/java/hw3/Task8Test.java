package hw3;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class Task8Test {
    @Test
    public void testBackwardIterator() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        Task8.BackwardIterator<Integer> backwardIterator = new Task8.BackwardIterator<>(numbers);

        // Проверяем, что hasNext работает правильно
        assertTrue(backwardIterator.hasNext());
        backwardIterator.next();
        assertTrue(backwardIterator.hasNext());
        backwardIterator.next();
        assertTrue(backwardIterator.hasNext());
        backwardIterator.next();
        assertFalse(backwardIterator.hasNext());

        // Проверяем, что next возвращает элементы в обратном порядке
        backwardIterator = new Task8.BackwardIterator<>(numbers);
        assertEquals(3, backwardIterator.next());
        assertEquals(2, backwardIterator.next());
        assertEquals(1, backwardIterator.next());

        // Проверяем, что итератор выкидывает NoSuchElementException, если попытаться пройти дальше
        assertThrows(NoSuchElementException.class, backwardIterator::next);
    }

}
