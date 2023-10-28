package hw3;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
public class Task3 {
    public static <T> Map<T, Integer> freqDict(List<T> list) {
        Map<T, Integer> freqMap = new HashMap<>();
        for (T item : list) {
            freqMap.put(item, freqMap.getOrDefault(item, 0) + 1);
        }
        return freqMap;
    }

    public static void main(String[] args) {
        List<String> input1 = Arrays.asList("a", "bb", "a", "bb");
        System.out.println(freqDict(input1)); // Output: {"bb": 2, "a": 2}

        List<String> input2 = Arrays.asList("this", "and", "that", "and");
        System.out.println(freqDict(input2)); // Output: {"that": 1, "and": 2, "this": 1}

        List<String> input3 = Arrays.asList("код", "код", "код", "bug");
        System.out.println(freqDict(input3)); // Output: {"код": 3, "bug": 1}

        List<Integer> input4 = Arrays.asList(1, 1, 2, 2);
        System.out.println(freqDict(input4)); // Output: {1: 2, 2: 2}
    }
}
