package hw3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.List;

public class Task2Test {
    @Test
    public void testClusterize() {
        String input = "((())())(()(()()))";
        List<String> expected = Arrays.asList("((())())", "(()(()()))");
        List<String> actual = Task2.clusterize(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testClusterizeEmptyString() {
        String input = "";
        List<String> expected = Arrays.asList();
        List<String> actual = Task2.clusterize(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testClusterizeNoBalancedClusters() {
        String input = "((())()(()(()())))";
        List<String> expected = Arrays.asList("((())()(()(()())))");
        List<String> actual = Task2.clusterize(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testClusterizeNestedClusters() {
        String input = "((())(()))";
        List<String> expected = Arrays.asList("((())(()))");
        List<String> actual = Task2.clusterize(input);
        assertEquals(expected, actual);
    }
}
