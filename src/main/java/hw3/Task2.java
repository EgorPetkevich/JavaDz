package hw3;
import java.util.ArrayList;
import java.util.List;
public class Task2 {
    public static List<String> clusterize(String input) {
        List<String> clusters = new ArrayList<>();
        int count = 0;
        StringBuilder cluster = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
            }

            cluster.append(c);

            if (count == 0) {
                clusters.add(cluster.toString());
                cluster.setLength(0);
            }
        }

        return clusters;
    }

    public static void main(String[] args) {
        String input = "()()()())";
        List<String> clusters = clusterize(input);
        System.out.println(clusters);
    }
}
