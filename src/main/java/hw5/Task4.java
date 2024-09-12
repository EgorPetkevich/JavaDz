package hw5;

public class Task4 {
    public static void main(String[] args) {
        String password = "examplePassword&";
        boolean isValid = validatePassword(password);

        if (isValid) {
            System.out.println("Пароль валиден.");
        } else {
            System.out.println("Пароль не валиден.");
        }
    }

    public static boolean validatePassword(String password) {
        String regex = ".*[~!@#$%^&*|].*";
        return password.matches(regex);
    }
}
