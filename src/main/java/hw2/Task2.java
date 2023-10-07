package hw2;

public class Task2 {
    public static int countDigits(int number) {
        // Обработка случая с нулем
        if (number == 0) {
            return 1;
        }

        int count = 0;
        // Используем Math.abs() для обработки отрицательных чисел
        int n = Math.abs(number);

        while (n > 0) {
            n = n / 10;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countDigits(4666)); // Вывод: 4
        System.out.println(countDigits(544));  // Вывод: 3
        System.out.println(countDigits(0));    // Вывод: 1
        System.out.println(countDigits(-12345)); // Вывод: 5
    }
}
