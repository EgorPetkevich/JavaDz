package hw1;

import java.util.Arrays;

public class Task6 {
    public static int countK(int number) {
        // Проверка, что число больше 1000 и не все его цифры одинаковы
        if (number <= 1000 || isAllDigitsEqual(number)) {
            return -1; // Вернуть -1 в случае некорректного ввода
        }

        // Рекурсивный вызов функции до достижения числа 6174
        if (number != 6174) {
            int ascending = sortDigits(number, true);
            int descending = sortDigits(number, false);
            int difference = Math.abs(ascending - descending);
            return 1 + countK(difference);
        }

        return 0; // Количество шагов для 6174 равно 0
    }

    private static boolean isAllDigitsEqual(int number) {
        int lastDigit = number % 10;
        while (number > 0) {
            if (number % 10 != lastDigit) {
                return false;
            }
            number /= 10;
        }
        return true;
    }

    private static int sortDigits(int number, boolean ascending) {
        String digitsString = Integer.toString(number);
        char[] digits = digitsString.toCharArray();

        Integer[] digitArray = new Integer[digits.length];
        for (int i = 0; i < digits.length; i++) {
            digitArray[i] = Character.getNumericValue(digits[i]);
        }

        Arrays.sort(digitArray);

        StringBuilder sortedNumberBuilder = new StringBuilder();
        if (ascending) {
            for (int digit : digitArray) {
                sortedNumberBuilder.append(digit);
            }
        } else {
            for (int i = digitArray.length - 1; i >= 0; i--) {
                sortedNumberBuilder.append(digitArray[i]);
            }
        }

        return Integer.parseInt(sortedNumberBuilder.toString());
    }

    public static void main(String[] args) {
        // Примеры использования функции
        System.out.println(countK(3524));  // Вывод: 3
        System.out.println(countK(6621));  // Вывод: 5
        System.out.println(countK(6554));  // Вывод: 4
        System.out.println(countK(1234));  // Вывод: 3
    }
}
