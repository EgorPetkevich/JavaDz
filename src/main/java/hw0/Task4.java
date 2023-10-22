package hw0;

public class Task4 {
    public static String fixString(String input) {
        if (input == null) {
            return "Некорректная строка";
        }
        char[] charArray = input.toCharArray();

        for (int i = 0; i < charArray.length; i += 2) {
            if (i + 1 < charArray.length) {
                char temp = charArray[i];
                charArray[i] = charArray[i + 1];
                charArray[i + 1] = temp;
            }
        }

        return new String(charArray);
    }

    public static void main(String[] args) {
        // Примеры использования функции
        System.out.println(fixString("123456"));  // Вывод: "214365"
        System.out.println(fixString("hTsii  s aimex dpus rtni.g"));  // Вывод: "This is a mixed up string."
        System.out.println(fixString("badce"));  // Вывод: "abcde"
    }
}
