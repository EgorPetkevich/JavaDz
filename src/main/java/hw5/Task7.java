package hw5;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Task7 {
    public static void main(String[] args) {
        String inputString = "010101";

        if (isValidString(inputString)) {
            System.out.println("Строка соответствует условиям.");
        } else {
            System.out.println("Строка не соответствует условиям.");
        }
    }

    public static boolean isValidString(String input) {
        String regex = "^(0|1)(.*\\1)?.*0.{2,}.*.{1,3}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }
}
