package hw3;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
public class Task3Test {
    @Test
    public void testFreqDictWithStrings() {
        List<String> input = Arrays.asList("a", "bb", "a", "bb");
        Map<String, Integer> expected = Map.of("bb", 2, "a", 2);
        Map<String, Integer> actual = Task3.freqDict(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFreqDictWithDifferentTypes() {
        List<Object> input = Arrays.asList("a", 1, "a", 1);
        Map<Object, Integer> expected = Map.of("a", 2, 1, 2);
        Map<Object, Integer> actual = Task3.freqDict(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFreqDictWithEmptyList() {
        List<Object> input = Arrays.asList();
        Map<Object, Integer> expected = Map.of();
        Map<Object, Integer> actual = Task3.freqDict(input);
        Assertions.assertEquals(expected, actual);
    }
}
