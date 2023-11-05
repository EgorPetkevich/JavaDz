package hw3;

import org.junit.jupiter.api.Test;
import java.util.TreeMap;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class Task7Test {
    @Test
    public void testNullHandlingComparator() {
        Task7.NullHandlingComparator comparator = new Task7.NullHandlingComparator();
        TreeMap<String, String> tree = new TreeMap<>(comparator);

        // Добавляем ключи и значения в TreeMap
        tree.put("apple", "red");
        tree.put("banana", "yellow");
        tree.put(null, "unknown");
        tree.put("cherry", "red");

        // Проверяем, что TreeMap содержит null
        boolean containsNull = tree.containsKey(null);
        assertEquals(true, containsNull);

        // Проверяем порядок ключей
        String[] expectedOrder = {null, "apple", "banana", "cherry"};
        String[] actualOrder = tree.keySet().toArray(new String[0]);

        assertArrayEquals(expectedOrder, actualOrder);
    }

    private void assertArrayEquals(String[] expected, String[] actual) {
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

}
