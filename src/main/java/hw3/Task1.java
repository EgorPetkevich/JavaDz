package hw3;
import java.util.Scanner;
public class Task1 {
    public static String encrypt(String input) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                char encryptedChar = (char) (base + ('Z' - Character.toUpperCase(c)));
                result.append(Character.isUpperCase(c) ? encryptedChar : Character.toLowerCase(encryptedChar));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String encrypted = encrypt(input);

        System.out.println("Encrypted: " + encrypted);
    }
}
