package hw5;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Task6 {
    public static void main(String[] args) {
        String s = "abc";
        String t = "achfdbaabgabcaabg";

        if (isSubsequence(s, t)) {
            System.out.println(s + " является подпоследовательностью " + t);
        } else {
            System.out.println(s + " не является подпоследовательностью " + t);
        }
    }

    public static boolean isSubsequence(String s, String t) {
        String regex = ".*" + s.chars().mapToObj(c -> (char) c + ".*").reduce("", String::concat) + ".*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(t);

        return matcher.matches();
    }
}
